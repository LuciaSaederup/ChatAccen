package chat.accen.service;

import chat.accen.domain.Question;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface QuestionService {
   
    public Mono<Question> getQuestion(long id);
    
    public Mono<Question> getQuestionByKeyword(String keyword);
    
    public Mono<Question> addQuestion(Question question);
}
