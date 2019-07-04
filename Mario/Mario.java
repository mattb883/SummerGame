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
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveVertically();
    }    
    
    private void moveVertically() {
        int worldHeight = getWorld().getHeight();
        int marioHeight = getImage().getHeight();
        boolean onGround = false;
        
        ySpeed += gravity;
        setLocation(getX(), getY() + ySpeed);
        
        if (getY() > 698) {
            setLocation(getX(), 698);
            ySpeed = 0;
            onGround = true;
        }
        /*
        int dy = (int)Math.signum(ySpeed);
        while (getOneIntersectingObject(null) != null) {
            setLocation(getX(), getY()-dy);
            if (dy>0) onGround = true;
            ySpeed = 0;
        }
        */
        if (onGround && Greenfoot.isKeyDown("space")) ySpeed = -jumpAbility;
    }
}
