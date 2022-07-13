package br.com.sale.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.sale.domain.Category;
import br.com.sale.repositories.CategoryRepository;

public class CategoryServiceTest {

	private CategoryRepository repos;
	private CategoryService service;

	@Test
	public void findAll() {
		List<Category> list = repos.findAll();
		System.out.println(Arrays.asList(list));
	}

	
	String re = "foo";
	
	@Test
	public boolean ifoo(String param) {
		if (param.equalsIgnoreCase("foo")) {
			return true;
		} else {
			return false;
		}
	}

}
