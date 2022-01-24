package com.algaworks.algafood.event;

import com.algaworks.algafood.modelo.Cliente;

public class ClientAtivadoEvent {

	Cliente cliente = new Cliente();

	public ClientAtivadoEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
