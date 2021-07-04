package visitoranimals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSteps {
	
	private static Map<Integer, Long> stepCount = new HashMap<>();
	
	static int countCached = 0 ;
	public static void main(String[] args) {
		
		List<Long> resultsOurs = new ArrayList<>();
		List<Long> gkfgResults = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i= 0 ; i < 40 ; i++) {
			resultsOurs.add( stepWays(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("our method total time taken "+(end-start));
		
		System.out.println("countCached: "+countCached);
		start = System.currentTimeMillis();
		for(int i= 0 ; i < 40 ; i++) {
			gkfgResults.add( findStep(i));
		}
		
		end = System.currentTimeMillis();
		System.out.println("gkfg method total time taken "+(end-start));
		
		System.out.println("are results correct "+gkfgResults.equals(resultsOurs));
	}

	private static long stepWays(int size) {
		if(size < 0 ) {
			return 0;
		}
		// valid smallest case as per input
		if (size == 1 || size == 0) {
			return 1;
		}
		if (size == 2) {
			return 2;
		}
		if (size == 3) {
			return 4;
		}
		
		if(stepCount.containsKey(size)) {
			countCached++;
			return stepCount.get(size);
		}

		long result =  stepWays(size-3) + stepWays(size-2) + stepWays(size-1);
		stepCount.put(size, result);
		return result;
		
		//return stepWays(size-3) + stepWays(size-2) + stepWays(size-1);
	}
	
	private static long findStep(int n)
	{
	    if (n == 1 || n == 0)
	        return 1;
	    else if (n == 2)
	        return 2;

	    else
	        return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
	}

}


