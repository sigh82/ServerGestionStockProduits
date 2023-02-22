package com.mr.formation.student.crud.productapi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mr.formation.student.crud.productapi.entity.Role;
import com.mr.formation.student.crud.productapi.entity.User;
import com.mr.formation.student.crud.productapi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);


	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		log.error("REST request to show : {}", user.getUsername());
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				user.isEnable(), 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, 
				getAuthorities(user.getRoles()));	
		return userDetails;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();;
		
		for (Role role : roles) {
			String name = role.getName().toUpperCase();
			if (!name.startsWith("ROLE_")) {
				name = "ROLE_" + name;
			}
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(name);
			grantedAuthorities.add(grantedAuthority);			
		}
		return grantedAuthorities;
	}
}
