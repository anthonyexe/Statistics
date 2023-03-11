import java.util.*;


public class MontyHall {
	/**
	 * 
	 * @param n (An integer representing the number of times to run the experiment)
	 * @return probability (A double representing the probability of winning the door game if the user does not change their guess)
	 */
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
	
	/**
	 * 
	 * @param n (An integer representing the number of times to run the experiment)
	 * @return probability (A double representing the probability of winning the door game if the user changes their guess)
	 */
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
