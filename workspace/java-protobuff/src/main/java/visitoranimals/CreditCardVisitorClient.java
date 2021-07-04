package visitoranimals;

public class CreditCardVisitorClient {

	public static void main(String[] args) {

		CreditCard bronzeCard = new BronzeCard();
		CreditCard goldCard = new GoldCard()
		;
		CreditCard platinumCard = new PlatinumCard();
		
		CardOperation gasOperation = new GasOperation();
		HospitalOperation hospitalOperation = new HospitalOperation();
		
		manageCards(bronzeCard, hospitalOperation);
		manageCards(bronzeCard, gasOperation);
		manageCards(goldCard, hospitalOperation);
		manageCards(goldCard, gasOperation);
		
		manageCards(platinumCard, hospitalOperation);
		manageCards(platinumCard, gasOperation);
		
		System.out.println("===========");
		
		HotelOperation hotelOperation = new HotelOperation();
		manageCards(bronzeCard, hotelOperation);
		manageCards(goldCard, hotelOperation);
		manageCards(platinumCard, hotelOperation);
		
	}
	public static void manageCards(CreditCard card , CardOperation cardOperation) {
		System.out.println("card "+ card.getClass().getName()+" with opertion "+cardOperation.getClass().getName() +" have discount " +card.visit(cardOperation));
	}
}

//instad of having multiple methods
//lets have one method
interface CreditCard{
	
	int visit(CardOperation cardOperation);
	
}

class BronzeCard implements CreditCard{

	@Override
	public int visit(CardOperation cardOperation) {
		return cardOperation.accept(this);
	}
	
}

class GoldCard implements CreditCard{

	@Override
	public int visit(CardOperation cardOperation) {
		return cardOperation.accept(this);
	}
	
}


class PlatinumCard implements CreditCard{

	@Override
	public int visit(CardOperation cardOperation) {
		return cardOperation.accept(this);
	}
	
}

interface CardOperation{
	
	int accept(BronzeCard bronzeCard);
	

	int accept(GoldCard goldCard);
	

	int accept(PlatinumCard platinumCard);
}

class GasOperation implements CardOperation{

	@Override
	public int accept(BronzeCard bronzeCard) {
		System.out.println("bronze gas operation called");
		return 1;
	}

	@Override
	public int accept(GoldCard goldCard) {
		System.out.println("gold gas operation called");
		return 3;
	}

	@Override
	public int accept(PlatinumCard platinumCard) {
		System.out.println("platinum gas operation called");
		return 5;
	}
	
	
}

class HospitalOperation implements CardOperation{

	@Override
	public int accept(BronzeCard bronzeCard) {
		System.out.println("bronze hospital operation called");
		return 5;
	}

	@Override
	public int accept(GoldCard goldCard) {
		System.out.println("gold hospital operation called");
		return 7;
	}

	@Override
	public int accept(PlatinumCard platinumCard) {
		System.out.println("platinum hspital operation called");
		return 10;
	}
}


class HotelOperation implements CardOperation{

	@Override
	public int accept(BronzeCard bronzeCard) {
		return 0;
	}

	@Override
	public int accept(GoldCard goldCard) {
		return 1;
	}

	@Override
	public int accept(PlatinumCard platinumCard) {
		return 3;
	}
	
}