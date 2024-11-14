package com.accenture.desafio_accenture_curso_online.excecoes;

public class DatabaseException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}

}
