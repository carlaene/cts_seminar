package ro.ase.csie.cts.dp.composite.clase;

public class Customer extends AbstractNode{
	String name;
	String administratorAccount;
	
	public Customer(String name, String adm) {
		super();
		this.name = name;
		this.administratorAccount=adm;
		
	}
	@Override
	public void create(String customerName) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%s opens an account.",customerName));
	}

	@Override
	public void closeTheAccount() {
		// TODO Auto-generated method stub
		System.out.println(String.format("%s closes the account.", name));
	}

	@Override
	public void changeAdministratorAccount(String adm) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%s changes the administrator from %s to %s", name,administratorAccount,adm));
	}

	@Override
	public void addNode(AbstractNode node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public AbstractNode getNode(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteNode(AbstractNode node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
