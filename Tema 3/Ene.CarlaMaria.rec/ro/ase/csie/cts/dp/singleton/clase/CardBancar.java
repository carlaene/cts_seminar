package ro.ase.csie.cts.dp.singleton.clase;

import java.util.Hashtable;

public class CardBancar {
	String numarCard;
	int cvc;
	
	private static Hashtable<String, CardBancar> card = 
			new Hashtable<>();

	private CardBancar(String numarCard, int cvc) {
		super();
		this.numarCard = numarCard;
		this.cvc = cvc;
	}
	
	public static CardBancar getCardBancar(String numarCard, int cvc) {
		CardBancar card = CardBancar.get(numarCard);
		if(card == null) {
			card = new CardBancar(numarCard, cvc);
			card.put(numarCard,card);
		}
		
		return card;
	}

	private void put(String numarCard2, CardBancar card2) {
		// TODO Auto-generated method stub
		
	}

	private static CardBancar get(String numarCard2) {
		// TODO Auto-generated method stub
		return null;
	}
}
