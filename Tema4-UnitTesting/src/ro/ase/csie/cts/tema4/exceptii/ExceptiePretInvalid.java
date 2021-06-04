package ro.ase.csie.cts.tema4.exceptii;

public class ExceptiePretInvalid extends Exception {
	public ExceptiePretInvalid(String mesaj) {
		super(mesaj);	
		}
		public ExceptiePretInvalid() {
			System.out.println("Exceptie pret invalid");
		}
}
