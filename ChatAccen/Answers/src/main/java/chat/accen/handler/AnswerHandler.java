package chat.accen.handler;

import chat.accen.domain.Answer;
import chat.accen.repository.AnswerRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Component
public class AnswerHandler {
    
    private AnswerRepository answerRepository;
    
    public AnswerHandler(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }
    
    
    public Mono<ServerResponse> create(ServerRequest request){
        
        Mono<Answer> answer = request.bodyToMono(Answer.class).map(savedAnswer ->{
            return answerRepository.save(savedAnswer);
        });
        
        return ServerResponse.status(HttpStatus.CREATED).bodyValue(answer);
    }

    public Mono<ServerResponse> getAnswer(ServerRequest request) {
        
        Answer emptyAnswer = new Answer();
        
        long idQuestion = Long.valueOf(request.pathVariable("idQuestion"));
        
        Answer answer = answerRepository.findById(idQuestion).orElse(emptyAnswer);
        
        return ServerResponse.ok().bodyValue(answer);
    }
}
