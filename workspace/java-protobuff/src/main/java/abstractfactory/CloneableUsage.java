package abstractfactory;

public class CloneableUsage {

	
	public static void main(String[] args) {
		StudentCloneable obj = new StudentCloneable();
		System.out.println(obj.hashCode());
		
		try {
			obj.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
