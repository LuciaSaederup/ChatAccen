package chat.accen.Repository;


import chat.accen.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends JpaRepository<User, Long> {

    public Mono<User> getUserById(Long id);
}
