package br.com.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sale.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	/*
	 * @Transactional(readOnly = true) Page<Pedido> findByCliente(Client client,
	 * Pageable pageRequest);
	 */
}
