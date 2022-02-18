package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sale.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
