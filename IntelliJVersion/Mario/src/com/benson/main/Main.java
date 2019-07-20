package com.benson.main;

import com.benson.main.Entities.Player;
import com.benson.main.Input.KeyInput;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferStrategy;
import java.lang.*;

/*Runnable is an interface, "An interface in the Java programming
  language is an abstract type that is used to specify a behavior
  that classes must implement." See (https://docs.oracle.com/javase/tutorial/java/concepts/interface.html).
  The Canvas class is used instead of a JPanel for simplicity purposes.
  To use the canvas, the class must inherit from the Canvas class.
  Threads are independent path execution for IntelliJ to follow.
  Multithreading will be accomplished by defining the run() method and invoking the start() method.
  See (http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html).
  "The Java synchronized keyword is an essential tool in concurrent programming in Java.
  Its overall purpose is to only allow one thread at a time into a
  particular section of code thus allowing us to protect, for example, variables or data
  from being corrupted by simultaneous modifications from different threads."
  (https://docs.oracle.com/javase/tutorial/index.html), see the "Learning the Java Language" section for help.
*/
public class Main extends Canvas implements Runnable {
    public static final int WIDTH = 1200;                       //width of the frame
    public static final int HEIGHT = 800;                       //height of the frame
    public static final String TITLE = "MarioGame";             //stores title of game screen

    private Thread thread;                                      //creates an independent path execution for the computer to follow
    private boolean isRunning = false;                          //checks current state if program is running

    public static Handler handler;

    public Main() {

    }

    public void initialize() {
        handler = new Handler();

        addKeyListener(new KeyInput());

        handler.addEntity(new Player(300, 512, 64, 64, true, ID.player, handler));
    }

    private synchronized void start() {
        if(isRunning) return;
        isRunning = true;
        thread = new Thread(this, "Thread1");
        thread.start();
    }

    private synchronized void stop() {
        if(!isRunning) return;
        isRunning = false;
        try {
            thread.join();                                      //stops the thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {                                         //required method
        initialize();
        requestFocus();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        double ns = 1000000000.0/60.0;
        int frames = 0;
        int ticks = 0;
        while(isRunning) {
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime = now;
            while(delta>=1) {
                update();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000) {
                timer+=1000;
                System.out.println(frames + " Frames Per Second " + ticks + " Updates Per Second");
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    public void render() {                                      //render graphics, display
        BufferStrategy bs = getBufferStrategy();
        if(bs==null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(66, 200, 245));
        g.fillRect(0, 0, getWidth(), getHeight());
        handler.render(g);
        g.dispose();
        bs.show();
    }

    public void update() {
        handler.update();
    }

    /**
     * The main method is a mandatory method that IntelliJ automatically
     * finds and executes.
     * Consequently, it does not need to be called from other methods or
     * classes. It is always run by the main thread.
     */
    public static void main(String[] args) {
        Main main = new Main();                                 //creates a new Main object
        JFrame frame = new JFrame(TITLE);                       //creates a new frame object for display
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));   //preferred size of frame is set to 1200, 800 using the Dimension class
        frame.add(main);                                        //adding the Main object to the JFrame
        frame.pack();                                           //no further objects to be added, size the frame
        frame.setResizable(false);                              //remove ability to resize frame
        frame.setLocationRelativeTo(null);                      //center frame on computer screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //program will close if exit button is pressed (default)
        frame.setVisible(true);                                 //make the frame visible
        main.start();                                           //calls custom start method to begin program
    }
}
