package chat.accen.Service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import chat.accen.Model.Billing;
@Service
public interface BillingService {
    public Mono<Billing> getQuestion(long id);

    public Mono<Billing> addQuestion();

}
