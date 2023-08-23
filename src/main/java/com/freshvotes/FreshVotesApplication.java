package com.freshvotes;

import com.freshvotes.domains.User;
import com.freshvotes.repositories.UserRepository;
import com.freshvotes.service.UserDetailsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreshVotesApplication {

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(FreshVotesApplication.class, args);
	}


	public void run(String... args)throws Exception{
		userRepo.save( new User(12L,"Shiv","pwd1","test1"));
		userRepo.save( new User(13L,"Shiv","pwd1","test1"));
		userRepo.save( new User(14L,"Shiv","pwd1","test1"));
	}

}
