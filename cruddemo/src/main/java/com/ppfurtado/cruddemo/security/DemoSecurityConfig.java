package com.ppfurtado.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {


        UserDetails pedro = User.builder()
                .username("pedro")
                .password("{noop}pedro")
                .roles("EMPLOYEE")
                .build();

        UserDetails kelly = User.builder()
                .username("kelly")
                .password("{noop}kelly")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails lucas = User.builder()
                .username("lucas")
                .password("{noop}lucas")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails bibi = User.builder()
                .username("bibi")
                .password("{noop}bibi")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(pedro, kelly, lucas, bibi);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/employee").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/employee/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/employee/**").hasRole("ADMIN")


        );

        http.httpBasic();
        http.csrf().disable();

        return http.build();
    }
}
