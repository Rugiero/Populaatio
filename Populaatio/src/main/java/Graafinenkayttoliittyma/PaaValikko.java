/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author iangervu
 */
public class PaaValikko implements Runnable, ActionListener {

    private JFrame frame;

    public PaaValikko() {
        run();
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(200, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        JLabel a = new JLabel("Valitse:");
        JLabel b = new JLabel("SIR/SIS");
        JLabel c = new JLabel("Peto- saaliseläin");
        JLabel d = new JLabel("Help");
        JLabel e = new JLabel("Poistu");

        container.add(a);
        container.add(b);
        container.add(c);
        container.add(d);
        container.add(e);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kohde.setText(this.lahde.getText());
    }

}
