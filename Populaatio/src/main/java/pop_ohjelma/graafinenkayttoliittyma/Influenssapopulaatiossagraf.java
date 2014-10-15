package pop_ohjelma.graafinenkayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import pop_ohjelma.matematiikka.Influenssapopulaatiossa;

/**
 * Graafinen liittymä influenssa populaatiossa tilanteeseen.
 * @author iangervu
 */
public class Influenssapopulaatiossagraf implements Runnable, ActionListener {

    private JFrame frame;
    private JTextField Nkentta;
    private JTextField Ikentta;
    private JTextField Bkentta;
    private JTextField akentta;
    private JTextField t1kentta;
    private JTextField infokentta;
    private ButtonGroup buttonGroup;
    private JButton Nappi;
    private JButton Nappi1;
    private JButton Nappi2;
    private JButton Nappi3;
    private JButton Nappi4;
    private JButton Nappi5;
    private JButton Pnkma;
    private JRadioButton SIS;
    private JRadioButton SIR;

    public Influenssapopulaatiossagraf() {

        run();
    }

    /**
     * Luodaan komponentit
     */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(11, 2);
        container.setLayout(layout);

        JLabel N = new JLabel("Populaation koko ");
        Nkentta = new JTextField();
        JLabel I = new JLabel("Sairastuneita aluksi ");
        Ikentta = new JTextField();
        JLabel B = new JLabel("Tarttumisintesiteetti ");
        Bkentta = new JTextField();
        JLabel a = new JLabel("Parantumistodennakoisyys/ aikayksikko ");
        akentta = new JTextField();
        JLabel t1 = new JLabel("Aika");
        t1kentta = new JTextField();
        JLabel R = new JLabel("info");
        infokentta = new JTextField();
        JLabel tyhja = new JLabel("");
        SIS = new JRadioButton("SIS");
        SIR = new JRadioButton("SIR");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(SIR);
        buttonGroup.add(SIS);

        Nappi = new JButton("Näytä kehitys");
        Nappi1 = new JButton("Laske R");
        Nappi2 = new JButton("Laske raja-arvo");
        Nappi3 = new JButton("Laske sairastuneita enimillään");
        Nappi4 = new JButton("Näytä faasidiagrammi");
        Nappi5 = new JButton("Tyhjennä kentät");

        Pnkma = new JButton("Päänäkymä");

        container.add(N);
        container.add(Nkentta);
        container.add(I);
        container.add(Ikentta);
        container.add(B);
        container.add(Bkentta);
        container.add(a);
        container.add(akentta);
        container.add(t1);
        container.add(t1kentta);
        container.add(R);
        container.add(infokentta);
        container.add(SIR);
        container.add(SIS);

        container.add(Nappi1);
        container.add(Nappi);
        container.add(Nappi2);
        container.add(Nappi3);
        container.add(Nappi4);
        container.add(tyhja);
        container.add(Nappi5);
        container.add(Pnkma);

        Nappi.addActionListener(this);
        Nappi1.addActionListener(this);
        Nappi2.addActionListener(this);
        Nappi3.addActionListener(this);
        Nappi4.addActionListener(this);
        Nappi5.addActionListener(this);
        Pnkma.addActionListener(this);
    }

    /**
     * Ajaa graafisen liittymän.
     */
    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(750, 750));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private boolean DesimaalinSyotto(String stringi) {
        SyotteidenTestaus testi = new SyotteidenTestaus();
        return (testi.DesimaalinSyotto(stringi));
    }

    private boolean Testaakentat() {

        return (DesimaalinSyotto(Nkentta.getText()) && DesimaalinSyotto(Ikentta.getText()) && DesimaalinSyotto(Bkentta.getText()) && DesimaalinSyotto(akentta.getText()) && DesimaalinSyotto(t1kentta.getText()));

    }

    /**
     * Nappien kuuntelija.
     *
     * @param e nappia painettu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] nimet = new String[2];
        nimet[0] = "sairastuneiden lkm.";
        nimet[1] = "sairaudelle alttiiden lkm.";

        if (e.getSource() == Nappi) {
            if (Testaakentat() == false) {
                infokentta.setText("Tarkista syöte!");
            } else {
//Testataan kumpi malli:
                if (SIS.isSelected()) {

                    ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText()));
                    //Käsitellään poikkeus:
                    if (tulokset == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }

                    PiirraKayra kayra = new PiirraKayra("", "lkm", "t", tulokset, nimet);

                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                } else if (SIR.isSelected()) {
                    ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText()));
                    //Käsitellään poikkeus:
                    if (tulokset == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }

                    PiirraKayra kayra = new PiirraKayra("", "lkm", "t", tulokset, nimet);
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                }

            }

        } else if (e.getSource() == Nappi1) {
            if (Testaakentat() == false) {
                infokentta.setText("Tarkista syöte!");
            } else {

                if (Double.parseDouble(akentta.getText()) == 0) {
                    infokentta.setText("inf");
                    return;
                }
                Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();

                infokentta.setText(laskin.PalautaR(Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(Nkentta.getText())) + "");

            }
        } else if (e.getSource() == Nappi2) {
            if (Testaakentat() == false) {
                infokentta.setText("Tarkista syöte!");
            } else {
                {
                    if (SIS.isSelected()) {
                        Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();

                        if (laskin.laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText())) == null) {
                            infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                            return;
                        }

                        infokentta.setText("Pysyvästi sairastuneita: " + laskin.TulostaRajaArvoSIS());
                    }
                }
            }
            if (SIR.isSelected()) {

                Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                if (laskin.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText())) == null) {
                    infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                    return;
                }
                infokentta.setText("Epidemian koko: " + laskin.TulostaRajaArvoSIR());

            }
        } else if (e.getSource() == Nappi3) {
            if (Testaakentat() == false) {
                infokentta.setText("Tarkista syöte!");
            } else {

                if (SIR.isSelected()) {
                    Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                    if (laskin.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText())) == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }
                    infokentta.setText(laskin.PalautaSairaitaMax() + "");
                } else if (SIS.isSelected()) {
                    Influenssapopulaatiossa laskin = new Influenssapopulaatiossa();
                    if (laskin.laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText())) == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }
                    infokentta.setText("");
                    infokentta.setText(laskin.PalautaSairaitaMax() + "");

                }

            }

        } else if (e.getSource() == Nappi4) {
            if (Testaakentat() == false) {
                infokentta.setText("Tarkista syöte!");
            } else {
                if (SIR.isSelected()) {

                    ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText()));
                    //Käsitellään poikkeus:
                    if (tulokset == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }
                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("", "I", "S", tulokset);
                    kayra1.PiirretaankayraFaasi();
                    kayra1.setVisible(true);
                }
                if (SIS.isSelected()) {
                    ArrayList<double[]> tulokset = new Influenssapopulaatiossa().laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(t1kentta.getText()));
                    //Käsitellään poikkeus:
                    if (tulokset == null) {
                        infokentta.setText("Tapahtui virhe :( Arvosi ovat luultavasti liian suuria.");
                        return;
                    }
                    PiirraFaasikayra kayra1 = new PiirraFaasikayra("", "I", "S", tulokset);
                    kayra1.PiirretaankayraFaasi();
                    kayra1.setVisible(true);

                }

            }
        } else if (e.getSource() == Nappi5) {
            Nkentta.setText("");
            Ikentta.setText("");
            Bkentta.setText("");
            akentta.setText("");
            infokentta.setText("");
            t1kentta.setText("");

        } else if (e.getSource() == Pnkma) {
            new PaaValikko();
            frame.setVisible(false);

        }

    }
}
