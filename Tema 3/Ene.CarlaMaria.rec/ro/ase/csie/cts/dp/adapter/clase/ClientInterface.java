package ro.ase.csie.cts.dp.adapter.clase;

public interface ClientInterface {
	public abstract String getName();
	public abstract int getCreditLimit();
	public abstract int getAmountOfMoney();
	public abstract void pay(int amount);
	public abstract void transfer(int amount);
	public abstract void save(int amount);
}
