import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class FlappyFrame extends JFrame
{
   public FlappyFrame()
   {
      super("Project Frame");
      //Add panel and set layout/size
      Container contents = getContentPane();
      FlappyPanel lp = new FlappyPanel();
      //contents.setBackground(Color.BLACK); //For black border
      contents.add(lp);
      setSize(1600,800);
      setVisible(true);      
      
      lp.requestFocus();  
   }
   public static void main(String[] args)
   {
      FlappyFrame theFrame = new FlappyFrame();
      theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}