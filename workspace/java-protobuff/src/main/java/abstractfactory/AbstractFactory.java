package abstractfactory;

public class AbstractFactory {

	public static void main(String[] args) {
		//FactoryCreator creator = new CarCreator();
		FactoryCreator creator = new HumanCreator();
		
		System.out.println(AbstractFactory.createObject(creator, "human"));
	}

	
	//factory method takes factory type and not direct properties
	public static CreatableObject createObject(FactoryCreator creator, String type) {
		return creator.createObject(type);
	}
}



interface FactoryCreator{
	public CreatableObject createObject(String type);
	
}


class CarCreator implements FactoryCreator{
	
	public CreatableObject createObject(String type) {

		if("hyundai".equals(type)) {
			return new Hyundai();
		}else if("toyota".equals(type)) {
			return new Toyota();
		}else {
			throw new IllegalArgumentException("car type "+type+" not supproted");
		}
	
	}
	
}

class HumanCreator implements FactoryCreator{
	
	public CreatableObject createObject(String type) {

		if("person".equals(type)) {
			return new Person();
		}else if("employee".equals(type)) {
			return new Employee();
		}else {
			throw new IllegalArgumentException("human type "+type+" not supproted");
		}
	
	}
	
}



interface Human extends CreatableObject{}
class Person implements Human{}
class Employee implements Human{}


