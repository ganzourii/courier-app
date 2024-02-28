package com.goods.courierapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

@Configuration
public class AppSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password_hash, active from users where username=?");
        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, user_role from users where username=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "api/customers/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PATCH,"api/customers").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.POST,"api/customers").permitAll()
                        .requestMatchers(HttpMethod.GET, "api/pilots/**").permitAll()
                        .requestMatchers(HttpMethod.PATCH,"api/pilots").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"api/pilots").permitAll()
                        .requestMatchers(HttpMethod.DELETE,"api/pilots/**").hasRole("ADMIN")                        .requestMatchers(HttpMethod.DELETE,"api/pilots/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"api/customers/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"api/pilots").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/").permitAll()

        );

        // http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable csrf (Cross Site Request Forgery)
        http.csrf(csrf-> csrf.disable());

        return http.build();

    }
}
