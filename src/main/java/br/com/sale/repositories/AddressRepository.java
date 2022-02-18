package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sale.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
