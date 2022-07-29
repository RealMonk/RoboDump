package Main;

import Beings.Entity;

import javax.swing.*;
import java.awt.*;

public class EntityPainter {
    Graphics2D g;
    Entity objToDraw;
//    public EntityPainter(Graphics2D g, Entity objToDraw){
//        this.g = g;
//        this.objToDraw = objToDraw;
//    }
    public void draw(Graphics2D g, Drawable objToDraw,int tileSize){
        g.setColor(objToDraw.getColor());
        g.fillRect(objToDraw.getCordX(),objToDraw.getCordY(),tileSize,tileSize);
        g.dispose();
    }
}
