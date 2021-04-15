package ro.ase.csie.cts.laborator.dp.decorator;

public abstract class SuperErou {
	String nume;
	int puncteViata;
	
	public SuperErou(String nume, int puncteViata) {
		super();
		this.nume = nume;
		this.puncteViata = puncteViata;
	}
	
	public abstract void alearga();
	public abstract void esteLovit(int puncte);//pierde puncte
	public abstract void seVindeca(int puncte);//recupereaza puncte
}
