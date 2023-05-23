package chat.accen.client;

import chat.accen.domain.Answer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_NDJSON_VALUE)
                .body(Mono.just(answer), Answer.class)
                .retrieve()
                .bodyToMono(Answer.class).log();
    }
    
    public Mono<Answer> getAnswer(Long idQuestion){
                
        return webClient
                .get()
                .uri(url + "/{idQuestion}", idQuestion)
                .retrieve()
                .bodyToMono(Answer.class).log();
    }
}
