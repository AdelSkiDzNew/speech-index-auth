package fr.speech.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.speech.authentication.model.Role;


public interface IRoleRepository extends JpaRepository<Role, Integer>{

}
