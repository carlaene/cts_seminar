package ro.ase.csie.cts.dp.strategy;

public class ClientBanca {
String nume;
int numarMediuTranzactiiLunare;
float sumaMaximaTransferata;
int nrInvitatiiTrimise;
int nivel;
InterfataStrategieAcordaPuncteBonus strategieMK = null;
public String getNume() {
	return nume;
}
public int getNumarMediuTranzactiiLunare() {
	return numarMediuTranzactiiLunare;
}
public float getSumaMaximaTransferata() {
	return sumaMaximaTransferata;
}
public int getNrInvitatiiTrimise() {
	return nrInvitatiiTrimise;
}
public void setInterfata(InterfataStrategieAcordaPuncteBonus interfata) {
	this.strategieMK = interfata;
}

public int getNivel() {
	return nivel;
}
public ClientBanca(String nume, int numarMediuTranzactiiLunare, float sumaMaximaTransferata, int nrInvitatiiTrimise, int nivel) {
	super();
	this.nume = nume;
	this.numarMediuTranzactiiLunare = numarMediuTranzactiiLunare;
	this.sumaMaximaTransferata = sumaMaximaTransferata;
	this.nrInvitatiiTrimise = nrInvitatiiTrimise;
	this.nivel=nivel;
}
public void acordaPuncteBonus() {
	if(this.strategieMK!=null) {
		this.strategieMK.aplicaStrategieMK(this);
	}
	else throw new  UnsupportedOperationException();
}

}
