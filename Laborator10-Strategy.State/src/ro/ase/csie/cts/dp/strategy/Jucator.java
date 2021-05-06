package ro.ase.csie.cts.dp.strategy;

public class Jucator {
int totalOreJucate;
String nume;
int clasaJucator;

	IStrategieMarketing strategieMk=null;
	public void acordaPuncteBonus() {
		if(this.strategieMk!=null) {
			this.strategieMk.aplicaStrategieBonus(this);
		}
		else {
			throw new UnsupportedOperationException();
		}
	
}
	
public Jucator(int totalOreJucate, String nume, int clasaJucator) {
		super();
		this.totalOreJucate = totalOreJucate;
		this.nume = nume;
		this.clasaJucator = clasaJucator;
	}

public int getTotalOreJucate() {
		return totalOreJucate;
	}

public void setStrategieMk(IStrategieMarketing strategieMk) {
		this.strategieMk = strategieMk;
	}

public String getNume() {
	return nume;
}
public int getClasaJucator() {
	return clasaJucator;
}
public void setTotalOreJucate(int totalOreJucate) {
	this.totalOreJucate = totalOreJucate;
}


}
