package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.sale.domain.Category;
import br.com.sale.repositories.CategoryRepository;
import br.com.sale.services.exception.DataIntegrityException;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category findById(Long id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
	}

	public List<Category> findAll() {
		return repo.findAll();
	}

	public void insert(Category category) {
		category.setId(null);
		repo.save(category);
	}
	
	public Category update(Category category) {
		findById(category.getId());
		return repo.save(category);
	}
	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("A categoria possui produtos inseridos, não é possivel exclui-la");
		}
	}
}
