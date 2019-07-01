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
     * Act - do whatever the Scroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Sets location of two identical images to be linked together.
     * Both images move simultaneously.
     */
    public void ActivateScroll() {
        if (getX() < -getImage().getWidth()/2) {
            setLocation(getWorld().getWidth() + 595, getY());
        }
        setLocation(getX() - 5, getY());
    }
}
