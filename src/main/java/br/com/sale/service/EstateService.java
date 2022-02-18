package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sale.domain.Estate;
import br.com.sale.repositories.EstateRepository;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class EstateService {

	@Autowired
	private EstateRepository repo;

	public Estate findById(Long id) {
		Optional<Estate> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estate.class.getName()));
	}

	public List<Estate> findAll() {
		return repo.findAll();
	}

	public void insert(Estate category) {
		repo.save(category);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
