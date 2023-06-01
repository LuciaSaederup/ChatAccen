package chat.accen.security.config;

import chat.accen.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class WebSecurityConfig {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/user/{idUser}", "/billing/{idUser}",
						"/answer/{id}", "/question/{id}", "/chat")
				.hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/showCreateCoupon", "/createCoupon", "/createResponse").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.POST, "/couponapi/coupons", "/saveCoupon", "/getCoupon").hasRole("ADMIN")
				.requestMatchers("/", "/login", "/logout", "/showReg", "/registerUser").permitAll().anyRequest().denyAll()
				.and().logout().logoutSuccessUrl("/");

		return null;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManagerBean();
	}

}
