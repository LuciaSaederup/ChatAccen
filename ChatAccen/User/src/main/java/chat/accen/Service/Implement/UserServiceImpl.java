package chat.accen.Service.Implement;

import chat.accen.Model.User;
import chat.accen.Repository.UserRepository;
import chat.accen.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    
    @Override
    public Mono<User> getUserById(long id) {
        return Mono.just(userRepository.findById(id).orElse(new User()));
    }

    @Override
    public Mono<User> createUser(User user){
        return Mono.just(userRepository.save(user));
    }

    @Override
    public Mono<User> updateUser(Long id, User updtUser) {
        
        User existingUser = userRepository.findById(id).orElse(new User());
        
        return Mono.just(existingUser)
                .map(user -> {
                    user.setUserName(updtUser.getUserName());
                    user.setEmail(updtUser.getEmail());
                    user.setPassword(updtUser.getPassword());
                    user.setQuestionsAsked(updtUser.getQuestionsAsked());
                    return userRepository.save(user);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        
        userRepository.deleteById(id);
        return Mono.empty();
    }
    @Override
    public Mono<User> findByEmail(String email){
        return Mono.just(userRepository.findByEmail(email));
    };



}
