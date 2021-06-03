package ro.ase.csie.cts.testari.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ro.ase.csie.cts.testari.modele.OperatiiMatematice;

class TestOperatiiMatematice {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testSumaValoriNormale() {
		int a = 5;
		int b = 6;
		int sumaAsteptata = 11;
		int sumaCalculata = OperatiiMatematice.suma(a, b);
		assertEquals("Test cu 5 si 6", sumaAsteptata, sumaCalculata);
	}

}
