/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_ohjelma.graafinenkayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Help extends JPanel {

    private Font fontti;
    private Font loppufontti;

    public Help() {

        super.setBackground(Color.LIGHT_GRAY);
        fontti = new Font("Courier", Font.PLAIN, 20);
        loppufontti = new Font("Arial", Font.PLAIN, 50);
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(50, 50, 600, 700);

        g.setColor(Color.pink);
        g.drawRect(0, 0, 600, 700);
        g.fillRect(0, 0, 600,700);
        g.setColor(Color.CYAN);
        g.setFont(loppufontti);
        g.drawString("Katso käyttöohjeet :]", 100, 150);

    }

}
