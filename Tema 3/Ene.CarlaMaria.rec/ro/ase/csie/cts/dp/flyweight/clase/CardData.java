package ro.ase.csie.cts.dp.flyweight.clase;

public class CardData {
	boolean isHavingFreeGymAccess;
String clientName;
int number;
int cvc;
public CardData(boolean opt,String clientName, int number, int cvc) {
	super();
	this.isHavingFreeGymAccess=opt;
	this.clientName = clientName;
	this.number = number;
	this.cvc = cvc;
}

}
