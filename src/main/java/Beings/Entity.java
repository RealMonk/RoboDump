package Beings;

import java.awt.*;
import java.awt.image.BufferedImage;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity {
    public enum Direction {UP,DOWN,LEFT,RIGHT,CENTER}
    public int cordX, cordY, speed;
    @Getter
    protected final Color color = Color.CYAN;
    protected BufferedImage[] currentSprite = new BufferedImage[10];

    public Rectangle collisionArea;
    public boolean collided = false;

    @Getter
    @Setter
    private boolean weightless;

    protected int frameCounter = 0;
    public Direction direction = Direction.CENTER;

    public abstract void update();


}
