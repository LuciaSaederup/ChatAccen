package chat.accen.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.oauth2.resourceserver.OAuth2ResourceServerSecurityMarker;


@Configuration
@OAuth2ResourceServerSecurityMarker
public class ResouceServerConfig  {
	private static final String RESOURCE_ID = "User";

	public void configure(ResourceLoader resources) throws Exception {
		resources.getResource(RESOURCE_ID);
	}

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/user/{id}", "/question/{id}")
				.hasAnyRole("USER", "ADMIN").requestMatchers(HttpMethod.POST, "/question", "/user").hasRole("ADMIN")
				.anyRequest().denyAll().and().csrf().disable();

	}

}
