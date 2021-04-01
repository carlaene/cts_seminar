package ase.ro.csie.cts.laboratoare.laborator6;

public class TestBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		//Supererou superErou1= new Supererou("Superman",100,false,false,new Arma(),null, new Laser(), null);
		Supererou superman= new Supererou.SuperErouBuilder("Superman",100).build();
	}

}
