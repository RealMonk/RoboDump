package Beings;

import Main.GameJPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tile extends Entity {
    GameJPanel gJP;
    private final Color color;



    public Tile(GameJPanel gJP, Color color, int cordX, int cordY) {
        this.gJP = gJP;
        this.color = color;
        this.setCordX(cordX);
        this.setCordY(cordY);
        try {
            currentSprite[0] = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
            currentSprite[1] = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            currentSprite[2] = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
            currentSprite[3] = ImageIO.read(getClass().getResourceAsStream("/tiles/floor01.png"));
            currentSprite[4] = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            currentSprite[5] = ImageIO.read(getClass().getResourceAsStream("/tiles/road00.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
    }

//    @Override
//    public void draw(Graphics2D g) {
//        g.setColor(this.getColor());
//        g.fillRect(this.getCordX(),this.getCordY(),gJP.tileSize,gJP.tileSize);
//    }

    @Override
    public Color getColor() {
        return color;
    }


}
