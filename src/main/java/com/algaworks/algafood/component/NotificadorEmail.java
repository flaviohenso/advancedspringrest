package com.algaworks.algafood.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.modelo.Cliente;

//@Primary // defini para o spring que esse component tem preferencia em caso de ambiguação de Bean
@Profile("prod")// defini o ambiente onde esse Bean deve ser usado
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements Notificador{

	@Override
	public void notificar(Cliente cliente, String msg) {
		cliente.notificar(cliente, msg);		
	}

}
