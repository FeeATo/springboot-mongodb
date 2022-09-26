package com.miguelteles.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Post insert(Post obj) {		
		return repo.insert(obj);
	}
}
