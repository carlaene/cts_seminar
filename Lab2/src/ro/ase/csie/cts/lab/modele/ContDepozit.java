package ro.ase.csie.cts.lab.modele;

import ro.ase.csie.cts.lab.exceptii.IllegalTransferException;
import ro.ase.csie.cts.lab.exceptii.InsufficientFundsException;
import ro.ase.csie.cts.lab.interfete.Profitabil;

public class ContDepozit extends ContBancar implements Profitabil{
	 public static final double BALANTA_MINIMA=100;
	    public ContDepozit(String iban){
	        super(BALANTA_MINIMA,iban);
	    }

	    @Override
	    public void alimenteazaCont(Double valaore) {
	        this.balanta+=valaore;
	    }

	    @Override
	    public void extrage(Double valoare) throws InsufficientFundsException{

	        if(this.balanta<valoare){
	            throw new InsufficientFundsException("Nu ai bani");
	        }
	        else
	            {
	            this.balanta-=valoare;
	            }
	    }

	    @Override
	    public void transfer(Cont destinatie, Double valoare)
	            throws InsufficientFundsException, IllegalTransferException{
	if(this==destinatie){throw new IllegalAccessError();}
	        this.extrage(valoare);
	destinatie.alimenteazaCont(valoare);

	    }
	    public void adaugaDobanda(double procentDobanda){
	        this.balanta *=(1+procentDobanda/100);
	    }
}
