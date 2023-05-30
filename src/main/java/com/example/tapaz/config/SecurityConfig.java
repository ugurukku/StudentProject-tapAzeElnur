package com.example.tapaz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails= User.withUsername("Elnur")
                .password(passwordEncoder().encode("Elnur"))
                .roles("User")
                .build();
        UserDetails userDetails1=User.withUsername("Orxan")
                .password(passwordEncoder().encode("Orxan"))
                .roles("User")
                .build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }

    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      http
              .csrf()
              .disable()
              .authorizeHttpRequests()
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic();

      return http.build();
  }
}
