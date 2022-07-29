package Beings;

import Main.GameJPanel;

import java.awt.*;

public class mario extends Entity{
    GameJPanel gJP = new GameJPanel();
    @Override
    public void update() {
        //TODO impl update to monster Mario
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColor());
        g.fillRect(this.getCordX(),this.getCordY(),gJP.tileSize,gJP.tileSize);
        g.dispose();
    }


    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public int getCordX() {
        return super.getCordX();
    }

    @Override
    public int getCordY() {
        return super.getCordY();
    }
}
