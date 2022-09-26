package com.miguelteles.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.miguelteles.projeto.domain.Post;

@Repository	
public interface PostRepository extends MongoRepository<Post, String>{

	
	
}
