import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{
    int acceleration = 2;
    int vSpeed = 0;
    int jumpAbility = 12;
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.isKeyDown("space") && onGround())
       {
          jump(); 
       }
       checkFall();
    }    
    
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, GameGround.class);
        return under != null;
    }
    
    public void Fall()
    {
        setLocation (getX(), getY() + vSpeed);
        vSpeed = vSpeed += acceleration;
    }
    
    public void checkFall()
    {
        if (onGround())
        {
            vSpeed = 0;
        }
        else {
            Fall();
        }
    }
    
    public void jump()
    {
       vSpeed = -jumpAbility;
       Fall();
    }
}
