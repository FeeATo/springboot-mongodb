package com.miguelteles.projeto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.miguelteles.projeto.domain.Post;
import com.miguelteles.projeto.services.PostService;

@RestController 
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired 
	private PostService service; 		
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){			
		Post obj = service.findById(id);												
		return ResponseEntity.ok().body(obj);		
	}	
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//ou PostMapping
	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<Void> insert(@RequestBody Post obj){				
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
					
		return ResponseEntity.created(uri).build();
	}
}
