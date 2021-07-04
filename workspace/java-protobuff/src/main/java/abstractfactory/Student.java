package abstractfactory;

//private constructor
public class Student {

	private String firstName;
	private String lastName;
	private String address;
	private int id;
	private Student(String firstName, String lastName, String address, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = id;
	}
	private Student() {
	}
	
	private Student(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.address = builder.address;
		this.id = builder.id;
	}
	

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", id=" + id
				+ "]";
	}
	public static Builder builder() {
		return new Builder(); 
	}
	
	public static class Builder{
		private String firstName;
		private String lastName;
		private String address;
		private int id;
		
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		
		public Student build() {
			//lets use builer intance
			//return new Student(firstName, lastName, address, id);
			return new Student(this);
		}
		
	}
	
	
}
