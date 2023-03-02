//Anthony D'Alessandro
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
			int reveal;
			int changeGuess;
			
			do
				reveal = rand.nextInt(3);
			while (reveal == 1 || reveal == guess);
			
			do
				changeGuess = rand.nextInt(3);
			while (changeGuess == guess || changeGuess == reveal);
			
			if (changeGuess == scenario.get(carIndex))
				count++;
		}
		
		probability = count / n;
		return probability;
	}
}
