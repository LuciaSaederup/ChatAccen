package chat.accen.Service.Implement;

import chat.accen.Model.User;
import chat.accen.Repository.UserRepository;
import chat.accen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Mono<User> getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public Mono<User> createUser(User user){
        return Mono.just(userRepository.save(user));
    }
}
