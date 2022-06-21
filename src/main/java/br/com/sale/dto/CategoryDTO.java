package br.com.sale.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.sale.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Campo obrigatório")
	@Length(min = 5, max = 80, message = "Você deve preencher esse campo de 5 à 80 caracteres")
	private String nome;

	public CategoryDTO() {
	}
	
	public CategoryDTO(Category entity) {
		id = entity.getId();
		nome = entity.getNome();
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
	
	public static Category fromDTO(CategoryDTO dto) {
		return new Category(dto.id, dto.getNome());
	}
	
	
}
