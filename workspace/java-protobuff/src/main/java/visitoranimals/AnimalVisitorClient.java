package visitoranimals;


public class AnimalVisitorClient {

	public static void main(String[] args) {
		AnimalVisitor walking = new WalkVisitor();
		AnimalVisitor eating = new EatVisitor();
		Animal dog =  new Dog();
		
		dog.accept(walking);
		dog.accept(eating);
		
		Animal cat = new Cat();
		cat.accept(walking);
		cat.accept(eating);
		
	}
}

//visitor based
//meaning it will have a single method for all kind of actions
//that actional will be generic
 interface Animal {

	void accept(AnimalVisitor animalVisitor);
}
 
 interface AnimalVisitor{
	 
	 void visit(Dog dog);
	 
	 void visit(Cat cat);
	 
 }
 
 class WalkVisitor implements AnimalVisitor{

	@Override
	public void visit(Dog dog) {
		System.out.println("dog walking");
	}

	@Override
	public void visit(Cat cat) {
		System.out.println("cat walking");
	}
 }
 
 class EatVisitor implements AnimalVisitor{

	@Override
	public void visit(Dog dog) {
		System.out.println("dog eating");
	}

	@Override
	public void visit(Cat cat) {
		System.out.println("cat eating");
	}
	 
 }
 
 class Dog implements Animal{

	@Override
	public void accept(AnimalVisitor animalVisitor) {

		animalVisitor.visit(this);
		
	}
	 
	 
 }
 
 class Cat implements Animal{

	@Override
	public void accept(AnimalVisitor animalVisitor) {

		animalVisitor.visit(this);
		
	}
	 
	 
 }
