package chat.accen.Service;

import reactor.core.publisher.Flux;
import chat.accen.Model.Billing;
import reactor.core.publisher.Mono;

public interface BillingService {
    
    Flux<Billing> getBillings(long idUser);
    
    Mono<Billing> addBilling(Billing billing);

    public Mono<Double> getBalance(long idUser);
}
