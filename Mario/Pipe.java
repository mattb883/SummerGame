import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends StationaryInteractiveObjects
{
    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() 
    {
        //moves pipe object at same velocity as background to create illusion of stationality
        if (Greenfoot.isKeyDown("right")) {
            move(-5);
        } else if (Greenfoot.isKeyDown("left")) {
            move(5);
        }
    }    
}
