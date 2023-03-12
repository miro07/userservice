package userservice.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthTokenFilter customFilter;
    @Autowired
    private AuthEntryPointJwt authEntryPointJwt;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(authEntryPointJwt)
                .and()
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
