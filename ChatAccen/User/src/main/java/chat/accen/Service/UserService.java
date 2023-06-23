package chat.accen.Service;

import chat.accen.Model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface UserService {
    public Mono<User> getUserById(long id);
    
    public Mono<User> getUserByEmail(String email);

    public Mono<User> createUser(User user);
    
    public Mono<User> updateUser(Long id, User user);

    public Mono<Void> deleteUser(Long id);

    public Mono<User> findByEmail(String email);

}
