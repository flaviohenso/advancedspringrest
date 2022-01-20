package com.algaworks.algafood.anotacoes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

import com.algaworks.algafood.enums.NivelUrgencia;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TipoDoNotificador {

	NivelUrgencia value();
}
