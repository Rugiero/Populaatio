package populaatio.populaatio;

import Graafinenkayttoliittyma.PiirraKayra;
import Tekstikayttoliittyma.Paavalikko;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import matematiikka.Influenssapopulaatiossa;
import org.jfree.chart.JFreeChart;

public class App {

    public static void main(String[] args) {

        Paavalikko valikko = new Paavalikko();
        valikko.alkunakyma();
    }
}
