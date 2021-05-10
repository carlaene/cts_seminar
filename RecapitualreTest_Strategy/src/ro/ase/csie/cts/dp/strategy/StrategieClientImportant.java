package ro.ase.csie.cts.dp.strategy;

public class StrategieClientImportant implements InterfataStrategieAcordaPuncteBonus{
public void aplicaStrategieMK(ClientBanca client) {
	if(client.getSumaMaximaTransferata()>5000) {
		client.nivel*=3;  
	}
}
}
