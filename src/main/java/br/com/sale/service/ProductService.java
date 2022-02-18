package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sale.domain.Product;
import br.com.sale.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

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
}
