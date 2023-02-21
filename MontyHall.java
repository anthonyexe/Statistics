import java.util.*;


public class MontyHall {

	public double noChange(int n) {
		Random rand = new Random();
		double count = 0;
		double probability;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> scenario = new ArrayList<Integer>();
			Collections.addAll(scenario, 2, 2, 2);
			int carIndex = rand.nextInt(3);
			scenario.set(carIndex, 1);
			
			int guess = rand.nextInt(3);
			/*
			if (carIndex == 0) {
				scenario.remove((int)(Math.random() * 2 + 1));
			}
			else if (carIndex == 1) {
				int randomDecision = rand.nextInt(2);
				if (randomDecision == 0)
					scenario.remove(0);
				else
					scenario.remove(2);
			}
			else
				scenario.remove(rand.nextInt(2));
			*/
			if (carIndex == guess)
				count++;
		}
		
		probability  = count / n;
		return probability;
	}
	
	public double withChange(int n) {
		Random rand = new Random();
		double count = 0;
		double probability;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> scenario = new ArrayList<Integer>();
			Collections.addAll(scenario, 2, 2, 2);
			int carIndex = rand.nextInt(3);
			scenario.set(carIndex, 1);
			
			int guess = rand.nextInt(3);
			
			if (carIndex == 0) {
				scenario.remove((int)(Math.random() * 2 + 1));
			}
			else if (carIndex == 1) {
				int randomDecision = rand.nextInt(2);
				if (randomDecision == 0)
					scenario.remove(0);
				else
					scenario.remove(2);
			}
			else
				scenario.remove(rand.nextInt(2));
			
			//if (carIndex == guess)
				//count++;
		}
		
		probability  = count / n;
		return probability;
	}
}
