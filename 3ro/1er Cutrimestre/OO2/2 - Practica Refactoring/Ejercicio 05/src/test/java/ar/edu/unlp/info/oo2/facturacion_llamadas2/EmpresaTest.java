package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	Empresa sistema;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.sistema.agregarNumeroTelefono("2214444554");
		this.sistema.agregarNumeroTelefono("2214444555");
		this.sistema.agregarNumeroTelefono("2214444556");
		this.sistema.agregarNumeroTelefono("2214444557");
		this.sistema.agregarNumeroTelefono("2214444558");
		this.sistema.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarUsuario("11555666", "Brendan Eich" , new Fisico());
		Cliente remitentePersonaFisica = sistema.registrarUsuario("00000001", "Doug Lea" ,  new Fisico());
		Cliente emisorPersonaJuridica = sistema.registrarUsuario("17555222", "Nvidia Corp" ,  new Juridico());
		Cliente remitentePersonaJuridica = sistema.registrarUsuario("25765432", "Sun Microsystems" , new Juridico());

		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, new Nacional(), 10);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, new Internacional(), 8);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, new Nacional(), 5);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, new Internacional(), 7);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, new Nacional(), 15);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, new Internacional(), 45);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, new Nacional(), 13);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, new Internacional(), 17);

		assertEquals(11454.64, this.sistema.calcularMontoTotalLlamadas(emisorPersonaFisca), 0.01);
		assertEquals(2445.40, this.sistema.calcularMontoTotalLlamadas(emisorPersonaJuridica), 0.01);
		assertEquals(0, this.sistema.calcularMontoTotalLlamadas(remitentePersonaFisica));
		assertEquals(0, this.sistema.calcularMontoTotalLlamadas(remitentePersonaJuridica));
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarUsuario("2444555","Alan Turing", new Fisico());

		assertEquals(1, this.sistema.cantidadDeUsuarios());
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGenerador(new Primero());
		assertEquals("2214444554", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGenerador(new Aleatorio());
		assertNotNull(this.sistema.obtenerNumeroLibre());
	}
}
