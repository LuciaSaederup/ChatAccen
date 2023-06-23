package chat.accen.Service;


import chat.accen.Model.CustomUser;
import chat.accen.Model.Role;
import chat.accen.Model.User;
import chat.accen.client.UserFeignClient;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Primary;

@Service
@Primary
public class UserDetailServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
        
    @Autowired
    private UserFeignClient userClient;

    public UserDetailServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userClient.getByEmail(username);
        if (Objects.isNull(user)) {
            logger.info(String.format("User logged wrong: %s", username));
            throw new UsernameNotFoundException(String.format("User %s not found.", username));
        }
//        List<Role> roles = Collections.singletonList(user.getRole());
        List<GrantedAuthority> roles = new ArrayList<>(); 
        roles.addAll(user.getRole());
        if (Objects.isNull(roles)) {
            logger.info(String.format("User without roles: %s", username));
            throw new RuntimeException("User without roles");
        }
        Collection<GrantedAuthority> grantedAuthorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getAuthority())).collect(Collectors.toList());
        logger.info(String.format("User logged: %s", username));
        return new CustomUser(user);
    }

}

