package com.miguelteles.projeto.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){			
		User obj = service.findById(id);												
		return ResponseEntity.ok().body(new UserDTO(obj));		
	}
	
	//ou PostMapping
	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){		
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//created retorna o código 201, que é o código http de quando se cria um novo recurso (quando foi salvo no DB)
		return ResponseEntity.created(uri).build();	//retorna uma resposta vazia e um cabeçalho com o novo recurso criado	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){			
		service.delete(id);												
		return ResponseEntity.noContent().build(); //quando faz uma operação que não precisa retornar nada, o código é o 204 (.noContent())		
	}
	
	//ou PostMapping
	@RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){		
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
		
	
	
	
}
