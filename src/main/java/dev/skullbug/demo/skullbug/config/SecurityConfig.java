package dev.skullbug.demo.skullbug.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Allow all requests to the /bugs and / endpoint without authentication
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/bugs/**", "/").permitAll()
                        .anyRequest().authenticated()
                )
                // Disable CSRF for simplicity
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
