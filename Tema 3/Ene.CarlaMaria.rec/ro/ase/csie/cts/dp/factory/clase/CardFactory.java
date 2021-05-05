package ro.ase.csie.cts.dp.factory.clase;

public class CardFactory {
	public static AbstractCard getCard(CardType type, String color) {
		AbstractCard card = null;
		switch (type) {
		case GOLD:
			card = new GoldCard(color, "old",100);
			break;
		case PLATINUM:
			card = new PlatinumCard(color,"loyal",100);
			break;
		case SILVER:
			card = new SilverCard(color, "less frquent");
			break;
		default:
			throw new UnsupportedOperationException();
		}
		
		return card;
	}
}
