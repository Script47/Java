package JFrame.skeleton;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * JFrame Skeleton
 * @author Script47
 */
public class FrameSkeleton extends JFrame {
    public FlowLayout layout = new FlowLayout();
    public Container container = getContentPane();
    
    public FrameSkeleton() {
        setTitle("Frame Skeleton");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JLabel introduction = new JLabel("This is a JFrame skeleton which can be used in all you projects, it also contains JOptionPane functions which have been explained and a lot easier to use and less to type.");
        
        container.setLayout(layout);
        container.add(introduction);
        revalidate();
    }
    
    /**
     * Default Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void popUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * Error Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void errorPopUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Information Pop-Up Box
     * @param message - defines the message to be displayed.
     * @param title - defines the title to be displayed on the top bar.
     */
    public static void informationPopUpBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * @param args - the command line arguments
     */
    public static void main(String[] args) {
        FrameSkeleton Frame = new FrameSkeleton();
    } 
    
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(250, 250, 10, 10);
    }
}
