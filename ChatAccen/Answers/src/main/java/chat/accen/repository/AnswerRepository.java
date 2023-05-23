package chat.accen.repository;

import chat.accen.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
    
    public Answer findByIdQuestion(Long idQuestion);
}
