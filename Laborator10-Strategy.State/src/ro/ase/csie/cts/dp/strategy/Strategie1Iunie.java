package ro.ase.csie.cts.dp.strategy;

public class Strategie1Iunie implements IStrategieMarketing{

	@Override
	public void aplicaStrategieBonus(Jucator jucator) {
		// TODO Auto-generated method stub
		if(jucator.getClasaJucator()>5) {
			jucator.clasaJucator*=2;
		}
		
	}

}
