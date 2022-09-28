import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class FlappyPanel extends JPanel
{
   //Declare Variables
   private FlappyPanel p;
   private int cloudY = 0;
   private boolean flip = true;
   private int count;
   private PipeLinkedList pL = new PipeLinkedList();
   private Random rand = new Random();
   private FlappyBird bird;
   private int N = 1;
   private double jump;

   
   
   public FlappyPanel()
   {
      //Add listeners
      p = this;
      addKeyListener(new KeyEventDemo());
      Timer t = new Timer(10, new TimeListener());
      setPreferredSize(new Dimension(1600, 800));
      setFocusable(true);
      FlapPipe first = new  FlapPipe(1600, 200+rand.nextInt(500));
      pL.addToFront(first);
      bird = new FlappyBird(100,100);
      //Start Timer
      t.start();

   }
   
   public void paintComponent(Graphics g)    
   {  

      super.paintComponent(g);
      
      //Background
      g.setColor(new Color (51, 153, 255));
      g.fillRect(0, 0, 1600, 650);
      g.setColor(new Color (0, 153, 0));
      g.fillRect(0,650, 1600, 200);
      g.setColor(new Color (153, 102, 0));
      //g.fillRect(0,675, 1600, 200);
      //Clouds
      g.setColor(Color.WHITE);
      g.fillOval(350,cloudY + 200, 200, 100);
      g.fillOval(450,cloudY + 200, 200, 100);
      g.fillOval(400,cloudY + 150, 200, 100);
      g.fillOval(900,cloudY + 400, 200, 100);
      g.fillOval(1000,cloudY + 400, 200, 100);
      g.fillOval(950,cloudY + 350, 200, 100);
      
      for(int i=0;i<pL.length();i++){
         pL.getPipeAt(i).draw(g,new Color(0,255,0));
      }
      bird.draw(g,new Color(255, 204, 51),jump);
   }
     
   public class TimeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
         if(count%2 == 0){ //Cloud movement
            if(cloudY >= 0 && cloudY <= 25 && flip){
                 cloudY++;
               }
            else if(cloudY != 0){
              flip = false;
              cloudY--;
            }
            else
               flip = true;
         }
         
         //Add Pipes
         if(pL.getPipeAt(0).getX() == 0 ||
            pL.getPipeAt(0).getX() == 400 ||
            pL.getPipeAt(0).getX() == 800 ||
            pL.getPipeAt(0).getX() == 1200){
               FlapPipe newPipe = new  FlapPipe(1600, 200+rand.nextInt(500));
               pL.addToEnd(newPipe);
         }
         //Remove Pipe 
         if(pL.getPipeAt(0).getX()+100 == 0){
               pL.deleteHead();
         }
         
         //Move Pipes Back  
         for(int i=0;i<pL.length();i++){
            int temp = pL.getPipeAt(i).getX();
            pL.getPipeAt(i).setX(temp-2);
         }
         //If player hits ceiling while jumping
         if(bird.isOnCeiling())
         {
            jump = 0;
         }
         if(bird.isOnGround())
         {
            OptionPane loss = new OptionPane();
         }
         
         //Gravity
         //Increment gravity by timer ticks
         if(count % 20 == 0)
         {
            if(N<7)
            {
               N+=1;
            }
         }
        
         //Move player for gravity
         for(int i=0;i<N;i++)
         {
            int temp = bird.getY();
            bird.setY(temp+1);
         }
         
         
         //Jump movement
         if(jump>0)
         {
            for(int i=0;i<jump;i++)
            {              
               int temp = bird.getY();
               bird.setY(temp-1);
            }
            jump-=0.1; 
         }
         
         //Collide with pipe
         if(((bird.getX()+30 == pL.getHead().getX()) &&
            (bird.getY() >= pL.getHead().getY())) ||
            ((bird.getX()+30 == pL.getHead().getX()) &&
            (bird.getY() <= pL.getHead().getY()-160))){
               OptionPane loss = new OptionPane();
            }
         if((bird.getY() >= pL.getHead().getY()) &&
            ((bird.getX() >= pL.getHead().getX()) && (bird.getX() <= pL.getHead().getX()+100))){
               OptionPane loss = new OptionPane();
            }
            
          if((bird.getY() <= pL.getHead().getY()-160) &&
            ((bird.getX() >= pL.getHead().getX()) && (bird.getX() <= pL.getHead().getX()+100))){
               OptionPane loss = new OptionPane();
            }
         
         count++;
         p.repaint();
            
      } 
   }
     //Key listener
   public class KeyEventDemo  implements KeyListener 
   {
      public void keyTyped(KeyEvent e) {
        //If player is on ground, set jump values

      }
      public void keyReleased(KeyEvent e){} 
      public void keyPressed(KeyEvent e) 
      {
                 if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
           jump = 5;

           N=1; 
        }

      }
   }
   //Option Pane class for when player hits victory block
   public class OptionPane 
   {  
      OptionPane()
      {  
         JOptionPane.showMessageDialog(p,"Wow, you are really bad at this, huh?","You Suck!",JOptionPane.WARNING_MESSAGE);   
         System.exit(1);  
      }  
   }
} 

