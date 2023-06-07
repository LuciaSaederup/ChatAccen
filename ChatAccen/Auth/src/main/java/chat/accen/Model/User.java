package chat.accen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private Double balance;
    private List<Long> detail;
    private Role role;
    private String pais;
    private String sexo;
    private Date fechaAlta;
    @Column(columnDefinition = "integer default 0")
    private int questionsAsked;

}
