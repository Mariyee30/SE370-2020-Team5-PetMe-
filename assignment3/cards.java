
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class cards extends JPanel
{
  JButton button = new JButton("Shuffle");//creating button

  public static void main(String[] a) {
     cards Deck = new cards();
     JFrame window = new JFrame("Card Randomizer");
     window.add(Deck, BorderLayout.CENTER);
     window.setSize(1000,1000);
     window.setVisible(true);
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //add frame to main class
  // window.getContentPane().add(new cards());
    // testing add one card

    Mycanvas m = new MyCanvas();
    JFrame f = new Jframe();
    f.add(m);
    f.setSize(400,400);
    f.setVisible(true);
  }

    public void paint(Graphics g)
    {
      Toolkit t = Toolkit.getDefaultToolkit();
      Image i = t.getImage("2C.png");
      g.drawImage(i, 120,100,this);
    }

}
