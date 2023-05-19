package chat.accen.Service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import chat.accen.Model.Billing;
@Service
public interface BillingService {
    Flux<Billing> getBillings(long idUser);
}
