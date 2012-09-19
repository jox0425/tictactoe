/**
 * TicTacToe játék 1.0 For more information, please visit http://www.xyz.hu Thx
 * for downloading
 */
package tictactoegame;

import javax.swing.JMenuBar;

/**
 *
 * @author Gyarmati János
 */
public class TicTacToeGame {

    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        InfoPanel infoPanel = new InfoPanel();
        PlayPanel playPanel = new PlayPanel(gf.getContentPanel().getSize());
        //GameOptionsDialog gameOptions = new GameOptionsDialog(gf);

        gf.initialize();
        gf.add(playPanel);
        gf.add(infoPanel);




    }
}
