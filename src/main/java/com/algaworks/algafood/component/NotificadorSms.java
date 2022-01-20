package com.algaworks.algafood.component;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.anotacoes.TipoDoNotificador;
import com.algaworks.algafood.enums.NivelUrgencia;
import com.algaworks.algafood.modelo.Cliente;

//@Primary // defini para o spring que esse component tem preferencia em caso de ambiguação de Bean
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorSms implements Notificador{

	@Override
	public void notificar(Cliente cliente, String msg) {
		cliente.notificar(cliente, msg + " SMS");		
	}

}
