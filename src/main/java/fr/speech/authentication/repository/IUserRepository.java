package fr.speech.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.speech.authentication.model.User;



public interface IUserRepository extends JpaRepository<User, Integer> {

	User getByUserName(String username) ;
}
