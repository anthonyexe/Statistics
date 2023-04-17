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
	public void plotter(String fileName, int min, int max, double interval) {
		File csvPlot = new File(fileName + ".csv");
		String header = ("x, y, y = x^2 + 2x + 1");
		ArrayList<Double> yValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		
		double[] plotFunction = new double[] {1, 2, 1};
		PolynomialFunction poly = new PolynomialFunction(plotFunction);
		try {
			FileWriter fWriter = new FileWriter(csvPlot);
			fWriter.write(header);
			fWriter.write(System.lineSeparator());
			double x = min + interval;
			for (double counter = min; counter < max; counter += interval) {
				if (!(counter > min)) {
					double y = poly.value(min);
					fWriter.write(min + "," + y);
					fWriter.write(System.lineSeparator());
					yValues.add(y);
				}
				if (counter + interval <= max) {
					double y = poly.value(x);
					fWriter.write(x + "," + y);
					fWriter.write(System.lineSeparator());
					x += interval;
					yValues.add(y);
				}
				xValues.add(counter);
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Graph plot = new Graph("Plotter", "Population Size of " + max + " with an Increment of " + interval, xValues, yValues);
		plot.pack();
		plot.setVisible(true);
	}
	
	public void salter(String fileName, int saltRangeMin, int saltRangeMax) {
		ArrayList<String> xyValues = new ArrayList<String>();
		ArrayList<Double> yValues = new ArrayList<Double>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		File saltedCSV = new File("salted" + fileName);
		Random rand  = new Random();
		
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			
			String nextLine;
			int count = 0;
			
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine(), count++) {
				if (count > 0) {
					String[] lineValues = nextLine.split(",");
					xyValues.addAll(Arrays.asList(lineValues));
				}
			} bReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < xyValues.size(); i++) {
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
