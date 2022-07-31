package Beings;

import Main.InputHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class Player extends Entity{
    InputHandler inputHandler = InputHandler.getInputHandler();
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;

    public Player(){
        this.setSpeed(4);
        this.setCordX(100);
        this.setCordY(100);
        this.setWeightless(false);

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
    public void update(){
        if (!inputHandler.shiftPressed){
            this.setSpeed(4);}
        if (inputHandler.shiftPressed){
            this.setSpeed(12);}
        if (inputHandler.upPressed){
            setCordY(super.getCordY() - getSpeed());
            this.currentSprite = up1;
        }
        if (inputHandler.downPressed){
            setCordY(super.getCordY() + getSpeed());
            this.currentSprite = down1;
        }
        if (inputHandler.leftPressed){
            setCordX(super.getCordX() - getSpeed());
            this.currentSprite = left1;
        }
        if (inputHandler.rightPressed){
            setCordX(super.getCordX() + getSpeed());
            this.currentSprite = right1;
        }
    }


}

