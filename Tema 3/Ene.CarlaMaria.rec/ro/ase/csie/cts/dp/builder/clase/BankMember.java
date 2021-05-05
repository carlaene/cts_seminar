package ro.ase.csie.cts.dp.builder.clase;

public class BankMember {
private String name;
private int fidelityPoints;
private boolean isLoyalClient;
private boolean isHavingADepot;
private boolean adaugaListaReduceri;
private CardInterface cardCredit;
private CardInterface cardDebit;
 
private MemberInterface clientDepotRON;
private MemberInterface clientDepotEUR;
 
 public BankMember() {}
public BankMember(String name, int fidelityPoints, boolean isLoyalClient, boolean isHavingADepot,
		CardInterface cardCredit, CardInterface cardDebit, MemberInterface clientDepozitRON,
		MemberInterface clientDepozitEUR) {
	super();
	this.name = name;
	this.fidelityPoints = fidelityPoints;
	this.isLoyalClient = isLoyalClient;
	this.isHavingADepot = isHavingADepot;
	this.cardCredit = cardCredit;
	this.cardDebit = cardDebit;
	this.clientDepotRON = clientDepozitRON;
	this.clientDepotEUR = clientDepozitEUR;
}



public static class BankMemberBuilder {
	 BankMember member;
	 public BankMemberBuilder(String name, int fidelityPoints) {
		 this.member=new BankMember();
		 this.member.name=name;
		 this.member.fidelityPoints=fidelityPoints;
	 
}
	 public BankMemberBuilder isLoyal() {
			this.member.isLoyalClient = true;
			return this;
		}
		
	 public BankMemberBuilder adaugaListaReduceri() {
		 this.member.adaugaListaReduceri=true;
		 return this;
	 }
		public BankMemberBuilder isHavingADepot() {
			this.member.isHavingADepot = true;
			return this;
		}
		public BankMemberBuilder setCardCredit(CardInterface card) {
			this.member.cardCredit = card;
			return this;
		}
		
		public BankMemberBuilder setDebitCard(CardInterface card) {
			this.member.cardDebit = card;
			return this;
		}
		
		public BankMemberBuilder setClientDepotRON(MemberInterface client) {
			this.member.clientDepotRON = client;
			return this;
		}
		
		public BankMemberBuilder setClientDepotEUR(MemberInterface client) {
			this.member.clientDepotEUR = client;
			return this;
		}

		public BankMember build() {
			return this.member;
		}

}
}


