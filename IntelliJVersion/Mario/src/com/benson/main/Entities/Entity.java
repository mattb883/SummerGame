package com.benson.main.Entities;

import com.benson.main.Handler;
import com.benson.main.ID;

import java.awt.*;

public abstract class Entity {
    public int x, y;
    public int width, height;

    public boolean solid;

    public int velocityX, velocityY;

    public ID id;

    public Handler handler;

    public Entity(int x, int y, int width, int height, boolean solid, ID id, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        this.handler = handler;
    }

    public abstract void render(Graphics g);
    public abstract void update();

    public void die() {
        handler.removeEntity(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSolid() {
        return solid;
    }

    public ID getId() {
        return id;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
}
