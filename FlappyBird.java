import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlappyBird extends FlapObject
{
   //Instantiate variables
   private int x;
   private int y;
   
   //Constructor, calls bird constructor
   public FlappyBird(int x_in, int y_in){
      super(x_in, y_in, new Color(255, 204, 51));
      x = x_in;
      y = y_in;
      
      
   }
   public boolean isOnCeiling(){
      if(y-40<=0)
         return true;
      else
         return false;
   }
   public boolean isOnGround(){
      if(y>=650)
         return true;
      else
         return false;
   }
   public void draw(Graphics g, Color c, double jump){
      
      //Bird Coming Down
      // x coordinates of vertices
      int xCDown[] = { x, x-24, x-12, x-22, x, x+6, x+8, x+16, x+24, x+24 };
      // y coordinates of vertices
      int yCDown[] = { y, y-24,y-24,y-40,y-30,y-24, y-24, y-40, y-24, y-16 };
      // x coordinates of vertices
      
      //Bird Going Up
      int xCFlap[] = { x, x-24, x-12, x-22, x, x+6, x+8, x+16, x+24, x+24 };
      // y coordinates of vertices
      int yCFlap[] = { y, y-24,y-24,y,y-10,y-24, y-24, y-40, y-24, y-16 };
      // number of vertices
      int numberofpoints = 10;
      
      //Bird Going down
      // x coordinates of vertices
      int xCFlapCover[] = {  x-12, x-22, x, x+6 };
      // y coordinates of vertices
      int yCFlapCover[] = { y-24,y,y-10,y-24};
      // number of vertices
      int numberofpointsCover = 4;
   
      // set the color of line drawn to blue
      g.setColor(Color.RED);
  
      // draw the polygon using drawPolygon function
      if(jump<=2.5){
         g.fillPolygon(xCDown, yCDown, numberofpoints);
         g.setColor(Color.BLACK);
         g.drawPolygon(xCDown, yCDown, numberofpoints);
      }
      if(jump>2.5){
         g.fillPolygon(xCFlap, yCFlap, numberofpoints);
         g.setColor(Color.BLACK);
         g.drawPolygon(xCFlap, yCFlap, numberofpoints);
         g.setColor(Color.RED);
         g.fillPolygon(xCFlapCover, yCFlapCover, numberofpointsCover);

      }
      //Beak
      int xCB[] = {x+24,x+30, x+24 };
  
      // y coordinates of vertices
      int yCB[] = { y-24,y-20, y-16 };
      int numberofpointsB = 3;
      g.setColor(c);
      g.fillPolygon(xCB, yCB, numberofpointsB);
      g.setColor(Color.BLACK);
      g.drawPolygon(xCB, yCB, numberofpointsB);
      //Eyes
      g.setColor(Color.WHITE);
      g.fillOval(x+13,y-30,8,8);
      g.setColor(Color.BLACK);
      g.fillOval(x+15,y-30,6,6);
     
      
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