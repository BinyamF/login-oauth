package sec.oauth.login_oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/public/**").permitAll() // ✅ Use antMatchers() for Spring Security 5.3
            .anyRequest().authenticated()
            .and()
            .oauth2Login() // ✅ No need for withDefaults()
            .and()
            .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Example in-memory authentication
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password") // {noop} means no password encoding
            .roles("USER");
    }
}
