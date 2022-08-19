package br.com.sale.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sale.domain.Client;
import br.com.sale.domain.OrderItem;
import br.com.sale.domain.PaymentBankSlip;
import br.com.sale.domain.Pedido;
import br.com.sale.domain.enums.EstatePayment;
import br.com.sale.repositories.OrderItemRepository;
import br.com.sale.repositories.PaymentRepository;
import br.com.sale.repositories.PedidoRepository;
import br.com.sale.security.UserSS;
import br.com.sale.services.exception.AuthorizationException;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Autowired
	private ProductService productService;

	@Autowired
	private ClientService clientService;

	public Pedido findById(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!	 Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public List<Pedido> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setClient(clientService.findById(pedido.getClient().getId()));
		pedido.setInstant(new Date());
		pedido.getPayment().setEstatePayment(EstatePayment.PENDENTE);
		pedido.getPayment().setPedido(pedido);
		if (pedido.getPayment() instanceof PaymentBankSlip) {
			PaymentBankSlip bankSlip = (PaymentBankSlip) pedido.getPayment();
			preenchimentoBoleto(bankSlip, pedido.getInstant());
		}
		pedido = repo.save(pedido);
		paymentRepo.save(pedido.getPayment());
		for (OrderItem order : pedido.getItens()) {
			order.setDiscount(BigDecimal.valueOf(0.0));
			order.setProduct(productService.findById(order.getProduct().getId()));
			order.setPrice(order.getProduct().getPreco());
			order.setPedido(pedido);

		}
		orderItemRepo.saveAll(pedido.getItens());
		return pedido;
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client client = clientService.findById(user.getId());
		return repo.findByClient(client, pageRequest);
	}

	private PaymentBankSlip preenchimentoBoleto(PaymentBankSlip bankSlip, Date intantPayment) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(intantPayment);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		bankSlip.setPaymentDate(cal.getTime());
		return bankSlip;
	}

}
