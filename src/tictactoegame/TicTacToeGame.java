/**
 * TicTacToe játék 1.0 For more information, please visit http://www.xyz.hu Thx
 * for downloading
 */
package tictactoegame;

import java.awt.SystemColor;

/**
 *
 * @author Gyarmati János
 */
public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        gf.initialize();
        PlayPanel pPanel = gf.getPlaypanel();
        //pPanel.get
        InfoPanel iPanel = gf.getInfopanel();
        iPanel.setBackground(SystemColor.LIGHT_GRAY);
    }
}
