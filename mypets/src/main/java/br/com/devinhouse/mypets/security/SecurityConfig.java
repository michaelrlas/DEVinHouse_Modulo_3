package br.com.devinhouse.mypets.security;

import br.com.devinhouse.mypets.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {

    @Autowired
    private UsuarioService service;

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
            .authorizeHttpRequests((auth) ->
                    auth//.anyRequest().authenticated()
                            .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
            )
        .httpBasic();


    return http.build();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service)
                .passwordEncoder(new BCryptPasswordEncoder());

}

    }

