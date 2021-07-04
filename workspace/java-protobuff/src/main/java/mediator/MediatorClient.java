package mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorClient {

	public static void main(String[] args) {
		MessageMediator mediator = new MessageMediator();
		IUser firstUser = new User("user-1");
		for(int i = 1 ; i < 5 ;  i++) {
			IUser user = new User("user-"+i);
			mediator.registerUser(user);
		}
		
		mediator.sendMessage("jai shree ram", firstUser);
	}
}

//complex objects whihc interacts

interface IUser{
	//send message to all others
	public void sendMessage(String message);
	
	public void recievMessage(String message);
	
	public String getName();
	
} 

class User implements IUser{
	private String name;
	
	//its tough to hold list of all other users
	//one to many relationship is complex coupling
	
	public User(String name) {
		this.name = name;
	}

	@Override
	public void sendMessage(String message) {
		System.out.println("user "+name+" sending message "+message);
	}

	@Override
	public void recievMessage(String message) {
		System.out.println("user "+name+" recieves message "+message);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	
}

class MessageMediator{
	
	private List<IUser> users;
	
	//lazy
	public void registerUser(IUser user) {
		if(users == null)
			users = new ArrayList<>();
		users.add(user);
	}
	
	public void sendMessage(String message , IUser sender) {
		if(users == null) {
			throw new IllegalStateException("users are empty");
		}
		users.stream()
		   .filter(user -> !user.equals(sender))
		   .forEach(user -> user.sendMessage(message));
		   ;
	}
}
