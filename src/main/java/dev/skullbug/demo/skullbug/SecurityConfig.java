package dev.skullbug.demo.skullbug.config; // Ensure the package is correct

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/", "/users/register", "/users/success", "/css/**", "/js/**").permitAll() // Allow access to these pages without authentication
                .anyRequest().authenticated() // Require authentication for all other requests
                .and()
                .formLogin()
                .loginPage("/users/login") // Custom login page
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Define a bean of PasswordEncoder
    }
}
