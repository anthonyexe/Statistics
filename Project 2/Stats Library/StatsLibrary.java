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
	 * @param n (An integer; the total number of items (population))
	 * @param m (An integer; the number of items chosen as a sample)
	 * @param r (An integer; the total number of success states)
	 * @param y (An integer; the number of observed success states)
	 * @return probability (A double; the probability of y successes in m items chosen given a population n that contains r success states)
	 */
	public double hypergeometricDistribution(int n, int m, int r, int y) {
		double probability;
		/*The probability is equal to the combinations of the number of success states and the number of observed success states multiplied
		 * by the combinations of the population minus the number of success states and the sample size minus the number of observed success
		 * states all divided by the combinations of the population and the sample size
		*/
		probability = (combination(r, y).multiply(combination(n - r, m - y))).doubleValue() / (combination(n, m).doubleValue());
		
		return probability;
	}
	
	/**
	 * 
	 * @param n (An integer; the total number of items(population))
	 * @param r (An integer; the total number of success states)
	 * @param m (An integer; the number of items chosen as a sample)
	 * @return expected (A double; the expected number of successes in m items given a population that contains r success state)
	 */
	public double hypergeometricExpected(int n, int r, int m) {
		double expected;
		//Store n as a double
		double population = n;
		
		//The expected value is the product of the sample size and the number of success states all divided by the population
		expected = (m*r) / population;
		
		return expected;
	}
	
	/**
	 * 
	 * @param n (An integer; the total number of items(population))
	 * @param r (An integer; the total number of success states)
	 * @param m (An integer; the number of items chosen as a sample)
	 * @return variance (A double; the average squared deviations from the mean in m items given a population that contains r success states)
	 */
	public double hypergeometricVariance(int n, int r, int m) {
		double variance;
		//Store n as a double
		double population = n;
		
		/*The variance is equal to the sample size multiplied by the number of success states divided by the population which is then multiplied by 
		 * the difference of the population and the number of success states divided by the population which is then multiplied by the difference of
		 * the population and the sample size divided by one less than the population
		*/
		variance = (m * (r / population) * ((population-r) / population) * ((population - m) / (population - 1)));
		
		return variance;
	}
	
	/**
	 * 
	 * @param n (An integer; the total number of items(population))
	 * @param r (An integer; the total number of success states)
	 * @param m (An integer; the number of items chosen as a sample)
	 * @return standardDeviation (A double; the dispersion of values relative to the mean in m items given a population that contains r success states)
	 */
	public double hypergeometricStandardDeviation(int n, int r, int m) {
		//Simply take the square root of the variance using the hypergeometric variance method
		double standardDeviation = Math.sqrt(hypergeometricVariance(n, r, m));
		
		return standardDeviation;
	}
	
	/**
	 * 
	 * @param lambda (An integer; the average number of events in a time interval)
	 * @param y (An integer; the number of occurrences of the event)
	 * @return probability (A double; the probability of y events occurring in a given time interval if the desired event occurs at an average rate that stays constant) 
	 */
	public double poissonDistribution(int lambda, int y) {
		double probability;
		//Store negative lambda as a double
		double negativeLambda = lambda * -1;
		
		//The probability is equal to lambda raised to the power of y divided by y! all multiplied by e (Euler's number) raised to the power of negative lambda
		probability = (Math.pow(lambda, y) / factorial(y).doubleValue()) * (Math.exp(negativeLambda));
		
		return probability;
	}
	
	/**
	 * 
	 * @param lambda (An integer; the average number of events in a time interval)
	 * @return lambda (An integer; the expected value and variance of a Poisson distribution is equal to lambda so it is simply returned back)
	 */
	public int poissonExpectedAndVariance(int lambda) {
		return lambda;
	}
	
	/**
	 * 
	 * @param lamda (An integer; the average number of events in a time interval)
	 * @return standardDeviation (A double; the dispersion of values relative to the mean (lambda))
	 */
	public double poissonStandardDeviation(int lamda) {
		//The standard deviation is simply the square root of the average (lambda)
		double standardDeviation = Math.sqrt(lamda);
		
		return standardDeviation;
	}
	
	/**
	 * 
	 * @param lowerRange (A double; the lower range for a specified interval)
	 * @param upperRange (A double; the upper range for a specified interval)
	 * @param mean (A double; the average or expected value in a given distribution)
	 * @param standardDeviation (A double; the dispersion of values relative to the mean in a given distribution)
	 * @return percentage (A double; the percentage of values between the specified interval given the mean and standard deviation)
	 */
	public double chebyshev(double lowerRange, double upperRange, double mean, double standardDeviation) {
		double percentage;
		//Find k by dividing the difference of the upper bound for a specified interval and the mean by the standard deviation
		double k = (upperRange - mean) / standardDeviation;
		
		//The percentage of values between the specified interval is equal to 1 - (1 divided by k squared)
		percentage = 1 - (1 / (k*k));
		
		return percentage;
	}
	
	/**
	 * 
	 * @param lowerRange (A double; the lower range for a specified interval)
	 * @param upperRange (A double; the upper range for a specified interval)
	 * @param mean (A double; the average or expected value in a given distribution)
	 * @param variance (A double; the average squared deviations from the mean in a given distribution)
	 * @return percentage (A double; the percentage of values between the specified interval given the mean and variance)
	 */
	public double chebyshevGivenVariance(double lowerRange, double upperRange, double mean, double variance) {
		double percentage;
		//Find the standard deviation by simply taking the square root of the variance
		double standardDeviation = Math.sqrt(variance);
		//Find k by dividing the difference of the upper bound for a specified interval and the mean by the standard deviation
		double k = (upperRange - mean) / standardDeviation;
		
		//The percentage of values between the specified interval is equal to 1 - (1 divided by k squared)
		percentage = 1 - (1 / (k*k));
		
		return percentage;
	}
	
	/**
	 * 
	 * @param a (An integer; the lower bound for a specified interval)
	 * @param b (An integer; the upper bound for a specified interval)
	 * @param c (An integer; the lower bound for the total interval)
	 * @param d (An integer; the upper bound for the total interval)
	 * @return probability (A double; the probability of an event occurring in a specified interval given a larger total interval)
	 */
	public double uniformDistribution(int a, int b, int c, int d) {
		double probability;
		//Store d as a double
		double intervalUpperBound = d;
		
		/*The probability is equal to the difference of the upper bound and lower bound of the specified interval divided by the 
		 difference of the upper bound and lower bound of the total interval
		*/
		probability = (b - a) / (intervalUpperBound - c);
		
		return probability;
	}
	
	/**
	 * 
	 * @param c (An integer; the lower bound for the total interval)
	 * @param d (An integer; the upper bound for the total interval)
	 * @return expected (A double; the expected value in a given total interval (usually the midway point))
	 */
	public double uniformExpectedValue(int c, int d) {
		double expected;
		//Store d as a double
		double intervalUpperBound = d;
		
		//The expected value is equal to the sum of the interval upper bound and lower bound all divided by 2
		expected = (intervalUpperBound + c) / 2;
		
		return expected;
	}
	
	/**
	 * 
	 * @param c (An integer; the lower bound for the total interval)
	 * @param d (An integer; the upper bound for the total interval)
	 * @return variance (A double; the average squared deviations from the mean given a total interval)
	 */
	public double uniformVariance(int c, int d) {
		double variance;
		//Store d as a double
		double intervalUpperBound = d;
		
		//The variance is equal to the square of the difference of the interval upper bound and lower bound all divided by 12
		variance = ((intervalUpperBound - c)*(intervalUpperBound - c)) / 12;
		
		return variance;
	}
	
	/**
	 * 
	 * @param c (An integer; the lower bound for the total interval)
	 * @param d (An integer; the upper bound for the total interval)
	 * @return standardDeviation (A double; the dispersion of values relative to the mean in a given total interval)
	 */
	public double uniformStandardDeviation(int c, int d) {
		//Simply take the square root of the variance using the uniformVariance method
		double standardDeviation = Math.sqrt(uniformVariance(c, d));
		
		return standardDeviation;
	}
}
