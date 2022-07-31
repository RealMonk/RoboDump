package Beings;

import java.awt.*;
import java.awt.image.BufferedImage;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity {
    public enum Direction {UP,DOWN,LEFT,RIGHT,CENTER}

    @Getter
    protected final Color color = Color.CYAN;

    @Getter
    protected BufferedImage currentSprite;

    @Getter
    @Setter
    protected int cordX, cordY, speed;

    @Getter
    @Setter
    private boolean weightless;

    protected int frameCounter = 0;
    protected Direction direction = Direction.CENTER;

    public abstract void update();


}
