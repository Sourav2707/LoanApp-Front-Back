package com.bridgelabz.finserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Allow CORS for all endpoints
//                .allowedOrigins("*") // Allow requests from any origin
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
//                .allowedHeaders("Authorization", "Content-Type") // Allow specific headers
//                .exposedHeaders("Authorization") // Expose specific headers in the response
//                .allowCredentials(false) // Don't allow cookies to be sent along with the request
//                .maxAge(3600); // Cache CORS preflight requests for 1 hour (3600 seconds)
//    }
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .antMatchers("/public/**").permitAll() // Configure public access URLs
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults()); // Disable Basic Authentication
//
//        return http.build();
//    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("username")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
