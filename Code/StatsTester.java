import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class StatsTester {
	public static void main(String[] args) {
		StatsLibrary lib = new StatsLibrary();
		SetOperations setOp = new SetOperations();
		Person people = new Person();
		MontyHall monty = new MontyHall();
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> testList2 = new ArrayList<Integer>();
		
		testList.add(1);
		testList.add(5);
		testList.add(3);
		testList.add(4);
		testList.add(7);
		testList.add(8);
		
		testList2.add(1);
		testList2.add(3);
		testList2.add(4);
		testList2.add(10);
		
		System.out.println("Standard Deviation: " + lib.standardDeviation(testList));
		System.out.println("Mode: " + lib.mode(testList));
		
		Collections.sort(testList);
		
		for (int i = 0; i <testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		
		System.out.println("Median: " + lib.median(testList));
		System.out.println("Mode: " + lib.mode(testList));
		
		System.out.println("Intersection of list1 and list2: " + setOp.intersection(testList, testList2));
		System.out.println("List size: " + testList.size());
		
		System.out.println("Union of list1 and list2: " + setOp.union(testList, testList2));
		
		
		System.out.println("Enter number of people: ");
		int numPeople = scan.nextInt();
		System.out.println("List of birthdays: " + people.birthday(numPeople));
		System.out.println("List of birthdays2: " + people.birthday2(numPeople));
		System.out.println("Probability of Sharing a Birthday Given a Sample Size of 30 People: " + people.birthdayProblem2(100, numPeople));
		//System.out.println("Probability of Sharing a Birthday Given a Sample Size of 30 People: " + people.birthdayProblem(50, numPeople));
		ArrayList<Integer> randomInts = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int randomInt = (int)(Math.random() * 3);
			randomInts.add(randomInt);
		}
		
		System.out.println("Random Integers from 0 to 2: " + randomInts);
		
		System.out.println("Monty Hall with no Change: " + monty.noChange(10000));
		System.out.println("Monty Hall With Change: " + monty.withChange(10000));
		System.out.println("Binomial Distribution given p = 0.80, q = 0.20, n = 10, and y = 7: " + lib.binomialDistribution(10, 7, 0.80));
		System.out.println("Geometric Distribution given p = 0.04, q = 0.96, n = 6: " + lib.geometricDistribution(6, 0.04));
		System.out.println("5 Factorial: " + lib.factorial(5));
		System.out.println("Permutation of 5 and 2: " + lib.permutation(5, 2));
	}
}
