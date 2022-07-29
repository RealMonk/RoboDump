package Beings;

import Main.Drawable;

import java.awt.*;

public abstract class Entity implements Drawable {
    private int cordX;
    private int cordY;
    private int speed;
    public abstract void update();
    public abstract void draw(Graphics2D g);

    @Override
    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    @Override
    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
