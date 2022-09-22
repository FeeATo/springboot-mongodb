package com.miguelteles.projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miguelteles.projeto.DTO.UserDTO;
import com.miguelteles.projeto.domain.User;
import com.miguelteles.projeto.services.UserService;

//os recursos REST ficam na subpasta .resources, que é disponibilizada pelo backend

@RestController //-> fala que esta classe é um recurso REST
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired //-> spring instancia automaticamente, por isso já podemos usar esse objeto
	private UserService service; //essa dependência serve para acessar o serviço que acessa o banco de dados. Controlador Rest -> Serviço -> Repositório
	
	
	//ou @GetMapping
	@RequestMapping(method=RequestMethod.GET) //-> diz que este método é um endpoint REST para aquele caminho ("/users")
			// retorna um objeto sofisticado ResponseEntity<T> que encapsula toda uma estrutura necessária pra retornar respostas HTTP, já com possíveis cabeçalhos, possíveis erros, etc. 
			// poderia ser só List<User> mas é melhor com esse objeto sofisticado
	public ResponseEntity<List<UserDTO>> findAll(){		
		//					↓ spring já instanciou esse objeto automaticamente, por isso já podemos usá-lo.
		List<User> list = service.findAll();
												//pra cada x, retornará:
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
}
