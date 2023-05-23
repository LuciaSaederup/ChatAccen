package chat.accen.router;

import chat.accen.handler.AnswerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class AnswerRouter {

    private String URL = "/answer";

    @Autowired
    AnswerHandler answerHandler;
    
    @Bean
    public RouterFunction<ServerResponse> answersRoute() {

        return RouterFunctions
                .route()
                .POST(URL, request -> answerHandler.create(request).log())
                .GET(URL + "/{idQuestion}", request -> answerHandler.getAnswerNyQuestionId(request).log())                
                .GET(URL + "/id/{id}", request -> answerHandler.getAnswerById(request).log())                
                .build();
    }
}
