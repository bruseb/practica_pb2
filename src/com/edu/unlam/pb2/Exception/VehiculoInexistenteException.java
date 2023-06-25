package com.edu.unlam.pb2.Exception;

public class VehiculoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public VehiculoInexistenteException() {
	}

	public VehiculoInexistenteException(String mensaje) {
		super(mensaje);
	}
}
