
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class cards extends JPanel
{cxv
  JButton button = new JButton("Shuffle");//creating button

  public static void main(String[] a) {
     cards Deck = new cards();
     JFrame window = new JFrame("Card Randomizer");
     frame.add(Deck, BorderLayout.CENTER);
     window.setSize(1000,1000);
     window.setVisible(true);
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //add frame to main class
  // window.getContentPane().add(new cards());

 }
}
