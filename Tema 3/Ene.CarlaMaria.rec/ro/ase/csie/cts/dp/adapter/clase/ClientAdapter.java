package ro.ase.csie.cts.dp.adapter.clase;

public class ClientAdapter extends BankClientInfo {
ClientInterface client = null;
	public ClientAdapter(ClientInterface cl) {
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

	@Override
	public void penaltyPoints(int penalty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getHigherMemberLevel() {
		// TODO Auto-generated method stub
		
	}

}
