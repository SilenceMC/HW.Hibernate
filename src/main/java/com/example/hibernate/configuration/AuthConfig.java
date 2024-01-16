package com.example.hibernate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password")
                .authorities("AGE")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}password")
                .authorities("AGE", "NAME")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/persons/by-age")
                        .hasAuthority("AGE")

                        .requestMatchers(HttpMethod.GET, "/persons/by-name-and-surname")
                        .hasAuthority("NAME")

                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults());
        return http.build();
    }
}
