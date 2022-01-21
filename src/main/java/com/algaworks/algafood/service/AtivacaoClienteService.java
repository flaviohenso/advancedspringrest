package com.algaworks.algafood.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.modelo.Cliente;

@Service
public class AtivacaoClienteService {

	//@Autowired(required = true) // quando o required estiver definido não pode possuir construtor, pq senao o spring vai ficar informando que a injecao é requerida
	private Notificador notificador;

	
	@Autowired
	public AtivacaoClienteService(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador) {
		this.notificador = notificador;
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

		notificador.notificar(cliente, "Seu cadastro esta ativo!");

	}

}
