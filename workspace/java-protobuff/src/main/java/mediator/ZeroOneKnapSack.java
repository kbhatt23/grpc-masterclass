package mediator;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapSack {
	
	private static final Map<String, Integer> STORAGE = new HashMap<>();
	public static void main(String[] args) {
		int prices[] = new int[] { 1,3,4,5  };
		int weights[] = new int[] { 1,4,5,7 };
		int capacity = 50;

		System.out.println(maximizeTheft(weights, prices, capacity, 0));
	}

	private static int maximizeTheft(int[] weights, int[] prices, int capacity, int index) {

		// base case
		if (index == weights.length || capacity == 0) {
			return 0;
		}
		
		String key = String.valueOf(capacity)+":"+index;
		if(STORAGE.containsKey(key)) {
			System.out.println("cache saved for key "+key);
			return STORAGE.get(key);
		}

		// when weight is already more than capacity
		// we can only skip
		int currentWright = weights[index];
		
		if (currentWright > capacity) {
			int amount=  maximizeTheft(weights, prices, capacity, index + 1);
			STORAGE.put(key, amount);
			return amount;
		}

		// choice
		// select it
		int selectedPrice = prices[index] + maximizeTheft(weights, prices, capacity - currentWright, index + 1);
		int skippedPRice = maximizeTheft(weights, prices, capacity, index + 1);

		int amount =  Math.max(selectedPrice, skippedPRice);
		STORAGE.put(key, amount);
		return amount;
	}
}
