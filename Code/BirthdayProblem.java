import java.util.*;
import java.util.HashSet;

public class BirthdayProblem {
	public void Person() {
		
	}
	// Help with generating random integers in a specified range from (https://mkyong.com/java/java-generate-random-integers-in-a-range/)
	public ArrayList<String> stringBirthdays(int n) {
		ArrayList<String> birthdays = new ArrayList<String>();
		
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
	
	public ArrayList<Integer> intBirthdays(int n) {
		ArrayList<Integer> birthdays2 = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			 int day = (int)(Math.random() * ((365 -1) + 1)) + 1;
			 birthdays2.add(day);
		}
		
		return birthdays2;
	}
	
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