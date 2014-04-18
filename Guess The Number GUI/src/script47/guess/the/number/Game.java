package script47.guess.the.number;

import javax.swing.*;

/**
 * Created by Script47 on 18/04/2014.
 */
public class Game {
    public int randomNumber = randomNumber();
    public static int guess;
    public static int lives = 3;

    public int getLives() {
        return lives;
    }

    public int setLives(int newLives) {
        return this.lives = newLives;
    }

    public int randomNumber() {
        return randomNumber = (int) (Math.random() * 10 + 1);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int setRandomNumber() {
        return randomNumber = getRandomNumber();
    }

    public double getVersion() {
        double version = 1.0;
        return version;
    }

    /**
     * Default Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void popUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, "<html><style>body { font: Consolas; }</style><center><font color='green'>" + message + "</font></center></html>", title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Error Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void errorPopUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, "<html><style>body { font: Consolas; }</style><center><font color='red'>"+message+"</font></center></html>", title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Information Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void informationPopUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, "<html><style>body { font: Consolas; }</style><center>"+message+"</center></html>", title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void consoleOutput(String output) {
        System.out.println(output);
    }
}