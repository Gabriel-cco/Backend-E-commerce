package br.com.sale.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.sale.domain.Pedido;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	 @Override
	public void sendOrderConfimationEmail(Pedido obj) {
		 SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		 sendEmail(sm);
	 }

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getClient().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Olá, " + obj.getClient().getName() + " informamos que seu pedido de numero: " + obj.getId() + " foi confirmado!");
		sm.setSentDate(new Date());
		sm.setText(obj.toString());
		return sm;
	}
}
