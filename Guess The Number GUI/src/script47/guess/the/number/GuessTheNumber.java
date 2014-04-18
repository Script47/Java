package script47.guess.the.number;

/**
 * Created by Script47 on 16/04/2014.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuessTheNumber extends JFrame {
    public FlowLayout layout = new FlowLayout();
    public Container container = getContentPane();

    public static ImageIcon image = new ImageIcon(GuessTheNumber.class.getResource("icon.png"));

    public JTextArea stringGuess = new JTextArea();
    public JTextArea credits = new JTextArea("Credits\nDeveloper: Script47\nVersion: ");

    public JButton guessButton = new JButton("Guess!");

    Game game = new Game();

    public GuessTheNumber() {
        setTitle("Guess The Number - Lives: "+game.getLives());
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(image.getImage());
        setVisible(true);

        credits.setPreferredSize(new Dimension(200, 75));
        credits.setToolTipText("Credits");
        credits.setFont(new Font("monospaced", Font.PLAIN, 12));
        credits.setEditable(false);

        stringGuess.setPreferredSize(new Dimension(200, 75));
        stringGuess.setToolTipText("Input Your Guess!");
        stringGuess.setFont(new Font("monospaced", Font.PLAIN, 12));

        guessButton.setPreferredSize(new Dimension(100, 75));
        guessButton.setToolTipText("Guess!");
        guessButton.setFont(new Font("monospaced", Font.PLAIN, 12));
        guessButton.setFocusPainted(false);

        guessButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stringGuess.getText().equals("")) {
                    game.errorPopUpBox("Field cannot be empty!", "Error!");
                    game.setLives(3);
                    setTitle("Guess The Number - Lives: "+game.getLives());
                    return;
                } else {
                    game.guess = Integer.parseInt(stringGuess.getText());

                    if(game.guess == 0) {
                        game.errorPopUpBox("You gave up! The number was "+game.getRandomNumber()+". The game has been refreshed.", "Error!");
                        game.randomNumber();
                        game.setRandomNumber();
                        game.setLives(3);
                        return;
                    } else if(game.guess == game.getRandomNumber()) {
                        game.popUpBox("Yay! You guessed the right number! You got an extra life.", "Guess!");
                        game.setLives(game.getLives()+1);
                        setTitle("Guess The Number - Lives: "+game.getLives());
                        System.out.println(game.getLives());
                    } else if(game.getLives() == 0) {
                        game.errorPopUpBox("Aww no! You ran out of lives!", "Error!");
                        game.randomNumber();
                        game.setRandomNumber();
                        game.setLives(3);
                        setTitle("Guess The Number - Lives: "+game.getLives());
                        return;
                    } else if(game.guess < 0 || game.guess > 10) {
                        game.errorPopUpBox("Number has to be between 1-10!", "Error!");
                        return;
                    } else if(game.guess > game.getRandomNumber()) {
                        game.errorPopUpBox("Oops! You guessed too high!", "Error!");
                        game.setLives(game.getLives()-1);
                        setTitle("Guess The Number - Lives: "+game.getLives());
                        return;
                    } else if(game.guess < game.getRandomNumber()) {
                        game.errorPopUpBox("Oops! You guessed too low!", "Error!");
                        game.setLives(game.getLives()-1);
                        setTitle("Guess The Number - Lives: "+game.getLives());
                        return;
                    }
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                stringGuess.requestFocus();
            }
        });

        container.setLayout(layout);
        container.add(credits);
        container.add(stringGuess);
        container.add(guessButton);
        container.repaint();
    }

    public static void main (String[] args) {
        GuessTheNumber Game  = new GuessTheNumber();
    }
}