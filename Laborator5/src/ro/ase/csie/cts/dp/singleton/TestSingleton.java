package ro.ase.csie.cts.dp.singleton;

public class TestSingleton {
public static void main(String [] args) {
	ConexiuneDB conexiune1 = ConexiuneDB.getConexiune();
	ConexiuneDB conexiune2 = ConexiuneDB.getConexiune();
	if(conexiune1==conexiune2) {
		System.out.println("Cele 2 referinte sunt identice");
	}
	else {
		System.out.println("Cele 2 referinte sunt diferite.");
	}
	ModulUI modulUI= new ModulUI();
	ModulProfil modulprofil =  new ModulProfil();
}
}
