package ro.ase.csie.cts.dp.singleton;

public class ConexiuneDB {
String ip;
String denumire;
private static ConexiuneDB conexiune=null;
public ConexiuneDB(String ip, String denumire) {
	System.out.println("ApelConstructor");
	this.ip = ip;
	this.denumire = denumire;
}
public static synchronized ConexiuneDB getConexiune() {//static ca sa o putem apela
if(conexiune==null) {
//datele se pot prelua din fis de configurare
	conexiune= new ConexiuneDB("10.0.0.1", "cts");
	
}
return conexiune;
}
}
