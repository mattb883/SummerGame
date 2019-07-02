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
        
        GameGround ground = new GameGround();
        addObject(ground, getWidth()/2, 670);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("right")) {
            Image1.ActivateForwardScroll();
            Image2.ActivateForwardScroll();
        } else if (Greenfoot.isKeyDown("left")) {
            Image1.ActivateBackwardScroll();
            Image2.ActivateBackwardScroll();
        }
    }
}
