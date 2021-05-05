package ro.ase.csie.cts.dp.decorator.clase;

import ro.ase.csie.cts.dp.adapter.clase.BankClientInfo;

public class AbstractDecorator extends BankClientInfo{
BankClientInfo client=null;
	public AbstractDecorator(BankClientInfo cl) {
		super(cl.getName(), cl.getCreditLimit(), cl.getAmountOfMoney());
		this.client=cl;
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void pay(int amount) {
		// TODO Auto-generated method stub
		this.client.pay(amount);
	}

	@Override
	public void transfer(int amount) {
		// TODO Auto-generated method stub
		this.client.transfer(amount);
	}

	@Override
	public void save(int amount) {
		// TODO Auto-generated method stub
		this.client.save(amount);
		
	}

	public void penaltyPoints(int points) {
		// TODO Auto-generated method stub
		this.client.penaltyPoints(points);
	}

	@Override
	public void getHigherMemberLevel() {
		// TODO Auto-generated method stub
		this.client.getAmountOfMoney();
	}

}
