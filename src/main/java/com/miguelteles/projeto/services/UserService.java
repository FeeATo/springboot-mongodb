package com.miguelteles.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelteles.projeto.domain.User;
import com.miguelteles.projeto.repository.UserRepository;
import com.miguelteles.projeto.services.exception.ObjectNotFoundException;

@Service //fala pro spring que isso é um Service
public class UserService {
	
	//para a camada Repository conversar com a camada de serviços, é preciso criar um objeto do tipo do repositório
	@Autowired //o spring vai instanciar esse objeto automaticamente
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll(); //esta função vem do repositório do spring data, eu não criei
	}
	
	public User findById(String id) {
		//Optional is a variable that may or may not have a non-null value
		Optional<User> user = repo.findById(id); //esta função vem do spring
		return user.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
