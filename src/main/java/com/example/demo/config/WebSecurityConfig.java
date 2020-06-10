package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain initSecurityWebFilterChain(ServerHttpSecurity http){
        http.formLogin().loginPage("/login");

        http.oauth2Login().and().authorizeExchange()
                .pathMatchers("/hello2").hasRole("USER")
                .pathMatchers("/**").permitAll();

        return http.build();
    }
}
