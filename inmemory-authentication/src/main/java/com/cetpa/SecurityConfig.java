package com.cetpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder pe)
	{	 
		String pa1=pe.encode("rehan");
		UserDetails rehan=User.withUsername("rehan123").password(pa1).roles("ADMIN","SYSTEM").build();
		UserDetails amit=User.withUsername("amit123").password(pe.encode("amit")).roles("SYSTEM").build();
		UserDetails hemant=User.withUsername("hemant123").password(pe.encode("hemant")).roles("USER").build();
		UserDetails manoj=User.withUsername("manoj123").password(pe.encode("manoj")).roles("GUEST","USER").build();
		UserDetailsService service=new InMemoryUserDetailsManager(rehan,amit,hemant,manoj);
		return service;
	}
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
