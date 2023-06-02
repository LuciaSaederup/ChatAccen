
package chat.accen.dto;

import chat.accen.domain.Answer;
import chat.accen.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {
    
    private Question question;
    private Answer answer;
    
}
