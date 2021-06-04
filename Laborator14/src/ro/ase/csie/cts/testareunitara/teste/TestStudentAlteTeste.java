package ro.ase.csie.cts.testareunitara.teste;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import ro.ase.csie.cts.testareunitara.clase.Student;
import ro.ase.csie.cts.testareunitara.exceptii.ExceptieNota;
import ro.ase.csie.cts.testareunitara.exceptii.ExceptieVarsta;
import ro.ase.csie.cts.testareunitara.teste.categorii.TestImportant;

class TestStudentAlteTeste {
	//test fixture
		static Student student;
		static ArrayList<Integer> noteInitiale = new ArrayList<>();
		static String numeInitial;
		static int varstaInitiala;
		static int nrNoteInitiale;
		static ArrayList<Integer> noteRandom;

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			numeInitial = "Gigel";
			varstaInitiala = Student.MIN_VARSTA + 1;
			nrNoteInitiale = 3;
			for(int i = 0; i < nrNoteInitiale; i++) {
				noteInitiale.add(Student.MAX_NOTA - i);
			}
			
			noteRandom = new ArrayList<>();
			int nrNote = (int) 1e6;
			Random random = new Random();
			for(int i = 0; i < nrNote; i++) {
				noteRandom.add(random.nextInt(Student.MAX_NOTA) + 1);
			}
			
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
			student = new Student(numeInitial, varstaInitiala, noteInitiale);
		}

		@After
		public void tearDown() throws Exception {
			student = null;
		}


		@Test
		public void testSetVarstaRangeMinValue() throws ExceptieVarsta {
			Assertions.assertThrows(ExceptieVarsta.class, new Executable() {
				
				@Override
				public void execute() throws Throwable {
			int varstaNoua = Integer.MIN_VALUE;
			student.setVarsta(varstaNoua);
		}
			});
		}
		
		@Test
		public void testSetVarstaRangeValoarePozitivaMare() throws ExceptieVarsta {
Assertions.assertThrows(ExceptieVarsta.class, new Executable() {
				
				@Override
				public void execute() throws Throwable {
			int varstaNoua = 200;
			student.setVarsta(varstaNoua);
		}
			});
		}
		
		@Test
		public void testSetVarstaBoundaryLimitaInferioara() throws ExceptieVarsta {
			int varstaNoua = Student.MIN_VARSTA;
			student.setVarsta(varstaNoua);
			int varstaStudent = student.getVarsta();
			assertEquals("Test pentru varsta minima", varstaNoua, varstaStudent);
		}
		
		@Test
		public void testSetVarstaBoundaryLimitaSuperioara() throws ExceptieVarsta {
			int varstaNoua = Student.MAX_VARSTA;
			student.setVarsta(varstaNoua);
			int varstaStudent = student.getVarsta();
			assertEquals("Test pentru varsta maxima", varstaNoua, varstaStudent);
		}
		
		@Test
		public void testSetNoteReferenceDeepCopy() throws ExceptieNota {
			int noteStudent[] = new int[]{9,9,10};
			ArrayList<Integer> refNote = new ArrayList<>(Arrays.asList(9,9,10));
			
			student.setNote(refNote);
			refNote.set(0, 5);
			
			int noteExistente[] = new int[student.getNrNote()];
			for(int i = 0; i < student.getNrNote(); i++) {
				noteExistente[i] = student.getNota(i);
			}
			
			assertArrayEquals("Test shallow copy pe setNote", noteStudent, noteExistente);
			
		}
		
		@Test
		public void testGetMediePerformance() throws ExceptieNota {
			ArrayList<Integer> note = new ArrayList<>();
			int nrNote = (int) 1e6;
			Random random = new Random();
			for(int i = 0; i < nrNote; i++) {
				note.add(random.nextInt(Student.MAX_NOTA) + 1);
			}
			
			student.setNote(note);
			
			long tStart = System.currentTimeMillis();
			student.getMedie();
			long tFinal = System.currentTimeMillis();
			
			long durata = tFinal - tStart;
			if(durata <= 10) {
				assertTrue(true);
			}
			else {
				fail("Calculul mediei dureaza mai mult de 10 milisecunde");
			}
		}
		
		@Category(TestImportant.class)
		@Test
		public void testGetMediePerformance2() throws ExceptieNota {
			assertTimeout(ofMinutes(2),()->
			{student.setNote(noteRandom);
			student.getMedie();});
		}
		
		private Duration ofMinutes(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		@Test
		public void testSetVarstaInverse() throws ExceptieVarsta {
			int varstaNoua = varstaInitiala + 1;
			student.setVarsta(varstaNoua);
			assertNotEquals("Set nu modifica valoarea atributului", varstaInitiala, student.getVarsta());
		}
		
		@Test
		public void testGetNotaMinimaInverse() throws ExceptieNota {
			ArrayList<Integer> note = new ArrayList<>();
			Random random = new Random();
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			
			student.setNote(note);
			
			int notaMinima = student.getNotaMinima();
			
			for(int i = 0; i < student.getNrNote(); i++) {
				if(notaMinima > student.getNota(i)) {
					fail("Minimul nu este calculat corect");
				}
			}
			
			assertTrue(true);
		}
		
		@Test
		public void testGetNotaMinimaCrossCheck() throws ExceptieNota {
			ArrayList<Integer> note = new ArrayList<>();
			Random random = new Random();
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			note.add(random.nextInt(Student.MAX_NOTA) + 1);
			
			student.setNote(note);
			
			int notaMinima = Collections.min(note);
			int notaMinimaCalculata = student.getNotaMinima();
			
			assertEquals("Nota minima nu este ok", notaMinima, notaMinimaCalculata);
			
		}

}
