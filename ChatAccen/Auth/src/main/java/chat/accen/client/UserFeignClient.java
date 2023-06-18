package chat.accen.client;

import chat.accen.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="user")
public interface UserFeignClient {

    @GetMapping("/user/search/email")
    public User getByEmail(@RequestParam String email);
}
