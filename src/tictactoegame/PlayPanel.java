/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Gyarmati János
 */
class PlayPanel extends JPanel {

    private ArrayList squares = new ArrayList();
    private double playPanelWidth, playPanelHeight;
    private Dimension size;
    private Square square;
    private int clicks = 0;
    private int actSquareIndex;
    private ArrayList XIndexList = new ArrayList(3);
    private ArrayList OIndexList = new ArrayList(3);
    int[][] winIndexes = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    public int[][] getWinIndexes() {
        return winIndexes;
    }

    public ArrayList getXIndexList() {
        return XIndexList;
    }

    public ArrayList getOIndexList() {
        return OIndexList;
    }

    public int getActSquareIndex() {
        return actSquareIndex;
    }

    public void setActSquareIndex(int actSquareIndex) {
        this.actSquareIndex = actSquareIndex;
    }
    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Square actSquare = (Square) e.getSource();
            if (!actSquare.isClicked()) {
                setActSquareIndex(findSquareIndex(actSquare));
                drawElement();
                actSquare.repaint();
                if (!winGame()) {
                    actSquare.setClicked();
                    clicks++;
                }
            }
        }
    };

    private void endGame() {
        System.out.println("endgame");
    }

    public PlayPanel(Dimension d) {
        Dimension panelSize = d;
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.black));
        setSize(panelSize.width, panelSize.height);
        setLayout(new GridLayout(3, 3));
        size = getSize();
        for (int i = 0; i < 9; i++) {
            add(square = new Square(panelSize.width, panelSize.height));
            squares.add(square);
            square.addMouseListener(mouseAdapter);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private int findSquareIndex(Object square) {
        return squares.indexOf(square);
    }

    private void drawElement() {
        Square s = (Square) squares.get(actSquareIndex);
        if (clicks % 2 > 0) {
            s.setPaintType(1);
            XIndexList.add(0, actSquareIndex);
        } else {
            s.setPaintType(2);
            OIndexList.add(0, actSquareIndex);
        }
    }

    private boolean winGame() {
        ArrayList winList = new ArrayList();
        ArrayList oList = getOIndexList();
        ArrayList xList = getXIndexList();
        try {
            for (int i = 0; i < getWinIndexes().length; i++) {
                winList.add(winIndexes[i][0]);
                winList.add(winIndexes[i][1]);
                winList.add(winIndexes[i][2]);

                if (oList.containsAll(winList)) {
                    endGame(0);
                    return true;
                }
                else if (xList.containsAll(winList)) {
                    endGame(1);
                    return true;
                }else if (oList.size()==5 && xList.size()==4){
                    endGame(2);
                    return true;
                }
                winList.clear();
            }
        } catch (Exception e) {
        }
        return false;
    }

    private void endGame(int winnerCode) {
        String winner = "";
        if (winnerCode == 0) {
            winner = "O";
        }
        if (winnerCode == 1) {
            winner = "X";
        }
        if (winnerCode == 2){
            winner = "Senki sem";
        }
        System.out.println(winner + " nyert!");
    }
}