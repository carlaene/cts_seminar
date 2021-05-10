package ro.ase.csie.cts.dp.strategy;

public class StrategieClientNou implements InterfataStrategieAcordaPuncteBonus{
public void aplicaStrategieMK(ClientBanca client) {
	if(client.getNumarMediuTranzactiiLunare()>10) {
		client.nivel+=1;
		System.out.println("Am aplicat strategia de mk pt un client nou-venit.");
	}
}
}
