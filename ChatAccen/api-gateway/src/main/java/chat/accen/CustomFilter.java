package chat.accen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class CustomFilter implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request =  exchange.getRequest();
        
        log.info("Authorization: " + request.getHeaders().getFirst("Authorization") );
        
        if(request.getURI().toString().contains("/answer")){
            log.info("Request info: " + request.getId() + ", " + request.getMethod() + ", " +
                    request.getBody().toString());
        }
        
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            log.info("Post filter: " + response.getStatusCode());
        }));
    }
    
}
