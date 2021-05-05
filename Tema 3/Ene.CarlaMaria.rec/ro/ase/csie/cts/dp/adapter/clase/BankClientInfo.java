package ro.ase.csie.cts.dp.adapter.clase;

public abstract class BankClientInfo {
	protected String name;
	protected int creditLimit;
	protected int amountOfMoney;
	
	public BankClientInfo(String name, int creditLimit, int money) {
		super();
		this.name = name;
		this.creditLimit = creditLimit;
		this.amountOfMoney=money;
	}

	public String getName() {
		return name;
	}

	public int getCreditLimit() {
		return creditLimit;
	}
	public int getAmountOfMoney() {
		return amountOfMoney;
	}
	
	public abstract void pay(int amount);
	public abstract void transfer(int amount);
	public abstract void save(int amount);

	public abstract void penaltyPoints(int penalty);

	public abstract void getHigherMemberLevel();
}
