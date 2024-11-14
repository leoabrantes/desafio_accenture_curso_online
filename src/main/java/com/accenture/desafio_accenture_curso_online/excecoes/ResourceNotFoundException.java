package com.accenture.desafio_accenture_curso_online.excecoes;

public class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
