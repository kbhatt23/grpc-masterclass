package abstractfactory;

public class BuilderDemo {

	public static void main(String[] args) {
		
		Student build = Student.builder().setFirstName("debu")
				.setId(1).build();
		;
		
System.out.println(build);
	}

}
