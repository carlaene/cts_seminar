package ro.ase.csie.cts.dp.composite.clase;

import java.util.ArrayList;

public class Group extends AbstractNode {
	String name;
	String admName;
	ArrayList<AbstractNode> nodes = new ArrayList<>();
	

	public Group(String name) {
		super();
		this.name = name;
		
	}

	@Override

	public void create(String clientName) {
		for(AbstractNode node : nodes) {
			node.create(clientName);
		}
	}


	@Override
	public void closeTheAccount() {
		for(AbstractNode node : nodes) {
			node.closeTheAccount();
		}
	}


	@Override
	public void changeAdministratorAccount(String name) {
		for(AbstractNode node : nodes) {
			node.changeAdministratorAccount(name);
		}
	}


	@Override
	public void addNode(AbstractNode node) {
		this.nodes.add(node);
	}


	@Override
	public AbstractNode getNode(int index) {
		return this.nodes.get(index);
	}


	@Override
	public void deleteNode(AbstractNode node) {
		this.nodes.remove(node);
	}
}
