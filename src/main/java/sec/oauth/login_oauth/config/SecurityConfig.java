package sec.oauth.login_oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
            .authorizeHttpRequests(auth -> {
                auth.antMatchers("/").permitAll();
                auth.anyRequest().authenticated();
            })
            .oauth2Login(withDefaults())
            .formLogin(withDefaults())
            .build();


    }
}