package br.com.sale.domain.enums;

public enum EstatePayment {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int code;
	private String descricao;

	private EstatePayment(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static EstatePayment valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for (EstatePayment value : EstatePayment.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid orderStatus code");
	}
 
}


