package decorator;

import java.util.HashMap;
import java.util.Map;

public class FlyweightClient {

	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i++) {
			EmployeeFlyweight fetchEmployee = null;
			if(i % 2 == 0) {
				fetchEmployee = EmployeeFactory.fetchEmployee("dev");
				fetchEmployee.setName("dev-"+i);
			}else {
				fetchEmployee = EmployeeFactory.fetchEmployee("qa");
				fetchEmployee.setName("qa-"+i);
			}
			fetchEmployee.assignTask("task-"+i);
			fetchEmployee.startTask();
		}
	}
	
}

abstract class EmployeeFlyweight {

	// the state that changes should have setter/modifyable methos here
	// contract will be shown for this abstract class

	private String name;

	private String taskId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaskId() {
		return taskId;
	}

	public void assignTask(String taskId) {
		this.taskId = taskId;
	}

	public abstract void startTask();

}

class Developer extends EmployeeFlyweight {

	@Override
	public void startTask() {
		System.out.println("devloper " + getName() + " started working task " + getTaskId());

	}

}

class Tester extends EmployeeFlyweight {

	@Override
	public void startTask() {
		System.out.println("tester " + getName() + " started working task " + getTaskId());

	}

}

class EmployeeFactory {

	private static Map<String, EmployeeFlyweight> storage = new HashMap<>();

	public static EmployeeFlyweight fetchEmployee(String role) {
		EmployeeFlyweight employeeFlyweight = null;

		if ("dev".equals(role)) {
			if (storage.containsKey(role)) {
				employeeFlyweight = storage.get(role);
			} else {
				System.out.println("creating new dev");
				employeeFlyweight = new Developer();
				storage.put(role, employeeFlyweight);
			}
		} else if ("qa".equals(role)) {
			if (storage.containsKey(role)) {
				employeeFlyweight = storage.get(role);
			} else {
				System.out.println("creating new tester");
				employeeFlyweight = new Tester();
				storage.put(role, employeeFlyweight);
			}

		} else {
			throw new IllegalArgumentException("do not support role " + role);
		}
		
		return employeeFlyweight;
	}
}