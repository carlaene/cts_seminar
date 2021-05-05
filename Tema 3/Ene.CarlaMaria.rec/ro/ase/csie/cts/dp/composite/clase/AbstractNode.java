package ro.ase.csie.cts.dp.composite.clase;

public abstract class AbstractNode implements CustomerActions {
	public abstract void addNode(AbstractNode node);
	public abstract AbstractNode getNode(int index);
	public abstract void deleteNode(AbstractNode node);

}
 