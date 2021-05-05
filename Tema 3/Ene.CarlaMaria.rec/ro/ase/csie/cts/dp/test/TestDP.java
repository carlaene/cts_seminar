package ro.ase.csie.cts.dp.test;



import ro.ase.csie.cts.dp.adapter.clase.BankAccountActions;
import ro.ase.csie.cts.dp.adapter.clase.BankClientInfo;
import ro.ase.csie.cts.dp.builder.clase.BankMember;
import ro.ase.csie.cts.dp.composite.clase.AbstractNode;
import ro.ase.csie.cts.dp.composite.clase.Customer;
import ro.ase.csie.cts.dp.composite.clase.Group;
import ro.ase.csie.cts.dp.factory.clase.AbstractCard;
import ro.ase.csie.cts.dp.factory.clase.CardFactory;
import ro.ase.csie.cts.dp.factory.clase.CardType;
import ro.ase.csie.cts.dp.flyweight.clase.CardData;
import ro.ase.csie.cts.dp.flyweight.clase.CardInterface;
import ro.ase.csie.cts.dp.flyweight.clase.ModelsFactory;
import ro.ase.csie.cts.dp.flyweight.clase.TypesOfCardModels;
import ro.ase.csie.cts.dp.prototype.clase.CardConfigurator;
import ro.ase.csie.cts.dp.prototype.clase.TypeCustomer;
import ro.ase.csie.cts.dp.proxy.clase.InterfataLogin;
import ro.ase.csie.cts.dp.proxy.clase.ModulLogin;
import ro.ase.csie.cts.dp.proxy.clase.ProxyLogin;
import ro.ase.csie.cts.dp.singleton.clase.CardBancar;

public class TestDP {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//TEST SINGLETON
		// TODO Auto-generated method stub
		CardBancar card1= CardBancar.getCardBancar("1345.6789.0012.3445", 317);
		CardBancar card2 = CardBancar.getCardBancar("1348.6780.2212.3445", 425);
		
		if(card1==card2) {
			System.out.println("The cards have the same credentials.");
		}
		else
		{
			System.out.println("The cards have different credentials.");
		}
		
		//TEST FACTORY SIMPLE
		AbstractCard card = CardFactory.getCard(CardType.GOLD, "purple");
		card = CardFactory.getCard(CardType.PLATINUM, "red");
		card = CardFactory.getCard(CardType.SILVER, "yellow");
		
		
		CardConfigurator cardd1 = new CardConfigurator(TypeCustomer.OLD, "red");
		
		CardConfigurator cardd2 = (CardConfigurator) cardd1.clone();
		CardConfigurator cardd3 = (CardConfigurator) cardd1.clone();
		
		//TEST BUILDER
		BankMember newMember = 
				new BankMember.BankMemberBuilder("Ionescu Razvan", 100).build();
		BankMember oldMember = 
				new BankMember.BankMemberBuilder("Costache Mirela", 1500)
				.isHavingADepot()
				.isLoyal()
				.build();
		
		//TEST ADAPTER
		BankClientInfo clientI1 = new BankAccountActions("Gheorghe Marius", 1000, 3500);
		clientI1.pay(150);
		clientI1.transfer(500);
		clientI1.save(1000);
		
		
		//TEST DECORATOR
		BankClientInfo clientI2 = new BankAccountActions("Georgescu Maria", 1500, 13500);
		
		clientI2.save(1000);
		clientI2.getHigherMemberLevel();
		clientI2.penaltyPoints(3);
		
		//TEST COMPOSITE
		AbstractNode group1 = new Group("Ionescu Marcel");
		group1.addNode(new Customer("Marinescu Robert", "Marinescu Oana"));
		group1.addNode(new Customer("Suciu Iuliana", "Iulian Ioan"));
		AbstractNode group2=new Group("Badescu Mihaela");
		group2.addNode(new Customer("Marghescu Claudia", "Popescu Maria"));
		group2.addNode(new Customer("Mircescu Ioan", "Rosescu Mariana"));
		
		
		
		group1.changeAdministratorAccount("Olivescu Ioana");
		group2.closeTheAccount();
		
		//TEST FLYWEIGHT
		CardData basic1 = new CardData(false,"Gheorghe Razvan",3456,367);
		CardData basic2 = new CardData(false,"Marinescu Radu",5699,665);
		
		CardData premium1 = new CardData(true,"Gina Iulia",1234,399);
		CardData premium2 = new CardData(true,"Petre Ana",1290,102);
		
		CardInterface int1 = ModelsFactory.getCard(TypesOfCardModels.PREMIUM);
		int1.viewCardDetails(premium1);
		int1.viewCardDetails(premium2);
		
		((CardInterface) ModelsFactory.getCard(TypesOfCardModels.BASIC)).viewCardDetails(basic1);
		((CardInterface) ModelsFactory.getCard(TypesOfCardModels.BASIC)).viewCardDetails(basic2);
		 //TEST PROTOTYPE
		CardConfigurator cardClient= new CardConfigurator(TypeCustomer.OLD,"gold");
		
		CardConfigurator anotherCard=cardClient;
		CardConfigurator cardClient1= (CardConfigurator) cardClient.clone();
		//TEST PROXY
		InterfataLogin login = new ModulLogin("10.0.0.1");
		if(login.accountAccess("admin", "1234"))
			System.out.println("Hello admin");
		
		
	
		login = new ProxyLogin(login);
		
		String[] pinList = 
				new String[] {"1234", "root", "admin", "root12","root1234"};
		for(String pin : pinList) {
			if(login.accountAccess("user", pin))
				System.out.println("Recovered PIN: " + pin);
		}
		
		System.out.println("Blocked account!");
	}

}
