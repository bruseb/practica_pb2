package com.edu.unlam.pb2.vehiculos;

import com.edu.unlam.pb2.interfaces.*;
import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;

public class HidroAvion extends Vehiculo implements Volador, Acuatico {

	public HidroAvion(Integer codigo, String nombre) {
		super(codigo, nombre);
	}
	
	
	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return 0.0;
	}


	@Override
	public TipoDeBatalla getTipo() {
		// TODO Auto-generated method stub
		return TipoDeBatalla.AIRE;
	}

}
