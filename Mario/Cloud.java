import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Actor
{
    int aSpeed;
    public Cloud(int speed) {
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
        aSpeed = speed;
        move(aSpeed);
    }

    protected void addedToWorld(World w)
    {
        setLocation(w.getWidth() + (this.getImage().getWidth() / 2), Greenfoot.getRandomNumber(100));     //random location for clouds 
    }

    void removeClouds() {
        if (this.getWorld() != null) {
            if (this.getX() + (this.getImage().getWidth() / 2) < 0) {
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(this.aSpeed);
        removeClouds();
    }    
}
