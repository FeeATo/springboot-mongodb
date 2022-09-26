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

import com.miguelteles.projeto.DTO.CommentDTO;
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
	
	@GetMapping(value="/{id}/comments")
	public ResponseEntity<List<CommentDTO>> getComments(@PathVariable String id){
		List<CommentDTO> list = service.getComments(id);
		return ResponseEntity.ok().body(list);
	}
		
	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<Void> insert(@RequestBody Post obj){				
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
					
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post obj){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}		
}
