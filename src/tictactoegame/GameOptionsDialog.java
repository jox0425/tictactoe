/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gyarmati János
 */
public class GameOptionsDialog extends JDialog {

    private String player1Name, player2Name;
    private JTextField tfP1, tfP2;
    private JButton btOk, btCancel;

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public GameOptionsDialog(JFrame owner) {
        super(owner,"Options",false);
        Container cp = getContentPane();
        setSize(400, 150);
        setResizable(false);
        setLocation(getParent().getX() + getWidth() / 2, getParent().getY() + getHeight() / 2);
        player1Name = "Player 1";
        player2Name = "Player 2";

        JPanel pn1 = new JPanel();
        pn1.add(new JLabel("Player 1 name: "));
        pn1.add(tfP1 = new JTextField(10));
        tfP1.setName("tfP1");
        cp.add(pn1, "North");

        JPanel pn2 = new JPanel();
        pn2.add(new JLabel("Player 2 name: "));
        pn2.add(tfP2 = new JTextField(10));
        tfP2.setName("tfP2");
        cp.add(pn2, "Center");

        JPanel pn3 = new JPanel();
        pn3.add(btOk = new JButton("Ok"));
        pn3.add(btCancel = new JButton("Cancel"));
        btOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayer1Name(validateField(tfP1));
                setPlayer2Name(validateField(tfP2));
            }
        });

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cp.add(pn3, "South");
        setVisible(true);
    }

    private String validateField(JTextField field) {
        String name = field.getText().trim();

        if (name.equals("")) {
            switch (field.getName()) {
                case "tfP1":
                    name = "Player 1";
                    break;
                case "tfP2":
                    name = "Player 2";
                    break;
            }
        }
        return name;
    }
}
