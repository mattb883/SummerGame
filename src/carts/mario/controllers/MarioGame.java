package carts.mario.controllers;

import javax.swing.*;
import java.awt.*;

public class MarioGame {
    private JPanel GameScreen;

    private MarioGame() {
        //initialization, action events, and static variable declaration here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SuperMario");          //create screen
        frame.setSize(1200, 600);     //set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //ends program by default
        frame.getContentPane().add(new MarioGame().GameScreen);        //create panel
        frame.pack();                                           //physical size or creation of screen stays the same, therefore finalize
        //frame.setResizable(false);                      //remove ability to resize screen
        frame.setVisible(true);                             //make screen visible
    }
















}
