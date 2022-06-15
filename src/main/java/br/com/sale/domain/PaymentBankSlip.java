package br.com.sale.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.sale.domain.enums.EstatePayment;

@Entity(name = "tb_payment_bank_slip")
public class PaymentBankSlip extends Payment {

	private static final long serialVersionUID = 1L;

	private EstatePayment estatePayment;

	// dataDeVencimento
	private Date dueDate;

	private Date paymentDate;

	public PaymentBankSlip() {
	}

	public PaymentBankSlip(Long id, EstatePayment estatePayment, Pedido pedido, Date dueDate, Date paymentDate) {
		super(id, estatePayment, pedido);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public EstatePayment getEstatePayment() {
		return estatePayment;
	}

	public void setEstatePayment(EstatePayment estatePayment) {
		this.estatePayment = estatePayment;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
