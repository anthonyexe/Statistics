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
	public Graph(String appTitle, String graphTitle, ArrayList<Double> xValues, ArrayList<Double> yValues) {
		super(appTitle);
		
		XYSeries xy = new XYSeries("X^2 + 2x + 1");
		
		for (int i = 0; i < xValues.size(); i++) {
			xy.add(xValues.get(i), yValues.get(i));
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(xy);
		
		JFreeChart xyValues = ChartFactory.createXYLineChart(graphTitle, "x", "y", dataset);
		
		ChartPanel panel = new ChartPanel(xyValues);
		panel.setPreferredSize(new java.awt.Dimension(500, 500));;
		XYPlot graph = xyValues.getXYPlot();
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		graph.setRenderer(renderer);
		setContentPane(panel);
	}
}
