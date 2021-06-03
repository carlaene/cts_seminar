package ro.ase.csie.cts.testari.modele;

import ro.ase.csie.cts.testari.exceptii.ExceptieImpartireLaZero;

public class OperatiiMatematice {
	public static int suma(int a, int b) {
		return a + b;
	}
	
	
	public static double impartire(int a, int b) throws ExceptieImpartireLaZero {
		if(b == 0) {
			throw new ExceptieImpartireLaZero();
		}
		return a/b;
	}
}
