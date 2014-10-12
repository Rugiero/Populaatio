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
public class Influenssapoulaatiossa implements Runnable, ActionListener {

    private JFrame frame;
    private JTextField Nkentta;
    private JTextField Ikentta;
    private JTextField Bkentta;
    private JTextField akentta;
    private JTextField infokentta;
    private ButtonGroup buttonGroup;
    private JButton Nappi;
    private JButton Nappi1;
    private JButton Nappi2;
    private JButton Nappi3;
    private JButton Nappi4;
    private JButton Pnkma;
    private JRadioButton SIS;
    private JRadioButton SIR;

    public Influenssapoulaatiossa() {

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
        JLabel R = new JLabel("info");
        infokentta = new JTextField();

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
        container.add(infokentta);
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
         String[] nimet = new String[2];
                    nimet[0] = "sairastuneiden lkm.";
                    nimet[1] = "sairaudelle alttiiden lkm.";

        if (e.getSource() == Nappi) {
            if (Testaakentat()) {
//Testataan kumpi malli:
                if (SIS.isSelected()) {
                 
                     PiirraKayra kayra = new PiirraKayra("", "lkm", "t", new Matematiikka.Influenssapopulaatiossa().laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())),nimet);
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                } else if (SIR.isSelected()) {
                    PiirraKayra kayra = new PiirraKayra("", "lkm", "t", new Matematiikka.Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())), nimet);
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                }

            }

        } else if (e.getSource() == Nappi1) {
            if (Testaakentat()) {
                double R = (Double.parseDouble(Bkentta.getText()) / Double.parseDouble(akentta.getText())) * Double.parseDouble(Nkentta.getText());
                infokentta.replaceSelection("");
                infokentta.replaceSelection(R + "");

            }
        } else if (e.getSource() == Nappi2) {
            if (Testaakentat()) {
                {
                    if (SIS.isSelected()) {
                        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                        laskin.laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()));
                        infokentta.replaceSelection("");
                        infokentta.replaceSelection("Pysyvästi sairastuneita: " + laskin.TulostaRajaArvoSIS());
                    }
                }
                if (SIR.isSelected()) {

                    Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                    laskin.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()));
                    infokentta.replaceSelection("");
                    infokentta.replaceSelection("Epidemian koko kun I0=1: " + laskin.TulostaRajaArvoSIR());
                }
            }
        } else if (e.getSource() == Nappi3) {
            if (Testaakentat()) {

                if (SIR.isSelected()) {
                    Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                    laskin.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()));
                    infokentta.replaceSelection("");
                    infokentta.replaceSelection(laskin.PalautaSairaitaMax() + "");
                } else if (SIS.isSelected()) {
                    Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                    laskin.laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()));
                    infokentta.replaceSelection("");
                    infokentta.replaceSelection(laskin.PalautaSairaitaMax() + "");

                }

            }

        } else if (e.getSource() == Nappi4) {
            if (Testaakentat()) {
                if (SIR.isSelected()) {
                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("", "I", "S", new Matematiikka.Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                    kayra1.PiirretaankayraFaasi();
                    kayra1.setVisible(true);
                }
                if (SIS.isSelected()) {
                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("", "I", "S", new Matematiikka.Influenssapopulaatiossa().laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
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
