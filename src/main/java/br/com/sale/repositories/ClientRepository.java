package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sale.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
