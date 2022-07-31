package Main;

import Beings.Entity;
import Beings.Player;
import Beings.Tile;
import Beings.mario;
import Forces.Force;
import Forces.Gravity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameJPanel extends JPanel implements Runnable {
    static GameJPanel gJP = new GameJPanel();
    //INIT GRAPHICS VARs
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    //INIT TIME VARs
    final int FPS = 60;
    double drawInterval = 1000000000f / FPS;
    //INIT OBJ COLLECTIONS
    List<Entity> allEntity = new ArrayList<>();
    List<Force> allForce = new ArrayList<>();
    List<Entity> allTiles = new ArrayList<>();
    //TEMP OBJ
    EntityPainter entityPainter;
    Player player = new Player();
    Force gravity = new Gravity();
    Tile tile1 = new Tile(this, Color.green, 0, 0);


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
        allEntity.add(player);
        allForce.add(gravity);
        allTiles.add(tile1);

    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
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
        for (Entity e : allEntity
        ) {
            for (Force f : allForce
            ) {
                f.influence(e);
            }
            e.update();
        }

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        //DRAWING ALL ENTITIES
        Stream.of(allTiles.stream(), allEntity.stream()).flatMap(s -> s).forEach(s1 -> entityPainter.draw(g2D, s1, gJP));
        g2D.dispose();
    }

}
