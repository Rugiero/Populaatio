/*
 * Luokalla piirretään faasidiagrammi, eli graafi missä aika on redusoitu pois. Luokalle odotetaan parametriksi ArrayList joka sisältää kolme
 * taulukkoa, joista ensimmäinen jätetään (vastaa a aikaa t) huomioimatta.
 * 
 */
package Graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author iangervu
 */
public class PiirraFaasikayra extends JFrame {

    private String otsikko;
    private String x;
    private String y;
    private ArrayList<double[]> tulokset;
    


    public PiirraFaasikayra(String otsikko, String x, String y, ArrayList<double[]> tulokset) {
        super("Populaatio");
        this.tulokset = tulokset;
        this.x = x;
        this.y = y;
        this.otsikko = otsikko;

    }

    public void PiirretaankayraFaasi() {

        JPanel chartPanel = createChartPanelFaasi();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    /**
     * Metodilla luodaan faasidiagrammi (x,y) annetuista taulukoista.
     */
    private XYDataset createDatasetFaasi() {
        boolean autoSort = false;

        XYSeriesCollection dataset = new XYSeriesCollection();
        int j = 0;

        XYSeries series = new XYSeries(j, autoSort);
        for (int i = 0; i < tulokset.get(1).length; i++) {
            series.add(tulokset.get(1)[i], tulokset.get(2)[i]);

        }
        dataset.addSeries(series);
        return dataset;

    }

    public JPanel createChartPanelFaasi() {
        boolean showLegend = true;
        boolean createURL = true;
        boolean createTooltip = true;
        String chartTitle = otsikko;
        String xAxisLabel = x;
        String yAxisLabel = y;

        XYDataset dataset = createDatasetFaasi();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset,
                PlotOrientation.HORIZONTAL, showLegend, createTooltip, createURL);

        return new ChartPanel(chart);

    }

}
