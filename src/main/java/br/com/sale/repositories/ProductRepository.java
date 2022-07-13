package br.com.sale.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sale.domain.Category;
import br.com.sale.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// @Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categorys cat
	// WHERE obj.nome LIKE %:nome% AND cat IN :categorys ")
	@Transactional(readOnly = true)
	Page<Product> findDistinctByNomeContainingAndCategorysIn(String nome, List<Category> categorias,
			Pageable pageRequest);

}
