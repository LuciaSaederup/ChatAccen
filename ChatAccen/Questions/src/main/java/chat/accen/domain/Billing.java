package chat.accen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    private double price;
    private Long idUser;
    private Long idQuestion;

}
