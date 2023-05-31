package chat.accen.Service;

import chat.accen.Model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    public Mono<User> getUserById(long id);

    public Mono<User> createUser(User user);
    
    public Mono<User> updateUser(Long id, User user);

    public Mono<Void> deleteUser(Long id);
}
