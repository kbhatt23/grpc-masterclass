package mediator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseArray {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5};
		String old = Arrays.stream(numbers).mapToObj(String :: valueOf).collect(Collectors.joining(","));
		System.out.println("old: "+old);
//		reverseArray(numbers);
//		String newo = Arrays.stream(numbers).mapToObj(String :: valueOf).collect(Collectors.joining(","));
//		System.out.println("newo: "+newo);
		
		reverseArrayRecursion(numbers, 0, numbers.length-1);
		String newo = Arrays.stream(numbers).mapToObj(String :: valueOf).collect(Collectors.joining(","));
		System.out.println("newo: "+newo);
	}
	
	public static void reverseArray(int[] numbers) {
		int length = numbers.length;
		int iteration = length/2;
		for(int i =0 , j = length-1 ; i < iteration ; i++,j--) {
			swap(numbers, i, j);
		}
	}

	private static void swap(int[] numbers, int i, int j) {
		int front = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = front;
	}
	
	public static void reverseArrayRecursion(int[] numbers, int frontIndex , int backIndex) {

		int halfLength = numbers.length/2;
		if(frontIndex == halfLength) {
			return;
		}
		
		//first do the task
		swap(numbers, frontIndex, backIndex);
		//move on
		reverseArrayRecursion(numbers, frontIndex+1, backIndex-1);
	}
}
