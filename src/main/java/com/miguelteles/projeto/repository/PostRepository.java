package com.miguelteles.projeto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.miguelteles.projeto.domain.Post;

@Repository	
public interface PostRepository extends MongoRepository<Post, String>{

	//usando @Query //-> busca todos os posts que contêm uma substring x no título
	@Query("{ 'title': { $regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	//usando query methods:
	//este método é criado automaticamente pelo Spring. É preciso checar como funciona a nomeação de métodos para que seja criado automaticamente: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	
	//findBy<Nome_do_Parâmetro>Containing(String text). O "IgnoreCase" é a notação para o spring ignorar se é maiúsculo ou minúsculo
	List<Post> findByTitleContainingIgnoreCase(String text);	
	
	////////////
	
	//Buscar posts contendo um dado string em qualquer lugar (no título, corpo ou comentários) e em um dado	intervalo de datas
	//critérios: https://www.mongodb.com/docs/manual/reference/operator/query/and/
	//			e		↓ onde 'date' for 'gte (greater than)' o parâmetro de index 1 (?1) passado na url (minDate)
	//										   ↓ onde 'date' for 'lte (lesser than)' o parâmetro de index 2 (?2) passado na url (maxDate)
	//			e (												  , ou (        title for igual ao parâmetro de index 0, opção 'i (ignore case)'	
	//                                    																					body for igual ao parâmtro de index 0
	//																																								   comments.text (lista de comments, cada comment tem uma propriedade text) for igual ao...
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> customSearch(String text, Date minDate, Date maxDate);
}
