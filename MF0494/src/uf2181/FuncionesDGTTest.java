package uf2181;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FuncionesDGTTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	/**@Test
	void test() {
		fail("No implementado aun");
	}*/


	@Test
	void mediaPuntosTest() {
	int v[] = {1,2,3,4,5};
	int v1[] = {4,4,4,4};
	int v2 [] = new int [0];
	assertEquals(3, FuncionesDGT.mediaPuntos(v));
	assertNotEquals(3.8, FuncionesDGT.mediaPuntos(v));
	assertEquals(4, FuncionesDGT.mediaPuntos(v2));
	assertNotEquals(3.4, FuncionesDGT.mediaPuntos(v2));
	
	
	assertThrows(ArrayIndexOutOfBoundsException.class, ()-> FuncionesDGT.mediaPuntos(v2));
	}



	@Test
	void maximaTasaPermitidaTest() {
		assertEquals(0.25, FuncionesDGT.maximaTasaPermitida("General", true));
		assertNotEquals(0.25, FuncionesDGT.maximaTasaPermitida("Novel", true));
		assertNotEquals(0.25, FuncionesDGT.maximaTasaPermitida("General", false));

		assertEquals(0.5, FuncionesDGT.maximaTasaPermitida("General", false));
		assertNotEquals(0.5, FuncionesDGT.maximaTasaPermitida("Novel", false));
		assertNotEquals(0.5, FuncionesDGT.maximaTasaPermitida("General", true));

		assertEquals(0.15, FuncionesDGT.maximaTasaPermitida("Novel", true));
		assertNotEquals(0.15, FuncionesDGT.maximaTasaPermitida("General", true));
		assertNotEquals(0.15, FuncionesDGT.maximaTasaPermitida("Novel", false));

		
		assertNotEquals(0.3, FuncionesDGT.maximaTasaPermitida("Novel", true));
		assertNotEquals(0.3, FuncionesDGT.maximaTasaPermitida("General", true));
		assertEquals(0.3, FuncionesDGT.maximaTasaPermitida("Novel", false));
	}
	
}
	
