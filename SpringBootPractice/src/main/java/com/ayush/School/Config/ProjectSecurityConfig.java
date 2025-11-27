package com.ayush.School.Config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//
//@Configuration
//@EnableWebSecurity
//public class ProjectSecurityConfig {
//
////    @Bean
////    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////
////        http
////                //.csrf(csrf -> csrf.disable())              // optional, but usually needed for APIs
////                .authorizeHttpRequests(auth -> auth
////                                .requestMatchers("/home").permitAll()
////                                .requestMatchers("/holidays").permitAll()
////                                .requestMatchers("/contact").permitAll()
////                                .requestMatchers("/saveMsg").permitAll()
////                                .requestMatchers("/about").permitAll()
////                        //.anyRequest()
////                                //.denyAll()
////                                //.permitAll()
////
////                        // allow ALL endpoints
////                )
////                .formLogin(form -> form.disable())         // disable form login
////                .httpBasic(httpBasic -> httpBasic.disable()); // disable basic auth
////
////        return http.build();
////    }
////@Bean
////public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//////
//////    http
//////            .csrf(csrf -> csrf.disable()) // Required for H2
//////            .headers(headers -> headers
//////                    .frameOptions(frame -> frame.disable()) // Required for H2
//////            )
//////            .authorizeHttpRequests(auth -> auth
//////                    .requestMatchers(
//////                            "/home",
//////                            "/holidays",      // FIXED
//////                            "/contact",
//////                            "/saveMsg",
//////                            "/about"
//////                    ).permitAll()
//////                    .requestMatchers(PathRequest.toH2Console()).permitAll()  // H2 Console access
//////                    .anyRequest().authenticated()
//////            )
//////            .formLogin(form -> form.permitAll())
//////            .httpBasic(Customizer.withDefaults());
//////
//////    return http.build();
////    }
//}


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // H2 console requires this
                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable())
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/home",
                                "/holidays",
                                "/contact",
                                "/saveMsg",
                                "/about"
                        ).permitAll()
                        .requestMatchers("/h2-console/**").permitAll()   // IMPORTANT: allow all sub-paths
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

