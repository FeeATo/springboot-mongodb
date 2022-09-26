package com.miguelteles.projeto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.miguelteles.projeto.domain.Post;

@Repository	
public interface PostRepository extends MongoRepository<Post, String>{

	//este método é criado automaticamente pelo Spring. É preciso checar como funciona a nomeação de métodos para que seja criado automaticamente: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	
	//findBy<Nome_do_Parâmetro>Containing(String text). O "IgnoreCase" é a notação para o spring ignorar se é maiúsculo ou minúsculo
	List<Post> findByTitleContainingIgnoreCase(String text);	
}
