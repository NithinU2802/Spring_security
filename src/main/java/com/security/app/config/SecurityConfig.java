package com.security.app.config;

import com.security.app.security.JwtFilter;
import com.security.app.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/profile"))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/auth/login"))
                .authorizeHttpRequests(authz ->
                authz
                        .requestMatchers(HttpMethod.POST,"/profile").permitAll()
                        .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .requestMatchers("/api/users/**").authenticated()
                        .requestMatchers("/").permitAll()
                        .anyRequest().permitAll()
                )
//                .formLogin(form -> form.permitAll().defaultSuccessUrl("/panel"))    // login form
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // To avoid session
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                ;

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailService(){
//        UserDetails user = User.withUsername("nithin")
//                .password(passwordEncoder.encode("user123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
        return new CustomUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(List.of(authenticationProvider()));
    }


}
