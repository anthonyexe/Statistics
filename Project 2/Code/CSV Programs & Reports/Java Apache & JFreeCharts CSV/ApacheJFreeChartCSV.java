//Anthony D'Alessandro
package jfreechart;
import org.apache.commons.math4.*;
import org.apache.commons.math4.legacy.analysis.UnivariateFunction;
import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math4.legacy.util.*;
import org.apache.commons.math4.legacy.random.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;


public class ApacheJFreeChartCSV {
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
		
		//Create new ArrayLists of Doubles to hold y-values and x-values respectively
		ArrayList<Double> yValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		
		//Create a new double array to represent the polynomial function
		double[] plotFunction = new double[] {1, 2, 1};
		//Create a new PolynomialFunction object from the Apache library using the double array to represent the function (x^2 + 2x + 1)
		PolynomialFunction poly = new PolynomialFunction(plotFunction);
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
				/*If counter is less than or equal to min, declare and assign y the value after using the PolynomialFunction 
				value method to evaluate the function with min as the x value. Then, write the min value and y value to the 
				CSV file separating them with a comma and move to the next row. Finally, add the y value to the ArrayList
				of y-values.
				*/
				if (!(counter > min)) {
					double y = poly.value(min);
					fWriter.write(min + "," + y);
					fWriter.write(System.lineSeparator());
					yValues.add(y);
				}
				/*If counter + interval is less than or equal to the maximum x value, declare and assign y the value after 
				using the PolynomialFunction value method to evaluate the function with the current x value. Then write the
				x value and y value to the CSV file separating them with a comma and move to the next row. Finally, add the 
				y value to the ArrayList of y-values.
				*/
				if (counter + interval <= max) {
					double y = poly.value(x);
					fWriter.write(x + "," + y);
					fWriter.write(System.lineSeparator());
					x += interval;
					yValues.add(y);
				}
				/*Since each counter value represents the x values from min up to max, counter can simply be added to the 
				ArrayList of x-values
				*/
				xValues.add(counter);
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
		/*Create a new Graph object passing "Plotter" as the application name, a string with the population size and the increment 
		value as the graph title, the ArrayList of x-values as the x-axis dataset, and the ArrayList of y-values as the y-axis dataset
		*/
		Graph plot = new Graph("Plotter", "Population Size of " + max + " with an Increment of " + interval, xValues, yValues);
		//Pack the Graph to size it to the preferred size
		plot.pack();
		//Set the Graph visibility to true so it shows the component
		plot.setVisible(true);
	}
	
	/*Salter function that takes a file name, a minimum salt value for the range of the salting value, and a maximum salt value
	for the range of the salting value as parameters
	*/
	public void salter(String fileName, int saltRangeMin, int saltRangeMax) {
		//Create a new ArrayList of Strings to hold the values from the plotter CSV file
		ArrayList<String> xyValues = new ArrayList<String>();
		//Create new ArrayLists of Doubles to hold y-values and x-values respectively
		ArrayList<Double> yValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		//Create a new File object with 'salted' added to the beginning of the file name
		File saltedCSV = new File("salted" + fileName);
		//Create a new random object to generate random numbers
		Random rand  = new Random();
		
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
				/*Skip the first line (header) then store the values from each line, splitting them by 
				commas, to a String array. Next, add the values from the String array to the ArrayList
				of Strings so by the end of the loop, the ArrayList contains all x values and y values
				from the file.
				*/
				if (count > 0) {
					String[] lineValues = nextLine.split(",");
					xyValues.addAll(Arrays.asList(lineValues));
				}
			//Close the BufferedReader which also closes the FileReader
			} bReader.close();
		//Catch any FileNotFoundExceptions and print the stack trace
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//Catch any IOExceptions and print the stack trace
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Loop for salting the y values that were read from the file
		for (int i = 0; i < xyValues.size(); i++) {
			/*If the counter is even (equivalent to the index of the x-values in the first column of the CSV file), then
			add the value from the ArrayList of x and y values to the ArrayList of x-values. Since the ArrayList of x and y
			values stores the values in a String format, Double.parseDouble is used to convert the values to Doubles and then
			store them in the ArrayList of x-values.
			*/
			if (i % 2 == 0)
				xValues.add(Double.parseDouble(xyValues.get(i)));
			/*If the counter is odd (equivalent to the index of the values in the second column of the CSV file),
			then salt the value at that index in the ArrayList of x and y values.
			*/
			if (i % 2 == 1) {.
				//Create a saltValue variable to hold the random salt value in the range of saltRangeMin to saltRangeMax
				double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
				//Create a random boolean value to choose whether to add or subtract the salt value
				boolean decision = rand.nextBoolean();
				//Create a temp variable to hold the value at the current index in the ArrayList of x and y values
				Double temp = Double.parseDouble(xyValues.get(i));
				//If the random boolean value is true, add the salt value to the current value
				if (decision)
					temp += saltValue;
				//If the random boolean value is false, subtract the value from the current value
				else
					temp -= saltValue;
				/*Add the temp value to the list of salted y-values. The y-value has already been converted to a Double and 
				stored in the temp variable so temp is simply used to add the value to the list.
				*/
				yValues.add(temp);
				//Update the value at the current index to be the salted y value
				xyValues.set(i, temp.toString());
			}
		}
		
		try {
			//Create a new FileWriter instance using the saltedCSV File object
			FileWriter fWriter = new FileWriter(saltedCSV);
			//Loop through the x and y values
			for (int i = 0; i < xyValues.size(); i++) {
				//Write the current value to the file and separate it by a comma
				fWriter.write(xyValues.get(i) + ",");
				//Move to the next line after each pair of x and y values are written to the file
				if (i % 2 == 0)
					fWriter.write(System.lineSeparator());
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
		
		/*Create a new Graph object passing "Salter" as the application name, a string describing the salting range as the graph title, 
		the ArrayList of x-values as the x-axis dataset, and the ArrayList of salted y-values as the y-axis dataset
		*/
		Graph plot = new Graph("Salter", "Salted Data With a Salt Range of [" + saltRangeMin + ", " + saltRangeMax + "]", xValues, yValues);
		//Pack the Graph to size it to the preferred size
		plot.pack();
		//Set the Graph visibility to true so it shows the component
		plot.setVisible(true);
	}
	
	//Smoother function that takes a file name and a window value for the smoothing window as parameters
	public void smoother(String fileName, int windowValue) {
		//Create a new DescriptiveStatistics object
		DescriptiveStatistics stats = new DescriptiveStatistics();
		//Create a new ArrayList of Strings to hold the values from the salted data CSV file
		ArrayList<String> xyValues = new ArrayList<String>();
		//Create new ArrayLists of Doubles to hold y-values and x-values respectively
		ArrayList<Double> doubleYValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		//Create a new File object using "smoothedCSV.csv" as the file name
		File smoothedCSV = new File("smoothedCSV.csv");
		
		try {
			//Create a new FileReader instance using the file name parameter
			FileReader fReader = new FileReader(fileName);
			//Create a new BufferedReader instance using the FileReader object
			BufferedReader bReader = new BufferedReader(fReader);
			
			//Create a nextLine String to hold each line while reading from the file
			String nextLine;
			
			/*Loop for reading the file where nextLine is assigned the next available line during each pass
			and terminates once nextLine is null (the end of the file has been reached)
			*/
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine()) {
				/*Store the values from each line, splitting them by commas, to a String array. Next, 
				add the values from the String array to the ArrayList of Strings so by the end of the 
				loop, the ArrayList contains all x values and y values from the file.
				*/
				String[] lineValues = nextLine.split(",");
				xyValues.addAll(Arrays.asList(lineValues));
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
		
		//Set the window size using the windowValue parameter for the DescriptiveStatistics object
		stats.setWindowSize(windowValue);
		
		//Loop for smoothing the y values that were read from the file
		for (int i = 0; i < xyValues.size(); i++) {
			/*If the counter is even (equivalent to the index of the x-values in the first column of the CSV file), then
			add the value from the ArrayList of x and y values to the ArrayList of x-values. Since the ArrayList of x and y
			values stores the values in a String format, Double.parseDouble is used to convert the values to Doubles and then
			store them in the ArrayList of x-values.
			*/
			if (i % 2 == 0)
				xValues.add(Double.parseDouble(xyValues.get(i)));
			/*If the counter is odd (equivalent to the index of the values in the second column of the CSV file),
			then smooth the values using the window value and the current index in the ArrayList of x and y values.
			*/
			if (i % 2 == 1) {
				//Add the current y-value to the DescriptiveStatistics instance
				stats.addValue(Double.parseDouble(xyValues.get(i)));
				//Declare an average variable and store the rolling mean using the DescriptiveStatistics getMean method
				Double average = stats.getMean();
				/*Add the average value to the ArrayList of smoothed y-values. The y-value has already been converted to a 
				Double and stored in the average variable so average is simply used to add the value to the list.
				*/
				doubleYValues.add(average);
				//Reassign the value at the current index of the x and y values the new smoothed y-value
				xyValues.set(i, average.toString());
			}
		}
		
		try {
			//Create a new FileWriter instance using the smoothedCSV File object
			FileWriter fWriter = new FileWriter(smoothedCSV);
			//Loop through the x and y values
			for (int i = 0; i < xyValues.size(); i++) {
				//Write the current value to the file and separate it by a comma
				fWriter.write(xyValues.get(i) + ",");
				//Move too the next line after each pair of x and y values are written to the file
				if (i % 2 != 0)
					fWriter.write(System.lineSeparator());
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
		
		/*Create a new Graph object passing "Smoother" as the application name, a string describing the smoothed data and the window size
		as the graph title, the ArrayList of x-values as the x-axis dataset, and the ArrayList of smoothed y-values as the y-axis dataset
		*/
		Graph plot = new Graph("Smoother", "Smoothed Data With a Window Size of " + windowValue, xValues, doubleYValues);
		//Pack the Graph to size it to the preferred size
		plot.pack();
		//Set the Graph visibility to true so it shows the component
		plot.setVisible(true);
	}
}
