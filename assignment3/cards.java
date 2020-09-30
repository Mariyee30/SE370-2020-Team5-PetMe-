
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class cards extends JPanel
{
  JButton button = new JButton("Shuffle");//creating button

  int rows = 4;
      int columns = 13;
      String[][] cardNames;
      cardNames = new String[rows][columns];//2d string array for cards
      String cardFace[] = new String[]{"C","D","H","S"};


      for(int i=0;i<rows;i++) {
        for(int j=0;j<columns;j++)
        {
          if(j==0) {
            cardNames[i][j] = "A"+cardFace[i]+".png";
          }else if(j==10) {
            cardNames[i][j] = "J"+cardFace[i]+".png";
          }else if(j==11) {
            cardNames[i][j] = "Q"+cardFace[i]+".png";
          }else if(j==12) {
            cardNames[i][j] = "K"+cardFace[i]+".png";
          }else {
            cardNames[i][j] = (j+1)+cardFace[i]+".png";
          }
        }

  window.add(button, BorderLayout.SOUTH);
  button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      Random random = new Random();
      for (int i = cardNames.length - 1; i > 0; i--) {
        for (int j = cardNames[i].length - 1; j > 0; j--) {
            int m = random.nextInt(i + 1);
            int n = random.nextInt(j + 1);

            String temp = cardNames[i][j];
              cardNames[i][j] = cardNames[m][n];
              cardNames[m][n] = temp;

              //change image icon in jpanel

            }
          }
        });

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

/*
    Mycanvas m = new MyCanvas();
    JFrame f = new Jframe();
    f.add(m);
    f.setSize(400,400);
    f.setVisible(true);
    */
  }
/*
    public void paint(Graphics g)
    {
      Toolkit t = Toolkit.getDefaultToolkit();
      Image i = t.getImage("2C.png");
      g.drawImage(i, 120,100,this);
    }
*/
}
