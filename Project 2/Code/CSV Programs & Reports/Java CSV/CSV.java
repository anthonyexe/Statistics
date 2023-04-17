import java.io.*;
import java.lang.Math;
import java.util.*;
public class CSV {
	/*Plotter method that takes a file name, minimum value for the range of x, maximum value for the range of x, and an 
	increment/interval value as parameters
	*/
	public void plotter(String fileName, int min, int max, double interval) {
		//Create a new File object with the file name & '.csv' file extension at the end
		File csvPlot = new File(fileName + ".csv");
		
		/*String to represent the header in the CSV file with 'x' as the first column header, 'y' as the second column header, and
		the function of choice 'x^2 + 2x + 1' as the header of the third column
		*/
		String header = ("x, y, y = x^2 + 2x + 1");
		try {
			//Create a new FileWriter instance using the csvPlot File object
			FileWriter fWriter = new FileWriter(csvPlot);
			//Write the header to the file and move to the next row
			fWriter.write(header);
			fWriter.write(System.lineSeparator());
			//Declare and assign x the first value after min using the increment value
			double x = min + interval;
			//Loop from min up to max using the interval to increment the loop counter (represents the range of x values)
			for (double counter = min; counter < max; counter += interval) {
				/*If counter is less than or equal to min, declare and assign y the value after evaluating the polynomial function
				using min as the x value. Then, write the min value and y value to the CSV file separating them with a comma.
				Finally, move to the next row.
				*/
				if (!(counter > min)) {
					double y = Math.pow(min, 2) + 2 * min + 1;
					fWriter.write(min + "," + y);
					fWriter.write(System.lineSeparator());
				}
				/*If counter + interval is less than or equal to the maximum x value, declare and assign y the value after 
				evaluating the polynomial function using the current x value. Then write the x value and y value to the CSV file 
				separating them with a comma. Finally, move to the next row.
				*/
				if (counter + interval <= max) {
					double y = Math.pow(x, 2) + 2 * x + 1;
					fWriter.write(x + "," + y);
					fWriter.write(System.lineSeparator());
					x += interval;
				}
			}
			//Close the FileWriter
			fWriter.close();
		//Catch any FileNotFoundExceptions and print the stack trace
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//Catch any IOExceptions and print the stack trace
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*Salter function that takes a file name, a minimum salt value for the range of the salting value, and a maximum salt value
	for the range of the salting value as parameters
	*/
	public void salter(String fileName, int saltRangeMin, int saltRangeMax) {
		//Create a new ArrayList of Strings to hold the values from the plotter CSV file
		ArrayList<String> yValues = new ArrayList<String>();
		//Create a new File object with 'salted' added to the beginning of the file name
		File saltedCSV = new File("salted" + fileName);
		//Create a new random object to generate random numbers
		Random rand = new Random();
		
		try {
			//Create a new FileReader instance using the file name parameter
			FileReader fReader = new FileReader(fileName);
			//Create a new BufferedReader instance using the FileReader object
			BufferedReader bReader = new BufferedReader(fReader);
			
			//Create a nextLine String to hold each line while reading from the file
			String nextLine;
			//Create a counter for the file reading loop
			int count = 0;
			
			/*Loop for reading the file where nextLine is assigned the next available line during each pass
			and terminates once nextLine is null (the end of the file has been reached)
			*/
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine(), count++) {
				/*Skip the first line (header) then store the values from each line, separating them by 
				commas, to a String array. Next, add the values from the String array to the ArrayList
				of Strings so by the end of the loop, the ArrayList contains all x values and y values
				from the file.
				*/
				if (count > 0) {
					String[] lineValues = nextLine.split(",");
					yValues.addAll(Arrays.asList(lineValues));
				}
			}
			//Close the BufferedReader which also closes the FileReader
			bReader.close();
		//Catch any FileNotFoundExceptions and print the stack trace
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//Catch any IOExceptions and print the stack trace
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Loop for salting the values that were read from the file
		for (int i = 0; i < yValues.size(); i++) {
			/*If the counter is odd (equivalent to the index of the values in the second column of the CSV file),
			then salt the value at that index in the ArrayList of x and y values.
			*/
			if (i % 2 == 1) {
				//Create a saltValue variable to hold the random salt value in the range of saltRangeMin to saltRangeMax
				double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
				//Create a random boolean value to choose whether to add or subtract the salt value
				boolean decision = rand.nextBoolean();
				//Create a temp variable to hold the value at the current index in the ArrayList of x and y values
				Double temp = Double.parseDouble(yValues.get(i));
				//If the random boolean value is true, add the salt value to the current value
				if (decision)
					temp += saltValue;
				//If the random boolean value is false, subtract the value from the current value
				else
					temp -= saltValue;
				//Update the value at the current index to be the salted y value
				yValues.set(i, temp.toString());
			}
		}
		
		try {
			//Create a new FileWriter instance using the saltedCSV File object
			FileWriter fWriter = new FileWriter(saltedCSV);
			//Loop through the x and y values
			for (int i = 0; i < yValues.size(); i++) {
				fWriter.write(yValues.get(i) + ",");
				if (i % 2 != 0)
					fWriter.write(System.lineSeparator());
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void smoother(String fileName, int windowValue) {
		ArrayList<String> yValues = new ArrayList<String>();
		File smoothedCSV = new File("smoothedCSV.csv");
		
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			
			String nextLine;
			int count = 0;
			
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine(), count++) {
				String[] lineValues = nextLine.split(",");
				yValues.addAll(Arrays.asList(lineValues));
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < yValues.size(); i++) {
			if (i % 2 == 1) {
				ArrayList<Double> yRanges = new ArrayList<Double>();
				Double yAverage;
				Double sum = 0.0;
				Double temp = Double.parseDouble(yValues.get(i));
				int surroundingIndex = 0;
				int yValuesMax = yValues.size();
				yRanges.add(temp);
				
				
				for (int j = 1; j <= windowValue; j++) {
					surroundingIndex += 2;
					if (i + surroundingIndex <= yValuesMax) {
						yRanges.add(Double.parseDouble(yValues.get(i + surroundingIndex)));
					}
					
					if (i - surroundingIndex >= 1) {
						yRanges.add(Double.parseDouble(yValues.get(i - surroundingIndex)));
					}
				}
				
				for (int k = 0; k < yRanges.size(); k++) {
					sum += yRanges.get(k);
				}
				
				yAverage = sum / yRanges.size();
				yValues.set(i, yAverage.toString());
			}
		}
		
		try {
			FileWriter fWriter = new FileWriter(smoothedCSV);
			for (int i = 0; i < yValues.size(); i++) {
				fWriter.write(yValues.get(i) + ",");
				if (i % 2 != 0)
					fWriter.write(System.lineSeparator());
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
