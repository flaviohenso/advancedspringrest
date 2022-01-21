package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.component.Notificador;
import com.algaworks.algafood.enums.NivelUrgencia;

//@Configuration
public class ServiceConfig {

	private Notificador notificador;
	
	@Autowired
	public ServiceConfig(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador) {
		this.notificador = notificador;
	}

	@Bean(initMethod = "init", destroyMethod = "destroy") //Forma chamar métodos de callback do ciclo de vida do spring
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificador);
	}
	
}
