package chat.accen.client;

import chat.accen.Model.Billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BillingRestClient {

    @Autowired
    private WebClient webClient;

    private String billingUrl = "http://localhost:8083/billing";
    
    public BillingRestClient() {
    }

    public Flux<Billing> getBillings(Long idUser) {

        String url = UriComponentsBuilder.fromHttpUrl(billingUrl)
                .buildAndExpand()
                .toString();

        return webClient
                .get()
                .uri(url + "/{idUser}", idUser)
                .retrieve()
                .bodyToFlux(Billing.class);
    }

//    public Mono<Double> getBalance(Long idUser){
//        
//        String url = UriComponentsBuilder.fromHttpUrl(billingUrl)                
//                .buildAndExpand()
//                .toString();
//        
//        Double price = 0D;
//        return Mono.just(price).flatMap(p -> {
//            webClient
//                .get()
//                .uri(url + "/{idUser}", idUser)
//                .retrieve()
//                .bodyToFlux(Billing.class)
//                .flatMap(b -> { p = p + b.getPrice()});
//        });        
//    }
}
