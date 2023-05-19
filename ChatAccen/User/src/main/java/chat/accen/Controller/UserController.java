package chat.accen.Controller;

import chat.accen.Model.User;
import chat.accen.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")
    public Mono<User>getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}
