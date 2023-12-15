package com.uexcel.loginlogoutcoding.config;

import com.uexcel.loginlogoutcoding.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/register").permitAll()
                        .requestMatchers("/admin-page").hasAuthority("ADMIN")
                        .requestMatchers("/user-page").hasAuthority("USER")
                        .requestMatchers("/**.css").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login").loginProcessingUrl("/login")
                        .defaultSuccessUrl("/").permitAll())
                .logout(out->out.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout"));
        return http.build();

    }
    @Autowired
    public  void authenticationBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder(11));
    }
}
