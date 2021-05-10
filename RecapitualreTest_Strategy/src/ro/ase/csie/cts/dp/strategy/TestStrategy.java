package ro.ase.csie.cts.dp.strategy;

public class TestStrategy {
public static void main(String[] args) {
	ClientBanca client1= new ClientBanca("Marinescu Ioan",20,3000,6,3);
	client1.setInterfata(new StrategieClientFidel());
	client1.acordaPuncteBonus();
	client1.setInterfata(new StrategieClientNou());
	client1.acordaPuncteBonus();
	client1.setInterfata(new StrategieClientImportant());
	client1.acordaPuncteBonus();
	System.out.println("Clientul"+client1.getNume()+" are nivelul "+client1.getNivel()+".");
	
}
}
