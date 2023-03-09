import java.util.*;
import java.lang.Math;
import java.math.BigInteger;
/**
 * 
 * @author Anthony D'Alessandro
 *
 */
public class StatsLibrary {
	public void StatsLibrary() {
		
	}
	/**
	 * 
	 * @param list (An ArrayList of Integers)
	 * @return avg (The mean, or average, of the list)
	 */
	//Mean; takes an ArrayList of Integers as a parameter, adds all of the values for a total sum, divides that sum by the number of values in the list, stores the quotient in an "avg" variable, and returns "avg"
	public double mean(ArrayList<Integer> list) {
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		avg = sum / list.size();
		return avg;
	}
	/**
	 * 
	 * @param list (An ArrayList of Integers)
	 * @return median (The middle value of the list after it has been sorted from least to greatest)
	 */
	/* Median; takes an ArrayList of Integers as a parameter, sorts the list from least to greatest, and determines if the length of the list is even or odd. 
	 If it is odd, then the index of the middle value of the list can be found by subtracting 1 from the list length and dividing by 2. The median then can be found by accessing the value at that index.
	 If it is even, then the median is found by finding the average of the middle two values in the list. The index of the middle two values can be found by dividing the length of the list by 2 to find the 
	 index of the first value followed by subtracting 1 from that value to find the index of the second value. The median can then be found by accessing the values at those two indexes, adding them together, and dividing by 2.
	 For either case, the median is calculated and stored in a "median" variable which is then returned. 
	*/
	public double median(ArrayList<Integer> list) {
		Collections.sort(list);
		double median;
		
		if (list.size() % 2 == 1) {
			int oddMiddle = (list.size() - 1)/ 2;
			median = list.get(oddMiddle);
		}
		else {
			int evenMiddle = list.size() / 2;
			median = (double) (list.get(evenMiddle) + list.get(evenMiddle - 1)) / 2;
		}
		
		return median;
	}
	
