
package chat.accen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DialogueDTO {
    
    private Question question;
    private Answer answer;
    
}
