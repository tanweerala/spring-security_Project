package com.cetpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
		//add api can be called by user has ADMIN role.Other apis will be authenticated
		SecurityFilterChain chain=http.csrf(cs->cs.disable()).
				authorizeHttpRequests(auth->auth.requestMatchers("/demo/add")
						.hasRole("admin")
						.anyRequest()
						.fullyAuthenticated())
				.formLogin(Customizer.withDefaults()).build();
		//SecurityFilterChain chain=http.csrf(cs->cs.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/demo/add").hasRole("ADMIN").requestMatchers("/demo/update").hasRole("USER").anyRequest().fullyAuthenticated()).formLogin(Customizer.withDefaults()).build();
		//SecurityFilterChain chain=http.csrf(cs->cs.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/demo/add").fullyAuthenticated().anyRequest().permitAll()).formLogin(Customizer.withDefaults()).build();
		return chain; 
    }
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
