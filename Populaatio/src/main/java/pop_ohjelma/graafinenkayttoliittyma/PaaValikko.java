/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_ohjelma.graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Päävalikko.
 *
 * @author iangervu
 */
public class PaaValikko extends JPanel implements Runnable {

    private JFrame frame;

    public PaaValikko() {
        run();
    }

    /**
     * Ajaa päävalikon.
     */
    @Override
    public void run() {
        frame = new JFrame("Populaatio");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(final Container container) {

        GridLayout layout = new GridLayout(5, 2);
        container.setLayout(layout);

        JLabel a = new JLabel("Tervetuloa! Valitse:");
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
                new Influenssapopulaatiossagraf();
                frame.setVisible(false);
            }
        });
        c.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PetoSaalisgraph();
                frame.setVisible(false);
            }
        });
        d.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Populaatio");
                int leveys = 600;
                int korkeus = 700;
                frame1.setPreferredSize(new Dimension(leveys, korkeus));
                frame1.setResizable(false);
                frame1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

                luoKomponentitHelpille(frame1.getContentPane());

                frame1.setVisible(true);
                frame1.pack();

            }
        });

        e.addActionListener(new ActionListener() {
            /**
             * Suljetaan ohjelma.
             */
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                System.exit(0);

            }
        }
        );

    }

    private void luoKomponentitHelpille(final Container container) {
        Help help = new Help();
        container.add(help, BorderLayout.CENTER);

    }

}
