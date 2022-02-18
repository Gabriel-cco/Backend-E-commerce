package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sale.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
