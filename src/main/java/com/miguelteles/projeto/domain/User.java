package com.miguelteles.projeto.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//a interface Serializable é capaz de transformar objetos em Bytes, para ser trafegado em rede, salvo em arquivos, etc.
			// ↓ se não colocar isso, o spring vai automaticamente mapear com uma entidade com o mesmo nome que a classe só que lowercase
@Document(collection="user") //-> fala pro Spring que esta classe corresponde a uma coleção do MongoDB. 
public class User implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id //fala pro spring que esse é o ID da coleção
	private String id;
	private String name;
	private String email;
	
	//ainda não tem associações
	
	public User() {}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