	/**
	 * 
	 * @param list (An ArrayList of Integers)
	 * @return mode (The value that occurs the most frequently in the list)
	 */
	/* Mode; takes an ArrayList of Integers as a parameter,
	 * 
	 */
	public Integer mode(ArrayList<Integer> list) {
		// Returns null if there is no mode or if there is more than one mode
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int temp = 0;
		int greatest = 0;
		int index = 0;
		Integer mode;
		
		for (int i = 0; i < list.size(); i++) {
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) == list.get(j))
					count++;
			}
			map.put(list.get(i), count);
		}
		
		for (int i = 0; i < list.size(); i++) {
			temp = map.get(list.get(i));
			if (temp > greatest) {
				greatest = temp;
				index = i;
			}
		}
		
		map.remove(list.get(index));
		
		if (map.containsValue(greatest) || greatest <= 1)
			mode = null;
		else
			mode = list.get(index);
		
		return mode;
	}
	/**
	 * 
	 * @param list (An ArrayList of Integers)
	 * @return standardDeviation (A measure of how spread out the values of the list are in relation to the mean)
	 */
	/*
	 * Standard Deviation; takes an ArrayList of Integers as a parameter. Starts by calling the local 'mean' method to find the average of the list. 
	 * Next, for each value in the list, subtracts the average, squares the difference, and adds the result to a total sum. The standard deviation is
	 * then calculated by dividing that total sum by the number of values in the list (size of the list) and taking the square root of the quotient.
	 * The standard deviation is then returned.
	 */
	public double standardDeviation(ArrayList<Integer> list) {
		double sum = 0;
		double standardDeviation = 0;
		double avg = mean(list);
		
		for (int i = 0; i < list.size(); i++) {
			sum += Math.pow((list.get(i) - avg), 2);
		}
		standardDeviation = Math.sqrt((sum/list.size()));
		return standardDeviation;
	}
	/**
	 * 
	 * @param list1 (An ArrayList of Integers)
	 * @param list2 (An ArrayList of Integers)
	 * @return list2 (An ArrayList of Integers; the complement of list1 given list2 as a universal set of Integers)
	 */
	/*
	 * Complement; takes two ArrayLists of Integers as parameters. List2 acts as the "universal" set in which the complement of list1 is every element in list2 excluding all elements from list1.
	 * Starts by iterating through list1; if list2 contains the current element from list1, then that element is removed from list2. This repeats until it completely iterates through list1.
	 * List2 is then returned.
	 */
	public ArrayList<Integer> complement(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) 
				list2.remove(list1.get(i));
		}
		return list2;
	}
	/**
	 * 
	 * @param list1 (An ArrayList of Integers)
	 * @param list2 (An ArrayList of Integers)
	 * @return intersectionList (An ArrayList of Integers; the intersection of list1 and list2)
	 */
	/*
	 * Intersection; takes two ArrayLists of Integers as parameters. Starts by declaring an empty ArrayList of Integers to act as the intersection list. It then iterates through list1 and for each element, checks if it exists in list2.
	 * If list1 shares an element with list2, then it is added to the intersection list. Once it completely iterates through list1, it returns intersectionList. 
	 */
	public ArrayList<Integer> intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> intersectionList = new ArrayList<Integer>();
		
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i)))
				intersectionList.add(list1.get(i));
		}
		
		return intersectionList;
	}
	/**
	 * 
	 * @param list1 (An ArrayList of Integers)
	 * @param list2 (An ArrayList of Integers)
	 * @return list2 (An ArrayList of Integers; the union of list1 and list2)
	 */
	/*
	 * Union; takes two ArrayLists of Integers as parameters. Starts by iterating through list1 and checks if each element is not contained in list2. If an element from list1 does not exist in list2, it is added to list2.
	 * Once it completely iterates through list1, it returns list2.
	 */
	public ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i)))
				list2.add(list1.get(i));
		}
		
		return list2;
	}
	/**
	 * 
	 * @param x (An integer)
	 * @return result (The factorial of x in the form of a BigInteger)
	 */
	/*
	 * Factorial; takes an integer as a parameter. Starts by declaring a BigInteger (result) and assigning the value of x to it. Next, it iterates through a loop from 1 up to 1 less than the value of x. For each pass through the loop, 
	 * the BigInteger result variable is assigned the value of itself multiplied with the current loop counter value. Once it completely iterates through the loop, result is returned.
	 */
	public BigInteger factorial(int x) {
		BigInteger result = BigInteger.valueOf(x);
		
		for (int i = 1; i < x; i++)
			result = result.multiply(BigInteger.valueOf(i));
		
		return result;
	}
	/**
	 * 
	 * @param n (An integer; the total number of items to choose from)
	 * @param r (An integer; the number of items selected)
	 * @return result (The number of possible arrangements given n and r where order does not matter; in the form of a BigInteger)
	 */
	public BigInteger combination(int n, int r) {
		BigInteger result;
		
		result = (factorial(n)).divide((factorial(r).multiply(factorial(n - r))));
		
		return result;
	}
	/**
	 * 
	 * @param n (An integer; the total number of items to choose from)
	 * @param r (An integer; the number of items selected)
	 * @return result (The number of possible arrangements given n and r where order does matter; in the form of a BigInteger)
	 */
	public BigInteger permutation(int n, int r) {
		BigInteger result;
		
		result = factorial(n).divide(factorial(n - r));
		
		return result;
	}
	/**
	 * 
	 * @param n (An integer)
	 * @param y (An integer)
	 * @param p (A double)
	 * @return probability (
	 */
	public double binomialDistribution(int n, int y, double p) {
		double probability;
		double q = 1 - p;
		double comb = combination(n, y).doubleValue();

		probability = comb * (Math.pow(p,  y)) * (Math.pow(q,  (n - y)));
		
		return probability;
	}
	/**
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	public double geometricDistribution(int n, double p) {
		double probability;
		double q = 1 - p;
		
		probability = (Math.pow(q, n-1)) * p;
		
		return probability;
	}
}
