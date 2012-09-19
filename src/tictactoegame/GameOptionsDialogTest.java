/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.HeadlessException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gyarmati János
 */
public class GameOptionsDialogTest extends JFrame{

    public GameOptionsDialogTest() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,200,300,300);
        GameOptionsDialog gd = new GameOptionsDialog(this);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        GameOptionsDialogTest god = new GameOptionsDialogTest();
    }
    
}
