package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sale.domain.Address;
import br.com.sale.repositories.AddressRepository;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;

	public Address findById(Long id) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Address.class.getName()));
	}

	public List<Address> findAll() {
		return repo.findAll();
	}

	public void insert(Address category) {
		repo.save(category);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
