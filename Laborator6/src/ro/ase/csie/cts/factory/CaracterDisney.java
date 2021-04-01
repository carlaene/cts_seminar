package ro.ase.csie.cts.factory;

public class CaracterDisney extends CaracterAbstract{
	String culoare;
	boolean okPentruCopiiMici;
	public CaracterDisney(String culoare, String nume, boolean ok){
		this.culoare=culoare;
		this.nume=nume;
	}
	public void alearga() {
		System.out.println("Alearga...");
		
	}
	public void sare() {
		System.out.println("Sare...");
	}

}
