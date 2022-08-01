package Main;

import Beings.Entity;
import Beings.Player;
import Beings.TileManager;
import Beings.mario;
import Forces.Force;
import Forces.Gravity;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    public Player player;
    Force gravity = new Gravity();
    TileManager tileManager;

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;



    InputHandler inputH;
    Thread gameThread;

    public GameJPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        allEntity.add(new mario());
        allForce.add(gravity);
        inputH = new InputHandler();
        this.addKeyListener(inputH);
        player = new Player(this,inputH);
        tileManager = new TileManager(this,player);
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
        gravity.influence(player);
        player.update();
    }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
//      Stream.of(allEntity.stream()).flatMap(s -> s).forEach(s1 -> entityPainter.draw(g2D, s1, 0, gJP));
        tileManager.drawTiles(g2D);
        player.drawPlayer(g2D);
        g2D.dispose();
        }
}

