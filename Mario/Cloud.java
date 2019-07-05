import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Actor
{
    int aSpeed;                     //holds random speed of cloud objects
    /**
     * This method is responsible for the setting up and the initialization of objects and variables.
     * This constructor has a parameter, meaning that spawning this actor in world classes will need to set that parameter in brackets.
     */
    public Cloud(int speed) {
        //using cases to generate a random cloud out of three different clouds
        int rndCloud = Greenfoot.getRandomNumber(3);
        switch(rndCloud) {
            case 0:
            setImage("Cloud1.png");
            break;

            case 1:
            setImage("Cloud2.png");
            break;

            case 2:
            setImage("Cloud3.png");
            break;
        }
        
        //update aSpeed
        aSpeed = speed;
        move(aSpeed);
    }

    /**
     * Built-in method.
     */
    protected void addedToWorld(World w)
    {
        setLocation(w.getWidth() + (this.getImage().getWidth() / 2), Greenfoot.getRandomNumber(100));     //random location for clouds 
    }

    /**
     * Removes clouds when no longer needed, to save space.
     */
    void removeClouds() {
        if (this.getWorld() != null) {
            if (this.getX() + (this.getImage().getWidth() / 2) < 0) {           //tests if cloud objects pass left edge of screen
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() 
    {
        move(this.aSpeed);              //move clouds at this random speed
        removeClouds();                 //call custom method
    }    
}
