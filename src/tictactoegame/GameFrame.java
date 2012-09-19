/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Gyarmati János
 */
class GameFrame extends JFrame {

    private GameFrame gameframe;
    private Container ContentPanel;
    private JMenuBar mbMainMenu;
    private JMenu mFile, mHelp;
    private JMenuItem miNewGame, miOptions, miExit, miAbout, miHowto;
    private PlayPanel playpanel;
    private InfoPanel infopanel;
    private ActionListener alFileMenu, alHelpMenu;
    private String howToPlay = "The X player usually goes first[citation needed]."
            + "\nThe player who succeeds in placing three respective marks in a "
            + "\nhorizontal, vertical, or diagonal row wins the game."
            + "\n\nIn the options menu, You can set the player names."
            + "\n\nWikipedia link: http://en.wikipedia.org/wiki/Tic-tac-toe";
    private String about = "TicTacToe game 1.0"
            + "\nCreated by Janos Gyarmati"
            + "\nAll rights reserved";

    public GameFrame() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ContentPanel = getContentPane();
        ContentPanel.setLayout(new GridLayout());
        //Main frame location and size, relative to Screen resolution.
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        int GameFrameWidth = Screen.width / 2;
        int GameFrameHeight = Screen.height / 2;
        setBounds((Screen.width - GameFrameWidth) / 2, (Screen.height - GameFrameHeight) / 2,
                GameFrameWidth, GameFrameHeight);
        setVisible(true);
    }

    public PlayPanel getPlaypanel() {
        return playpanel;
    }

    public void setPlaypanel(PlayPanel playpanel) {
        this.playpanel = playpanel;
    }

    public InfoPanel getInfopanel() {
        return infopanel;
    }

    public void setInfopanel(InfoPanel infopanel) {
        this.infopanel = infopanel;
    }

    void initialize() {
        createMenu();
        addListeners();
        createPlayPanel();
        createInfoPanel();
    }

    private void createMenu() {
        setJMenuBar(mbMainMenu = new JMenuBar());
        mbMainMenu.add(mFile = new JMenu("File"));
        mbMainMenu.add(mHelp = new JMenu("Help"));
        mFile.add(miNewGame = new JMenuItem("New Game"));
        mFile.add(miOptions = new JMenuItem("Options"));
        mFile.add(miExit = new JMenuItem("Exit"));
        mHelp.add(miHowto = new JMenuItem("How to play"));
        mHelp.add(miAbout = new JMenuItem("About"));
    }

    private void createPlayPanel() {
        ContentPanel = getContentPane();
        ContentPanel.add(playpanel = new PlayPanel(ContentPanel.getSize()));
    }

    private void createInfoPanel() {
        ContentPanel = getContentPane();
        ContentPanel.add(infopanel = new InfoPanel());
    }

    private void addListeners() {
        miNewGame.addActionListener(alFileMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                String[] args = null;
                TicTacToeGame.main(args);
            }
        });
        miOptions.addActionListener(alFileMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameOptionsDialog god = new GameOptionsDialog(gameframe);
            }
        });
        miExit.addActionListener(alFileMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miHowto.addActionListener(alHelpMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gameframe, howToPlay, "How to play", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        miAbout.addActionListener(alHelpMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gameframe, about, "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
