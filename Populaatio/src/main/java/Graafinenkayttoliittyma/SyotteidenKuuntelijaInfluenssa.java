/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graafinenkayttoliittyma;

import Matematiikka.Influenssapopulaatiossa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author iangervu
 */
public class SyotteidenKuuntelijaInfluenssa implements ActionListener {

    private JTextField Nkentta;
    private JTextField Ikentta;
    private JTextField Bkentta;
    private JTextField akentta;
    private JRadioButton SIS;
    private JRadioButton SIR;
    private final Matematiikka.Influenssapopulaatiossa laskuri = new Influenssapopulaatiossa();

    public SyotteidenKuuntelijaInfluenssa(JRadioButton SIS, JRadioButton SIR, JTextField Nkentta, JTextField Ikentta, JTextField Bkentta, JTextField akentta) {

        this.Bkentta = Bkentta;
        this.Ikentta = Ikentta;
        this.Nkentta = Nkentta;
        this.akentta = akentta;
        this.SIS = SIS;
        this.SIR = SIR;
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Testaakentat()) {
//Testataan kumpi malli:
            if (SIS.isSelected()) {
                PiirraKayra kayra = new PiirraKayra("", "lkm", "t", laskuri.laskeSIS(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                kayra.Piirretaankayra();
                kayra.setVisible(true);

            } else if (SIR.isSelected()) {
                PiirraKayra kayra = new PiirraKayra("", "lkm", "t", laskuri.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                kayra.Piirretaankayra();
                kayra.setVisible(true);

            }

//Testataan että SIR-malli on valittu, muuten ei piirretä:
            if (SIR.isSelected()) {
                PiirraFaasikayra kayra1 = new PiirraFaasikayra("", "", "", laskuri.laskeSIR(Double.parseDouble(Nkentta.getText()), Double.parseDouble(Ikentta.getText()), Double.parseDouble(Bkentta.getText()), Double.parseDouble(akentta.getText())));
                kayra1.PiirretaankayraFaasi();
                kayra1.setVisible(true);

            }

        }

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

}
