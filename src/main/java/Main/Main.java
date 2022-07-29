package Main;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final String TITLE = "RoboDump";

    static GraphicsDevice ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1];


    public static void main(String[] args) {
        GameJPanel gameJPanel = new GameJPanel();
        JFrame window = new JFrame(TITLE);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(gameJPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameJPanel.startGameThread();
    }
}
