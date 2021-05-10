package ro.ase.csie.cts.dp.strategy;

public class StrategieClientFidel implements InterfataStrategieAcordaPuncteBonus{
public void aplicaStrategieMK(ClientBanca client) {
	if(client.getNrInvitatiiTrimise()>5) {
		client.nivel+=2;
		System.out.println("Am aplicat stragetgia de mk pt un client fidel al bancii.");
	}
}
}
