package ro.ase.csie.cts.dp.decorator.clase;

import ro.ase.csie.cts.dp.adapter.clase.BankClientInfo;

public class CardDecorator extends AbstractDecorator{
	int fidelityPoints;

	public CardDecorator(BankClientInfo client, int points) {
		super(client);
		this.fidelityPoints=points;
	}
	@Override
	public void penaltyPoints(int points) {
		int penalty = points - fidelityPoints;
		if(penalty > 0 )
			this.client.penaltyPoints(penalty);	
	}
}
