package Main;

import Beings.Entity;
import Beings.Player;
import Beings.Tile;
import Beings.mario;
import Forces.Force;
import Forces.Gravity;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameJPanel extends JPanel implements Runnable {
    //INIT TIME VARs
    @Getter
    private static final int FPS = 60;
    static GameJPanel gJP = new GameJPanel();
    //INIT GRAPHICS VARs
    final static int originalTileSize = 16;
    final static int scale = 3;
    public  final int tileSize = originalTileSize * scale;
    final static int maxScreenCol = 16;
    final static int maxScreenRow = 12;
    @Getter
    final  int screenWidth = tileSize * maxScreenCol;
    @Getter
    final  int screenHeight = tileSize * maxScreenRow;

    double drawInterval = 1000000000f / FPS;
    //INIT OBJ COLLECTIONS
    List<Entity> allEntity = new ArrayList<>();
    List<Force> allForce = new ArrayList<>();

    //TEMP OBJ
    EntityPainter entityPainter;
    Player player;
    Force gravity = new Gravity();
    Tile tile1 = new Tile(this, Color.green, 0, 0);
    static int[][] map = new int[50][50];

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    int mapX = 0;
    int mapY = 0;


    InputHandler inputHandler = InputHandler.getInputHandler();
    Thread gameThread;

    public GameJPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        entityPainter = new EntityPainter();
        allEntity.add(new mario());

        allForce.add(gravity);

        player = new Player(this);


    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        map = Loader.getMap();
        double timeDelta = 0;
        long lastTime = System.nanoTime();
        long currentTIme;
        while (gameThread != null) {
            //LOOP TIME LOGIC
            currentTIme = System.nanoTime();
            timeDelta += (currentTIme - lastTime) / drawInterval;
            lastTime = currentTIme;
            if (timeDelta >= 1) {
                //MAIN GAME LOOP
                updateGameState();
                repaint();

                timeDelta--;
            }
        }
    }

    public void updateGameState() {
        gravity.influence(gJP.player);
        gJP.player.update();
    }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                mapX = x*gJP.tileSize - gJP.player.cordX + gJP.player.screenX;
                mapY = y*gJP.tileSize - gJP.player.cordY + gJP.player.screenY;
                if (x*gJP.tileSize +tileSize > gJP.player.cordX - gJP.player.screenX &&
                    x*gJP.tileSize- tileSize< gJP.player.cordX + gJP.player.screenX &&
                        y*gJP.tileSize+ tileSize> gJP.player.cordY - gJP.player.screenX &&
                        y*gJP.tileSize- tileSize< gJP.player.cordY + gJP.player.screenX) {
                    entityPainter.drawTile(g2D, tile1, mapX, mapY, map[y][x], this);
                }

            }
        }


//            Stream.of(allEntity.stream()).flatMap(s -> s).forEach(s1 -> entityPainter.draw(g2D, s1, 0, gJP));
            gJP.player.draw(g2D);


            g2D.dispose();
        }
}

