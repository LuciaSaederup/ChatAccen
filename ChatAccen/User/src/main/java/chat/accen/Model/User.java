package chat.accen.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private Double balance;
    private List<Long> detail;
    private int questionsAsked;
}
