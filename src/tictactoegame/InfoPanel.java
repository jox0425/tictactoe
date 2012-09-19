/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gyarmati János
 */
class InfoPanel extends JPanel {

    private JLabel p1name, p2name, p1score, p2score;
    private final Font font = new Font("Arial", Font.BOLD, 30);

    public InfoPanel() {

        setLayout(new GridLayout(2, 1));
        JPanel pn1 = new JPanel(new GridLayout(2, 1));
        pn1.add(p1name = new JLabel("Player1 Score:", JLabel.CENTER));
        p1name.setFont(font);
        pn1.add(p1score = new JLabel("0", JLabel.CENTER));
        p1score.setFont(font);
        add(pn1);

        JPanel pn2 = new JPanel(new GridLayout(2, 1));
        pn2.add(p2name = new JLabel("Player2 Score:", JLabel.CENTER));
        p2name.setFont(font);
        pn2.add(p2score = new JLabel("0", JLabel.CENTER));
        p2score.setFont(font);
        add(pn2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
