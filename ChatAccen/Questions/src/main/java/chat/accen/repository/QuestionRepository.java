package chat.accen.repository;

import chat.accen.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
//public interface QuestionRepository extends ReactiveCrudRepository<Question, Long>{
public interface QuestionRepository extends JpaRepository<Question, Long>{

    @Query("SELECT q FROM Question q WHERE q.message like %:keyword%")
    public Question getQuestionByKeyword(@Param("keyword") String keyword);

}
