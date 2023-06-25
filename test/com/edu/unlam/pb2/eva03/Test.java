package com.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Assert;
import com.edu.unlam.pb2.Exception.BatallaInexistenteException;
import com.edu.unlam.pb2.Exception.VehiculoIncompatibleException;
import com.edu.unlam.pb2.Exception.VehiculoInexistenteException;
import com.edu.unlam.pb2.interfaces.Acuatico;
import com.edu.unlam.pb2.interfaces.Terrestre;
import com.edu.unlam.pb2.interfaces.Volador;
import com.edu.unlam.pb2.interfazBatalla.FuerzaArmada;
import com.edu.unlam.pb2.interfazBatalla.TipoDeBatalla;
import com.edu.unlam.pb2.vehiculos.Anfibio;
import com.edu.unlam.pb2.vehiculos.Avion;
import com.edu.unlam.pb2.vehiculos.Camion;
import com.edu.unlam.pb2.vehiculos.Destructor;
import com.edu.unlam.pb2.vehiculos.HidroAvion;
import com.edu.unlam.pb2.vehiculos.Portaviones;
import com.edu.unlam.pb2.vehiculos.Submarino;
import com.edu.unlam.pb2.vehiculos.Tanque;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearUnObjetoVolador() {
		Volador avion = new Avion(1, "A-10");

		assertEquals(0.0, avion.getAltura(), 0.01);
		assertNotNull(avion);
	}

	@org.junit.Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Terrestre tanque = new Tanque(5, "Renault FT");

		assertEquals(0.0, tanque.getVelocidad(), 0.1);
		assertNotNull(tanque);
	}

	@org.junit.Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Acuatico submarino = new Submarino(8, "ARA - San Juan");

		assertEquals(0.0, submarino.getProfundidad(), 0.01);
		assertNotNull(submarino);
	}

	@org.junit.Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio var = new Anfibio(12, "LARC-5");

		assertEquals(0.0, var.getVelocidad(), 0.01);
		assertEquals(0.0, var.getProfundidad(), 0.01);
		assertNotNull(var);
	}

	@org.junit.Test
	public void queSePuedaCrearUnHidroavion() {
		HidroAvion ag600 = new HidroAvion(12, "AG600");

		assertEquals(0.0, ag600.getAltura(), 0.01);
		assertEquals(0.0, ag600.getProfundidad(), 0.01);
	}

	@org.junit.Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));
		argentina.agregarVehiculo(new Avion(14, "A-10"));
		argentina.agregarVehiculo(new Avion(15, "A-10"));
		argentina.agregarVehiculo(new Avion(16, "F-102"));
		argentina.agregarVehiculo(new Avion(17, "F-15"));
		argentina.agregarVehiculo(new Tanque(18, "Renault FT"));
		argentina.agregarVehiculo(new Camion(19, "T-72"));
		argentina.agregarVehiculo(new Camion(20, "T-72"));
		argentina.agregarVehiculo(new Submarino(21, "ARA - San Juan"));
		argentina.agregarVehiculo(new Portaviones(22, "A-10"));
		argentina.agregarVehiculo(new Destructor(23, "A-10"));
		argentina.agregarVehiculo(new Destructor(24, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(25, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(26, "LARC-5"));

		assertEquals((Integer) 26, argentina.getCapacidadDeDefensa());
	}
	
	@org.junit.Test
	public void queSePuedaCrearUnaBatalla() {

		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertEquals(100.5, argentina.getBatallas().get("San Lorenzo").getLatitud(), 0.01);
		assertEquals(20.3, argentina.getBatallas().get("San Lorenzo").getLongitud(), 0.01);

	}
	@org.junit.Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("Malvinas", TipoDeBatalla.ACUATICA, 100.5, 20.3);

		Assert.assertTrue(argentina.getBatallas().get("Malvinas").getLatitud() == 100.5);
		Assert.assertTrue(argentina.getBatallas().get("Malvinas").getLongitud() == 20.3);

	}
	@org.junit.Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(10001, "A-10"));
		argentina.agregarVehiculo(new Avion(20002, "A-10"));
		argentina.agregarVehiculo(new Avion(30003, "F-102"));
		argentina.agregarVehiculo(new Avion(40004, "F-15"));
		argentina.agregarVehiculo(new Tanque(50005, "Renault FT"));
		argentina.agregarVehiculo(new Camion(60006, "T-72"));
		argentina.agregarVehiculo(new Camion(70007, "T-72"));
		argentina.agregarVehiculo(new Submarino(80008, "A-10"));
		argentina.agregarVehiculo(new Portaviones(90009, "A-10"));
		argentina.agregarVehiculo(new Destructor(10010, "A-10"));
		argentina.agregarVehiculo(new Destructor(10011, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(10012, "A-10"));
		argentina.agregarVehiculo(new Anfibio(10013, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));

		//argentina.presentarBatalla()
		//argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}
	
	@org.junit.Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		assertEquals((Integer)5, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.ACUATICA, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));
	}
	
	@org.junit.Test(expected = VehiculoIncompatibleException.class)
	
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 11));

	}
	@org.junit.Test(expected = VehiculoInexistenteException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista()
			throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}
	
	@org.junit.Test(expected = BatallaInexistenteException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaQueNoExista()
			throws VehiculoInexistenteException, VehiculoIncompatibleException, BatallaInexistenteException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("Caseros", 4));
	}

}
