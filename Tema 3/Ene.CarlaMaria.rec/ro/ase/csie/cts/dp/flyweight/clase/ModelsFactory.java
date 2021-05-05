package ro.ase.csie.cts.dp.flyweight.clase;

import java.util.HashMap;

public class ModelsFactory {
static HashMap<String, CardInterface> models = new HashMap<>();
	
	static {
		models.put(TypesOfCardModels.PREMIUM.toString(), new CardFlyweight(true));
		models.put(TypesOfCardModels.BASIC.toString(), new CardFlyweight(false));
	}
	
	public static CardInterface getCard(TypesOfCardModels type) {
		return models.get(type.toString());
	}

	
}
