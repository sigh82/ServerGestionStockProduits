package com.mr.formation.student.crud.productapi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    private final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Autowired
    private UserDetailsService userDetailsService;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        log.error("REST request to show security congfi : {}", http);

		http
		 .httpBasic()
		   .and()
		     .authorizeRequests().antMatchers("/api/**")
		       .hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
		         .csrf().disable().headers().frameOptions().disable();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) 
    		throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(
        		NoOpPasswordEncoder.getInstance());
    }
         
}