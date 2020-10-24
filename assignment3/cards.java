
import java.util.Random;
import java.awt.*;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class cards extends JPanel
{
  JButton button = new JButton("Shuffle"); //creating button
  String[][] NameOfCards; // 2d string array of cards
  private JPanel[][] boxes; //2d jpanel array of jpanels


  public cards()
  {
    //set of the grid layout
    setLayout(new FlowLayout());

    NameOfCards = new String[5][13]; //2d string array for cards
    boxes = new JPanel[4][13]; //2d jpanel array for panels
    setBackground(Color.green); //background color to green


    //creasting memory for each kind of card
    String faces[] = new String[]{"C","D","H","S"};

    //putting pngs into 2d array
    for(int i=0;i<4;i++) {
      for(int j=0;j<13;j++)
      {
        if(j==0) {
          NameOfCards[i][j] = "A"+faces[i]+".png";
        }else if(j==10) {
          NameOfCards[i][j] = "J"+faces[i]+".png";
        }else if(j==11) {
          NameOfCards[i][j] = "Q"+faces[i]+".png";
        }else if(j==12) {
          NameOfCards[i][j] = "K"+faces[i]+".png";
        }else {
          NameOfCards[i][j] = (j+1)+faces[i]+".png";
        }
      }
    }

    //gets each card png and displays
    for(int i = 0; i < boxes.length; i++) {
      for(int j = 0; j < boxes[i].length; j++) {
        ImageIcon icon = new ImageIcon("PNG/"+NameOfCards[i][j]);
        Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        JLabel wIcon = new JLabel(new ImageIcon(scaleImage));

        //add panel
        boxes[i][j] = new JPanel();
        boxes[i][j].add(wIcon);

        //add into boxes matrix
        add(boxes[i][j]);
        final int iCopy = i;
        final int jCopy = j;

        //set color black
        boxes[iCopy][jCopy].setBackground(Color.green);

        //set border gray
        boxes[i][j].setBorder(BorderFactory.createLineBorder(Color.green));
        }
      }
      add(button);
      //creating an action listener for the shuffle button to work
      button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          // Fisher–Yates algorithm modified for two-dimensional arrays:
        Random random = new Random();
           for(int i=0;i<4;i++) {
            for(int j=0;j<13;j++) {
                int row = random.nextInt(4);
                int col = random.nextInt(13);

                int row1 = random.nextInt(4);
                int col1 = random.nextInt(13);

                String name = NameOfCards[row][col];
                NameOfCards[row][col] = NameOfCards[row1][col1];
                NameOfCards[row1][col1] = name;

                boxes[i][j].removeAll();
                ImageIcon icon = new ImageIcon("PNG/"+NameOfCards[i][j]);
                Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
                JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
                boxes[i][j].add(wIcon);
                boxes[i][j].repaint();
            }
           }
      revalidate(); //this call is an instruction to tell the layout manager to reset based on the new component list.
      }
    });
  }

  public static void main(String[] a) {
     //cards Deck = new cards();
        JFrame window = new JFrame(); //creating jFrame called window
        window.setSize(2000,1000); //seting size of window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add frame to main class
        window.getContentPane().add(new cards());
        window.setVisible(true);
 }
}
