/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
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

public class PiirraKayra extends JFrame {

    private String otsikko;
    private String x;
    private String y;
    private ArrayList<double[]> tulokset;

    public PiirraKayra(String otsikko, String x, String y, ArrayList<double[]> tulokset) {
        super("Populaatio");
        this.tulokset = tulokset;
        this.x = x;
        this.y = y;
        this.otsikko = otsikko;

       
    }
    public void Piirretaankayra() {
        
         JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    public void PiirretaankayraFaasi() {
        
         JPanel chartPanel = createChartPanelFaasi();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
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
    public JPanel createChartPanel() {
        boolean showLegend = true;
        boolean createURL = true;
        boolean createTooltip = true;
        String chartTitle = otsikko;
        String xAxisLabel = x;
        String yAxisLabel = y;

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset,
                PlotOrientation.HORIZONTAL, showLegend, createTooltip, createURL);

        return new ChartPanel(chart);
    }

    /**
     * Metodilla luodaan diagrammi (x,t) jokaisesta annetusta taulukosta:
     */
    private XYDataset createDataset() {

        boolean autoSort = false;

        XYSeriesCollection dataset = new XYSeriesCollection();
        int j = 0;
        String[] stringi = new String[2];
        stringi[1] = "pedot";
        stringi[0] = "saalikset";
        
        for (double[] tulokset1 : this.tulokset) {
            XYSeries series = new XYSeries(stringi[j], autoSort);
            for (int i = 0; i < tulokset1.length; i++) {
                series.add(tulokset1[i], i);
            }
            j++;
            dataset.addSeries(series);

        }

        return dataset;
    }

    /**
     * Metodilla luodaan faasidiagrammi (x,y) annetuista taulukoista.
     */
    private XYDataset createDatasetFaasi() {
        boolean autoSort = false;

        XYSeriesCollection dataset = new XYSeriesCollection();
        int j = 0;

        XYSeries series = new XYSeries(j, autoSort);
        for (int i = 0; i < tulokset.get(0).length; i++) {
            series.add(tulokset.get(0)[i], tulokset.get(1)[i]);

        }
        dataset.addSeries(series);
        return dataset;

    }
}
