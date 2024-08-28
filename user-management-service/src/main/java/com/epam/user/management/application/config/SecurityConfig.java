package com.epam.user.management.application.config;

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

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        System.out.println("here");
//        http.authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/register","/").permitAll()
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register", "/").permitAll() // Allow access to /register and root endpoint
                        .anyRequest().permitAll() // Require authentication for all other endpoints
                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/custom-login") // Optionally configure a custom login page
//                        .permitAll()
//                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) ->
                                response.sendRedirect("/custom-login") // Redirect unauthenticated users
                        )
                );

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
