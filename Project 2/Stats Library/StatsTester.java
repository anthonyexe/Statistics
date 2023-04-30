import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class StatsTester {
	public static void main(String[] args) {
		StatsLibrary lib = new StatsLibrary();
		BirthdayProblem people = new BirthdayProblem();
		MontyHall monty = new MontyHall();
		CSV commas = new CSV();
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> testList2 = new ArrayList<Integer>();
		ArrayList<Integer> testList3 = new ArrayList<Integer>();
		ArrayList<Integer> testList4 = new ArrayList<Integer>();
		ArrayList<Integer> testList5 = new ArrayList<Integer>();
		ArrayList<Integer> universalList = new ArrayList<Integer>();
		/*
		testList.add(1);
		testList.add(5);
		testList.add(3);
		testList.add(4);
		testList.add(7);
		testList.add(8);
		
		testList2.add(1);
		testList2.add(1);
		testList2.add(5);
		testList2.add(3);
		testList2.add(4);
		testList2.add(7);
		testList2.add(8);
		
		testList3.add(1);
		testList3.add(3);
		testList3.add(3);
		testList3.add(5);
		testList3.add(5);
		
		testList4.add(1);
		testList4.add(3);
		testList4.add(5);
		
		testList5.add(9);
		testList5.add(10);
		testList5.add(11);
		
		for (int i = 1; i <= 10; i++) {
			universalList.add(i);
		}
		
		System.out.println("Mean: " + lib.mean(testList));
		System.out.println("Median: " + lib.median(testList));
		System.out.println("Mode: " + lib.mode(testList));
		System.out.println("Mode: " + lib.mode(testList2));
		System.out.println("Mode: " + lib.mode(testList3));
		
		System.out.println("Standard Deviation: " + lib.standardDeviation(testList));
		System.out.println("Complement of List 1 Given Universal List: " + lib.complement(testList, universalList));
		
		
		System.out.println("Intersection of List 1 and List 2: " + lib.intersection(testList, testList4));
		System.out.println("Union of List 1 and List 2: " + lib.union(testList, testList5));
		System.out.println("Factorial of 12: " + lib.factorial(12));
		
		System.out.println("Permutation of 7 and 2: " + lib.permutation(7, 2));
		System.out.println("Combination of 7 and 2: " + lib.combination(7, 2));
		
		System.out.println("Binomial Distribution given p = 0.80, q = 0.20, n = 10, and y = 7: " + lib.binomialDistribution(10, 7, 0.80));
		System.out.println("Geometric Distribution given p = 0.04, q = 0.96, n = 6: " + lib.geometricDistribution(6, 0.04));
		
		System.out.println("Enter number of people: ");
		int numPeople = scan.nextInt();
		
		System.out.println("List of birthdays: " + people.stringBirthdays(numPeople));
		System.out.println("Probability of Sharing a Birthday Given a Sample Size of " +numPeople + " People: " + people.birthdayProblem(100, numPeople));
		
		
		System.out.println("List of birthdays2: " + people.intBirthdays(numPeople));
		System.out.println("Probability of Sharing a Birthday Given a Sample Size of " + numPeople + " People: " + people.birthdayProblem2(100, numPeople));
		
		System.out.println("Monty Hall: Probability of winning with no Change: " + monty.noChange(10000));
		System.out.println("Monty Hall: Probability of winning with change: " + monty.withChange(10000));
		*/

		//System.out.println("Hypergeometric Distribution given n = 20, m = 5, r = 6, and y = 4: " + lib.hypergeometricDistribution(20, 5, 6, 4));
		//System.out.println("Poisson Distribution given lambda = 1 and y = 1: " + lib.poissonDistribution(1, 1));
		//commas.plotter("xyValues", 1, 500, 0.5);
		//commas.salter("xyValues.csv", 0, 100000);
		//commas.smoother("smoothedCSV2.csv", 25);
		System.out.printf("Percentage of values between 16 and 24 given a mean of 20 and a standard deviation of 2: %.3f", lib.chebyshev(16, 24, 20, 2));
		System.out.printf("\n\nPercentage of values between 16 and 24 given a mean of 20 and a variance of 4: %.3f", lib.chebyshevGivenVariance(16, 24, 20, 4));
		
		
		//System.out.printf("Hypergeometric Distribution given y = 2, N = 10, n = 5, r = 4: %.3f", lib.hypergeometricDistribution(10, 5, 4, 2));
		//System.out.printf("\n\nExpected Value of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricExpected(10, 4, 5));
		//System.out.printf("\n\nVariance of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricVariance(10, 4, 5));
		//System.out.printf("\n\nStandard Deviation of Hypergeometric Distribution given N = 10, n = 5, r = 4: %.3f", lib.hypergeometricStandardDeviation(10, 4, 5));
		
		//System.out.printf("\n\nPoisson Distribution given lambda = 2 and y = 4: %.3f", lib.poissonDistribution(2, 4));
		//System.out.println("\n\nExpected Value and Variance of Poisson Distribution given lambda = 2: " + lib.poissonExpectedAndVariance(2));
		//System.out.printf("\n\nStandard Deviation of Poisson Distribution given lambda = 2: %.3f", lib.poissonStandardDeviation(2));
		
		System.out.printf("\n\nUniform Distribution given a = 5, b = 15, c = 0, d = 20: %.3f", lib.uniformDistribution(5, 15, 0, 20));
		System.out.printf("\n\nExpected Value of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformExpectedValue(1, 20));
		System.out.printf("\n\nVariance of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformVariance(1, 20));
		System.out.printf("\n\nStandard Deviation of Uniform Distribution given c = 1, d = 20: %.3f", lib.uniformStandardDeviation(1, 20));
		
	}
}
