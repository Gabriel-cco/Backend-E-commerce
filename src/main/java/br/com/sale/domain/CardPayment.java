package br.com.sale.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.sale.domain.enums.EstatePayment;

@Entity(name = "tb_cart_payment")
@JsonTypeName("pagamentoComCartao")
public class CardPayment extends Payment {

	private static final long serialVersionUID = 1L;

	private Integer estatePayment;

	private Integer numberInstallments;

	public CardPayment() {
	}

	public CardPayment(Long id, EstatePayment estatePayment, Pedido pedido, Integer numberInstallments) {
		super(id, estatePayment, pedido);
		this.numberInstallments = numberInstallments;
	}

	public EstatePayment getEstatePayment() {
		return EstatePayment.valueOf(estatePayment);
	}

	public void setEstatePayment(EstatePayment estatePayment) {
		this.estatePayment = estatePayment.getCode();
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

}
