package com.miguelteles.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelteles.projeto.DTO.CommentDTO;
import com.miguelteles.projeto.domain.Post;
import com.miguelteles.projeto.repository.PostRepository;
import com.miguelteles.projeto.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}	

	public List<CommentDTO> getComments(String id){
		return findById(id).getComments();
	}
	
	public Post insert(Post obj) {		
		return repo.insert(obj);
	}

	public void delete(String id) {
		repo.deleteById(id);		
	}

	public Post update(Post obj) {
		Post newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		
	
	private void updateData(Post newObj, Post obj) {
		//copia os dados de obj para o newObj
		newObj.setBody(obj.getBody());
		newObj.setTitle(obj.getTitle());		
	}
	
	
	
	public Post insertComment(CommentDTO comment, String idPost) {
		Post post = findById(idPost);
		post.getComments().add(comment);		
		return repo.save(post);
	}
	
	
}
