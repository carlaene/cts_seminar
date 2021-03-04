package ro.ase.csie.cts.lab.modele;

import ro.ase.csie.cts.lab.exceptii.IllegalTransferException;
import ro.ase.csie.cts.lab.exceptii.InsufficientFundsException;

public abstract class Cont {
	 public abstract double getBalanta();
	    public abstract void alimenteazaCont(Double valaore); //cu Object primesc o valaore generica
	    //Double acopera toate tipurile numerice
	    public abstract void extrage(Double valoare) throws InsufficientFundsException;
	    public abstract void transfer(Cont destinatie, Double valoare) throws InsufficientFundsException, IllegalTransferException;
}
