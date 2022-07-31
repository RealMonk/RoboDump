package Main;

import Beings.Entity;

import javax.swing.*;
import java.awt.*;

public class EntityPainter {

//    public EntityPainter(Graphics2D g, Entity objToDraw){
//        this.g = g;
//        this.objToDraw = objToDraw;
//    }
    public void draw(Graphics2D g, Entity objToDraw,GameJPanel gJP) {
        if (objToDraw.getCurrentSprite() == null){
            g.setColor(objToDraw.getColor());
        g.fillRect(objToDraw.getCordX(), objToDraw.getCordY(), gJP.tileSize, gJP.tileSize);
        } else{
            g.drawImage(objToDraw.getCurrentSprite(),objToDraw.getCordX(),objToDraw.getCordY(),48,48,null);
        }
    }
}
