package com.algaworks.algafood.component;

import com.algaworks.algafood.modelo.Cliente;

public interface Notificador {
	
	public void notificar(Cliente cliente, String msg);

}
