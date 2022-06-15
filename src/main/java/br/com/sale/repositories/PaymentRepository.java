package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sale.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
