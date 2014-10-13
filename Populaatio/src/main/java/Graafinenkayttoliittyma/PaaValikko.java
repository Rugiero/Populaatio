/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author iangervu
 */
public class PaaValikko implements Runnable {

    private JFrame frame;

    public PaaValikko() {
        run();
    }

    @Override
    public void run() {
        frame = new JFrame("Populaatio");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        GridLayout layout = new GridLayout(5, 2);
        container.setLayout(layout);

        JLabel a = new JLabel("Valitse:");
        JLabel tyhja = new JLabel("");
        JButton b = new JButton("SIR/SIS");
        JButton c = new JButton("Peto- saaliseläin");
        JButton d = new JButton("Help");
        JButton e = new JButton("Poistu");
        JLabel kuvaketusta = new JLabel(new ImageIcon("Pics/rabbit-foxresized.gif"));
        JLabel kuvabakteerista = new JLabel(new ImageIcon("Pics/germs-viruses-bacteria.jpg"));
        JLabel kysymys = new JLabel(new ImageIcon("Pics/quest.gif"));
        JLabel exit = new JLabel(new ImageIcon("Pics/exit.jpeg"));

        container.add(a);
        container.add(tyhja);
        container.add(b);
        container.add(kuvabakteerista);
        container.add(c);
        container.add(kuvaketusta);
        container.add(d);
        container.add(kysymys);
        container.add(e);
        container.add(exit);

        //Lisätään komennot:
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Influenssapoulaatiossa();
                frame.setVisible(false);
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PetoSaalis();
                frame.setVisible(false);
            }
        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Influenssapoulaatiossa();
                
            }
        });
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }

}
