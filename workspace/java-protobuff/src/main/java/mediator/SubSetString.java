package mediator;

import java.util.ArrayList;
import java.util.List;

public class SubSetString {
	public static void main(String[] args) {
		String input  = "abcd";
		String subset = "";
		List<String> items = new ArrayList<>();
		input = input.replaceAll(" ", "");
		printSubsets(input, 0, subset,items);
		
		System.out.println("final result "+items);
	}
	
	
	public static void printSubsets(String input , int index , String current,List<String> items) {
		//base condition
		int length = input.length();
		if(index == length) {
			//all task done
			System.out.println("subset found "+current);
			items.add(current);
			return;
		}
		
		//either take it or ignore it
		//however index keep on groing so that we go to next choice diagram
		printSubsets(input, index + 1, current,items);
		printSubsets(input, index + 1, current + input.charAt(index),items);
	}
}
