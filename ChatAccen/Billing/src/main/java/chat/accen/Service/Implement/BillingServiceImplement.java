package chat.accen.Service.Implement;


import chat.accen.Model.Billing;
import chat.accen.Repository.BillingRepository;
import chat.accen.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BillingServiceImplement implements BillingService {

    @Autowired
    BillingRepository billingRepository;
    @Override
    public Flux<Billing> getBillings(long idUser) {
        return Flux.fromIterable(billingRepository.findBillingsByIdUser(idUser));
    }

    @Override
    public Mono<Billing> addBilling(Billing billing) {
        
        return Mono.just(billingRepository.save(billing));
        
    }
}
