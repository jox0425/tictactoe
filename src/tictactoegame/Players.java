/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author Jox
 */
public class Players {

    private static int p1score;
    private static int p2score;
    private static String player1Name;
    private static String player2Name;

    public static int getP1score() {
        return p1score;
    }

    public static void setP1score(int p1score) {
        Players.p1score = p1score;
    }

    public static int getP2score() {
        return p2score;
    }

    public static void setP2score(int p2score) {
        Players.p2score = p2score;
    }

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static void setPlayer1Name(String player1Name) {
        Players.player1Name = player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public static void setPlayer2Name(String player2Name) {
        Players.player2Name = player2Name;
    }
}
