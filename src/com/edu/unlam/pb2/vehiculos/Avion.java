package com.edu.unlam.pb2.vehiculos;

import com.edu.unlam.pb2.interfaces.Volador;
import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;

public class Avion extends Vehiculo implements Volador {

	public Avion(Integer codigo, String nombre) {
		super(codigo, nombre);
	}

	@Override
	public Double getAltura() {

		return 0.0;
	}

	@Override
	public TipoDeBatalla getTipo() {
		// TODO Auto-generated method stub
		return TipoDeBatalla.AIRE;
	}

}
