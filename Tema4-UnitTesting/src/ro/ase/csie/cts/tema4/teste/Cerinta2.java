package ro.ase.csie.cts.tema4.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

class Cerinta2 {

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
//Cerinta 2
	//a) test Right pentru fiecare metoda
	//pt metoda adaugaSaptamana
	@Test
	public void testAdaugaSaptamanaRight() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.adaugaSaptamana(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE);
		assertEquals(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE, produs.getNrProduseVandute(1));
	}
	//pt metoda getNrProduseVandute
	public void testGetNrProduseVanduteRight() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		assertEquals(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE, produs.getNrProduseVandute(0));
	}
	//pt metoda getNrSaptamaniPesteMedie
	public void testGetNumarSaptamaniPesteMedieRight() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		assertEquals(rezultat, 1);
	}
	//b) test Range pentru a verifica o conditie pentru care functia testata genereaza o exceptie (pentru fiecare metoda);
	//pt metoda adaugaSaptamana
	@Test
	public void testAdaugaSaptamanaRange() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.adaugaSaptamana(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE + 1);
		produs.adaugaSaptamana(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE - 1);
			}
		});
	}
	//pt metoda getNrProduseVandute
	public void testGetNrProduseVanduteRange() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		assertEquals(-1, produs.getNrProduseVandute(1));
	}
	//pt metoda getNrSaptamaniPesteMedie
	@Test
	public void testGetNrSaptamaniPesteMediRange() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE);
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE - 1);	
		}
	});
}
	//c) 2 teste pentru verificarea limitelor extreme (Boundary) pentru fiecare metoda
	@Test
	public void testAdaugaSaptamanaBoundaryMinim() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.adaugaSaptamana(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE - 1);
	}
		
		});
	}
	@Test
	public void testAdaugaSaptamanaBoundaryMaxim() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.adaugaSaptamana(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE - 1);
	}
		
		});
	}
	
	@Test
	public void testGetArticoleVanduteBoundary() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		assertEquals(-1, produs.getNrProduseVandute(1));
	}
	@Test
	public void testGetNrSaptamaniPesteMedieBoundaryMinim() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE - 1);}
		});
	}
	@Test
	public void testGetNrSaptamaniPesteMedieBoundaryMaxim() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticoleVanduteInvalide.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE - 1);}
		});
	}
	//d)2 teste de Cardinalitate pentru getNrSaptamaniPesteMedie();
	@Test
	public void testGetNrSaptamaniPesteMedieCardinalityMinElements() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/2,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/3));
		Produs produs=new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		assertEquals(rezultat, 3);
	}
	@Test
	public void testGetNrSaptamaniPesteMedieCardinalityMaxElements() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE,
				IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE + 1));
		Produs produs=new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		assertEquals(rezultat, 2);
	}
	//e) 2 teste de tip Ordering pentru getNrSaptamaniPesteMedie();
	@Test
	public void testGetNrSaptamaniPesteMedieOrdineDescrescatoare() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/1,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/2,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/3));
		Produs produs=new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat1 = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		Collections.sort(articoleVandute, Collections.reverseOrder());
		
		produs.setVanzari(articoleVandute);
		int rezultat2 = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		assertEquals(rezultat1, rezultat2);
	}
	@Test
	public void testGetNrSaptamaniPesteMedieOrdineCrescatoare() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/1,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/2,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE/3));
		Produs produs=new Produs("rochie",IReguliDeValidare.PRET_MINIM, articoleVandute);
		int rezultat1 = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		Collections.sort(articoleVandute);
		produs.setVanzari(articoleVandute);
		int rezultat2 = produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		assertEquals(rezultat1, rezultat2);
	}
	//f) numai pentru getNrSaptamaniPesteMedie() un test de performanta / timp
	//care va verifica daca functia returneaza un rezultat sub 3 secunde pentru o lista cu 1000 de saptamani
	
	@Test
	public void testGetNrSaptamaniPesteMediePerformance() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent{
	ArrayList<Integer> articoleVandute = new ArrayList<Integer>();
	for(int i=IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE;i<IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE;i++) {
		articoleVandute.add(i);
	}
	Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM, articoleVandute);
	long timpInceput = System.currentTimeMillis();
	produs.getNrSaptamaniPesteMedie(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
	long timpFinal = System.currentTimeMillis();
	if(timpFinal - timpInceput > 3000) fail("Apelul are peste 3 secunde!!!");
}

	

}
