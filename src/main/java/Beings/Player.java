package Beings;

import Main.GameJPanel;
import Main.InputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.ArrayList;

public class Player extends Entity {
    GameJPanel gJP;
    static public int frameNumber = 0;
    private final int animationSpeed = 2;
    boolean standing = false;
    int standingCounter = 0;
    private final InputHandler inputH;
    private final BufferedImage[] up = new BufferedImage[2];
    private final BufferedImage[] down = new BufferedImage[2];
    private final BufferedImage[] left = new BufferedImage[2];
    private final BufferedImage[] right = new BufferedImage[2];
    public int cordX, cordY, speed;
    public final int screenX;
    public final int screenY;
    public Player(GameJPanel gJP,InputHandler inputH) {
        this.gJP = gJP;
        this.inputH = inputH;
        this.speed = 2;
        this.cordX = 100;
        this.cordY = 100;
        this.setWeightless(true);
        screenX = gJP.getScreenWidth()/2 - (gJP.tileSize/2);
        screenY = gJP.getScreenHeight()/2 - (gJP.tileSize/2);

        try {
            up[0] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_up_1.png"));
            up[1] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_up_2.png"));
            down[0] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_down_1.png"));
            down[1] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_down_2.png"));
            left[0] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_left_1.png"));
            left[1] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_left_2.png"));
            right[0] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_right_1.png"));
            right[1] = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.currentSprite[0] = down[0];
    }

    @Override
    public void update() {

        if  (inputH.xDirection == Direction.CENTER && inputH.yDirection == Direction.CENTER){
            if (standingCounter < 21){
                standingCounter++;
            } else {
                frameNumber = 0;
                standing = true;
            }
        } else {
            standingCounter = 0;
        }

        if (inputH.shiftPressed) {
            speed = 4;
        } else {
            speed = 3;
        }

        switch (inputH.xDirection){
            case LEFT -> {this.cordX -= speed; direction = Direction.LEFT; }
            case RIGHT -> {this.cordX += speed;direction = Direction.RIGHT; }
        }

        switch (inputH.yDirection){
            case UP -> {cordY -= speed; direction = Direction.UP; }
            case DOWN -> {cordY += speed; direction = Direction.DOWN; }
        }

        switch (direction){
            case LEFT -> {this.currentSprite[0] = left[frameNumber];}
            case RIGHT -> {this.currentSprite[0] = right[frameNumber];}
            case UP -> {this.currentSprite[0] = up[frameNumber];}
            case DOWN -> {this.currentSprite[0] = down[frameNumber];}
        }

        if (!(inputH.yDirection == Direction.CENTER) || !(inputH.xDirection == Direction.CENTER)){
            animationForward();
        }

    }

    public void drawPlayer(Graphics2D g2D){
        g2D.drawImage(currentSprite[0],screenX,screenY,gJP.tileSize,gJP.tileSize,null);

    }
    private void animationForward(){
        int frameCycle = GameJPanel.getFPS() / (speed / animationSpeed);
        frameCounter = frameCounter <= frameCycle ? frameCounter + 1 //yes
                                                  :  0;              //no
        if (frameCounter <= frameCycle / 2 ){
            frameNumber = 0;
        }else {
            frameNumber = 1;
        }
    }
}

