package ro.ase.csie.cts.lab.modele;

public abstract class ContBancar extends Cont {
	protected double balanta;
    protected String iban;

    public ContBancar(double balanta, String iban) {
        this.balanta = balanta;
        this.iban = iban;
    }

    @Override
    public double getBalanta() {
        return balanta;
    }
}
