package lab.rest.security.OAuth2JWT.service;


import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lab.rest.security.OAuth2JWT.domain.User;
import lab.rest.security.OAuth2JWT.domain.UserRole;
import lab.rest.security.OAuth2JWT.repository.UserRepository;



@Service
@Transactional
public class SignupService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	
	
	@PostConstruct
	private void setupDefaultUser() {
		//-- just to make sure there is an ADMIN user exist in the database for testing purpose
		if (userRepository.count() == 0) {
			userRepository.save(new User("crmadmin", 
									passwordEncoder.encode("adminpass"), 
									Arrays.asList(new UserRole("USER"), new UserRole("ADMIN"))));
		}		
	}

}
