package br.com.sale.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sale.domain.Estate;
import br.com.sale.service.EstateService;

@RestController
@RequestMapping(value = "/estate")
public class EstateResource {

	@Autowired
	private EstateService catService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estate>> findAll() {
		List<Estate> list = catService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estate> findById(@PathVariable Long id) {
		Estate obj = catService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
