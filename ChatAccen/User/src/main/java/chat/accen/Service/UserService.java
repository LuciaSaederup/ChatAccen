package chat.accen.Service;

import chat.accen.Model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface UserService {
    public Mono<User>getUserById(long id);

    public Mono<User>createUser(User user);
}
