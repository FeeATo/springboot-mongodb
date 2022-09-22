package com.miguelteles.projeto.DTO;

import java.io.Serializable;

import com.miguelteles.projeto.domain.User;

/* Data Transfer Object - DTO
 * É um objeto que tem o papel de carregar dados das entidades de forma simples,
 * podendo inclusive "projetar" apenas alguns dados da entidade original. Vantagens:
 * - Otimizar o tráfego;
 * - Evitar que dados de interesse exclusivo do sistema fiquem sendo expostos;
 * - Customizar os objetos trafegados conforme a necessidade de cada requisição;
 * 
 * */

public class UserDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {}
	
	public UserDTO(User obj) { //recebe um objeto pra contruir
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
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
}
