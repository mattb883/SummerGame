package com.benson.main.Input;

import com.benson.main.Entities.Entity;
import com.benson.main.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param arg0
     */
    @Override
    public void keyTyped(KeyEvent arg0) {
        //NA
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for(Entity en : Main.handler.entity) {
            switch(key) {
                case KeyEvent.VK_W:
                    en.setVelocityY(-5);
                    break;
                case KeyEvent.VK_S:
                    en.setVelocityY(5);
                    break;
                case KeyEvent.VK_A:
                    en.setVelocityX(-5);
                    break;
                case KeyEvent.VK_D:
                    en.setVelocityX(5);
                    break;
            }
        }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(Entity en : Main.handler.entity) {
            switch(key) {
                case KeyEvent.VK_W:
                    en.setVelocityY(0);
                    break;
                case KeyEvent.VK_S:
                    en.setVelocityY(0);
                    break;
                case KeyEvent.VK_A:
                    en.setVelocityX(0);
                    break;
                case KeyEvent.VK_D:
                    en.setVelocityX(0);
                    break;
            }
        }
    }
}
