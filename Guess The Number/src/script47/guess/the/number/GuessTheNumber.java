package script47.guess.the.number;

import java.util.Scanner;

/**
 * Guess The Number
 * @author Script47
 */
public class GuessTheNumber {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Main variables for the game. 
         */
        Scanner userInput = new Scanner(System.in);        
        int randomNumber = (int) (Math.random()* 10 + 1);
        int lives = 3;
        boolean gameRunning = true;
        
        System.out.println("Hello, what is your name?");
        String name = userInput.nextLine();
        System.out.println("Ah, well hello "+name+". I'm going to pick a number between 1-10, try guess it.\nIf you wish to give up, then type 0 and hit enter.\n");

        int guess = userInput.nextInt();            
            
        while (gameRunning) {
            if(guess < -1 || guess > 10) {
                System.out.println("Number can only be between 1-10.");
                guess = userInput.nextInt();                
            } else if(guess == 0) {
                System.out.println("You gave up, the number was: "+randomNumber+". Do you wish to try again? Y/N");
                String tryAgain = userInput.next();
                if(tryAgain.equals("Y")) {
                    lives = 3;
                    System.out.println("\nLives Remainaing: "+lives);                       
                    System.out.println("Pick a number between 1-10.");                    
                    randomNumber = (int) (Math.random() * 10 + 1);
                    guess = userInput.nextInt();                     
                } else {
                    System.out.println("Goodbye "+name+".");
                    gameRunning = false; 
                }
            } else if(lives <= 0) {
                System.out.println("You ran out of lives! Do you wish to try again? Y/N");
                String tryAgain = userInput.next();
                 if(tryAgain.equals("Y")) {
                     lives = 3;
                     System.out.println("\nPick a number between 1-10.\n");                    
                     randomNumber = (int) (Math.random() * 10 + 1);                    
                     guess = userInput.nextInt();                     
                 } else {
                     System.out.println("Goodbye "+name+".");
                     gameRunning = false; 
                 }                
            } else if(guess > randomNumber) {
                lives--;                
                System.out.println("Lives Remainaing: "+lives);                   
                System.out.println("Your guess was too high, try again.\n");
                guess = userInput.nextInt();                  
            } else if(guess < randomNumber) {
                lives--;                
                System.out.println("Lives Remainaing: "+lives);                  
                System.out.println("Your guess was too low, try again.\n");
                guess = userInput.nextInt();                  
            } else if(guess == randomNumber) {
                System.out.println("Great guess! You got it right. Do you wish to try again? Y/N");
                String tryAgain = userInput.next();
                if(tryAgain.equals("Y")) {
                    lives++;                        
                    System.out.println("\nYou got an extra life! Pick a number between 1-10.");
                    System.out.println("Lives Remainaing: "+lives+"\n");                                  
                    randomNumber = (int) (Math.random() * 10 + 1);                    
                    guess = userInput.nextInt();                     
                } else {
                    System.out.println("Goodbye "+name+".");
                    gameRunning = false; 
                }
            }
        }
        System.exit(0);
    }
}