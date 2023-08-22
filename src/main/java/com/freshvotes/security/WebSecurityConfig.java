package com.freshvotes.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class WebSecurityConfig {


    @Bean
    public PasswordEncoder getpasswordencoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("user")
                .password("{noop}password").roles("USER")
                .build();

        userDetailsService.createUser(user);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login"))
                .hasRole("USER")
                .anyRequest().hasRole("USER")
                .and()
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/index") // Redirect after successful login
                        .permitAll()
        )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                )

                .httpBasic(withDefaults());
        return http.build();
    }
}

