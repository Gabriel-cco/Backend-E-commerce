package br.com.sale.domain.enums;

public enum EstatePayment {

	PENDENTE(1),
	QUITADO(2),
	CANCELADO(3);

	private int code;

	private EstatePayment(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
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


