package ase.ro.cts.laboratoare;

public enum TipProdus {
	NOU(0),DISCOUNT(0.1f),STOC_LIMITAT(0.25f),VECHI(0.35f); //referinte catre obiecte
private final float discount;
private TipProdus(float discount) {
	this.discount=discount;
}
public float getDiscount() {
	return this.discount;
}
}
