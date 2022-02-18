package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sale.domain.Estate;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {

}
