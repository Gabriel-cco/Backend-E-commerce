package br.com.sale.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.sale.domain.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Campo obrigatório")
	@Length(min = 5, max = 80, message = "Você deve preencher esse campo de 5 à 80 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;

	public ClientDTO() {
	}
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		nome = entity.getName();
		email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Client fromDTO(ClientDTO dto) {
		return new Client(dto.getId(), dto.getNome(), dto.getEmail(), null, null);
	}
	
	
	
	
}
