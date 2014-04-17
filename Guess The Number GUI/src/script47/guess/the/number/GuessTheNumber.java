package script47.guess.the.number;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by Script47 on 16/04/2014.
 */


public class GuessTheNumber extends JFrame {
    public FlowLayout layout = new FlowLayout();
    public Container container = getContentPane();

    public static int randomNumber = (int) (Math.random() * 10 + 1);
    public static int guess;
    public static int lives = 3;
    public static double version = 1.0;

    public static JTextField stringGuess = new JTextField();

    public static JTextArea credits = new JTextArea();

    public static JButton guessNumber = new JButton("Guess!");

    public static JLabel giveUp = new JLabel("<html><font color='red'>You gave up! The number was "+randomNumber+".</font></html>");
    public static JLabel gameOver = new JLabel("<html><font color='red'>You ran out of lives! The number was "+randomNumber+". The game has refreshed.</font></html>");

    private static ImageIcon image = new ImageIcon(GuessTheNumber.class.getResource("icon.png"));

    public GuessTheNumber() {
        setTitle("Guess The Number - Lives Remaining: "+lives);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(image.getImage());
        setVisible(true);

        stringGuess.setPreferredSize(new Dimension(200, 50));
        stringGuess.setFont(new Font("monospaced", Font.PLAIN, 12));
        stringGuess.setToolTipText("You guess here, between 1-10.");

        guessNumber.setPreferredSize(new Dimension(100, 25));
        guessNumber.setFont(new Font("monospaced", Font.PLAIN, 12));
        guessNumber.setToolTipText("Guess!");

        credits.setPreferredSize(new Dimension(200, 50));
        credits.setToolTipText("Credits");
        credits.setEditable(false);
        credits.setFont(new Font("monospaced", Font.PLAIN, 12));
        credits.setText("Credits\nDeveloped By: Script47\nVersion: "+version);

        giveUp.setFont(new Font("monospaced", Font.PLAIN, 12));
        gameOver.setFont(new Font("monospaced", Font.PLAIN, 12));

        popUpBox("Guess The Number<br/><br/>Rules<br/><li>You have three lives.</li><li>I will choose a number between 1-10, you have to try and guess it.</li><li>If you get it right, then you will gain a life otherwise you'll lose one.</li><li>Type 0 in the field if you give up and the answer will be revealed.</li>", "Welcome!");
        guessNumber.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                container.remove(giveUp);
                container.remove(gameOver);
                container.repaint();
                if (stringGuess.equals("")) {
                    errorPopUpBox("Field empty!", "Error!");
                    return;
                } else {
                    guess = Integer.parseInt(stringGuess.getText());

                    if (lives < 1) {
                        container.add(gameOver);
                        lives = 3;
                        setTitle("Guess The Number - Lives Remaining: " + lives);
                        randomNumber = (int) (Math.random() * 10 + 1);
                        container.revalidate();
                        return;
                    } else if (guess == 0) {
                        container.add(giveUp);
                        lives = 3;
                        setTitle("Guess The Number - Lives Remaining: " + lives);
                        randomNumber = (int) (Math.random() * 10 + 1);
                        container.revalidate();
                        return;
                    } else if (guess == randomNumber) {
                        popUpBox("You guessed correct!", "Good Guess!");
                        lives++;
                        setTitle("Guess The Number - Lives Remaining: " + lives);
                        randomNumber = (int) (Math.random() * 10 + 1);
                        container.revalidate();
                        return;
                    } else if (guess < 1 || guess > 10) {
                        errorPopUpBox("Guess has to be between 1-10.", "Error!");
                        return;
                    } else if (guess < randomNumber) {
                        errorPopUpBox("Ooops. You guessed too low!", "Error!");
                        lives--;
                        setTitle("Guess The Number - Lives Remaining: " + lives);
                        container.revalidate();
                        return;
                    } else if (guess > randomNumber) {
                        errorPopUpBox("Ooops. You guessed too high!", "Error!");
                        lives--;
                        setTitle("Guess The Number - Lives Remaining: " + lives);
                        container.revalidate();
                        return;
                    }
                }
            }
        });

        container.setLayout(layout);
        container.add(credits);
        container.add(stringGuess);
        container.add(guessNumber);
        container.revalidate();
        container.repaint();
    }

    /**
     * Default Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void popUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, "<html><style>body { font: Consolas; }</style><center><font color='green'>"+message+"</font></center></html>", title, JOptionPane.DEFAULT_OPTION);
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

    public static void main(String[] args) {
        GuessTheNumber Frame = new GuessTheNumber();
    }
}