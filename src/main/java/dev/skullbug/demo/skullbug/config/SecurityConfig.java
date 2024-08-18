package dev.skullbug.demo.skullbug;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/index", "/images/**", "/styles/**").permitAll() // Allow access to these endpoints without authentication
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build();
    }
}

