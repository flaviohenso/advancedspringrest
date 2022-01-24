package com.algaworks.algafood.event;

public class CompraEvent {

	String cliente = "";

	public CompraEvent(String cliente) {
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente;
	}
	
}
