package jfreechart;

public class Tester {
	public static void main(String[] args) {
		ApacheJFreeChartCSV test = new ApacheJFreeChartCSV();
		
		test.plotter("xyValues", 1, 50, 0.5);
		
		test.salter("xyValues.csv", 0, 250);
		
		test.smoother("saltedxyValues.csv", 8);
	}
}
