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
        int dx = 0;
        if (Greenfoot.isKeyDown("left")) dx--;
        if (Greenfoot.isKeyDown("right")) dx++;
        if (dx == 0) return;
        setLocation(getX()+dx*5, getY());
        
        Actor a = getOneIntersectingObject(Obstacles.class);
        if (a == null) return;
        setLocation(a.getX()-dx*((getImage().getWidth()+a.getImage().getWidth())/2+1), getY());
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

        //allows jumping on platforms
        Actor a = getOneIntersectingObject(Obstacles.class);
        if (a != null) {
            int dy = (int)Math.signum(ySpeed);
            setLocation(getX(), a.getY()-dy*((a.getImage().getHeight()+getImage().getHeight())/2+1));
            if (dy > 0) onPlatform = true;
            ySpeed = 0;
        }

        //collision detection from bottom of objects, make Mario fall down
        int dy = (int)Math.signum(ySpeed);
        while (getOneIntersectingObject(Obstacles.class) != null) {
            setLocation(getX(), getY()-dy);
            if(dy>0) onPlatform = true;
            ySpeed = 0;
        }

        //if Mario is on top of a platform or the ground and the space bar is pressed, enable jumping
        if (onPlatform && Greenfoot.isKeyDown("space")) ySpeed = -jumpAbility;
    }
}
