package ro.ase.csie.cts.dp.state;

public class SuperErou {
int puncteVaita;
public static final int PUNCTE_NIVEL_CRITIC=50;
public static final int PUNCTE_NIVEL_NORMAL=500;
String efectMagic;
String nume;
IModDeplasare stareDeplasare=null;
public SuperErou(int puncteVaita, String nume) {
	super();
	this.puncteVaita = puncteVaita;
	this.nume = nume;
}
public SuperErou(String nume) {
	super();
	this.nume = nume;
	this.puncteVaita = PUNCTE_NIVEL_NORMAL;
	this.stareDeplasare = new StareDeplasareNormala();
}
public void esteAtacat(int puncteLovitura) {
	System.out.println(this.nume+" este lovit cu "+puncteLovitura);
	this.puncteVaita-=puncteLovitura;
	if(this.puncteVaita<PUNCTE_NIVEL_CRITIC) {
		this.stareDeplasare=(IModDeplasare) new StareDeplasareRanitCritic();
	}
	else {
		if(this.puncteVaita<PUNCTE_NIVEL_NORMAL) {
			this.stareDeplasare= new StareDeplasareRanit();
		}
	}
}
public void seVindeca(int pct) {
	System.out.println("Eroul se vindeca.");
	this.puncteVaita+=pct;
	if(this.puncteVaita>PUNCTE_NIVEL_NORMAL) {
		this.stareDeplasare=new StareDeplasareNormala();
	}
	else if(this.puncteVaita>PUNCTE_NIVEL_CRITIC) {
		this.stareDeplasare= new StareDeplasareRanit();
	}
}
public void seDeplaseaza() {
	this.stareDeplasare.seMisca(this);
}

}
