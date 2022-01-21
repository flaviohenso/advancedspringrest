package com.algaworks.algafood.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.modelo.Cliente;

//@Primary // defini para o spring que esse component tem preferencia em caso de ambiguação de Bean
@Profile("dev")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmailMock implements Notificador{

	
	
	public NotificadorEmailMock() {
		System.out.println("Notificador email mock");
	}

	@Override
	public void notificar(Cliente cliente, String msg) {
		System.out.println("Notificação de email Mock");
		cliente.notificar(cliente, msg);		
	}

}
