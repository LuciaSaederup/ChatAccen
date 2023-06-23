package chat.accen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    private Long id;
    private String email;
    private String password;    
    private Double balance;
    private List<Long> detail;
    private Set<Role> role;
    private String pais;
    private String sexo;
    private Date fechaAlta;    
    private int questionsAsked;

}
