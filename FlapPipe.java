import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlapPipe extends FlapObject
{
   //Instantiate variables
   private int x;
   private int y;
   private int tpH;
   private int bpH;
   
   //Constructor, calls bird constructor
   public FlapPipe(int x_in, int y_in){
      super(x_in, y_in, new Color(102, 255, 102));
      x = x_in;
      y = y_in;
      bpH = 650 - y;
      tpH = y - 200;
      
      
   }
   public void draw(Graphics g, Color c)
   {
      g.setColor(c);
      g.fillRect(x,0,100,tpH);
      g.fillRect(x,y,100,bpH);
   }  
   
      //X & Y mutators
   public void setY(int y){
      this.y = y;
   }
   public void setX(int x){
      this.x = x;
   }
   
   //X & Y accessor
   public int getX(){
      return x;
   }
   public int getY(){
      return y;
   }
   

   

   

   
}