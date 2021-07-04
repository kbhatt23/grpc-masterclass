package mediator;

public class MaxWaysToCountAmount {

	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3};
		int sum =5;
		System.out.println(waysToExchange(coins, sum, 0));
	}
	
	private static int waysToExchange(int[] coins , int sum , int index) {
		
		if(sum == 0 || index == coins.length) {
			return 0;
		}
		
		int amount = coins[index];
		if(amount > sum) {
			//can only ignore
			return waysToExchange(coins, sum, index +1);
		}
		
		int rejectCoinWays = waysToExchange(coins, sum, index +1);
		//unbounded
		int acceptCoinWays = amount+ waysToExchange(coins, sum - amount, index /* +1 */);
		
		return Math.max(rejectCoinWays, acceptCoinWays);
	}
}
