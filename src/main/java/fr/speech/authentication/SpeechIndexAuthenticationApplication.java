package fr.speech.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import fr.speech.authentication.security.CustomUserDetails;
import fr.speech.authentication.service.impl.UserServiceImpl;


@SpringBootApplication
public class SpeechIndexAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeechIndexAuthenticationApplication.class, args);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
    }
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserServiceImpl userService) throws Exception {
	    builder
            .userDetailsService(s -> { return new CustomUserDetails(userService.getByUsername(s)); })
            .passwordEncoder(passwordEncoder())
        ;
    }
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
}
