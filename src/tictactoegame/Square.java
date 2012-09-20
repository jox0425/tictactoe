/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author Gyarmati János
 */
class Square extends JComponent {

    private int width, height;
    private boolean clicked;
    private int paintType;           //ez tárolja hogy x-et rajzol(0), vagy o-t (1)

    public int getPaintType() {
        return paintType;
    }

    public void setPaintType(int paintType) {
        this.paintType = paintType;
    }

    public Square(int width,int height) {
        this.width = width;
        this.height = height;
        this.clicked = false;
        this.paintType = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, width, height);
        switch (getPaintType()) {
            case 0:
                break;
            case 1:
                paintX(g);
                break;
            case 2:
                paintO(g);
                break;
        }
    }

    public void paintX(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.blue);
        g.setStroke(new BasicStroke(6));
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
        g.dispose();
    }

    public void paintO(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(6));
        g.drawOval(3, 3, getWidth() - 3, getHeight() - 3);
        g.dispose();
    }

    public void setClicked() {
        clicked = true;
    }

    public boolean isClicked() {
        return clicked;
    }
}
