package br.com.sale.domain.enums;

public enum TypeClient {

	PESSOAFISICA(1),
	PESSOAJURIDICA(2);

	private int code;

	private TypeClient(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TypeClient valueOf(Integer code) {
		
		if(code == null) {
			return null;
		}
		
		for (TypeClient value : TypeClient.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid orderStatus code");
	}
 
}


