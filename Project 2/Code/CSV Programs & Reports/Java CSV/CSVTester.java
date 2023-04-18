//Anthony D'Alessandro
public class CSVTester {
	public static void main(String[] args) {
		CSV commas = new CSV();
		
		commas.plotter("xyValues", 1, 500, 0.5);
		commas.salter("xyValues.csv", 0, 100000);
		commas.smoother("saltedxyValues.csv", 25);
	}
}
