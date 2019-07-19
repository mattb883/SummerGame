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
    int tempBackgroundWidth = 10000;
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
     * Built-in method, no call needed.
     * Solely for the purpose of preventing clouds from spawning on top of each other.
     */
    protected void addedToWorld(World w)
    {
        while (getX() == 0 || isTouching(Cloud.class))          //check if any overlap occurs
        {
            int rndX = Greenfoot.getRandomNumber(tempBackgroundWidth);
            int rndY = Greenfoot.getRandomNumber(250);
            setLocation(rndX, rndY);
        }
    }

    /**
     * Greenfoot cycles through the act method at a speed of approximately 60 frames per second.
     * Custom methods and code that need to be constantly checked should be placed here.
     */
    public void act() 
    {
        move(this.aSpeed);              //move clouds at this random speed
    }    
}
