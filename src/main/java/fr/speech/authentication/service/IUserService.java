package fr.speech.authentication.service;

import fr.speech.authentication.model.User;

public interface IUserService {

	User saveUser(User user);
	
	User getByUsername(String username);
}
