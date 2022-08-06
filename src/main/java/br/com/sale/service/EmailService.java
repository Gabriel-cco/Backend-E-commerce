package br.com.sale.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.sale.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfimationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage obj);

}
