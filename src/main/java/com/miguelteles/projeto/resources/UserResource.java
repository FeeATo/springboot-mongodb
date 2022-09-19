package com.miguelteles.projeto.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miguelteles.projeto.domain.User;

//os recursos REST ficam na subpasta .resources, que é disponibilizada pelo backend

@RestController //-> fala que esta classe é um recurso REST
@RequestMapping(value="/users")
public class UserResource {
	
	//ou @GetMapping
	@RequestMapping(method=RequestMethod.GET) //-> diz que este método é um endpoint REST para aquele caminho ("/users")
			// retorna um objeto sofisticado ResponseEntity<T> que encapsula toda uma estrutura necessária pra retornar respostas HTTP, já com possíveis cabeçalhos, possíveis erros, etc. 
			// poderia ser só List<User> mas é melhor com esse objeto sofisticado
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex  = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
		
	}
}
