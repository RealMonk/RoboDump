package Beings;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private int cordX;
    private int cordY;
    private int speed;
    private boolean weightless;
    public BufferedImage currentSprite;
    public Color getColor() {
        return Color.CYAN;
    }

    public BufferedImage getCurrentSprite(){
        return currentSprite;
    }

    public void setWeightless(boolean weightless) {
        this.weightless = weightless;
    }

    public boolean isWeightless() {
        return this.weightless;
    }


    public abstract void update();
//    public abstract void draw(Graphics2D g);


    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }


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
