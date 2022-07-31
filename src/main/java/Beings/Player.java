package Beings;

import Main.InputHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    static public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    static final private InputHandler inputHandler = InputHandler.getInputHandler();

    public Player() {
        this.setSpeed(4);
        this.setCordX(100);
        this.setCordY(100);
        this.setWeightless(true);

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/walk/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.currentSprite = down1;
    }

    @Override
    public void update() {

        frameCounter = frameCounter <= 60 ? frameCounter + 1 //yes
                :  0;              //no

        if (!inputHandler.shiftPressed) {
            this.setSpeed(4);
        }
        if (inputHandler.shiftPressed) {
            this.setSpeed(12);
        }
        switch (inputHandler.xDirection){
            case LEFT -> {cordX -= speed; direction = Direction.LEFT;}
            case RIGHT -> {cordX += speed;direction = Direction.RIGHT;}
        }
        switch (inputHandler.yDirection){
            case UP -> {cordY -= speed; direction = Direction.UP;}
            case DOWN -> {cordY += speed; direction = Direction.DOWN;}

        }

        switch (direction){
            case LEFT -> this.currentSprite = left1;
            case RIGHT -> this.currentSprite = right1;
            case UP -> this.currentSprite = up1;
            case DOWN -> this.currentSprite = down1;
        }


    }


//        if (!inputHandler.shiftPressed) {
//            this.setSpeed(4);
//        }
//        if (inputHandler.shiftPressed) {
//            this.setSpeed(12);
//        }
//        if (inputHandler.upPressed) {
//            cordY = getCordY() - getSpeed();
//            direction = Direction.UP;
//            this.currentSprite = up1;
//        }
//        if (inputHandler.downPressed) {
//            cordY = getCordY() + getSpeed();
//            this.currentSprite = down1;
//            direction = Direction.DOWN;
//        }
//        if (inputHandler.leftPressed) {
//            cordX = getCordX() - getSpeed();
//            this.currentSprite = left1;
//            direction = Direction.LEFT;
//        }
//        if (inputHandler.rightPressed) {
//            cordX= getCordX() + getSpeed();
//            this.currentSprite = right1;
//            direction = Direction.RIGHT;
//        }
//    }


}

