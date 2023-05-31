package chat.accen.controller;

import chat.accen.domain.Answer;
import chat.accen.domain.DialogueDTO;
import chat.accen.domain.Question;
import chat.accen.client.AnswerRestClient;
import chat.accen.client.BillingRestClient;
import chat.accen.domain.Billing;
import chat.accen.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    AnswerRestClient answerRestClient;

    @Autowired
    BillingRestClient billingRestClient;
    
     Sinks.Many<Question> quesitonSink = Sinks.many().replay().all();

    public QuestionController(QuestionService querstionService) {
        this.questionService = querstionService;
    }

    @PostMapping("/full")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DialogueDTO> addQuestion(@RequestBody DialogueDTO dialogue) {

        return questionService.addQuestion(dialogue.getQuestion())
                .flatMap(q -> {
                    dialogue.getQuestion().setId(q.getId());
                    dialogue.getAnswer().setIdQuestion(q.getId());
                    Mono<Answer> answer = answerRestClient.createAnswer(dialogue.getAnswer()).log();
                    return answer.map(a -> new DialogueDTO(q, a));
                });
    }

    @GetMapping("/full/{id}")
    public Mono<DialogueDTO> getDialog(@PathVariable long id) {
        return questionService.getQuestion(id).log()
                .flatMap(q -> {
                    Mono<Answer> answer = answerRestClient.getAnswer(q.getId());
                    return answer.map(a -> new DialogueDTO(q, a));
                });
    }

    @GetMapping("/{id}")
    public Mono<Question> getQuestion(@PathVariable long id) {
        return questionService.getQuestion(id).log();

    }

    @GetMapping("/answer/{id}")
    public Mono<Answer> getTheAnswer(@PathVariable long id) {
        return questionService.getQuestion(id).log()
                .flatMap(q -> {
                    return answerRestClient.getAnswer(q.getId());
                });

    }

    @GetMapping("/chat")
    public Mono<Answer> getAnswer(@RequestParam long userId, @RequestBody String keywords) {
        //Traer userId por metodo de security?
        return questionService.getQuestionByKeyword(keywords).log()
                .flatMap(q -> {
//                    billingRestClient
//                        .addBilling(new Billing(q.getPrice(), userId, q.getId()));
                    return answerRestClient.getAnswer(q.getId());
                });
    }

    @PostMapping("/answer")
    public Mono<Answer> postAnswer(@RequestBody Answer answer) {
        return answerRestClient.createAnswer(answer).log();
    }

}
