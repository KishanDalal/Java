import becker.robots.*;
/**
*  Assignment: Assignment # 3
*  Submitted by: Kishan Dalal 
*  Program: Computer Systems Technology, Software Development and Network Engineering
*  File name: PutiPod.java
*  Description: Apparently, the robot called mark gets the ipod and turns on lights! 
*/

public class PutiPod
{

   public static void main(String[] args) {
      
      // Create the city
      City ny = new City();
      
      // Call the makeWalls method to create the walls
      // passing in our city (ny) as a parameter
      makeWalls(ny);

      // Create a random boolean by creating a random number
      // between 0 and 9 and checking to see whether it's even 
      boolean turnOn = ((int)(Math.random() * 10 ) % 2) == 0;
      
      // Create the iPod and set the on-screen label
      Thing iPod = new Thing(ny, 1, 0);
      iPod.getIcon().setLabel("iPod"); 
      
      // Create firstHouseFlasher and randomly turn it on
      Flasher firstHouseFlasher = new Flasher(ny, 2, 1, turnOn);
      
      // Create secondHouseFlasher and randomly turn it on note by using the not operator !, 
      // we're guaranteed one flasher will always be on and the other off
      Flasher secondHouseFlasher = new Flasher(ny, 6, 4, !turnOn);

      // Create our robot, mark
      Robot mark = new Robot(ny, 0, 6, Direction.WEST);


      // Put your code between these lines
      // a is a place value for loops, b is avenue(top to bottom), c is street (right to left)
    
      int a,b,c;
      while (mark.frontIsClear())
       {
       mark.move();
      b= mark.getAvenue();
      c= mark.getStreet();
      // Gets the item in Avenue 0 and Street 1. 
      if (mark.canPickThing()) 
      {
        if (b== 0 && c== 1)
        {
          mark.pickThing();
        }
      }
      // Makes a turn WEST on position Avenue 2 and Street 2 
      if (b== 2 && c== 2) 
      {
        for (a=1; a<=3; a++)
        {
          mark.turnLeft();
        }
        mark.move();
        //Checks if the light is on, if not the robots turns it on.
        if(!firstHouseFlasher.isOn())
        {
          firstHouseFlasher.turnOn();
        }
        //Turns to face NORTH
        for (a=1; a<=3; a++)
        {
          mark.turnLeft();
        }
      }
      // Makes a turn EAST on position Avenue 0 and Street 0  
      if (b== 0 && c== 0)
      {
        for (a=1; a<=3; a++)
        {
          mark.turnLeft();
        }
      }
      // Makes a turn SOUTH on position Avenue 1 and Street 0 
      if (b== 1 && c==0)
      {
        for(a=1; a<=3; a++)
        {
          mark.turnLeft();
        }
      }
      // Stops at position Avenue 4 and Street 6 to turn on light if not on. 
      if (b== 4 && c== 6)
      {
        if(!secondHouseFlasher.isOn())
        {
          secondHouseFlasher.turnOn();
        }
      }
      // Stops at position Avenue 2 and Street 5 to put the "ipod" and end. 
      if (b== 2 && c== 5)
      {
        mark.putThing();
        mark.turnLeft();
        mark.move();
        mark.turnLeft();
        break; 
      }
      // If the front is not clear turns left! 
      while (!mark.frontIsClear())
      {
        mark.turnLeft();
      }
    }
   
   }
   /** Create the walls that make up the 2 houses.   */
   private static void makeWalls(City city) {

      // Create the top-left house
      Wall blockStr0 = new Wall(city, 0, 0, Direction.WEST);
      Wall blockStr1 = new Wall(city, 1, 0, Direction.WEST);
      Wall blockAve1 = new Wall(city, 1, 0, Direction.SOUTH);
      Wall blockStr0E = new Wall(city, 0, 1, Direction.EAST);
      Wall blockStr1E = new Wall(city, 1, 1, Direction.EAST);
      Wall blockAve2N = new Wall(city, 0, 0, Direction.NORTH);
      Wall blockAve4N = new Wall(city, 0, 1, Direction.NORTH);
      Wall blockAve2E = new Wall(city, 1, 0, Direction.EAST);

      // Create the bottom house
      Wall blockStr0s = new Wall(city, 4, 2, Direction.WEST);
      Wall blockStr1s = new Wall(city, 5, 2, Direction.WEST);
      Wall blockAve1s = new Wall(city, 5, 2, Direction.SOUTH);
      Wall blockAve2s = new Wall(city, 5, 3, Direction.SOUTH);
      Wall blockStr0Es = new Wall(city, 4, 4, Direction.EAST);
      Wall blockStr1Es = new Wall(city, 5, 4, Direction.EAST);
      Wall blockAve2Ns = new Wall(city, 4, 2, Direction.NORTH);
      Wall blockAve3Ns = new Wall(city, 4, 3, Direction.NORTH);
      Wall blockAve4Ns = new Wall(city, 4, 4, Direction.NORTH);
      Wall blockAve2Es = new Wall(city, 5, 3, Direction.EAST);

      // Create the barriers
      Wall lower = new Wall(city, 6, 1, Direction.SOUTH);
      Wall right = new Wall(city, 6, 4, Direction.EAST);

   }
}
