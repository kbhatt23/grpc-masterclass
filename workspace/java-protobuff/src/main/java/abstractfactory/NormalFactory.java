package abstractfactory;

public class NormalFactory {

	public static void main(String[] args) {
		System.out.println(NormalFactory.createCar("toyota").getClass());
	}
	
	public static Car createCar(String type) {
		if("hyundai".equals(type)) {
			return new Hyundai();
		}else if("toyota".equals(type)) {
			return new Toyota();
		}else {
			throw new IllegalArgumentException("car type "+type+" not supproted");
		}
	}
}

interface Car extends CreatableObject{}

class Hyundai implements Car{}

class Toyota implements Car{}

interface CreatableObject{}