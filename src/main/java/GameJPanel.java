import javax.swing.*;
import java.awt.*;

public class GameJPanel extends JPanel implements Runnable {


    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize= originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    final int FPS = 60;

    int pX,pY = 100;
    int speed = 4;

    inputHandler inputHandler = new inputHandler();
    Thread gameThread;

    public GameJPanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {


        while (gameThread != null) {
            System.out.println("Running");

            //UPDATE GAME STATE
            updateGameState();
            //DRAW
            repaint();
        }
    }

    public void updateGameState(){
        if(inputHandler.upPressed){
            pY -=speed;}
        else if (inputHandler.downPressed){
            pY +=speed;
        }else if (inputHandler.leftPressed){
            pX -=speed;
        }else if (inputHandler.rightPressed){
            pX +=speed;
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setColor(Color.white);
        g2D.fillRect(pX,pY,tileSize,tileSize);
        g2D.dispose();
    }

}
