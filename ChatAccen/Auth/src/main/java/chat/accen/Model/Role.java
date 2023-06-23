package chat.accen.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority{
	private Integer id;
	private String name;

    @Override
    public String getAuthority() {
        return null;
    }
    
    public String getName() {
        return this.name;
    }
        
}

