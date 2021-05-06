package ro.ase.csie.cts.ro.test;

import ro.ase.csie.cts.dp.strategy.Jucator;
import ro.ase.csie.cts.dp.strategy.Strategie1Iunie;
import ro.ase.csie.cts.dp.strategy.StrategieJucatorNou;

public class TestStrategy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jucator j1=new Jucator(150,"Gigel",7);
		j1.setStrategieMk(new StrategieJucatorNou());
		j1.acordaPuncteBonus();
		j1.setStrategieMk(new Strategie1Iunie());
	}

}
