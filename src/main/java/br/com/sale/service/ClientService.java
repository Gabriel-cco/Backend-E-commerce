package br.com.sale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sale.domain.Address;
import br.com.sale.domain.City;
import br.com.sale.domain.Client;
import br.com.sale.domain.enums.Perfil;
import br.com.sale.domain.enums.TypeClient;
import br.com.sale.dto.ClientNewDTO;
import br.com.sale.repositories.AddressRepository;
import br.com.sale.repositories.ClientRepository;
import br.com.sale.security.UserSS;
import br.com.sale.services.exception.AuthorizationException;
import br.com.sale.services.exception.DataIntegrityException;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private AddressRepository addRepo;
	
	@Autowired
	private static BCryptPasswordEncoder pe;

	@Transactional
	public Client insert(Client client) {
		client.setId(null);
		client = repo.save(client);
		addRepo.saveAll(client.getAddress());
		return client;
	}
	
	public Client update(Client client) {
	Client newEntity = findById(client.getId());
	updateData(newEntity, client);
		 return repo.save(newEntity);
	}

	public void delete(Long id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("O cliente possui pedidos relacionados, não é possivel exclui-lo");
		}
	}

	public Client findById(Long id) {
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}

	public List<Client> findAll() {
		return repo.findAll();
	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	private void updateData(Client newObject, Client obj) {
		newObject.setEmail(obj.getEmail());
		newObject.setName(obj.getName());
	}
	

	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TypeClient.valueOf(objDto.getTipo()), pe.encode(objDto.getSenha()));
		City cid = new City(objDto.getCidadeId(), null, null);
		Address end = new Address(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getAddress().add(end);
		cli.getFones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getFones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getFones().add(objDto.getTelefone3());
		}
		return cli;
	}
}
