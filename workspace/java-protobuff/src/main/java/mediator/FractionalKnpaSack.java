package mediator;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnpaSack {
	public static void main(String[] args) {
		// weight of items in kgs
		int[] weights = { 10, 40, 20, 30 };

		// price of whole items
		int[] prices = { 60, 40, 100, 120 };

		int capacity = 50;

		System.out.println(maximizFractionalTheft(weights, prices, capacity));
		
		System.out.println(getMaxValue(weights, prices, capacity));
	}

	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		TheftItem[] iVal = new TheftItem[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new TheftItem(wt[i], val[i]);
		}

// sorting items by value;
		Arrays.sort(iVal, new Comparator<TheftItem>() {
			@Override
			public int compare(TheftItem o1, TheftItem o2) {
				return Double.valueOf(o2.getUnitPrice()).compareTo(o1.getUnitPrice());
			}
		});

		double totalValue = 0d;

		for (TheftItem i : iVal) {

			int curWt = (int) i.getWeight();
			int curVal = (int) i.getPrice();

			if (capacity - curWt >= 0) {
				capacity = capacity - curWt;
				totalValue += curVal;
			} else {
				double fraction = ((double) capacity / (double) curWt);
				totalValue += (curVal * fraction);
				capacity = (int) (capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	private static double maximizFractionalTheft(int[] weights, int[] prices, int capacity) {

		double theft = 0;
		int length = prices.length;
		TheftItem[] theftItems = new TheftItem[length];
		for (int i = 0; i < length; i++) {
			theftItems[i] = new TheftItem(weights[i], prices[i]);
		}

		Arrays.sort(theftItems, Comparator.comparing(TheftItem::getUnitPrice).reversed());
		

		for (TheftItem theftItem : theftItems) {
			// maybe still availble
			int weight = theftItem.getWeight();
			int price = theftItem.getPrice();
			if (capacity - weight >= 0) {
				theft += price;
				capacity -= weight;
			} else {

				// specific weight is greater than capacity
				double fraction = ((double) capacity / (double) weight);
				// lets eat complete fraction
				theft = theft + (fraction * price);
				capacity = capacity - (int) (fraction * weight);
				break;
			}
		}
		return theft;
	}

}

class TheftItem {

	private int weight;

	private int price;

	private double unitPrice;

	public TheftItem(int weight, int price) {
		this.weight = weight;
		this.price = price;
		this.unitPrice = price / weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
