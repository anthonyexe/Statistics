import java.util.*;
import java.util.HashSet;

public class BirthdayProblem {
	public void Person() {
		
	}
	/**
	 * 
	 * @param n (An integer representing the number of birthdays to generate)
	 * @return birthdays (An ArrayList of Strings representing n random birthdays using the format MM/DD)
	 */
	/*
	 * stringBirthdays; takes an integer n as a parameter. Starts by declaring an ArrayList of Strings to store n random birthdays. Starts by entering a loop with a length of n in which a StringBuilder object is declared to store the random birthday at each instance of the loop.
	 * Next, declares an integer month and assigns it a random value between 1 and 12. An integer day is then declared for future storage of the random day. Next, it checks if the value of month is equal to 2 in which the day variable would be assigned a random value between 1 and 28.
	 * If month is not equal to 2, it then checks if month is equal to 4, 5, 9, or 11 in which the day variable would be assigned a random value between 1 and 30. Finally, if the month is not equal to 2, 4, 6, 9, or 11, then the only other possible values it could have would be either 
	 * 1, 3, 5, 7, 8, 10, or 12 in which the day variable would be assigned a random value between 1 and 31. Once the month and day variables have been assigned appropriate random values, the StringBuilder object then appends the month and day in the format of MM/DD to store that 
	 * random birthday. Next, it then adds that random birthday to the birthdays ArrayList to officially add the random birthday to the list. Once the loop completes n cycles, the ArrayList is filled with n random birthdays and the birthdays ArrayList is then returned. 
	 */
	public ArrayList<String> stringBirthdays(int n) {
		ArrayList<String> birthdays = new ArrayList<String>();
		
		// Help with generating random integers in a specified range from (https://mkyong.com/java/java-generate-random-integers-in-a-range/)
		
		for (int i = 0; i < n; i++) {
			StringBuilder str = new StringBuilder();
			int month = (int)(Math.random() * ((12 - 1) + 1)) + 1;
			int day;
			
			if (month == 2) {
				day = (int)(Math.random() * ((28 - 1) + 1)) + 1;
			}
			
			else if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = (int)(Math.random() * ((30 - 1) + 1)) + 1;
			}
			
			else {
				day = (int)(Math.random() * ((31 - 1) + 1)) + 1;
			}
			
			str.append(month + "/" + day);
			birthdays.add(str.toString());
		}
		
		return birthdays;
	}
	/**
	 * 
	 * @param n (An integer representing the number of birthdays to generate)
	 * @return birthdays2 (An ArrayList of Integers representing n random birthdays using the integer format in which each value is simply an integer in the range of 1 to 365)
	 */
	/*
	 * intBirthdays; takes an integer n as a parameter. Starts by declaring an ArrayList of Integers to store n random birthdays. Starts by entering a loop with a length of n. An integer day is declared and assigned a random value between 1 and 365. That random day value is then added 
	 * to the birthdays ArrayList to officially store the random birthday. Once the loop completes n cycles, the ArrayList is filled with n random birthdays and the birthday ArrayList is then returned.
	 */
	public ArrayList<Integer> intBirthdays(int n) {
		ArrayList<Integer> birthdays2 = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			 int day = (int)(Math.random() * ((365 -1) + 1)) + 1;
			 birthdays2.add(day);
		}
		
		return birthdays2;
	}
	/**
	 * 
	 * @param n (An integer representing the number of times to run the experiment)
	 * @param m (An integer representing the number of random birthdays to be generated)
	 * @return probability (A double representing the probability of two people sharing a birthday given m random birthdays ran n times)
	 */
	/*
	 * birthdayProblem; takes integers n and m as parameters. Starts by declaring doubles count and probability. Next, enters a loop with a length of n and declares an empty HashSet with a type of String and an ArrayList of Strings with m random birthdays by calling the stringBirthdays method.
	 * Inside the outer loop, it then enters an inner loop with a length of the size of the birthday list. Inside the inner loop it simply adds every element from the birthday list to the HashSet.
	 * It then checks if the HashSet size is less than the birthday list size in which the count variable is incremented given that conditional statement is true. If the HashSet size is less than the birthday list size, this implies that there was a duplicate (shared birthday)
	 * in the birthday list since HashSets cannot contain duplicates. Once the outer loop is finished, the probability variable is assigned by dividing the value of count by n (the number of runs for the experiment). The probability is then returned.
	 */
	public double birthdayProblem(int n, int m) {
		double count = 0;
		double probability;
		
		for (int i = 0; i < n; i++) {
			HashSet<String> dupeSet = new HashSet<String>();
			ArrayList<String> birthdayList = stringBirthdays(m);
			
			for (int j = 0; j < birthdayList.size(); j++) {
				dupeSet.add(birthdayList.get(j));
			}
			
			if (dupeSet.size() < birthdayList.size()) {
				count++;
			}
		}
		probability = count / n;
		return probability;
	}
	/**
	 * 
	 * @param n (An integer representing the number of times to run the experiment)
	 * @param m (An integer representing the number of random birthdays to be generated)
	 * @return probability (A double representing the probability of two people sharing a birthday given m random birthdays ran n times)
	 */
	/*
	 * birthdayProblem2 (Same process as birthdayProblem method above but accomplishes this using the Integer birthday format); takes integers n and m as parameters. Starts by declaring doubles count and probability. Next, enters a loop with a length of n and declares an empty 
	 * HashSet with a type of Integer and an ArrayList of Integers with m random birthday by calling the intBirthdays method. Inside the outer loop, it then enters an inner loop with a length of the size of the birthday list. Inside the inner loop it adds every element from the birthday list 
	 * to the HashSet. It then checks if the HashSet size is less than the birthday list size in which the count variable is incremented given that conditional statement is true. If the HashSet size is less than the birthday list size, this implies that there was a duplicate (shared birthday) 
	 * in the birthday list since HashSets cannot contain duplicates. Once the outer loop is finished, the probability variable is assigned by dividing the value of count by n (the number of runs for the experiment). THe probability is then returned.
	 */
	public double birthdayProblem2(int n, int m) {
		double count = 0;
		double probability;
		
		for (int i = 0; i <n; i++) {
			HashSet<Integer> dupeSet = new HashSet<Integer>();
			ArrayList<Integer> birthdayList = intBirthdays(m);
			
			for (int j = 0; j < birthdayList.size(); j++) {
				dupeSet.add(birthdayList.get(j));
			}
			
			if (dupeSet.size() < birthdayList.size()) {
				count++;
			}
		}
		probability = count / n;
		return probability;
	}
}