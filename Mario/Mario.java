import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    static final int gravity = 2;                   //force of gravity
    static final int jumpAbility = 30;              //the jumping ability of Mario (high he can reach)
    int ySpeed = 0;                                 //the vertical speed of Mario
    boolean onPlatform;                               //checks if Mario is standing on the ground on a platform
    int groundLocation = 655;                       //y-location of top of ground
    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() 
    {
        moveVertically();       //call custom method
        moveHorizontally();     //call custom method
    } 

    public void moveHorizontally() {
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(this.getX() + 5, this.getY());
        }
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(this.getX() - 5, this.getY());
        }
    }

    /**
     * Responsible for the vertical movement of Mario,
     * Involving jumping, falling, and platform detection
     */
    public void moveVertically() {
        int worldHeight = getWorld().getHeight();
        int marioHeight = getImage().getHeight();
        boolean onPlatform = false;                         //originally, Mario is in the air

        ySpeed += gravity;                                  //represents acceleration, updates vertical speed accordingly
        setLocation(getX(), getY() + ySpeed);               //updates Mario's location based on vertical speed

        //if Mario is on the ground
        if (getY() > groundLocation) {
            setLocation(getX(), groundLocation);
            ySpeed = 0;
            onPlatform = true;
        }

        //if Mario is on a pipe
        Actor a = getOneIntersectingObject(Actor.class);
        if (a != null) {
            if (this.getY() + this.getImage().getHeight()/2 > a.getY() - a.getImage().getHeight()/2) {
                setLocation(this.getX(), a.getY() - a.getImage().getHeight()/2 - this.getImage().getHeight()/2);
                ySpeed = 0;
                onPlatform = true;
            }
        }

        //if Mario is on top of a platform or the ground and the space bar is pressed, enable jumping
        if (onPlatform && Greenfoot.isKeyDown("space")) ySpeed = -jumpAbility;
    }
}
