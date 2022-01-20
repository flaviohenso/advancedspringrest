package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.modelo.Cliente;

@Service
public class AtivacaoClienteServiceQualifierAnotation {

	//@Autowired(required = true) // quando o required estiver definido não pode possuir construtor, pq senao o spring vai ficar informando que a injecao é requerida
	private Notificador notificador;

	
	@Autowired
	public AtivacaoClienteServiceQualifierAnotation(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro esta ativo!");

	}

}
