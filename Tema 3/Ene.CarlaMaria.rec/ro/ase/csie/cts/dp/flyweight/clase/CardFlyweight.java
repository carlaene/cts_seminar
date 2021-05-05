package ro.ase.csie.cts.dp.flyweight.clase;

import java.util.ArrayList;

public class CardFlyweight implements CardInterface {
	boolean isHavingFreeGymAccess;
	ArrayList<Integer> points = new ArrayList<>();
	
	public CardFlyweight(boolean opt) {
		super();
		this.isHavingFreeGymAccess=opt;
	}


	@Override
	public void viewCardDetails(CardData data) {
	
		System.out.println(String.format(
				" client name: %s, number: %d, cvc: %d", 
				data.clientName, data.number, data.cvc));
		if(isHavingFreeGymAccess==false)
		{System.out.println("There aren't any benefits related to this card.");}
	else {
		System.out.println("There are some benefits related to this card.");
	}
	}
}
