package Graafinenkayttoliittyma;

import Matematiikka.Influenssapopulaatiossa;
import Matematiikka.Petoelainsaaliselain;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Graafinen liittymä influenssa populaatiossa tilanteeseen.
 */
public class Influenssa implements Runnable, ActionListener {

    private JFrame frame;
    private JTextField Nkentta;
    private JTextField Ikentta;
    private JTextField Bkentta;
    private JTextField akentta;
    private JTextField Rkentta;
    private ButtonGroup buttonGroup;
    private JButton Nappi;
    private JButton Nappi1;
    private JButton Nappi2;
    private JButton Nappi3;
    private JButton Nappi4;
    private JButton Pnkma;
    private JRadioButton SIS;
    private JRadioButton SIR;

    public Influenssa() {

        run();
    }

    /**
     * Luodaan komponentit
     */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(9, 2);
        container.setLayout(layout);

        JLabel N = new JLabel("Populaation koko: ");
        Nkentta = new JTextField();
        JLabel I = new JLabel("Sairastuneita aluksi: ");
        Ikentta = new JTextField();
        JLabel B = new JLabel("Tarttumisintesiteetti ");
        Bkentta = new JTextField();
        JLabel a = new JLabel("Parantumistodennakoisyys/ aikayksikko ");
        akentta = new JTextField();
        JLabel R = new JLabel("R");
        Rkentta = new JTextField();

        SIS = new JRadioButton("SIS");
        SIR = new JRadioButton("SIR");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(SIR);
        buttonGroup.add(SIS);

        Nappi = new JButton("Nayta kehitys");
        Nappi1 = new JButton("Laske R");
        Nappi2 = new JButton("Laske raja-arvo");
        Nappi3 = new JButton("Laske sairastuneita enimillään");
        Nappi4 = new JButton("Näytä Faasi");
        Pnkma = new JButton("Paanäkymä");

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

        container.add(Nappi1);
        container.add(Nappi);
        container.add(Nappi2);
        container.add(Nappi3);
        container.add(Nappi4);
        container.add(Pnkma);

        Nappi.addActionListener(this);
        Nappi1.addActionListener(this);
        Nappi2.addActionListener(this);
        Nappi3.addActionListener(this);
        Nappi4.addActionListener(this);
        Pnkma.addActionListener(this);
    }

    /**
     * Ajaa graafisen liittymän
     */
    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Testaa yksittäisen kentän.
     */
    private boolean DesimaalinSyotto(String stringi) {
        SyotteidenTestaus testi = new SyotteidenTestaus();
        return (testi.DesimaalinSyotto(stringi));
    }

    /**
     * Testaa kaikki kentät.
     */
    private boolean Testaakentat() {

        return (DesimaalinSyotto(Nkentta.getText()) && DesimaalinSyotto(Ikentta.getText()) && DesimaalinSyotto(Bkentta.getText()) && DesimaalinSyotto(akentta.getText()));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Nappi) {
            if (Testaakentat()) {
//Testataan kumpi malli:
                if (SIS.isSelected()) {
                    PiirraKayra kayra = new PiirraKayra("Saalikset ja pedot", "lkm", "t", new Matematiikka.Influenssapopulaatiossa().laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                } else if (SIR.isSelected()) {
                    PiirraKayra kayra = new PiirraKayra("Saalikset ja pedot", "lkm", "t", new Matematiikka.Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                }

            }

        } else if (e.getSource() == Nappi1) {

        } else if (e.getSource() == Nappi2) {

        } else if (e.getSource() == Nappi3) {

        } else if (e.getSource() == Nappi4) {
            if (Testaakentat()) {
//Testataan että SIR-malli on valittu, muuten ei piirretä:
                if (SIR.isSelected()) {
                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("Saalikset ja pedot faasidiagrammi", "Jänöt", "Ketut", new Matematiikka.Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                    kayra1.PiirretaankayraFaasi();
                    kayra1.setVisible(true);

                }
            }
        } else if (e.getSource() == Pnkma) {
            new PaaValikko();
            frame.setVisible(false);

        }

    }

}
