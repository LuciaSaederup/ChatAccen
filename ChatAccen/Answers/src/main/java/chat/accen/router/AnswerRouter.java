package chat.accen.router;

import chat.accen.handler.AnswerHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class AnswerRouter {
    
    private final String URL = "http://localhost:8082";
    
    public RouterFunction<ServerResponse> answerRouter(AnswerHandler answerHandler){
        
        return RouterFunctions
                .route()
                .POST(URL, request -> answerHandler.create(request))
                .GET(URL + "/{idQuestion}", request -> answerHandler.getAnswer(request))
                .build();
    }
}
