package com.edu.unlam.pb2.interfazBatalla;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.edu.unlam.pb2.Exception.BatallaInexistenteException;
import com.edu.unlam.pb2.Exception.VehiculoIncompatibleException;
import com.edu.unlam.pb2.Exception.VehiculoInexistenteException;
import com.edu.unlam.pb2.vehiculos.Vehiculo;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;

	public FuerzaArmada() {
		this.convoy = new HashSet<Vehiculo>();
		this.batallas = new HashMap<String, Batalla>();

	}

	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public Map<String, Batalla> getBatallas() {
		return batallas;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		convoy.add(vehiculo);
	}

	public Integer getCapacidadDeDefensa() {
		// TODO Auto-generated method stub
		return convoy.size();
	}

	public void crearBatalla(String nombreBatalla, TipoDeBatalla tipoDeBatalla, double latitud, double longitud) {
		this.batallas.put(nombreBatalla, new Batalla(tipoDeBatalla, latitud, longitud));

	}

	public Boolean enviarALaBatalla(String nombreDeLaBatalla, Integer codigoVehiculo)
			throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		Batalla batalla = buscarBatallaPorNombre(nombreDeLaBatalla);
		Vehiculo vehiculo = buscarVehiculo(codigoVehiculo);
		batalla.agregarVehiculo(vehiculo);

		return true;
	}

	private Vehiculo buscarVehiculo(Integer codigoVehiculo) throws VehiculoInexistenteException {
		for (Vehiculo vehiculo : convoy) {
			if (vehiculo.getCodigo().equals(codigoVehiculo)) {
				return vehiculo;
			}
		}
		throw new VehiculoInexistenteException("Vehiculo inexistente");

	}

	private Batalla buscarBatallaPorNombre(String nombreDeLaBatalla) throws BatallaInexistenteException {
		if (this.batallas.containsKey(nombreDeLaBatalla)) {
			return this.batallas.get(nombreDeLaBatalla);
		}
		throw new BatallaInexistenteException("Batalla inexistente");
	}

}
