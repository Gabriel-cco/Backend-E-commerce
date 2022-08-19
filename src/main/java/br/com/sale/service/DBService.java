
package br.com.sale.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import br.com.sale.domain.enums.Perfil;
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

@Service
public class DBService {

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
	private BCryptPasswordEncoder pe;

	@Autowired
	private PedidoRepository pedidoRepo;

	@Autowired
	PaymentRepository paymentRepo;

	@Autowired
	OrderItemRepository orderItemRepo;

	public void instantiateTestDataBase() throws ParseException {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");

		Product p1 = new Product(null, "Computador", BigDecimal.valueOf(2000.00));
		Product p2 = new Product(null, "Impressora", BigDecimal.valueOf(800.00));
		Product p3 = new Product(null, "Mouse", BigDecimal.valueOf(80.00));
		Product p4 = new Product(null, "Mesa de escritório", BigDecimal.valueOf(300.00));
		Product p5 = new Product(null, "Toalha", BigDecimal.valueOf(50.00));
		Product p6 = new Product(null, "Colcha", BigDecimal.valueOf(200.00));
		Product p7 = new Product(null, "TV true color", BigDecimal.valueOf(1200.00));
		Product p8 = new Product(null, "Roçadeira", BigDecimal.valueOf(800.00));
		Product p9 = new Product(null, "Abajour", BigDecimal.valueOf(100.00));
		Product p10 = new Product(null, "Pendente", BigDecimal.valueOf(180.00));
		Product p11 = new Product(null, "Shampoo", BigDecimal.valueOf(90.00));

		Product p12 = new Product(null, "Product 12", BigDecimal.valueOf(10.00));
		Product p13 = new Product(null, "Product 13", BigDecimal.valueOf(10.00));
		Product p14 = new Product(null, "Product 14", BigDecimal.valueOf(10.00));
		Product p15 = new Product(null, "Product 15", BigDecimal.valueOf(10.00));
		Product p16 = new Product(null, "Product 16", BigDecimal.valueOf(10.00));
		Product p17 = new Product(null, "Product 17", BigDecimal.valueOf(10.00));
		Product p18 = new Product(null, "Product 18", BigDecimal.valueOf(10.00));
		Product p19 = new Product(null, "Product 19", BigDecimal.valueOf(10.00));
		Product p20 = new Product(null, "Product 20", BigDecimal.valueOf(10.00));
		Product p21 = new Product(null, "Product 21", BigDecimal.valueOf(10.00));
		Product p22 = new Product(null, "Product 22", BigDecimal.valueOf(10.00));
		Product p23 = new Product(null, "Product 23", BigDecimal.valueOf(10.00));
		Product p24 = new Product(null, "Product 24", BigDecimal.valueOf(10.00));
		Product p25 = new Product(null, "Product 25", BigDecimal.valueOf(10.00));
		Product p26 = new Product(null, "Product 26", BigDecimal.valueOf(10.00));
		Product p27 = new Product(null, "Product 27", BigDecimal.valueOf(10.00));
		Product p28 = new Product(null, "Product 28", BigDecimal.valueOf(10.00));
		Product p29 = new Product(null, "Product 29", BigDecimal.valueOf(10.00));
		Product p30 = new Product(null, "Product 30", BigDecimal.valueOf(10.00));
		Product p31 = new Product(null, "Product 31", BigDecimal.valueOf(10.00));
		Product p32 = new Product(null, "Product 32", BigDecimal.valueOf(10.00));
		Product p33 = new Product(null, "Product 33", BigDecimal.valueOf(10.00));
		Product p34 = new Product(null, "Product 34", BigDecimal.valueOf(10.00));
		Product p35 = new Product(null, "Product 35", BigDecimal.valueOf(10.00));
		Product p36 = new Product(null, "Product 36", BigDecimal.valueOf(10.00));
		Product p37 = new Product(null, "Product 37", BigDecimal.valueOf(10.00));
		Product p38 = new Product(null, "Product 38", BigDecimal.valueOf(10.00));
		Product p39 = new Product(null, "Product 39", BigDecimal.valueOf(10.00));
		Product p40 = new Product(null, "Product 40", BigDecimal.valueOf(10.00));
		Product p41 = new Product(null, "Product 41", BigDecimal.valueOf(10.00));
		Product p42 = new Product(null, "Product 42", BigDecimal.valueOf(10.00));
		Product p43 = new Product(null, "Product 43", BigDecimal.valueOf(10.00));
		Product p44 = new Product(null, "Product 44", BigDecimal.valueOf(10.00));
		Product p45 = new Product(null, "Product 45", BigDecimal.valueOf(10.00));
		Product p46 = new Product(null, "Product 46", BigDecimal.valueOf(10.00));
		Product p47 = new Product(null, "Product 47", BigDecimal.valueOf(10.00));
		Product p48 = new Product(null, "Product 48", BigDecimal.valueOf(10.00));
		Product p49 = new Product(null, "Product 49", BigDecimal.valueOf(10.00));
		Product p50 = new Product(null, "Product 50", BigDecimal.valueOf(10.00));

		cat1.getProduct()
				.addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
						p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
						p48, p49, p50));

		p12.getCategorys().add(cat1);
		p13.getCategorys().add(cat1);
		p14.getCategorys().add(cat1);
		p15.getCategorys().add(cat1);
		p16.getCategorys().add(cat1);
		p17.getCategorys().add(cat1);
		p18.getCategorys().add(cat1);
		p19.getCategorys().add(cat1);
		p20.getCategorys().add(cat1);
		p21.getCategorys().add(cat1);
		p22.getCategorys().add(cat1);
		p23.getCategorys().add(cat1);
		p24.getCategorys().add(cat1);
		p25.getCategorys().add(cat1);
		p26.getCategorys().add(cat1);
		p27.getCategorys().add(cat1);
		p28.getCategorys().add(cat1);
		p29.getCategorys().add(cat1);
		p30.getCategorys().add(cat1);
		p31.getCategorys().add(cat1);
		p32.getCategorys().add(cat1);
		p33.getCategorys().add(cat1);
		p34.getCategorys().add(cat1);
		p35.getCategorys().add(cat1);
		p36.getCategorys().add(cat1);
		p37.getCategorys().add(cat1);
		p38.getCategorys().add(cat1);
		p39.getCategorys().add(cat1);
		p40.getCategorys().add(cat1);
		p41.getCategorys().add(cat1);
		p42.getCategorys().add(cat1);
		p43.getCategorys().add(cat1);
		p44.getCategorys().add(cat1);
		p45.getCategorys().add(cat1);
		p46.getCategorys().add(cat1);
		p47.getCategorys().add(cat1);
		p48.getCategorys().add(cat1);
		p49.getCategorys().add(cat1);
		p50.getCategorys().add(cat1);

		cat1.getProduct().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduct().addAll(Arrays.asList(p2, p4));
		cat3.getProduct().addAll(Arrays.asList(p5, p6));
		cat4.getProduct().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProduct().addAll(Arrays.asList(p8));
		cat6.getProduct().addAll(Arrays.asList(p9, p10));
		cat7.getProduct().addAll(Arrays.asList(p11));

		p1.getCategorys().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorys().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorys().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorys().addAll(Arrays.asList(cat2));
		p5.getCategorys().addAll(Arrays.asList(cat3));
		p6.getCategorys().addAll(Arrays.asList(cat3));
		p7.getCategorys().addAll(Arrays.asList(cat4));
		p8.getCategorys().addAll(Arrays.asList(cat5));
		p9.getCategorys().addAll(Arrays.asList(cat6));
		p10.getCategorys().addAll(Arrays.asList(cat6));
		p11.getCategorys().addAll(Arrays.asList(cat7));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		prodRepo.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
				p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47, p48,
				p49, p50));

		Estate est1 = new Estate(null, "Minas Gerais");
		Estate est2 = new Estate(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCity().addAll(Arrays.asList(c1));
		est2.getCity().addAll(Arrays.asList(c2, c3));

		estateRepo.saveAll(Arrays.asList(est1, est2));
		cityRepo.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Gabriel Batista da Silva", "gabrielbatista1551@gmail.com", "36378912377",
				TypeClient.PESSOAFISICA, pe.encode("123"));

		cli1.getFones().addAll(Arrays.asList("27363323", "93838393"));

		Client cli2 = new Client(null, "Batista Gabriel", "gabrielbatista78@hotmail.com", "31628382740",
				TypeClient.PESSOAFISICA, pe.encode("123"));
		cli2.getFones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);

		Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Address e3 = new Address(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);

		cli1.getAddress().addAll(Arrays.asList(e1, e2));
		cli2.getAddress().addAll(Arrays.asList(e3));

		clientRepo.saveAll(Arrays.asList(cli1, cli2));
		adressRepo.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Payment pagto1 = new CardPayment(null, EstatePayment.QUITADO, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentBankSlip(null, EstatePayment.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		paymentRepo.saveAll(Arrays.asList(pagto1, pagto2));

		OrderItem ip1 = new OrderItem(ped1, p1, BigDecimal.valueOf(0.00), 1, BigDecimal.valueOf(2000.00));
		OrderItem ip2 = new OrderItem(ped1, p3, BigDecimal.valueOf(0.00), 2, BigDecimal.valueOf(80.00));
		OrderItem ip3 = new OrderItem(ped2, p2, BigDecimal.valueOf(100.00), 1, BigDecimal.valueOf(800.00));

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		orderItemRepo.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
