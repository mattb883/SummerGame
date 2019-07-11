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
    GreenfootSound backgroundMusic = new GreenfootSound("world1.mp3");           //variable that stores theme music
    private int delay;                  //timer responsible for spawning clouds

    public static final int WIDE = 1200;
    public static final int HIGH = 800;

    Scroller scroller;
    Actor scrollActor;

    /**
     * This method is responsible for the setting up and the initialization of objects and variables
     */
    public MyWorld()
    {    
        super(WIDE, HIGH, 1, false);                 //create unbounded world (can spawn objects outside edges)

        GreenfootImage bg = new GreenfootImage("bg1.png");              //image is 10,000 pixels wide, memory error occurs too often
        int bgWide = bg.getWidth();
        int bgHigh = bg.getHeight();
        scroller = new Scroller(this, bg, bgWide, bgHigh);
        scrollActor = new Mario();
        addObject(scrollActor, 50, 600);
        scroll();

        Pipe pipe = new Pipe();
        addObject(pipe, 1000, 635);

        spawn();
    }

    /**
     * Custom method created to spawn cloud objects in MyWorld
     */
    public void spawn() {
        for (int i = 0; i < 30; i++) {
            Cloud cloud = new Cloud(0);
            addObject(cloud, 0, 0);
        }
    }

    private void scroll() {
        int dsx = scrollActor.getX()-WIDE/2;
        int dsy = scrollActor.getY()-HIGH/2;
        scroller.scroll(dsx, dsy);
    }

    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() {
        if (scrollActor != null) scroll();
        backgroundMusic.playLoop();                     //play music repeatedly         
    }
}
