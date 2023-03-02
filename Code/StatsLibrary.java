import java.util.*;
import java.lang.Math;
import java.math.BigInteger;

public class StatsLibrary {
	public void StatsLibrary() {
		
	}
	//Mean (GOOD)
	public double mean(ArrayList<Integer> list) {
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		avg = sum / list.size();
		return avg;
	}
	//Median (GOOD)
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
	
	//Mode (GOOD)
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
	//Standard Deviation (GOOD)
	public double standardDeviation(ArrayList<Integer> list) {
		double sum = 0;
		double standardDeviation = 0;
		StatsLibrary lib = new StatsLibrary();
		double avg = lib.mean(list);
		
		for (int i = 0; i < list.size(); i++) {
			sum += Math.pow((list.get(i) - avg), 2);
		}
		standardDeviation = Math.sqrt((sum/list.size()));
		return standardDeviation;
	}
	//Complement (GOOD)
	public ArrayList<Integer> complement(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) 
				list2.remove(list1.get(i));
		}
		return list2;
	}
	//Intersection (GOOD)
	public ArrayList<Integer> intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> unionList = new ArrayList<Integer>();
		
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i)))
				unionList.add(list1.get(i));
		}
		
		return unionList;
	}
	//Union (GOOD)
	public ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i)))
				list2.add(list1.get(i));
		}
		
		return list2;
	}
	//Factorial (GOOD)
	public BigInteger factorial(int x) {
		BigInteger result = BigInteger.valueOf(x);
		
		for (int i = 1; i < x; i++)
			result = result.multiply(BigInteger.valueOf(i));
		
		return result;
	}
	//Combination (GOOD)
	public BigInteger combination(int n, int r) {
		BigInteger result;
		
		result = (factorial(n)).divide((factorial(r).multiply(factorial(n - r))));
		
		return result;
	}
	//Permutation (GOOD)
	public BigInteger permutation(int n, int r) {
		BigInteger result;
		
		result = factorial(n).divide(factorial(n - r));
		
		return result;
	}
	//Binomial Distribution (GOOD)
	public double binomialDistribution(int n, int y, double p) {
		double probability;
		double q = 1 - p;
		double comb = combination(n, y).doubleValue();

		probability = comb * (Math.pow(p,  y)) * (Math.pow(q,  (n - y)));
		
		return probability;
	}
	//Geometric Distribution (GOOD)
	public double geometricDistribution(int n, double p) {
		double probability;
		double q = 1 - p;
		
		probability = (Math.pow(q, n-1)) * p;
		
		return probability;
	}
}