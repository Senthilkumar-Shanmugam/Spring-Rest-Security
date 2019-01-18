package lab.rest.security.OAuth2JWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	@GetMapping
    public String home() {
		System.out.println("inside service");
        return "Hello World";
    }

}
