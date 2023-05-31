package chat.accen.service;

import chat.accen.client.BillingRestClient;
import chat.accen.domain.Billing;
import chat.accen.domain.Question;
import chat.accen.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    
    @Autowired
    BillingRestClient billingRestClient;

    Question q = new Question();

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        q.setMessage("¿Las focas ponen Huevos?");

    }

    @Override
    public Mono<Question> getQuestion(long id) {
        return Mono.just(questionRepository.findById(id).orElse(q));
    }

    @Override
    public Mono<Question> addQuestion(Question question) {
        return Mono.just(questionRepository.save(question));
    }

    @Override
    public Mono<Question> getQuestionByKeyword(String keyword) {
        return Mono.just(questionRepository.getQuestionByKeyword(keyword));
                
//        return Mono.just(questionRepository.findById(2L).orElse(q));
    }
}
