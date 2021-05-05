package ro.ase.csie.cts.dp.adapter.clase;

public class BankAccountActions extends BankClientInfo {

	public BankAccountActions(String name, int creditLimit, int money) {
		super(name, creditLimit,money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%s pays %d per month for invoices", name, amount));
	}

	@Override
	public void transfer(int amount) {
		// TODO Auto-generated method stub
		if(this.amountOfMoney>amount)
		{System.out.println(String.format("%s transfers %d from his account", name, amount));
		this.amountOfMoney-=amount;}
		else {
			System.out.println("Not enough money for your transfer!!!");
		}
		
	}

	@Override
	public void save(int amount) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%s saves %d in his account", name, amount));
		this.amountOfMoney+=amount;
	}

	@Override
	public void penaltyPoints(int penalty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getHigherMemberLevel() {
		// TODO Auto-generated method stub
		
	}
	
	

}
