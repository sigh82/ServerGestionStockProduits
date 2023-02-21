package com.mr.formation.student.crud.productapi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.mr.formation.student.crud.productapi.controller.ProduitController;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    private final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        log.error("REST request to show security congfi : {}");

		http
		 .httpBasic()
		   .and()
		     .authorizeRequests().antMatchers("/api/**")
		       .hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
		         .csrf().disable().headers().frameOptions().disable();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("password1").roles("USER").and().withUser("admin").password("password2").roles("USER","ADMIN");
    }
         
}