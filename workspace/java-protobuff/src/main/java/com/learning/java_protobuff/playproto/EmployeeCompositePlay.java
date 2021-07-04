package com.learning.java_protobuff.playproto;

import java.util.HashMap;
import java.util.Map;

import com.learning.java_protobuff.beans.Address;
import com.learning.java_protobuff.beans.Car;
import com.learning.java_protobuff.beans.CarType;
import com.learning.java_protobuff.beans.Employee;

public class EmployeeCompositePlay {

	public static void main(String[] args) {
		Address address = Address.newBuilder()
								 .setAddress1("C 502 Majestic Apartment")
								 .setCity("New Delhi")
								 .setState("Delhi")
								 .setZipCode("110075")
								 .setCountry("IN")
								 .build();
		
		Car car1 = Car.newBuilder().setBrand("bajaj").setCarNumber("c1234")
				.setPrice(100000).setYear(2018)
				.setCarType(CarType.COOPER)
				.build();
		
		//System.out.println(car1.getCarType());
		
		Car car2 = Car.newBuilder().setBrand("honda").setCarNumber("c1235")
				.setPrice(2000000).setYear(2020)
				.setCarType(CarType.SEDAN)
				.build();
		
		Car car3 = Car.newBuilder().setBrand("maruti").setCarNumber("c1236")
				.setPrice(500000).setYear(2000)
				.setCarType(CarType.SUV)
				.build();
		Map<Integer, Car> carsMap = new HashMap<>();
		carsMap.put(1, car1);
		carsMap.put(2, car2);
		carsMap.put(3, car3);
		Student employee = Student.newBuilder().setAddress(address)
						.setAge(101)
						.setName("kanhayya")
						.addCar(car1)
						.addCar(car2)
						.addCar(car3)
						.putAllDealers(carsMap)
						.putDealers(3, car3)
						.setSalary(100000)
						.build();
		
		
		System.out.println("employee generated "+employee);
	}
}
