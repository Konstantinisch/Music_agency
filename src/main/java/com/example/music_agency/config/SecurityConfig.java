package com.example.music_agency.config;//package com.example.music_agency.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@Configuration
//@EnableWebMvc
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.builder()
//                        .username("user")
//                        .password("user111")
//                        .roles("USER")
//                        .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                        .build();
//
//        UserDetails admin =
//                User.builder()
//                        .username("admin")
//                        .password("admin111")
//                        .roles("ADMIN")
//                        .passwordEncoder(new BCryptPasswordEncoder()::encode)
//                        .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService());
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(au ->
//                        au.requestMatchers("/manager").hasAnyRole().anyRequest().permitAll())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////        return httpSecurity
////                .csrf(csrf ->csrf.disable())
////                .authorizeHttpRequests(au ->
////                        au.requestMatchers("/manager").hasAnyRole("USER", "ADMIN")
////                                .anyRequest().permitAll())
//////                        au.anyRequest().permitAll())
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .formLogin(Customizer.withDefaults())
////                .build();
////    }
//}


@Configuration
@EnableWebMvc
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user111")) // Хэшируем пароль
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin111")) // Хэшируем пароль
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
    .authorizeHttpRequests(auth ->
        auth.requestMatchers("/").permitAll() // Разрешить доступ к корневому маршруту
            .requestMatchers("/manager").hasAnyRole("USER", "ADMIN")
            .anyRequest().permitAll())
//
//
//
//        httpSecurity
//                .csrf(csrf -> csrf.disable()) // Отключаем CSRF (для тестирования REST API)
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/manager").hasAnyRole("USER", "ADMIN") // Доступ для ролей USER и ADMIN
//                                .anyRequest().permitAll()) // Разрешить остальной доступ без авторизации
                .formLogin(Customizer.withDefaults()) // Включаем форму логина
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // REST API в Stateless
                .build();
    }
}
