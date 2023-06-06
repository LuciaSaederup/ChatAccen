package chat.accen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Role role;
    @Column(columnDefinition = "integer default 0")
    private int questionsAsked;


}
