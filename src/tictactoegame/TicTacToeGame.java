/**
 * TicTacToe játék 1.0 For more information, please visit http://www.xyz.hu Thx
 * for downloading
 */
package tictactoegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Gyarmati János
 */
public class TicTacToeGame extends JFrame {

    private Container contentPanel;
    private JMenuBar mbMainMenu;
    private JMenu mFile, mHelp;
    private JMenuItem miNewGame, miOptions, miExit, miAbout, miHowto;
    private PlayPanel playPanel;
    private InfoPanel infoPanel;
    private String howToPlay, about;
    private Dimension screenSize;
    private int frameWidth, frameHeight;
    private Player player1, player2;
    private static String[] arguments;

    public static void main(String[] args) {
        try {
            arguments = args;
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGame().setVisible(true);
            }
        });

    }

    private TicTacToeGame() {
        initComponents();
        createMenu();
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds((screenSize.width - frameWidth) / 2, (screenSize.height - frameHeight) / 2, frameWidth, frameHeight);
        contentPanel.setLayout(new GridLayout(1, 2));
        contentPanel.add(playPanel = new PlayPanel(getSize()));
        contentPanel.add(infoPanel);
        playPanel.uploadPanelWithSquares();
        playPanel.setPlayer1(player1);
        playPanel.setPlayer2(player2);
        playPanel.setInfoPanel(infoPanel);

    }

    private void initComponents() {
        contentPanel = getContentPane();
        mbMainMenu = new JMenuBar();
        mFile = new JMenu();
        mHelp = new JMenu();
        miNewGame = new JMenuItem();
        miOptions = new JMenuItem();
        miExit = new JMenuItem();
        miAbout = new JMenuItem();
        miHowto = new JMenuItem();
        //playPanel = new PlayPanel();
        
        howToPlay = "The X player usually goes first[citation needed]."
                + "\nThe player who succeeds in placing three respective marks in a "
                + "\nhorizontal, vertical, or diagonal row wins the game."
                + "\n\nIn the options menu, You can set the player names."
                + "\n\nWikipedia link: http://en.wikipedia.org/wiki/Tic-tac-toe";
        about = "TicTacToe game 1.0"
                + "\nCreated by Janos Gyarmati"
                + "\nAll rights reserved";
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameWidth = (screenSize.width) / 2;
        frameHeight = (screenSize.height) / 2;

        if (arguments.length < 1) {
            player1 = new Player("Player 1", 0);
            player2 = new Player("Player 2", 0);
        } else {
            player1 = new Player(arguments[0], Integer.parseInt(arguments[2]));
            player2 = new Player(arguments[1], Integer.parseInt(arguments[3]));
        }
        infoPanel = new InfoPanel(player1,player2);
    }

    private void createMenu() {
        setJMenuBar(mbMainMenu);
        mbMainMenu.add(mFile);
        mbMainMenu.add(mHelp);
        mFile.add(miNewGame);
        mFile.add(miOptions);
        mFile.add(miExit);
        mHelp.add(miHowto);
        mHelp.add(miAbout);

        mFile.setText("File");
        mHelp.setText("Help");
        miNewGame.setText("New Game");
        miOptions.setText("Options");
        miExit.setText("Exit");
        miHowto.setText("How To Play");
        miAbout.setText("About");


        miNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameMenuItemActionPerformed(e);
            }
        });
        miOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsMenuItemActionPerformed(e);
            }
        });
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenuItemActionPerformed(e);
            }
        });
        miHowto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToPlayMenuItemActionPerformed(e);
            }
        });
        miAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutMenuItemActionPerformed(e);
            }
        });
    }

    public void newGameMenuItemActionPerformed(ActionEvent e) {
        dispose();
        String args[] = {player1.getName(), player2.getName(),
            Integer.toString(player1.getScore()), Integer.toString(player2.getScore())};
        main(args);
    }

    private void optionsMenuItemActionPerformed(ActionEvent e) {
        GameOptionsDialog god = new GameOptionsDialog(this);
        god.setVisible(true);
        player1.setName(god.getP1name());
        infoPanel.setP1name(player1.getName());
        player2.setName(god.getP2name());
        infoPanel.setP2name(player2.getName());
    }

    private void exitMenuItemActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void howToPlayMenuItemActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, howToPlay, "How To Play", JOptionPane.INFORMATION_MESSAGE);
    }

    private void aboutMenuItemActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, about, "About", JOptionPane.INFORMATION_MESSAGE);
    }
}
