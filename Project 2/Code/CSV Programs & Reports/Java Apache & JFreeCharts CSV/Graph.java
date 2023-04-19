//Anthony D'Alessandro
package jfreechart;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.*;

public class Graph extends ApplicationFrame {
	/*Graph method that takes parameters including an application title, graph title, ArrayList of doubles that hold x values, and 
	an ArrayList of doubles that hold y values
	*/
	public Graph(String appTitle, String graphTitle, ArrayList<Double> xValues, ArrayList<Double> yValues) {
		//Set the application title using the appTitle parameter
		super(appTitle);
		
		//Create a new XYSeries object using the polynomial function as the data label
		XYSeries xy = new XYSeries("X^2 + 2x + 1");
		/*Loop to add x-y pairs to the XYSeries (note: xValues.size() can be interchanged with yValues.size() since they
		have the same length)
		*/
		for (int i = 0; i < xValues.size(); i++) {
			//Add the pair of x-y values at the current index to the XYSeries
			xy.add(xValues.get(i), yValues.get(i));
		}
		//Create a new XYSeriesCollection object
		XYSeriesCollection dataset = new XYSeriesCollection();
		//Add the XYSeries to the XYSeriesCollection
		dataset.addSeries(xy);
		
		/*Create a new XYLineChart using the graphTitle parameter, "x" as the x-axis label, "y" as the y-axis label, and
		the XYSeriesCollection dataset as the source of the data
		*/
		JFreeChart xyValues = ChartFactory.createXYLineChart(graphTitle, "x", "y", dataset);
		
		//Create a new panel object using the XYLineChart xyValues
		ChartPanel panel = new ChartPanel(xyValues);
		//Set the panel size to 500x500 pixels
		panel.setPreferredSize(new java.awt.Dimension(500, 500));;
		//Create a new XYPlot object from the XYLineChart
		XYPlot graph = xyValues.getXYPlot();
		
		//Create a new XYLineAndShapeRenderer object and set it to the XYPlot renderer
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		graph.setRenderer(renderer);
		//Set the content pane using the ChartPanel
		setContentPane(panel);
	}
}
