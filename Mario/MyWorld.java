import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Matthew Benson, Daniel Olinyk 
 * @version 1.0
 */
public class MyWorld extends World
{
    public Background Image1, Image2;                             //images merged together to create illusion of scrolling background
    GreenfootSound backgroundMusic = new GreenfootSound("3 - Map 2 (Overworld).mp3");           //variable that stores theme music
    private int delay;                  //timer responsible for spawning clouds
    boolean allowed;                    //checks if screen is able to scroll (if object is in the way of Mario);
    /**
     * This method is responsible for the setting up and the initialization of objects and variables
     */
    public MyWorld()
    {    
        super(1200, 800, 1, false);                 //create unbounded world (can spawn objects outside edges)

        allowed = true;                                                     //at the start of the game, scrolling is enabled

        Image1 = new Background();
        addObject(Image1, getWidth()/2, getHeight()/2);
        Image2 = new Background();
        addObject(Image2, getWidth() + getWidth()/2, getHeight()/2);

        Mario player1 = new Mario();
        addObject(player1, getWidth()/2, 690);

        Pipe pipe = new Pipe();
        addObject(pipe, 900, 679);
    }

    /**
     * Custom method created to spawn cloud objects in MyWorld
     */
    public void spawn() {
        delay = (delay + 1)%180;            //spawns clouds every 3 seconds
        
        //each cloud has a random speed(range)
        //position is set of (0,0) because position will be manually adjusted using the addedToWorld(World w) method in the cloud class
        if (delay == 0) addObject(new Cloud(Greenfoot.getRandomNumber(4)-3), 0, 0);
    }

    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() {
        backgroundMusic.playLoop();                     //play music repeatedly         
        spawn();                                        //call custom method

        //if Mario is not touching an object (in the x), then to enable screen scrolling
        if (allowed) {                                  
            if (Greenfoot.isKeyDown("right")) {
                Image1.ActivateForwardScroll();
                Image2.ActivateForwardScroll();
            } else if (Greenfoot.isKeyDown("left")) {
                Image1.ActivateBackwardScroll();
                Image2.ActivateBackwardScroll();
            }
        }
    }
}
