package ro.ase.csie.cts.dp.decorator.clase;

import ro.ase.csie.cts.dp.adapter.clase.BankClientInfo;

public class HigherLevelMemberDecorator extends AbstractDecorator {
	public final static int NECESSARY_DEPOT = 75000;
	public HigherLevelMemberDecorator(BankClientInfo cl) {
		super(cl);
		// TODO Auto-generated constructor stub
	}
	public void getHigherMemberLevel() {
		if(this.client.getAmountOfMoney() < NECESSARY_DEPOT) {
			System.out.println("You don't have enough savings to achieve the next membership level.");
		}
		else
			this.client.getHigherMemberLevel();
	}

}
