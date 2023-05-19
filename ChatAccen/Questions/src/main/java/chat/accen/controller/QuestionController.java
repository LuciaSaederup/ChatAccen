package chat.accen.controller;

import chat.accen.domain.Question;
import chat.accen.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private QuestionService questionService;
    
//    @Autowired
//    WebClient webClient;
    
    public QuestionController(QuestionService querstionService){
        this.questionService = querstionService;
    }
    
    @PostMapping
    public Mono<Question> addQuestion(@RequestBody Question question){
        
        return questionService.addQuestion(question);
        
    }
    
    @GetMapping("/{id}")
    public Mono<Question> getDaQuestion(@PathVariable long id){
        return questionService.getQuestion(id);
    }
}
