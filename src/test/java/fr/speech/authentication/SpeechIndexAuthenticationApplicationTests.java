package fr.speech.authentication;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.speech.authentication.model.User;
import fr.speech.authentication.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpeechIndexAuthenticationApplicationTests {
	
	
	@Autowired
	private IUserService iUserService;
	

	@Test
	@Ignore
	public void addUsers()
	{
		List<User> users = Arrays.asList(new User("mourad","mourad"),new User("sonia","sonia"),new User("adel","adel"));
		users.forEach(user->{
			iUserService.saveUser(user);
		});
		
	}

}
