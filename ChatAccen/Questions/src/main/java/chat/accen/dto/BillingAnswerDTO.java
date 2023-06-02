package chat.accen.dto;

import chat.accen.domain.Answer;
import chat.accen.domain.Billing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAnswerDTO {
    
    private Billing billing;
    private Answer anwer;
    
}
