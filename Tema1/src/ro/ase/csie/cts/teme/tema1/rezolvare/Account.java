package ro.ase.csie.cts.teme.tema1.rezolvare;

public enum Account {
	STANDARD(0),BUGET(1),PREMIUM(2),SUPER_PREMIUM(3);
	private int tipCont;
	public int getTipCont() {
		return this.tipCont;
	}
	private Account(int tipCont) {
		this.tipCont=tipCont;
	}
}
