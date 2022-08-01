package Main;

import Beings.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed;
    public Entity.Direction xDirection = Entity.Direction.CENTER;
    public Entity.Direction yDirection = Entity.Direction.CENTER;



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //region v1
        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                System.out.println("Going Up");
                upPressed = true;
                if (!downPressed){
                    yDirection = Entity.Direction.UP;
                }else{
                    yDirection = Entity.Direction.CENTER;
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                System.out.println("Going Down");
                downPressed = true;
                if (!upPressed){
                    yDirection = Entity.Direction.DOWN;
                }else{
                    yDirection = Entity.Direction.CENTER;
                }
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                System.out.println("Going Left");
                leftPressed = true;
                if (!rightPressed){
                    xDirection = Entity.Direction.LEFT;
                }else{
                    xDirection = Entity.Direction.CENTER;
                }
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                System.out.println("Going Right");
                rightPressed = true;
                if (!leftPressed){
                    xDirection = Entity.Direction.RIGHT;
                }else{
                    xDirection = Entity.Direction.CENTER;
                }

            }
            case KeyEvent.VK_SHIFT -> {
                System.out.println("Going FAST");
                shiftPressed = true;

            }

        }
        //endregion

        //region v2
//        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
////              System.out.println("Going Up");
//            if (keysInputed < inputLimit)
//                upPressed = true;
//            keysInputed++;
//        }
//        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
////              System.out.println("Going Down");
//            if (keysInputed < inputLimit) {
//                downPressed = true;
//                keysInputed++;
//            }
//
//        }
//        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
////              System.out.println("Going Left");
//            if (keysInputed < inputLimit) {
//                leftPressed = true;
//                keysInputed++;
//            }
//
//        }
//        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
////          System.out.println("Going Right");
//            if (keysInputed < inputLimit) {
//                rightPressed = true;
//                keysInputed++;
//            }
//
//        }
//        if (code == KeyEvent.VK_SHIFT) {
////          System.out.println("Going FAST");
//            if (keysInputed < inputLimit) {
//                shiftPressed = true;
//                keysInputed++;
//            }
//
//        }
        //endregion

    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP ->  {
                upPressed = false;
                if (!downPressed){
                    yDirection = Entity.Direction.CENTER;
                }else{
                    yDirection = Entity.Direction.DOWN;
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                downPressed = false;
                if (!upPressed){
                    yDirection = Entity.Direction.CENTER;
                }else{
                    yDirection = Entity.Direction.UP;
                }
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                leftPressed = false;
                if (!rightPressed){
                    xDirection = Entity.Direction.CENTER;
                }else{
                    xDirection = Entity.Direction.RIGHT;
                }
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                rightPressed = false;
                if (!leftPressed){
                    xDirection = Entity.Direction.CENTER;
                }else{
                    xDirection = Entity.Direction.LEFT;
                }
            }

            case KeyEvent.VK_SHIFT -> shiftPressed = false;
//            default -> throw new IllegalStateException("Unexpected value: " + code);





        }
    }
}
