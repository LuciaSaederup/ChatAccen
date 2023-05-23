package chat.accen.Service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import chat.accen.Model.Billing;
import reactor.core.publisher.Mono;
@Service
public interface BillingService {
    
    Flux<Billing> getBillings(long idUser);
    
    Mono<Billing> addBilling(Billing billing);
}
