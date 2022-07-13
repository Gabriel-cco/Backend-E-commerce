package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.sale.domain.Category;
import br.com.sale.domain.Product;
import br.com.sale.repositories.CategoryRepository;
import br.com.sale.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository catRepo;

	public Product findById(Long id) {
		Optional<Product> obj = repo.findById(id);
		return obj.get();
	}

	public List<Product> findAll() {
		return repo.findAll();
	}

	public void insert(Product product) {
		repo.save(product);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Page<Product> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categorias = catRepo.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategorysIn(nome, categorias, pageRequest);
	}
}
