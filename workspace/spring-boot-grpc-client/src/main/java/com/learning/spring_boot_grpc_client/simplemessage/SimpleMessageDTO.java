package com.learning.spring_boot_grpc_client.simplemessage;

public class SimpleMessageDTO {

	private int number;
	private long squareNumber;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getSquareNumber() {
		return squareNumber;
	}

	public void setSquareNumber(long squareNumber) {
		this.squareNumber = squareNumber;
	}

	public SimpleMessageDTO() {
		super();
	}

	public SimpleMessageDTO(int number, long squareNumber) {
		super();
		this.number = number;
		this.squareNumber = squareNumber;
	}

	@Override
	public String toString() {
		return "SimpleMessageDTO [number=" + number + ", squareNumber=" + squareNumber + "]";
	}

}
