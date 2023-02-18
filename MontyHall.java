import java.util.*;

public class MontyHall {

	public double noChange(int n) {
		
		double count = 0;
		double probability;
		
		ArrayList<Integer> scenario1 = new ArrayList<Integer>();
		ArrayList<Integer> scenario2 = new ArrayList<Integer>();
		ArrayList<Integer> scenario3 = new ArrayList<Integer>();
		Collections.addAll(scenario1, 1, 2, 2);
		Collections.addAll(scenario2, 2, 1, 2);
		Collections.addAll(scenario3, 2, 2, 1);
		
		for (int i = 0; i < n; i++) {
			int randomScenario;
			int answer;
			int reveal;
			// 1.) Change random integer generation method
			// 2.) Assign reveal a random integer corresponding to the available '2's' in each scenario
			// 3.) Update if statement(s) to include reveal 
			randomScenario = (int)(Math.random() * ((3 - 1) + 1)) + 1;
			answer = (int)(Math.random() * 3);
			
			switch (randomScenario) {
			case 1:
				if (scenario1.get(answer) == 1)
					count++;
			case 2:
				if (scenario2.get(answer) == 1)
					count++;
			case 3:
				if (scenario3.get(answer) == 1)
					count++;
			}
		}
		probability = count / n;
		return probability;
	}
}
