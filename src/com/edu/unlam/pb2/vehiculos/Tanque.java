package com.edu.unlam.pb2.vehiculos;

import com.edu.unlam.pb2.interfaces.Terrestre;
import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;

public class Tanque extends Vehiculo implements Terrestre {
	
	public Tanque(Integer codigo, String nombre){
		super(codigo,nombre);		
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public TipoDeBatalla getTipo() {
		// TODO Auto-generated method stub
		return TipoDeBatalla.TERRESTRE;
	}

}
