package chat.accen.client;

import chat.accen.domain.Billing;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BillingRestClient {
    
    private WebClient webClient;
    
    private String billingUrl = "http://localhost:8083/billing";
    
    public BillingRestClient(WebClient webClient){
        this.webClient = webClient;
    }
    
    public Flux<Billing> getBillings(Long id){
        
        String url = UriComponentsBuilder.fromHttpUrl(billingUrl)                
                .buildAndExpand()
                .toString();
        
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Billing.class);
    }
    
        
//    public Mono<Double> getBalance(){
//        
//        String url = UriComponentsBuilder.fromHttpUrl(billingUrl)                
//                .buildAndExpand()
//                .toString();
//        
//        Double price = 0D;
//        
//        return Mono.just(price).flatMap(p -> {
//            webClient
//                .get()
//                .uri(url)
//                .retrieve()
//                .bodyToFlux(Billing.class)
//                .map(b -> { p = p + b.getPrice()});
//        });        
//    }
    
    public Mono<Billing> addBilling(Billing billing){
        
        String url = UriComponentsBuilder.fromHttpUrl(billingUrl)                
                .buildAndExpand()
                .toString();
        
        return webClient
                .post()
                .uri(url)
                .body(Mono.just(billing), Billing.class)
                .retrieve()
                .bodyToMono(Billing.class);
    }
}
