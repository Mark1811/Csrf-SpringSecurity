package com.example.csrf.springSecuritycsrf.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    String[] resources = new String[]{
            "/static/**","/img/**","/js/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                 //.csrf().disable()

                 .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                 .and()
                 .authorizeHttpRequests((authz)-> {
                     try {
                         authz
                                 .requestMatchers(resources).permitAll()
                                 .requestMatchers("/login").permitAll()
                                 .requestMatchers("/csrf").permitAll()
                                 .anyRequest().authenticated().
                                 and().
                                 formLogin()
                                 .and().httpBasic();
                     } catch (Exception e) {
                         throw new RuntimeException(e);
                     }
                 }).httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
        user.createUser(User.withUsername("mark")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .build());

        return user;

    }



}
