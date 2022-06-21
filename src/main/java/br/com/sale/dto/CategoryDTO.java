package br.com.sale.dto;

import java.io.Serializable;

import br.com.sale.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
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
	
	
}
