package com.embl.RestfulEmbl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
    // By default two users created
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    		
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("embl")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("embl")).roles("USER", "ADMIN");

    }

    // Endpoints with Authentication and Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http              
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/persons/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/v1/persons").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/persons/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/persons/**").hasRole("ADMIN")	
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}
