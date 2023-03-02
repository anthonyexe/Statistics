import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class StatsTester {
	public static void main(String[] args) {
		StatsLibrary lib = new StatsLibrary();
		BirthdayProblem people = new BirthdayProblem();
		MontyHall monty = new MontyHall();
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> testList2 = new ArrayList<Integer>();
		ArrayList<Integer> testList3 = new ArrayList<Integer>();
		ArrayList<Integer> testList4 = new ArrayList<Integer>();
		ArrayList<Integer> testList5 = new ArrayList<Integer>();
		ArrayList<Integer> universalList = new ArrayList<Integer>();
		
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
	}
}
