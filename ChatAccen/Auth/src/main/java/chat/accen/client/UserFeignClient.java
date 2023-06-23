package chat.accen.client;

import chat.accen.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user")
public interface UserFeignClient {

    @GetMapping("/user/{email}")
    public User getByEmail(@PathVariable String email);
}
