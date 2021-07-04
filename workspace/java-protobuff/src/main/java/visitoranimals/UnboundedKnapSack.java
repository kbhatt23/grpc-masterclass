package visitoranimals;

public class UnboundedKnapSack {

	public static void main(String[] args) {
		int prices[] = new int[] { 1,3,4,5  };
		int weights[] = new int[] { 1,4,5,7 };
		int capacity = 50;

		System.out.println(unboundedBestTheft(weights, prices, capacity, 0));
	}
	
	private static int unboundedBestTheft(int[] weights, int[] prices , int capacity , int index) {
		
		if(capacity == 0 || index == weights.length) {
			return 0;
		}
		
		int weight = weights[index];
		if(weight > capacity) {
			//can only inore
			return unboundedBestTheft(weights, prices, capacity, index + 1);
		}
		int ignoredTheftPrice = unboundedBestTheft(weights, prices, capacity, index + 1);
		int acceptTheftPrice =prices[index] + unboundedBestTheft(weights, prices, capacity - weight, index);
		return Math.max(ignoredTheftPrice, acceptTheftPrice);
	}
}
