import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;


public class Plot extends ApplicationFrame {
    double a , b , c;
    double range1,range2;

    public Plot(final String title, double a , double b , double c, double range1, double range2) {
        super(title);
        this.range1 = range1;
        this.range2 = range2;
        this.a = a;
        this.b = b;
        this.c = c;
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Result Equation", "X", "Y", createDataset(a,b,c),
                PlotOrientation.VERTICAL, true, true, false);
        final XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setBaseShapesVisible(true);
        r.setSeriesShape(0, new Rectangle(-6, -6, 12, 12));
        final ChartPanel chartPanel = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        add(chartPanel, BorderLayout.CENTER);


    }

    private XYDataset createDataset(double a, double b, double c) {
        double[] array = {c, b, a};
        Function2D p = new PolynomialFunction2D(array);
        return DatasetUtilities.sampleFunction2D(
                p, range1, range2, 10, "y = " + a + "x² +"+b+"x +"+c);

    }

}