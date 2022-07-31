package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed,shiftPressed;
    static private InputHandler ih;

    private InputHandler(){}
//    private static final InputHandler inputHandlerObj = new InputHandler();

    public static InputHandler getInputHandler(){
        if (ih == null) {
            ih = new InputHandler();
        }
        return ih;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP-> {
                System.out.println("Going Up");
                upPressed = true;
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN-> {
                System.out.println("Going Down");
                downPressed = true;
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT-> {
                System.out.println("Going Left");
                leftPressed = true;
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT-> {
                System.out.println("Going Right");
                rightPressed = true;
            }
            case KeyEvent.VK_SHIFT -> {
                System.out.println("Going FAST");
                shiftPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W,KeyEvent.VK_UP -> {
                upPressed = false;
            }
            case KeyEvent.VK_S,KeyEvent.VK_DOWN -> {
                downPressed = false;
            }
            case KeyEvent.VK_A,KeyEvent.VK_LEFT -> {
                leftPressed = false;
            }
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT -> {
                rightPressed = false;
            }
            case KeyEvent.VK_SHIFT -> {
                shiftPressed = false;
            }
        }
    }
}
