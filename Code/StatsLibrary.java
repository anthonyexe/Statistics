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
	/* 
	 * Mode; takes an ArrayList of Integers as a parameter. Starts by declaring a new HashMap object, three integers temp, greatest, and index, as well as one Integer object to store the final mode value. Starts by iterating through the list declaring an int variable count 
	 * inside the outer loop followed by starting an inner loop to iterate through the list again to compare list values. Inside the inner loop, the list value at the i'th index is compared to the list value at the j'th index. If the values are equal to each other, the count 
	 * variable is incremented. Next, outside of the inner loop but still inside of the outer loop, the list value at the i'th index is added to the hashmap along with the corresponding count value to represent the number of occurrences of that list value.
	 * 
	 * Once every element of the list has been counted and entered into the hashmap, it then moves on and iterates through the hashmap assigning the temp variable to the hashmap value at the i'th index. It then checks if the temp value is greater than the greatest variable (which
	 * starts with a value of 0). If temp is greater than the greatest variable, then greatest is reassigned the value of temp and the index variable is assigned the value of the loop counter (i). Once it iterates through the whole hashmap, the greatest value from the map should be
	 * stored in the greatest variable with its corresponding index stored in the index variable.
	 * 
	 * Next, using the index of the greatest map value, that value is removed from the hashmap. It then checks if the hashmap still contains the value of the greatest variable or if the value of the greatest variable is less than or equal to 1. If the hashmap still contains the value 
	 * of the greatest variable, then that must mean there were multiple modes in which the mode value to be returned should be null. In the other case of the greatest variable having a value of less than or equal to 1, this indicates that there was actually no mode in which the mode 
	 * value to be returned should also be null. Finally, the only other possible case in which the hashmap does not still contain the value of the greatest variable and it is greater than 1, there must be a mode in which the value to be returned is assigned by retrieving the list value 
	 * using the index value of the greatest variable. The mode is then returned.
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
	/*
	 * Combination; takes two integers n and r as parameters. Starts by declaring a BigInteger variable for the result. Next, applies the combination formula by taking the factorial of (n - r) and multiplying it by the factorial of r, then divides the factorial
	 * of n by that product. The result is then returned.
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
	/*
	 * Permutation; takes two integers n and r as parameters. Starts by declaring a BigInteger variable for the result. Next, applies the permutation formula by taking the factorial of (n - r) and dividing the factorial of n by that result.
	 * The result is then returned.
	 */
	public BigInteger permutation(int n, int r) {
		BigInteger result;
		
		result = factorial(n).divide(factorial(n - r));
		
		return result;
	}
	/**
	 * 
	 * @param n (An integer; the total number of trials)
	 * @param y (An integer; the number of successes)
	 * @param p (A double; the probability of success for a single trial)
	 * @return probability (A double; the probability distribution of an experiment given n trials and y successes where the outcome of a trial is either a success or a failure (p or q))
	 */
	/*
	 * Binomial Distribution; takes two integers n and y as well as a double p as parameters. Starts by declaring a double for probability and defining the probability of failure for a single trials by taking the complement of p (the probability of success). Next, declares a double for
	 * the combination of n and y and assigns this value by calling the combination function using n and y as parameters. It then applies the binomial distribution formula by raising the probability of failure to the power of n - y, raising the probability of success to the power of y, 
	 * and then multiplying those two results together followed by multiplying that product by the combination of n and y. The probability is then returned.
	 */
	public double binomialDistribution(int n, int y, double p) {
		double probability;
		//q is the probability of failure for a single trial
		double q = 1 - p;
		double comb = combination(n, y).doubleValue();

		probability = comb * (Math.pow(p,  y)) * (Math.pow(q,  (n - y)));
		
		return probability;
	}
	/**
	 * 
	 * @param n (An integer; the number of trials needed for the first success)
	 * @param p (A double; the probability of success for a single trial)
	 * @return probability (A double; the probability of success (p) on the nth trial)
	 */
	/*
	 * Geometric Distribution; takes an integer n and a double p as parameters. Starts by declaring a double for probability and defining the probability of failure for a single trial by taking the complement of p (the probability of success). Next, applies the
	 * geometric distribution formula by raising the probability of failure to the power of n - 1 and then multiplying that result by the probability of success. The probability is then returned.  
	 */
	public double geometricDistribution(int n, double p) {
		double probability;
		//q is the probability of failure for a single trial
		double q = 1 - p;
		
		probability = (Math.pow(q, n-1)) * p;
		
		return probability;
	}
	/**
	 * 
	 * @param n (An integer; the total number of items (population))
	 * @param m (An integer; the number of items chosen as a sample)
	 * @param r (An integer; the total number of success states)
	 * @param y (An integer; the number of observed success states)
	 * @return probability (A double; the probability of y successes in m items chosen given a population n that contains r success states)
	 */
	public double hypergeometricDistribution(int n, int m, int r, int y) {
		double probability;
		
		probability = (combination(r, y).multiply(combination(n - r, m - y))).doubleValue() / (combination(n, m).doubleValue());
		
		return probability;
	}
	/**
	 * 
	 * @param lambda (An integer; the average number of events in a time interval)
	 * @param y (An integer; the number of occurrences of the event)
	 * @return probability (A double; the probability of y events occurring in a given time interval if the desired event occurs at an average rate that stays constant) 
	 */
	public double poissonDistribution(int lambda, int y) {
		double probability;
		
		double negativeLambda = lambda * -1;
		probability = (Math.pow(lambda, y) / factorial(y).doubleValue()) * (Math.exp(negativeLambda));
		
		return probability;
	}
	
	public double chebyshev(double lowerRange, double upperRange, double mean, double standardDeviation) {
		double percentage;
		double k = (upperRange - mean) / standardDeviation;
		percentage = 1 - (1 / (k*k));
		
		return percentage;
	}
}
