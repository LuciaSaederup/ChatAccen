package chat.accen.restClient;

import chat.accen.domain.Answer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Component
public class AnswerRestClient {
    
    WebClient webClient;
    
    public AnswerRestClient(WebClient webClient){
        this.webClient = webClient;
    }
    
    private String answerUrl = "http://localhost:8082/answer";
    
    String url = UriComponentsBuilder.fromHttpUrl(answerUrl)                
                .buildAndExpand()
                .toString();
    
    public Mono<Answer> createAnswer(Answer answer){
        
        return webClient
                .post()
                .uri(url)
                .body(answer, Answer.class)              
                .retrieve()
                .bodyToMono(Answer.class).log();
    }    
}
