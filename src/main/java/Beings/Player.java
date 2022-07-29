package Beings;

import Main.Drawable;
import Main.GameJPanel;
import Main.InputHandler;

import java.awt.*;

public class Player extends Entity{
    InputHandler inputHandler = InputHandler.getInputHandler();
    GameJPanel gJP;
    public Player(GameJPanel gJP){

        this.gJP = gJP;
        this.setSpeed(4);
        this.setCordX(100);
        this.setCordY(100);
    }

    @Override
    public void update(){
        if (inputHandler.upPressed){
            setCordY(super.getCordY() - getSpeed());}
        if (inputHandler.downPressed){
            setCordY(super.getCordY() + getSpeed());}
        if (inputHandler.leftPressed){
            setCordX(super.getCordX() - getSpeed());}
        if (inputHandler.rightPressed){
            setCordX(super.getCordX() + getSpeed());}

    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    @Override
    public int getCordX() {
        return super.getCordX();
    }

    @Override
    public int getCordY() {
        return super.getCordY();
    }

    public void draw(Graphics2D g){
        g.setColor(this.getColor());
        g.fillRect(this.getCordX(),this.getCordY(),gJP.tileSize,gJP.tileSize);

    }
}

