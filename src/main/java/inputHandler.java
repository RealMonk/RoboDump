import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W -> {
                System.out.println("Going Up");
                upPressed = true;
            }
            case KeyEvent.VK_S -> {
                System.out.println("Going Down");
                downPressed = true;
            }
            case KeyEvent.VK_A -> {
                System.out.println("Going Left");
                leftPressed = true;
            }
            case KeyEvent.VK_D -> {
                System.out.println("Going Right");
                rightPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W -> {
                System.out.println("Going Up");
                upPressed = false;
            }
            case KeyEvent.VK_S -> {
                System.out.println("Going Down");
                downPressed = false;
            }
            case KeyEvent.VK_A -> {
                System.out.println("Going Left");
                leftPressed = false;
            }
            case KeyEvent.VK_D -> {
                System.out.println("Going Right");
                rightPressed = false;
            }
        }
    }
}
