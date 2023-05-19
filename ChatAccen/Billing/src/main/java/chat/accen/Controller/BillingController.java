package chat.accen.Controller;

import chat.accen.Model.Billing;
import chat.accen.Service.BillingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/billing")
public class BillingController {
    private BillingService billingService;
    @GetMapping("/{idUser}")
    public Flux<Billing> getBillings(@PathVariable long idUser){
        return billingService.getBillings(idUser);
    }

}
