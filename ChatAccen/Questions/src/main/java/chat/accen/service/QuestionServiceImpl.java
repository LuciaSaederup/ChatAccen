package chat.accen.service;

import chat.accen.domain.Question;
import chat.accen.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    
    Question q = new Question();
    
    public QuestionServiceImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
        q.setMessage("¿Las focas ponen Huevos?");

    }
    
    @Override
    public Mono<Question> getQuestion(long id) {
        return Mono.just(questionRepository.findById(id).orElse(q));
//        return questionRepository.findById(id);
    }

    @Override
    public Mono<Question> addQuestion(Question question) {
        return Mono.just(questionRepository.save(question));
//        return questionRepository.save(question);
    }
    
}
