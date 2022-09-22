package com.miguelteles.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.miguelteles.projeto.domain.User;

/* Padrão de camadas
 * 
 * O sistema é definido da seguinta maneira:
 * 
 * Front-end 
 * 	   ↕
 * ________________________________________________________
 * Controladores REST______________________________________|
 * ________________________________________________________
 * Camada de serviço_____________________|     Camada de   |
 * Camada de acesso a dados (Repository)_|_____domínio_____|
 * 
 * */

@Repository	//fala pro string q é isso é um repositório	//Qual entidade ele vai ser responsável e seu tipo do ID
public interface UserRepository extends MongoRepository<User, String>{

	
	
}
