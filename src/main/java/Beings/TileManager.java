package Beings;

import Main.GameJPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class TileManager {
    public final int worldMaxWidth;
    public final int worldMaxHeight;
    GameJPanel gJP;
    BufferedImage[] currentSprite = new BufferedImage[100];
    private final int[][] world;
    private final Player player;

    public TileManager(GameJPanel gJP,Player player) {
        this.gJP = gJP;
        this.player = player;
        worldMaxWidth = gJP.tileSize * gJP.maxWorldCol;
        worldMaxHeight = gJP.tileSize * gJP.maxWorldRow;
        world = new int[gJP.maxWorldRow][gJP.maxWorldCol];
        getMap();
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

    public void getMap() {

        System.out.println("Loading map");
        Scanner sc = new Scanner(getClass().getResourceAsStream("/levels/world01.txt"));
        while (sc.hasNext()) {
            for (int y = 0; y < 50; y++) {
                System.out.println();
                String[] stringLine = sc.nextLine().split(" ");
                for (int x = 0; x < 50; x++) {
                    world[y][x] = Integer.parseInt(stringLine[x]);
                    System.out.print(world[y][x]);
                }
            }
        }
        System.out.println();
        System.out.println("Finished loading map");
    }

    public void drawTiles(Graphics2D g) {
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                int mapX = x * gJP.tileSize - player.cordX + player.screenX;
                int mapY = y * gJP.tileSize - player.cordY + player.screenY;
                if (x * gJP.tileSize + gJP.tileSize > player.cordX - player.screenX &&
                    x * gJP.tileSize - gJP.tileSize < player.cordX + player.screenX &&
                    y * gJP.tileSize + gJP.tileSize > player.cordY - player.screenX &&
                    y * gJP.tileSize - gJP.tileSize < player.cordY + player.screenX) {
                    g.drawImage(currentSprite[world[y][x]], mapX, mapY, 48, 48, null);
                }
            }
        }
    }
}