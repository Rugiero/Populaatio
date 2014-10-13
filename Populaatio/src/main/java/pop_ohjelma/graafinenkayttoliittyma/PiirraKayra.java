/**
 * Luokalla piirretää käyrä muotoa y=x(t) ArrayListassa olevien taulukoiden
 * datasta. Luokalle odotetaan parametriksi ArrayList joka sisältää vähintään
 * kaksi taulukkoa. Ensimmäinen taulukko tulkitaan ajaksi. String[] taulukon
 * oletetaan sisältävän käyrien nimet järjestyksessä.
 *
 */
package pop_ohjelma.graafinenkayttoliittyma;

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
    private String[] nimet;

    public PiirraKayra(String otsikko, String x, String y, ArrayList<double[]> tulokset, String[] nimet) {
        super("Populaatio");
        this.tulokset = tulokset;
        this.x = x;
        this.y = y;
        this.otsikko = otsikko;
        this.nimet = nimet;

    }

    public void Piirretaankayra() {

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

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
     * Metodilla luodaan diagrammi (x,t) jokaisesta annetusta taulukosta. Huom!
     * Arraylistin esimmäinen taulukko tulkitaan olevan aika t.
     */
    private XYDataset createDataset() {

        boolean autoSort = false;

        XYSeriesCollection dataset = new XYSeriesCollection();

        int j = 0;
        for (int k = 1; k < tulokset.size(); k++) {
            XYSeries series = new XYSeries(nimet[j], autoSort);
            for (int i = 0; i < tulokset.get(k).length; i++) {
                series.add(tulokset.get(k)[i], tulokset.get(0)[i]);
            }

            dataset.addSeries(series);
            j++;
        }

        return dataset;
    }

}
