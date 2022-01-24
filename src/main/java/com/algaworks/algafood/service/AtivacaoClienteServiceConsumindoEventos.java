package com.algaworks.algafood.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.event.ClientAtivadoEvent;
import com.algaworks.algafood.modelo.Cliente;

@Service
public class AtivacaoClienteServiceConsumindoEventos {

	//@Autowired(required = true) // quando o required estiver definido não pode possuir construtor, pq senao o spring vai ficar informando que a injecao é requerida
	private Notificador notificador;

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	public AtivacaoClienteServiceConsumindoEventos(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador, ApplicationEventPublisher applicationEventPublisher) {
		this.notificador = notificador;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		applicationEventPublisher.publishEvent(new ClientAtivadoEvent(cliente));
		//notificador.notificar(cliente, "Seu cadastro esta ativo!");

	}

}
