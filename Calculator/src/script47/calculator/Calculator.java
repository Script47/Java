package script47.calculator;

import javax.swing.*;

/**
 * Calculator
 * @author Script47
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double version = 1.0;      
        boolean goAgain = true;
        JOptionPane.showMessageDialog(null, "A simple calculator.\nDeveloped By: Script47\nVersion: "+version, "Simple Calculator", JOptionPane.INFORMATION_MESSAGE);
        
        while(goAgain) {
            Object[] mathOperators = {"Addition", "Subtraction", "Division", "Multiplication"};
            int choice;
            double firstNumber, secondNumber, total;
            String firstBox, secondBox;
        
            choice = JOptionPane.showOptionDialog(null, "What type of calculation would you like to do?", "Set Calculation Type", 0, JOptionPane.QUESTION_MESSAGE, null, mathOperators, null);
            
            if(choice == -1) {
                System.exit(0);
            }

            firstBox = JOptionPane.showInputDialog(null, "First Number: ");
            secondBox = JOptionPane.showInputDialog(null, "Second Number: ");

            if(firstBox == null || firstBox.equals("")) {
                firstNumber = 0;
            } else if(secondBox == null || secondBox.equals("")) {
                secondNumber = 0;
            } else { 
                
                try {
                    firstNumber = Double.parseDouble(firstBox);
                    secondNumber = Double.parseDouble(secondBox);

                    if(choice == 0) {
                        total = firstNumber + secondNumber;
                        JOptionPane.showMessageDialog(null, "Total: "+total, "Results", JOptionPane.PLAIN_MESSAGE);              
                    } else if(choice == 1) {
                        total = firstNumber - secondNumber;
                        JOptionPane.showMessageDialog(null, "Total: "+total, "Results", JOptionPane.PLAIN_MESSAGE);     
                    } else if(choice == 2) {
                        total = firstNumber / secondNumber;     
                        JOptionPane.showMessageDialog(null, "Total: "+total, "Results", JOptionPane.PLAIN_MESSAGE);            
                    } else if(choice == 3) {
                        total = firstNumber * secondNumber;
                        JOptionPane.showMessageDialog(null, "Total: "+total, "Results", JOptionPane.PLAIN_MESSAGE);     
                    } 
                    
                    int reGo = JOptionPane.showConfirmDialog(null, "Would you like to do another calculation?", "Retry?", JOptionPane.YES_NO_OPTION);

                    if(reGo == 1) {
                        goAgain = false;                        
                        System.exit(0);
                    } else if(reGo == -1) {
                        goAgain = false;
                        System.exit(0);
                    }
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error!\nNumber has to be smaller than 9999999999.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
