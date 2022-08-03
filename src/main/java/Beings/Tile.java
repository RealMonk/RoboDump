package Beings;

import java.awt.image.BufferedImage;



public class Tile {
    public BufferedImage image;
    public boolean collidable = false;

    public Tile(BufferedImage image){
        this.image = image;
    }

}
