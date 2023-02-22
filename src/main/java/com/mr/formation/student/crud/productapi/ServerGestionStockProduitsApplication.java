package com.mr.formation.student.crud.productapi;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mr.formation.student.crud.productapi.entity.Produit;
import com.mr.formation.student.crud.productapi.entity.Role;
import com.mr.formation.student.crud.productapi.entity.User;
import com.mr.formation.student.crud.productapi.repository.ProduitRepository;
import com.mr.formation.student.crud.productapi.repository.RoleRepository;
import com.mr.formation.student.crud.productapi.repository.UserRepository;

@SpringBootApplication
public class ServerGestionStockProduitsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(ServerGestionStockProduitsApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		produitRepository.save(new Produit("Livre", 50, 20));
		produitRepository.save(new Produit("Cahier", 200, 5.25f));
		produitRepository.save(new Produit("Stylo", 500, 2.10f));
		
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		
		Role roleUser = new Role("user");
		Role roleAdmin = new Role("admin");
		
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		
		User user = new User("user1", "password1", true);
				
		user.setRoles(Arrays.asList(roleUser));
		userRepository.save(user);
		
		User admin = new User("admin", "password2", true);
		
		admin.setRoles(Arrays.asList(roleUser,roleAdmin));	
		userRepository.save(admin);
	} 

}
