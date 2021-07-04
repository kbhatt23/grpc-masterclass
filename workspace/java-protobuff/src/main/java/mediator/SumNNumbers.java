package mediator;

import java.util.stream.LongStream;

public class SumNNumbers {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(sumV1(n));
		
		System.out.println(sumV2(n));
	}
	
	public static long sumV1(long n) {
		return LongStream.rangeClosed(1, n)
					.sum()
		;
	}
	
	public static long sumV2(long n) {
		if( n == 0 || n == 1) {
			return n;
		}
		
		return n + sumV2(n-1);
	}
}
