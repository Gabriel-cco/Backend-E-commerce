package br.com.sale.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.sale.domain.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Campo obrigatório")
	@Length(min = 5, max = 80, message = "Você deve preencher esse campo de 5 à 80 caracteres")
	private String nome;

	private BigDecimal preco;

	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		nome = entity.getNome();
		preco = entity.getPreco();
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public static Product fromDTO(ProductDTO dto) {
		return new Product(dto.id, dto.getNome(), dto.getPreco());
	}

}
