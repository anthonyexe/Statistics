import java.io.FileNotFoundException;
import java.io.*;
import java.lang.Math;
import java.util.*;
public class CSV {

	public void plotter(String fileName, int min, int max, double interval) {
		File csvPlot = new File(fileName + ".csv");
		
		String header = ("x, y, y = x^2 + 2x + 1");
		//int rows = (int) (max/interval) - 1;
		try {
			FileWriter fWriter = new FileWriter(csvPlot);
			fWriter.write(header);
			fWriter.write(System.lineSeparator());
			double x = min + interval;
			// for (int count = 1; count < rows; count++) --> Working for loop
			for (int count = 1; count < max; count += interval) {
				if (count == 1) {
					double y = Math.pow(min, 2) + 2 * min + 1;
					fWriter.write(min + "," + y);
					fWriter.write(System.lineSeparator());
				}
				double y = Math.pow(x, 2) + 2 * x + 1;
				fWriter.write(x + "," + y);
				fWriter.write(System.lineSeparator());
				x += interval;
			}
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salter(String fileName, int saltRangeMin, int saltRangeMax) {
		ArrayList<String> yValues = new ArrayList<String>();
		File saltedCSV = new File("salted" + fileName);
		Random rand = new Random();
		
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			
			String nextLine;
			int count = 0;
			
			for (nextLine = bReader.readLine(); nextLine != null; nextLine = bReader.readLine(), count++) {
				if (count > 0) {
					String[] lineValues = nextLine.split(",");
					yValues.addAll(Arrays.asList(lineValues));
				}
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < yValues.size(); i++) {
			if (i % 2 == 1) {
				double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
				boolean decision = rand.nextBoolean();
				Double temp = Double.parseDouble(yValues.get(i));
				if (decision)
					temp += saltValue;
				else
					temp -= saltValue;
				yValues.set(i, temp.toString());
			}
		}
		
		try {
			FileWriter fWriter = new FileWriter(saltedCSV);
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
