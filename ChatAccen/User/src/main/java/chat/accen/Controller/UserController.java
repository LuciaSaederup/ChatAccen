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
    
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<User>getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User>createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    
    @PutMapping("/{id}")
    public Mono<User> updateUSer(@PathVariable Long id, @RequestBody User updtUser){                
        return userService
                .updateUser(id, updtUser);
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
