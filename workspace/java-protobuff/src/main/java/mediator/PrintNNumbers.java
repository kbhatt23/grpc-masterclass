package mediator;

public class PrintNNumbers {

	public static void main(String[] args) {
		int n = 10;
		printNumbers(n , 1);
		
		printNumbersLoop(n);
		
		printNumbersV2(n);
	}
	
	public static void printNumbersReverse(int n) {
		if(n == 0)
			return;
		//choice one ->lets use this item
		System.out.println("number found "+n);
		//choice 2 -> lets ignore this item and go to other itemss
		printNumbersReverse(n - 1);
	}
	
	public static void printNumbers(int n , int current) {
		if(n == 0 || current > n)
			return;
		
		System.out.println("number found "+current);
		printNumbers(n  , current +1);
	}
	
	public static void printNumbersV2(int n ) {
		if( n == 0) {
			return;
		}
		printNumbersV2(n-1);
		System.out.println("printNumbersV2 "+n);
	}
	
	public static void printNumbersLoop(int n) {
		for(int i = 1 ; i <= n ; i++) {
			System.out.println(i);
		}
	}
}
