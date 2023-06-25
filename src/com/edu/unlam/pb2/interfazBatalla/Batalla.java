package com.edu.unlam.pb2.interfazBatalla;

import java.util.HashSet;
import java.util.Set;

import com.edu.unlam.pb2.Exception.VehiculoIncompatibleException;
import com.edu.unlam.pb2.vehiculos.Vehiculo;

public class Batalla {
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;

	public Batalla(TipoDeBatalla tipo, Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
		this.vehiculosEnLaBatalla = new HashSet<Vehiculo>();

	}

	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public void agregarVehiculo(Vehiculo vehiculo)throws VehiculoIncompatibleException {
		validarVehiculo(vehiculo);
		this.vehiculosEnLaBatalla.add(vehiculo);
		
	}

	private void validarVehiculo(Vehiculo vehiculo) throws VehiculoIncompatibleException{
		if(!vehiculo.getTipo().equals(this.tipo)) {
			throw new VehiculoIncompatibleException("Vehiculo incompatible");
		}
		
	}
}
