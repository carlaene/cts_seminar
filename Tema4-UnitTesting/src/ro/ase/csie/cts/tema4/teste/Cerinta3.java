package ro.ase.csie.cts.tema4.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ro.ase.csie.cts.tema4.clase.IReguliDeValidare;
import ro.ase.csie.cts.tema4.clase.Produs;
import ro.ase.csie.cts.tema4.exceptii.ExceptieArticolVandutInexistent;
import ro.ase.csie.cts.tema4.exceptii.ExceptieArticoleVanduteInvalide;
import ro.ase.csie.cts.tema4.exceptii.ExceptieFormatNumeInvalid;
import ro.ase.csie.cts.tema4.exceptii.ExceptiePretInvalid;

class Cerinta3 {

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
//cerinta 3
	//Scrieti un caz de testare pentru a testa getProcentSaptamaniSlabe() si getIndexSaptamaniCuVanzariMaxime()
	//a)1 test Right pentru fiecare metoda;
	@Test
	public void testGetProcentSaptamaniSlabeRight () throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 2));
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat = produs.getProcentSaptamaniSlabe(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 3);
		assertEquals(50, rezultat);
	}
	@Test
	public void testGetIndexSaptamaniCuVanzariMaximeRight () throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		ArrayList<Integer> listaRezultateAsteptate = new ArrayList<Integer>(Arrays.asList(0,2));
		assertEquals(listaRezultateAsteptate, produs.getIndexSaptamaniCuVanzariMaxime(0));
	}
	//b) 1 test de tip Cross-Check;
	@Test
	public void testGetProcentSaptamaniSlabeCrossCheck() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 2));
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat = produs.getProcentSaptamaniSlabe(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 3);
		int rezultatAsteptat = (100 * 1 / 2);
		assertEquals(rezultatAsteptat, rezultat);
	}
	//c) 1 test de tip Inverse Relationship;
	@Test
	public void testGetIndexSaptamaniCuVanzariMaximeInverseRelationship() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		ArrayList<Integer> listaRezultateAsteptate = new ArrayList<Integer>(Arrays.asList(0,2));
		assertEquals(listaRezultateAsteptate, produs.getIndexSaptamaniCuVanzariMaxime(produs.getNrProduseVandute(0)));
	}
	
// d) 2 teste la alegere pentru a verifica alte criterii (altele decat cele de mai sus) pentru oricare dintre cele 2 metode.
	@Test
	public void testGetProcentSaptamaniSlabeErrorCondition() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 2));
				Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
				produs.getProcentSaptamaniSlabe(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE - 1);
				System.out.println("TEST CONDITIE DE EROARE PT METODA getProcentSaptamaniSlabe");
			}	
		});
	}
	@Test
	public void testGetIndexSaptamaniCuVanzariMaximeErrorCondition() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE, IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
				Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
				produs.getIndexSaptamaniCuVanzariMaxime(10000);
				System.out.println("TEST CONDITIE DE EROARE PT METODA getIndexSaptamaniCuVanzariMaxime");
			}	
		});
	}

	

}
