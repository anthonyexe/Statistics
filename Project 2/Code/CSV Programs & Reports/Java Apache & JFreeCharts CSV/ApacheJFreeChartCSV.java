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
		
		for (int i = 0; i < xyValues.size(); i++) {
			/*If the counter is even (equivalent to the index of the x-values in the first column of the CSV file), then
			add the value from the ArrayList of x and y values to the ArrayList of x-values. Since the ArrayList of x and y
			values stores the values in a String format, Double.parseDouble is used to conver the values to Doubles and then
			store them in the ArrayList of x-values.
			*/
			if (i % 2 == 0)
				xValues.add(Double.parseDouble(xyValues.get(i)));
			if (i % 2 == 1) {
				double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
				boolean decision = rand.nextBoolean();
				Double temp = Double.parseDouble(xyValues.get(i));
				if (decision)
					temp += saltValue;
				else
					temp -= saltValue;
				yValues.add(temp);
				xyValues.set(i, temp.toString());
			}
		}
		
		try {
			FileWriter fWriter = new FileWriter(saltedCSV);
			for (int i = 0; i < xyValues.size(); i++) {
				fWriter.write(xyValues.get(i) + ",");
				if (i % 2 == 0)
					fWriter.write(System.lineSeparator());
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graph plot = new Graph("Salter", "Salted Data With a Salt Range of [" + saltRangeMin + ", " + saltRangeMax + "]", xValues, yValues);
		plot.pack();
		plot.setVisible(true);
	}
	
	public void smoother(String fileName, int windowValue) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
		ArrayList<String> xyValues = new ArrayList<String>();
		ArrayList<Double> doubleYValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		File smoothedCSV = new File("smoothedCSV3.csv");
		
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			
			String nextLine;
			
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine()) {
				String[] lineValues = nextLine.split(",");
				xyValues.addAll(Arrays.asList(lineValues));
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		stats.setWindowSize(windowValue);
		
		for (int i = 0; i < xyValues.size(); i++) {
			if (i % 2 == 0)
				xValues.add(Double.parseDouble(xyValues.get(i)));
			if (i % 2 == 1) {
				stats.addValue(Double.parseDouble(xyValues.get(i)));
				Double average = stats.getMean();
				doubleYValues.add(average);
				xyValues.set(i, average.toString());
			}
		}
		
		try {
			FileWriter fWriter = new FileWriter(smoothedCSV);
			for (int i = 0; i < xyValues.size(); i++) {
				fWriter.write(xyValues.get(i) + ",");
				if (i % 2 != 0)
					fWriter.write(System.lineSeparator());
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graph plot = new Graph("Smoother", "Smoothed Data Third Run With a Window Size of " + windowValue, xValues, doubleYValues);
		plot.pack();
		plot.setVisible(true);
	}
}
