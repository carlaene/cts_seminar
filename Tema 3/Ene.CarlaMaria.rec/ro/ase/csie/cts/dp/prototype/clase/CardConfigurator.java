package ro.ase.csie.cts.dp.prototype.clase;

import java.util.ArrayList;
import java.util.Random;

public class CardConfigurator {
	TypeCustomer type;
	String cardColor;
	
	ArrayList<Integer> fidelityPoints = new ArrayList<>();

	public CardConfigurator(TypeCustomer type, String color) {
		this.type = type;
		this.cardColor = color;
		
		System.out.println("Generating the model of the card......");
		
		try {
			Thread.sleep(2000);
			Random random = new Random(7887);
			for(int i = 0; i < 20; i++) {
				fidelityPoints.add(random.nextInt(1000));
			}
			
			System.out.println("Model loaded.");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private CardConfigurator() {

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		//don't
		//Char3DModel copy = new Char3DModel(this.type, this.color);
		
		CardConfigurator copy = new CardConfigurator();
		copy.type = this.type;
		copy.cardColor = this.cardColor;
		copy.fidelityPoints = (ArrayList<Integer>) this.fidelityPoints.clone();
		
		return copy;
	}
	
}
