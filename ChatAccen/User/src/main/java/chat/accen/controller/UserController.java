package chat.accen.controller;

import chat.accen.Model.User;
import chat.accen.Service.UserService;
import chat.accen.client.BillingRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.apache.logging.log4j.util.Base64Util.encode;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    
    @Autowired
    BillingRestClient billingRestClient;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public Mono<User>getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("/registerUser")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User>createUser(@RequestBody User user){
        user.setPassword(encode(user.getPassword()));
        return userService.createUser(user);
    }

    @PutMapping("user/{id}")
    public Mono<User> updateUSer(@PathVariable Long id, @RequestBody User updtUser){                
        return userService
                .updateUser(id, updtUser);
    }
    
    @DeleteMapping("user/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
