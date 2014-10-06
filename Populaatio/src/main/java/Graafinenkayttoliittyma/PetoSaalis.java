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
import Matematiikka.Petoelainsaaliselain;
import Tekstikayttoliittyma.SyotteidenTestaus;
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

public class PetoSaalis implements Runnable {

    private JFrame frame;
    private JTextField F0kentta;
    private JTextField R0kentta;
    private JTextField akentta;
    private JTextField bkentta;
    private JTextField ckentta;
    private JTextField dkentta;
    private JTextField infokentta;

    public PetoSaalis() {
        run();

    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(10, 2);
        container.setLayout(layout);

        JLabel F0 = new JLabel("Petojen tiheys: ");
        F0kentta = new JTextField();
        JLabel R0 = new JLabel("Saalisetn tiheys:  ");
        R0kentta = new JTextField();
        JLabel a = new JLabel("a ");
        akentta = new JTextField();
        JLabel b = new JLabel("b ");
        bkentta = new JTextField();
        JLabel c = new JLabel("c ");
        ckentta = new JTextField();
        JLabel d = new JLabel("d ");
        dkentta = new JTextField();
        JLabel info = new JLabel("info ");
        infokentta = new JTextField();

        JButton lisaaNappi = new JButton("Nayta kehitys");
        JButton lisaaNappi1 = new JButton("Laske tasapainopiste");
        JButton lisaaNappi2 = new JButton("Laske Min/max");
        JButton lisaaNappi3 = new JButton("Näytä Faasi");
        JButton Pnkma = new JButton("Paanäkymä");

        container.add(F0);
        container.add(F0kentta);
        container.add(R0);
        container.add(R0kentta);
        container.add(a);
        container.add(akentta);
        container.add(b);
        container.add(bkentta);
        container.add(c);
        container.add(ckentta);
        container.add(d);
        container.add(dkentta);
        container.add(info);
        container.add(infokentta);
        container.add(lisaaNappi1);
        container.add(lisaaNappi);
        container.add(lisaaNappi2);
        container.add(lisaaNappi3);
        container.add(Pnkma);

        //Aetetaan komennot napeille:
        Pnkma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaaValikko();
                frame.setVisible(false);

            }
        });
        lisaaNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Petoelainsaaliselain laskuri = new Petoelainsaaliselain();
                if (Testaakentat()) {
            

                    PiirraKayra kayra = new PiirraKayra("Saalikset ja pedot", "lkm", "t", laskuri.laske(Double.parseDouble(R0kentta.getText()), Double.parseDouble(F0kentta.getText()), Double.parseDouble(akentta.getText()), Double.parseDouble(bkentta.getText()), Double.parseDouble(ckentta.getText()), Double.parseDouble(dkentta.getText())));
                    kayra.Piirretaankayra();
                    kayra.setVisible(true);

                }

            }
        });

    }

    //Testataan kentat:
    private boolean DesimaalinSyotto(String stringi) {
        SyotteidenTestaus testi = new SyotteidenTestaus();
        return (testi.DesimaalinSyotto(stringi));
    }

    //Testataan että kaikki syötteet ok:
    private boolean Testaakentat() {

        return (DesimaalinSyotto(F0kentta.getText()) && DesimaalinSyotto(R0kentta.getText()) && DesimaalinSyotto(akentta.getText()) && DesimaalinSyotto(bkentta.getText()) && DesimaalinSyotto(ckentta.getText()) && DesimaalinSyotto(dkentta.getText()));

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
