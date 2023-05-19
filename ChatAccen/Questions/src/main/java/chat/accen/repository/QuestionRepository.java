package chat.accen.repository;

import chat.accen.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface QuestionRepository extends ReactiveCrudRepository<Question, Long>{
public interface QuestionRepository extends JpaRepository<Question, Long>{

//    public Mono<Question> findById() {
//
//        Question q = new Question();
//        q.setMessage("¿Las focas ponen Huevos?");
//
//        return Mono.just(q);
//    }    
//    
//    public Mono<Question> save() {
//        Question q = new Question();
//        q.setMessage("¿Que gusto tiene la sal?");
//        
//        return Mono.just(q);
//    }
}
