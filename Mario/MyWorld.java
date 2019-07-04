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
    GreenfootSound backgroundMusic = new GreenfootSound("3 - Map 2 (Overworld).mp3");
    private int delay;
    private int rndDelay;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1200, 800, 1, false); 

        Image1 = new Background();
        addObject(Image1, getWidth()/2, getHeight()/2);
        Image2 = new Background();
        addObject(Image2, getWidth() + getWidth()/2, getHeight()/2);

        Mario player1 = new Mario();
        addObject(player1, getWidth()/2, 50);

    }

    public void spawn() {
        delay = (delay + 1)%180;
        if (delay == 0) addObject(new Cloud(Greenfoot.getRandomNumber(4)-3), 0, 0);
    }

    public void act() {
        backgroundMusic.playLoop();
        spawn();
        if (Greenfoot.isKeyDown("right")) {
            Image1.ActivateForwardScroll();
            Image2.ActivateForwardScroll();
        } else if (Greenfoot.isKeyDown("left")) {
            Image1.ActivateBackwardScroll();
            Image2.ActivateBackwardScroll();
        }
    }
}
