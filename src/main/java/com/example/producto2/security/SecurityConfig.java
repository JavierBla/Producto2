package com.example.producto2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}secret")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}secret")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/auth/**","/css/**",
//                        "/js/**","/images/**").permitAll().anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/auth/login").defaultSuccessUrl("/",
//                        true).failureUrl("/auth/login?error=true")
//                .loginProcessingUrl("/auth/login-post").permitAll()
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/");
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll()
        ).logout(
                LogoutConfigurer::permitAll
        ).exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
        );

        return http.build();
    }

}
