package br.com.sale;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sale.domain.Address;
import br.com.sale.domain.CardPayment;
import br.com.sale.domain.Category;
import br.com.sale.domain.City;
import br.com.sale.domain.Client;
import br.com.sale.domain.Estate;
import br.com.sale.domain.OrderItem;
import br.com.sale.domain.Payment;
import br.com.sale.domain.PaymentBankSlip;
import br.com.sale.domain.Pedido;
import br.com.sale.domain.Product;
import br.com.sale.domain.enums.EstatePayment;
import br.com.sale.domain.enums.TypeClient;
import br.com.sale.repositories.AddressRepository;
import br.com.sale.repositories.CategoryRepository;
import br.com.sale.repositories.CityRepository;
import br.com.sale.repositories.ClientRepository;
import br.com.sale.repositories.EstateRepository;
import br.com.sale.repositories.OrderItemRepository;
import br.com.sale.repositories.PaymentRepository;
import br.com.sale.repositories.PedidoRepository;
import br.com.sale.repositories.ProductRepository;

@SpringBootApplication
public class SaleApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository prodRepo;

	@Autowired
	private EstateRepository estateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private AddressRepository adressRepo;
	
	@Autowired
	PedidoRepository pedidoRepo;

	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	OrderItemRepository OrderItemRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(SaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informatica");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");
		Category cat8 = new Category(null, "Roupas");
		Category cat9 = new Category(null, "Infantil");
		Category cat10 = new Category(null, "Automotivos");
		
		Product prod1 = new Product(null, "Computador", new BigDecimal("2000.00"));
		Product prod2 = new Product(null, "Impressora", new BigDecimal("800.00"));
		Product prod3 = new Product(null, "Mouse", new BigDecimal("80.00"));

		cat1.getProduct().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProduct().addAll(Arrays.asList(prod2));

		prod1.getCategorys().addAll(Arrays.asList(cat1));
		prod2.getCategorys().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorys().addAll(Arrays.asList(cat1));

		Estate est1 = new Estate(null, "Minas Gerais");
		Estate est2 = new Estate(null, "São Paulo");

		City city1 = new City(null, "Uberlândia", est1);
		City city2 = new City(null, "São Paulo", est2);
		City city3 = new City(null, "Campinas", est1);

		estateRepo.saveAll(Arrays.asList(est1, est2));
		cityRepo.saveAll(Arrays.asList(city1, city2, city3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		prodRepo.saveAll(Arrays.asList(prod1, prod2, prod3));

		Client cli1 = new Client(null, "Gabriel Batista", "gabrielbatista78@hotmail.com", "36378912377",
				TypeClient.PESSOAFISICA);
		cli1.getFones().addAll(Arrays.asList("99999999", "88888888"));

		Address adress1 = new Address(null, "Rua Flores", "300", "Apto", "Jardim", "28220834", cli1, city3);
		Address adress2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38551177", cli1, city2);

		cli1.getAddress().addAll(Arrays.asList(adress1, adress2));

		clientRepo.saveAll(Arrays.asList(cli1));
		adressRepo.saveAll(Arrays.asList(adress1, adress2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("11/06/2022 22:46"), cli1, adress1);
		Pedido ped2 = new Pedido(null, sdf.parse("11/06/2022 22:51"), cli1, adress2);

		Payment pay1 = new CardPayment(null, EstatePayment.QUITADO, ped1, 6);
		ped1.setPayment(pay1);
		
		Payment pay2 = new PaymentBankSlip(null, EstatePayment.PENDENTE, ped2, sdf.parse("15/06/2022 00:00"), null);
		ped2.setPayment(pay2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		paymentRepo.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem order1 = new OrderItem(ped1, prod1, new BigDecimal("0.00"), 1, new BigDecimal("2000.00"));
		OrderItem order2 = new OrderItem(ped1, prod3, new BigDecimal("0.00"), 2, new BigDecimal("80.00"));
		OrderItem order3 = new OrderItem(ped2, prod2, new BigDecimal("100.00"), 1, new BigDecimal("800.00"));
		
		ped1.getItens().addAll(Arrays.asList(order1, order2));
		ped2.getItens().addAll(Arrays.asList(order3));
		
		prod1.getItens().addAll(Arrays.asList(order1));
		prod2.getItens().addAll(Arrays.asList(order3));
		prod3.getItens().addAll(Arrays.asList(order2));
		
		OrderItemRepos.saveAll(Arrays.asList(order1, order2, order3));
	}

}
