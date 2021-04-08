package ro.ase.csie.cts.ro.factory.method;

public class TestFactory {
public static void main(String[] args) {
	boolean isModJoc4Kids=true;
	
	if(isModJoc4Kids) {
		//dezvoltare doar cu caractere 4Kids
	}
	else {
		//dezvoltare doar cu caractere normale
	}
	FactoryAbstractCaracter factoryCaracter=null;
	if (isModJoc4Kids)
		factoryCaracter = new FactoryMod4Kids();
	else
		factoryCaracter = new FactoryModNormal();
	
	//dezvoltare joc
	CaracterJoc superman=factoryCaracter.getCaracter(TipCaracter.MARVEL, "Superman");
	
}

}
