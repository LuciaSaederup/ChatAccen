package chat.accen.controller;

import chat.accen.Model.User;
import chat.accen.Service.UserService;
import chat.accen.client.BillingRestClient;
import chat.accen.security.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.apache.logging.log4j.util.Base64Util.encode;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    
    @Autowired
    BillingRestClient billingRestClient;

    private SecurityService securityService;
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
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean loginResponse = securityService.login(email, password);
        if (loginResponse) {
            return "index";
        }
        return "login";
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
