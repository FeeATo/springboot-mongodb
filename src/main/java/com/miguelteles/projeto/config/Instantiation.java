package com.miguelteles.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.miguelteles.projeto.DTO.AuthorDTO;
import com.miguelteles.projeto.DTO.CommentDTO;
import com.miguelteles.projeto.domain.Post;
import com.miguelteles.projeto.domain.User;
import com.miguelteles.projeto.repository.PostRepository;
import com.miguelteles.projeto.repository.UserRepository;

@Configuration //para o spring entender que isso é uma configuração
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; //o spring faz a injeção de dependência automaticamente, não precisa criar um Factory
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll(); //deleta tudo antes de popular novamente, apenas por teste
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria)); //salva no banco duas cópias diferentes de 'maria', não é uma referência
				
		CommentDTO c1 = new CommentDTO("Boa viagem, mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2)); //salva no banco
		
		maria.getPosts().addAll((Arrays.asList(post1,post2))); //associa os posts à maria
		userRepository.save(maria);
	}

}
