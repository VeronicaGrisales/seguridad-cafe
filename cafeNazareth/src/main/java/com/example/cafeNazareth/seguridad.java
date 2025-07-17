package com.example.cafeNazareth;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class seguridad {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(
                User.withUsername("admin")
                    .password("{noop}admin123") // {noop} dice que no se encripta
                    .roles("ADMIN")
                    .build());

        manager.createUser(
                User.withUsername("user")
                    .password("{noop}user123")
                    .roles("USER")
                    .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(withDefaults())
            .logout(withDefaults());

        return http.build();
    }
}


/* 
//Estas líneas importan clases de Spring y Spring Security necesarias para configurar la seguridad

import 
org.springframework.context.annotation.Bean;

import
org.springframework.context.annotation.Configuration;

import
org.springframework.security.config.annotation.web.builders.HttpSecurity;
 
import
org.springframework.security.core.userdetails.User;

import 
org.springframework.security.core.userdetails.UserDetailsService;

import
org.springframework.security.provisioning.InMemoryUserDetailsManager;

import
org.springframework.security.web.SecurityFilterChain;

@Configuration 
//	Declara esta clase como una clase de configuración

public class seguridad {

    @Bean 
    // Indica que un método crea un "objeto gestionado" por Spring

    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

              
                manager.createUser(
                    User.withUsername("admin")
                    .password("{noop} admin123") //{noop} diece que no encripta
                    .roles("ADMIN")
                    .build()
                );

                manager.createUser(
                User.withUsername("user")
                .password("{noop user123}")
                .roles("USER")
                .build()
                );

                return manager;
    }
    
    @Bean

    public SecurityFilterChain
    filterChain(HttpSecurity http) throws 
    Exception {
        http 
        .authorizeHttpRequests(autch-> autch
                .requestMatchers("/public").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("/USER", "ADMIN")
                .anyRequest().authenticated()

        )
        .formLogin()
        .and()
        .logout();

        return http.build();
    }
}
*/