package com.algaworks.algafood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {

	private AtivacaoClienteService ativacaoService;

	@Autowired
	public MeuPrimeiroController(AtivacaoClienteService ativacaoService) {
		this.ativacaoService = ativacaoService;
	}

	@GetMapping("/hello")
	@ResponseBody // fsz com que o return seja retornado no corpo da resposta
	public String hello() {

		Cliente cliente = new Cliente();
		
		cliente.setNome("Joao");
		cliente.setEmail("flavio.henso@gmail.com");
		
		ativacaoService.ativar(cliente);
		return cliente.toString();
	}

}
