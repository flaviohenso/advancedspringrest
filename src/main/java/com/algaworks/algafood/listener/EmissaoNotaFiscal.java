package com.algaworks.algafood.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.event.CompraEvent;

@Component
public class EmissaoNotaFiscal {

	@EventListener
	public void emitirNotaFiscal(CompraEvent compraEvent) { // esse evento só vai funcionar se o metodo publish for desparado com um compraEvent
		System.out.println("Emitindo nota fiscal para o cleinte: " + compraEvent.getCliente());
	}
	
}
