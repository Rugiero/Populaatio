/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graafinenkayttoliittyma;

/**
 *
 * @author iangervu
 */
import Matematiikka.Influenssapopulaatiossa;
import Matematiikka.Petoelainsaaliselain;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PetoSaalis implements Runnable, ActionListener {

    private JFrame frame;
    private JTextField F0kentta;
    private JTextField R0kentta;
    private JTextField akentta;
    private JTextField bkentta;
    private JTextField ckentta;
    private JTextField dkentta;
    private JTextField t1kentta;
    private JTextField infokentta;
    private JButton Nappi;
    private JButton Nappi1;
    private JButton Nappi2;
    private JButton Nappi3;
    private JButton Nappi4;
    private JButton Pnkma;

    public PetoSaalis() {
        run();

    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(12, 2);
        container.setLayout(layout);

        JLabel F0 = new JLabel("Petojen tiheys: ");
        F0kentta = new JTextField();
        JLabel R0 = new JLabel("Saaliiden tiheys:  ");
        R0kentta = new JTextField();
        JLabel a = new JLabel("a ");
        akentta = new JTextField();
        JLabel b = new JLabel("b ");
        bkentta = new JTextField();
        JLabel c = new JLabel("c ");
        ckentta = new JTextField();
        JLabel d = new JLabel("d ");
        dkentta = new JTextField();
        JLabel t1 = new JLabel("t1");
        t1kentta = new JTextField();
        JLabel info = new JLabel("info ");
        infokentta = new JTextField();

        Nappi = new JButton("Nayta kehitys");
        Nappi1 = new JButton("Laske tasapainopiste");
        Nappi2 = new JButton("Laske Min/max pedot");
        Nappi4 = new JButton("Laske Min/max saaliit");
        Nappi3 = new JButton("Näytä Faasi");

        Pnkma = new JButton("Paanäkymä");
        Nappi.addActionListener(this);
        Nappi1.addActionListener(this);
        Nappi2.addActionListener(this);
        Nappi3.addActionListener(this);
        Nappi4.addActionListener(this);
        Pnkma.addActionListener(this);

        container.add(R0);
        container.add(R0kentta);
        container.add(F0);
        container.add(F0kentta);
        container.add(a);
        container.add(akentta);
        container.add(b);
        container.add(bkentta);
        container.add(c);
        container.add(ckentta);
        container.add(d);
        container.add(dkentta);
        container.add(t1);
        container.add(t1kentta);
        container.add(info);
        container.add(infokentta);
        container.add(Nappi1);
        container.add(Nappi);
        container.add(Nappi2);
        container.add(Nappi3);
        container.add(Nappi4);
        container.add(Pnkma);

    }

    //Testataan kentat:
    private boolean DesimaalinSyotto(String stringi) {
        SyotteidenTestaus testi = new SyotteidenTestaus();
        return (testi.DesimaalinSyotto(stringi));
    }

    //Testataan että kaikki syötteet ok:
    private boolean Testaakentat() {

        return (DesimaalinSyotto(F0kentta.getText()) && DesimaalinSyotto(R0kentta.getText()) && DesimaalinSyotto(akentta.getText()) && DesimaalinSyotto(bkentta.getText()) && DesimaalinSyotto(ckentta.getText()) && DesimaalinSyotto(dkentta.getText())  &&  DesimaalinSyotto(t1kentta.getText()));

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Nappi) {
            if (Testaakentat()) {
                String[] nimet = new String[2];
                nimet[0] = "saaliiden tiheys";
                nimet[1] = "petojen tiheys";

                PiirraKayra kayra = new PiirraKayra("Saaliit ja pedot", "tiheys", "t", new Matematiikka.Petoelainsaaliselain().laske(Double.parseDouble(R0kentta.getText()), Double.parseDouble(F0kentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(bkentta.getText()), Double.parseDouble(ckentta.getText()), Double.parseDouble(dkentta.getText()),  Double.parseDouble(t1kentta.getText()) ), nimet);
                kayra.Piirretaankayra();
                kayra.setVisible(true);

            }

        } else if (e.getSource() == Nappi1) {
            //Palauttaa syysteemin tasapainopisteen. Osoittautuu että se on (d/c, a/b).

            if (Testaakentat()) {
                infokentta.setText("");
                infokentta.setText(Double.parseDouble(dkentta.getText()) / Double.parseDouble(ckentta.getText()) + "," + Double.parseDouble(akentta.getText()) / Double.parseDouble(bkentta.getText()));
            }
        } else if (e.getSource() == Nappi2) {
            if (Testaakentat()) {
                Petoelainsaaliselain laskin = new Petoelainsaaliselain();
                laskin.laske(Double.parseDouble(R0kentta.getText()), Double.parseDouble(F0kentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(bkentta.getText()), Double.parseDouble(ckentta.getText()), Double.parseDouble(dkentta.getText()),Double.parseDouble(t1kentta.getText()));
                infokentta.setText("");
                infokentta.setText("Max: " + laskin.PalautaMaxPetoja() + "Min:" + laskin.PalautaMinpetoja());
            }
        } else if (e.getSource() == Nappi4) {

            if (Testaakentat()) {
                Petoelainsaaliselain laskin = new Petoelainsaaliselain();
                laskin.laske(Double.parseDouble(R0kentta.getText()), Double.parseDouble(F0kentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(bkentta.getText()), Double.parseDouble(ckentta.getText()), Double.parseDouble(dkentta.getText()),Double.parseDouble(t1kentta.getText()));
                infokentta.setText("");
                infokentta.setText("Max: " + laskin.PalautaMaxsaaliita() + "Min:" + laskin.PalautaMinsaaliita());
            }
        } else if (e.getSource() == Nappi3) {
            if (Testaakentat()) {

                PiirraFaasikayra kayra1 = new PiirraFaasikayra("Saaliit ja pedot faasidiagrammi", "Saaliit", "Pedot", new Matematiikka.Petoelainsaaliselain().laske(Double.parseDouble(R0kentta.getText()), Double.parseDouble(F0kentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(bkentta.getText()), Double.parseDouble(ckentta.getText()), Double.parseDouble(dkentta.getText()),Double.parseDouble(t1kentta.getText())));
                kayra1.PiirretaankayraFaasi();
                kayra1.setVisible(true);

            }

        } else if (e.getSource() == Pnkma) {
            new PaaValikko();
            frame.setVisible(false);

        }

    }

}
