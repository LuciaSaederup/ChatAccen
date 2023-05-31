package chat.accen.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;    
    private String userName;
    private Double balance;
    private List<Long> detail;
    @Column(columnDefinition = "integer default 0")
    private int questionsAsked;
}
