package chat.accen.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
}
