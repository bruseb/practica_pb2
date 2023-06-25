package com.edu.unlam.pb2.vehiculos;

import com.edu.unlam.pb2.interfaces.Acuatico;
import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;

public class Portaviones extends Vehiculo implements Acuatico {
	
	public Portaviones(Integer codigo, String nombre) {
		super(codigo, nombre);
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public TipoDeBatalla getTipo() {
		// TODO Auto-generated method stub
		return TipoDeBatalla.ACUATICA;
	}

}
