package ro.ase.csie.cts.tema4.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions;

import ro.ase.csie.cts.tema4.clase.IReguliDeValidare;
import ro.ase.csie.cts.tema4.clase.Produs;
import ro.ase.csie.cts.tema4.exceptii.ExceptieArticolVandutInexistent;
import ro.ase.csie.cts.tema4.exceptii.ExceptieArticoleVanduteInvalide;
import ro.ase.csie.cts.tema4.exceptii.ExceptieFormatNumeInvalid;
import ro.ase.csie.cts.tema4.exceptii.ExceptiePretInvalid;

class Cerinta1 {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//Cerinta 1: 
	//a) cel putin 1 test Right / Conformance pentru fiecare constructor
	// test pentru constructorul cu 2 parametri
	@Test
	public void testConstructorCu2Param() throws ExceptiePretInvalid, ExceptieFormatNumeInvalid {
		String nume = "geanta";
		float pret = IReguliDeValidare.PRET_MINIM;
		Produs produs = new Produs(nume, pret);
		assertEquals("Nume: ", nume , produs.getNume());
		
	}
	//test pentru constructorul cu toti parametrii
	@Test
	public void testConstructorTotiParamRight() throws ExceptieArticolVandutInexistent, ExceptieFormatNumeInvalid,
	ExceptiePretInvalid, ExceptieArticoleVanduteInvalide{
		String nume = "geaca";
		float pret = IReguliDeValidare.PRET_MINIM;
		ArrayList<Integer> articoleVanduteSaptamanal = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE,
				IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs(nume, pret, articoleVanduteSaptamanal);
		assertEquals("Nume: ", nume, produs.getNume());			
		assertEquals("Pret: ", pret, produs.getPret(),0);
		for(int i=0;i<articoleVanduteSaptamanal.size();i++) {
			assertEquals("Error at"+i,(int)articoleVanduteSaptamanal.get(i), produs.getNrProduseVandute(i));
		}
}


	//b)cel putin 2 teste Error Condition pentru fiecare constructor
	@Test 
	//(expected = ExceptieFormatNumeInvalid.class)
	public void testConstructorCu2ParamNume() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid {
		Assertions.assertThrows(ExceptieFormatNumeInvalid.class, new Executable() {
			public void execute() throws Throwable{
		String numeInvalid = "ABC";
		Produs produs =new Produs(numeInvalid,IReguliDeValidare.PRET_MINIM);
			}
		});
	}
	
	public void testConstructorCu2ParamPret() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid {
		Assertions.assertThrows(ExceptiePretInvalid.class, new Executable() {
			public void execute() throws Throwable{
		float pretInvalid = IReguliDeValidare.PRET_MINIM - IReguliDeValidare.PRET_MAXIM;
		Produs produs =new Produs("geanta",pretInvalid);
			}
		});
	}
	
	public void testConstructorCuTotiParamNume() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptiePretInvalid.class, new Executable() {
			public void execute() throws Throwable{
				String numeGresit = "XXX";
				Produs produs =new Produs(numeGresit,IReguliDeValidare.PRET_MAXIM,new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE,IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE)));
				}
		});
	}
	public void testConstructorCuTotiParamPret() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, ExceptieArticolVandutInexistent {
			Assertions.assertThrows(ExceptiePretInvalid.class, new Executable() {
				public void execute() throws Throwable{
					float pretInvalid = IReguliDeValidare.PRET_MINIM - IReguliDeValidare.PRET_MAXIM;
					Produs produs =new Produs("bluza",pretInvalid,new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE,IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE)));
					}
			});
	
	}
//c)1 test Reference pentru constructorul care primeste ArrayList
	public void testConstructorTotiParamArticoleVanduteReference() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, ExceptieArticolVandutInexistent {
		ArrayList<Integer> articoleVandute =new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE,IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		Produs produs = new Produs("cravata",IReguliDeValidare.PRET_MINIM, articoleVandute);
		articoleVandute.add(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		int i;
		for(i=0;i<articoleVandute.size()-1;i++) {
			assertEquals("Eroare la articolul nr "+i, produs.getNrProduseVandute(i),(int)articoleVandute.get(i));
		}
		assertNotEquals("Eroare la articolul nr "+i, produs.getNrProduseVandute(i),(int)articoleVandute.get(i));
	}
//d) 1 test Existence pentru constructorul care primeste ArrayList
	public void testConstructorTotiParamArticoleVanduteExistence() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticolVandutInexistent.class, new Executable() {
			public void execute() throws Throwable{
				ArrayList<Integer> articoleVandute = new ArrayList<Integer>();
				Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM,articoleVandute);
		}
		});
	}
//e) 1 test Reference pentru setVanzari()
	@Test
	@Category(TestPrincipal.class)
	public void testSetVanzariReference() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>(Arrays.asList(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE,IReguliDeValidare.NUMAR_MAXIM_ARTICOLE_VANDUTE));
		
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM);
		produs.setVanzari(articoleVandute);
		articoleVandute.add(IReguliDeValidare.NUMAR_MINIM_ARTICOLE_VANDUTE);
		int i;
		for(i=0;i<articoleVandute.size()-1;i++) {
			assertEquals("Eroare la pozitia "+i, produs.getNrProduseVandute(i),(int)articoleVandute.get(i));
		}
		assertNotEquals("Eroare la pozitia "+i, produs.getNrProduseVandute(i),(int)articoleVandute.get(i));
	}
//f) test Existence pentru setSales
	@Test
	@Category(TestPrincipal.class)
	public void testSetSalesExistance() throws ExceptieFormatNumeInvalid, ExceptiePretInvalid, ExceptieArticoleVanduteInvalide, 
	ExceptieArticolVandutInexistent {
		Assertions.assertThrows(ExceptieArticolVandutInexistent.class, new Executable() {
			public void execute() throws Throwable{
		ArrayList<Integer> articoleVandute = new ArrayList<Integer>();
		Produs produs = new Produs("geaca",IReguliDeValidare.PRET_MINIM);
		produs.setVanzari(articoleVandute);
	}
		});
	}
	
}
