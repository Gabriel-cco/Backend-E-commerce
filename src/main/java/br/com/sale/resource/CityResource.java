package br.com.sale.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sale.domain.City;
import br.com.sale.service.CityService;

@RestController
@RequestMapping(value = "/city")
public class CityResource {

	@Autowired
	private CityService catService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<City>> findAll() {
		List<City> list = catService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> findById(@PathVariable Long id) {
		City obj = catService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
