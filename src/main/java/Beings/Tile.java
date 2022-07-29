package Beings;

import Main.Drawable;
import Main.GameJPanel;

import java.awt.*;

public class Tile extends Entity implements Drawable {
    private Color color;
    GameJPanel gJP;
    public Tile(GameJPanel gJP,Color color,int cordX, int cordY){
        this.gJP = gJP;
        this.color = color;
        this.setCordX(cordX);
        this.setCordY(cordY);

    }
    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColor());
        g.fillRect(this.getCordX(),this.getCordY(),gJP.tileSize,gJP.tileSize);
    }

    @Override
    public Color getColor() {
        return color;
    }

}
