package ro.ase.csie.cts.lab.exceptii;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception{
	public InsufficientFundsException(String mesaj){
        super(mesaj);
    }
    public InsufficientFundsException(){

    }
}
