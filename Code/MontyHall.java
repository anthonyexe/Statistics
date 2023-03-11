import java.util.*;
/**
 * 
 * @author Anthony D'Alessandro
 *
 */

public class MontyHall {
	/**
	 * 
	 * @param n (An integer representing the number of times to run the experiment)
	 * @return probability (A double representing the probability of winning the door game if the user does not change their guess)
	 */
	/*
	 * noChange; takes an integer n as a parameter. Starts by declaring a new Random object and two doubles count and probability. Next, enters a loop with a length of n in which an empty scenario ArrayList of Integers is declared. It then adds three 2's to the scenario list 
	 * to represent three doors with no prize. It then declares the carIndex integer and assigns it a random value between 0 and 2. The carIndex variable is then used to set the scenario value at that index to 1, representing the door with the car behind it. Next, a new integer
	 * guess is declared and assigned a random number between 0 and 2 to represent the player's random guess. It then checks if the carIndex variable is equal to the player's guess. If they are equal, the count variable is incremented, otherwise nothing happens. Once the loop
	 * completes n cycles, the probability variable is assigned the value of count divided by n (the number of trials). Probability is then returned.
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
	/*
	 * withChange; takes an integer n as a parameter. Starts by declaring a new Random object and two doubles count and probability. Next, enters a loop with a length of n in which an empty scenario ArrayList of Integers is declared. It then adds three 2's to the scenario list
	 * to represent three doors with no prize. It then declares the carIndex integer and assigns it a random value between 0 and 2. The carIndex variable is then used to set the scenario value at that index to 1, representing the door with the car behind it. Next, a new integer 
	 * guess is declared and assigned a random number between 0 and 2 to represent the player's random guess. Two new integers are also declared, reveal and changeGuess. Next, it enters a do-while loop that assigns a random integer between 0 and 2 to the reveal variable. It 
	 * continues to reassign the reveal variable a random integer between 0 and 2 until it is either equal to 1 or the guess variable. It then continues on to another do-while loop in which the changeGuess variable is assigned a random integer between 0 and 2 until it is either 
	 * equal to the guess variable or the reveal variable. Finally, it checks if the changeGuess variable is equal to the scenario ArrayList value at the index of carIndex. If so, count is incremented. Once the outer loop finishes n iterations, the probability variable is assigned 
	 * the value of count divided by n (the number of trials). Probability is then returned.
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
