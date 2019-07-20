package com.benson.main.Entities;

import java.awt.*;

import com.benson.main.Handler;
import com.benson.main.ID;

public class Player extends Entity {
    public Player(int x, int y, int width, int height, boolean solid, ID id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
        //setVelocityX(5);
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void update() {
        x+=velocityX;
        y+=velocityY;

        if(x <= 0) x = 0;
        if(y <= 0) y = 0;
        if(x + width >= 1200) x = 1200 - width;
        //x = 0 @ bottom of white title bar, but when JFrame is created dimension includes top bar, which is why it is not 800
        if(y + height >= 765) y = 765 - height;
    }
}
