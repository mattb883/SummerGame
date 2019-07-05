import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scrolls the screen.
 * 
 * @author Matthew Benson, Daniel Olinyk
 * @version 1.0
 */
public class Scroll extends Actor
{
    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() 
    {
        //none
    }    
    
    /**
     * Sets location of two identical images to be linked together.
     * Both images move simultaneously.
     */
    public void ActivateForwardScroll() {
        if (getX() < -getImage().getWidth()/2) {
            setLocation(getWorld().getWidth() + 595, getY());
        }
        setLocation(getX() - 5, getY());
    }
    
    /**
     * Sets location of two identical images to be linked together.
     * Both images move simultaneously.
     */
    public void ActivateBackwardScroll() {
        if (getX() > getImage().getWidth() + getImage().getWidth()/2) {
            setLocation(-595, getY());
        }
        setLocation(getX() + 5, getY());
    }
}
