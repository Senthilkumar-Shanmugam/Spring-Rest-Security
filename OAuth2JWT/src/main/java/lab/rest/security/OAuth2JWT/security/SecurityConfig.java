package lab.rest.security.OAuth2JWT.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.
		     formLogin().disable().
		     anonymous().disable().
		     authorizeRequests().anyRequest().denyAll();
		     
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().
		      withUser("user").password("password").roles("USER").and()
		      .withUser("admin").password("admin").authorities("ROLE_ADMIN");
		      
	}

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}
}
