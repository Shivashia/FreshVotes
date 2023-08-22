package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import static org.springframework.security.config.Customizer.withDefaults;

//import org.springframework.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurityConfig {
    //    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password("user1Pass")
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password("user2Pass")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("adminPass")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user1")
//                .password("primaryUser")
//                .authorities("ROLE_USER");
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
//                .hasAnyRole("ADMIN","USER")
                .anyRequest().hasRole("USER")
                .and()
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Custom login page
//                      .defaultSuccessUrl("/dashboard") // Redirect after successful login
                        .permitAll()
        )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );
        //        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().hasRole("ROLE_USER").and()
//                        .formlogin
//                )
//                .httpBasic(withDefaults());
        return http.build();
    }
}

