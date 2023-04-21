//Anthony D'Alessandro
package jfreechart;

public class Tester {
	public static void main(String[] args) {
		//Create a new ApacheJFreeChartsCSV object
		ApacheJFreeChartCSV test = new ApacheJFreeChartCSV();
		
		//Call the plotter method using a minimum x-value of 1, maximum x-value of 50, and an increment value of 0.5
		test.plotter("xyValues", 1, 50, 0.5);
		
		/*Call the salter method using the x and y values generated from the plotter method with a minimum salt value of 0 and
		a maximum salt value of 250
		*/
		test.salter("xyValues.csv", 0, 250);
		
		/*Call the smoother method using the salted x and y values generated from the salter method with a window value of 8
		*/
		test.smoother("saltedxyValues.csv", 8);
	}
}
