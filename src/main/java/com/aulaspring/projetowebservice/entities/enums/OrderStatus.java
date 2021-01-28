package com.aulaspring.projetowebservice.entities.enums;

public enum OrderStatus {
	
	//Atribuição dos valores
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//Criamos o construtor private para receber o código
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//Criamos um método público para acessar o construtor
	public int getCode() {
		return code;
	}

	//Criamos um método statico para converter um valor numérico para o tipo enumerado
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
