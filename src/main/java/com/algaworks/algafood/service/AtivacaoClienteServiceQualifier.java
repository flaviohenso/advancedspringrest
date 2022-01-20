package com.algaworks.algafood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.modelo.Cliente;

@Service
public class AtivacaoClienteServiceQualifier {

	//@Autowired(required = true) // quando o required estiver definido não pode possuir construtor, pq senao o spring vai ficar informando que a injecao é requerida
	//private Notificador notificador; //injentando um bean simples
	private List<Notificador> notificadores;  // injetando uma lista de beans para resolver problema de ambiguidade

	@Autowired
	public AtivacaoClienteServiceQualifier(List<Notificador> notificadores) {
		this.notificadores = notificadores;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		this.notificadores.forEach( notificador -> {
			notificador.notificar(cliente, "Seu cadastro esta ativo!");
		});
		

	}

}
