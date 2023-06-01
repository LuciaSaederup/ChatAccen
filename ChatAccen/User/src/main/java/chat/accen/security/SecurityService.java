package chat.accen.security;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    boolean login(String email, String password);

}
