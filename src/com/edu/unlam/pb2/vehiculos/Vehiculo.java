package com.edu.unlam.pb2.vehiculos;

import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;

public abstract class Vehiculo {

	protected Integer codigo;
	protected String nombre;
	

	public Vehiculo(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Vehiculo() {
	}
	
	public abstract TipoDeBatalla getTipo();

	public String getNombre() {
		return nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
