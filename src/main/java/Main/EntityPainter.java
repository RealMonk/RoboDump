package Main;

import Beings.Entity;
import Beings.Player;
import Beings.Tile;

import java.awt.*;

public class EntityPainter {

//        public EntityPainter(Graphics2D g, Entity objToDraw){
//        this.g = g;
//        this.objToDraw = objToDraw;
//    }
    public void draw(Graphics2D g, Entity objToDraw,int imgNumber, GameJPanel gJP) {
//        if (objToDraw.getCurrentSprite(imgNumber) == null) {
//            g.setColor(objToDraw.getColor());
//            g.fillRect(objToDraw.getCordX(), objToDraw.getCordY(), gJP.tileSize, gJP.tileSize);
//        } else {
            g.drawImage(objToDraw.getCurrentSprite(imgNumber), objToDraw.getCordX(), objToDraw.getCordY(), 48, 48, null);
//        }
    }

    public void drawTile(Graphics2D g,Tile tile, int x, int y,int imgNumber, GameJPanel gJP) {

        g.drawImage(tile.getCurrentSprite(imgNumber), x, y, 48, 48, null);

    }
    public void drawCamera(Player player){

    }
}
