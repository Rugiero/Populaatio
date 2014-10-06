package Graafinenkayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Influenssa implements Runnable {

    private JFrame frame;

    public Influenssa() {
        run();

    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(8, 2);
        container.setLayout(layout);

        JLabel N = new JLabel("Populaation koko: ");
        JTextField Nkentta = new JTextField();
        JLabel I = new JLabel("Sairastuneita aluksi: ");
        JTextField Ikentta = new JTextField();
        JLabel B = new JLabel("Tarttumisintesiteetti ");
        JTextField Bkentta = new JTextField();
        JLabel a = new JLabel("Parantumistodennakoisyys/ aikayksikko ");
        JTextField akentta = new JTextField();
        JLabel R = new JLabel("R");
        JTextField Rkentta = new JTextField();

        JRadioButton SIS = new JRadioButton("SIS");
        JRadioButton SIR = new JRadioButton("SIR");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(SIR);
        buttonGroup.add(SIS);

        JButton lisaaNappi = new JButton("Nayta kehitys");
        JButton lisaaNappi1 = new JButton("Laske R");
        JButton lisaaNappi2 = new JButton("Laske raja-arvo");
        JButton lisaaNappi3 = new JButton("Laske sairastuneita enimillään");
        // tapahtumankuuntelija

        container.add(N);
        container.add(Nkentta);
        container.add(I);
        container.add(Ikentta);
        container.add(B);
        container.add(Bkentta);
        container.add(a);
        container.add(akentta);
        container.add(R);
        container.add(Rkentta);
        container.add(SIR);
        container.add(SIS);

        container.add(lisaaNappi1);
        container.add(lisaaNappi);
        container.add(lisaaNappi2);
                container.add(lisaaNappi3);
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
