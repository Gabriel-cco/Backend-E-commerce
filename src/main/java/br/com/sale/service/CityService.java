package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sale.domain.City;
import br.com.sale.repositories.CityRepository;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;

	public City findById(Long id) {
		Optional<City> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + City.class.getName()));
	}

	public List<City> findAll() {
		return repo.findAll();
	}

	public void insert(City category) {
		repo.save(category);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
