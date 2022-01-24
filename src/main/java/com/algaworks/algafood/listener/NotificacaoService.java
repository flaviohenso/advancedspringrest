package com.algaworks.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.event.ClientAtivadoEvent;

@Component
public class NotificacaoService {
	
	private Notificador notificador;

	
	@Autowired
	public NotificacaoService(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador) {
		this.notificador = notificador;
	}

	@EventListener
	public void clienteAtivadoListerner(ClientAtivadoEvent event) {
		notificador.notificar(event.getCliente(),"Seu cadastro no sistemas esta ativo!");
	}
}
