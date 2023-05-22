package chat.accen.controller;

import chat.accen.domain.Answer;
import chat.accen.domain.Question;
import chat.accen.restClient.AnswerRestClient;
import chat.accen.service.QuestionService;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private QuestionService questionService;
    
    @Autowired
    AnswerRestClient answerRestClient;
    
    public QuestionController(QuestionService querstionService){
        this.questionService = querstionService;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<HashMap<Question, Answer>> addQuestion(@RequestBody HashMap<Question, Answer> body){

        Question question = new Question();
        Answer answer = new Answer();
        HashMap conjunto = new HashMap<Question, Answer>();
        Mono<Question> newQuestionId = questionService.addQuestion(body.).log();
        //.map(question1 -> question1.getId());
        answer.setIdQuestion(newQuestionId.map(question1 -> question1.getId()).block());
//        answer.setMessage(newQuestionId.);
        answerRestClient.createAnswer(answer).log();
        conjunto.put(question, answer);
        return Mono.just(conjunto);
        
    }
    
    @GetMapping("/{message}")
    public Mono<Question> getDaQuestion(@PathVariable long msj){
        return questionService.getQuestion(msj);
//        quesition.getId(9)
//              restCliuent  Answer
    }
}
