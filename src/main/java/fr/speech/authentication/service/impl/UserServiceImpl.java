package fr.speech.authentication.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.speech.authentication.model.Role;
import fr.speech.authentication.model.User;
import fr.speech.authentication.repository.IRoleRepository;
import fr.speech.authentication.repository.IUserRepository;
import fr.speech.authentication.service.IUserService;


@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IRoleRepository iRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = new Role("ROLE_ADMIN");
		iRoleRepository.save(role);
		user.setRoles(Arrays.asList(role));
		return iUserRepository.save(user);
	}
	
	@Override
	public User getByUsername(String username) {
		return iUserRepository.getByUserName(username);
	}

}