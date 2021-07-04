package command;

public class CommandRunner {

	public static void main(String[] args) {
		Reciever reciever = new Reciever();
		
		CreateUserCommand createCommand = new CreateUserCommand(reciever, "debu", 22);
		Server server = new Server();
		
		server.execute(createCommand);
		
		RemoveUserCommand removeUserCommand = new RemoveUserCommand(reciever, 101);
		
		server.execute(removeUserCommand);
	}
	
}


class Reciever {
	
	public void createUser(String name , int id) {
		System.out.println("creating user "+name+" with id "+id);
	}
	
	public void removeUser(int id) {
		System.out.println("removing user with id "+id);
	}
	
}

interface Command{
	
	void execute();
}

class CreateUserCommand implements Command{
	private Reciever reciever;
	
	private String name;
	
	private int age;
	
	public CreateUserCommand(Reciever reciever, String name, int age) {
		this.reciever = reciever;
		this.name = name;
		this.age = age;
	}

	@Override
	public void execute() {
		reciever.createUser(name, age);
	}

}

class RemoveUserCommand implements Command{
	private Reciever reciever;
	
	
	private int age;
	
	public RemoveUserCommand(Reciever reciever, int age) {
		this.reciever = reciever;
		this.age = age;
	}

	@Override
	public void execute() {
		reciever.removeUser(age);
	}

}

class Server{
	
	public void execute(Command command) {
		command.execute();
	}
	
}
