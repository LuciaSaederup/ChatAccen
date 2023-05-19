package chat.accen.Service.Implement;


import chat.accen.Model.Billing;
import chat.accen.Repository.BillingRepository;
import chat.accen.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

public class BillingServiceImplement implements BillingService {

    @Autowired
    BillingRepository billingRepository;
    @Override
    public Flux<Billing> getBillings(long idUser) {
        return Flux.fromIterable(billingRepository.findBillingsByIdUser(idUser));
    }
}
