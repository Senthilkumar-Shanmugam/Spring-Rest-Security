package lab.rest.security.OAuth2JWT.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab.rest.security.OAuth2JWT.domain.User;
import lab.rest.security.OAuth2JWT.domain.UserRole;
import lab.rest.security.OAuth2JWT.service.SignupService;

@RestController
public class SignupController {
	@Autowired
	private SignupService signupService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody User user) {
   		user.setRoles(Arrays.asList(new UserRole("USER")));
    	User newUser = signupService.addUser(user);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
	

}
