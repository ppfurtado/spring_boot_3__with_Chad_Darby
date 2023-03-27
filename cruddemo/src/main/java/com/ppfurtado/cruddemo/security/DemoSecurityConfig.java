package com.ppfurtado.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){


        return new JdbcUserDetailsManager(dataSource);
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
