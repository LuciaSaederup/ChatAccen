@Configuration
public class GlobalSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
    private UserDetailsService userDetailsService;

    public GlobalSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
