package chat.accen.Controller;

import chat.accen.Model.User;
import chat.accen.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")
    public Mono<User>getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User>createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
