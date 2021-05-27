package ro.ase.csie.cts.testare.teste;

import java.util.ArrayList;

import junit.framework.Test;
import ro.ase.csie.cts.testare.exceptii.ExceptieNume;
import ro.ase.csie.cts.testare.exceptii.ExceptieVarsta;
import ro.ase.csie.cts.testare.modele.Student;

public class TestStudent {
static Student student;
static ArrayList<Integer>note;
static String numeInitial="Gigel";
static int varstaInitiala=21;
public static void setUpBeforeClass()  throws Exception{
	note=new ArrayList<>();
	note.add(9);
	note.add(10);
	
	}
	
public static void tearDownAfterClass() throws Exception{
	note.clear();
	note=null;
}
public void setUp() throws Exception {
	Student student = new Student(numeInitial,varstaInitiala,note); //studentul este creat de fiecare data inaintea fiecarui test
}
public void tearDown() throws Exception{
student=null;
}
public void test() {
	fail("Not yet implemented");
}

private void fail(String string) {
	// TODO Auto-generated method stub
	
}
public void testSetVarstaConformanceRight() throws ExceptieVarsta {
	
	int varstaNoua=23;
	student.setVarsta(varstaNoua);
	//assertEquals("Testul cu valori corecte", varstaNoua, student.getVarsta());
	
			
}
public void testSetNumeRight() throws ExceptieNume {
	String numeNou="Ana";
	student.setNume(numeNou);
	try {
		student.setNume(numeNou);
		assertEquals("Test cu valori corecte",numeNou, student.getNume());
		
	}catch (ExceptieNume e) {
		fail("Gnereaza exceptie pentru valori corecte.");
	}
	
}

private void assertEquals(String string, String numeNou, String string2) {
	// TODO Auto-generated method stub
	
}

public void testSetVarstaErrorCondition() {
	int varstaNoua = Student.MIN_VARSTA - 1;
	try {
		student.setVarsta(varstaNoua);
		fail("Nu genereaza exceptie pt varsta in afara limitelor.");
	} catch (ExceptieVarsta e) {
		// TODO Auto-generated catch block
		assertTrue(true);
	}
	
}

private void assertTrue(boolean b) {
	// TODO Auto-generated method stub
	
}


}