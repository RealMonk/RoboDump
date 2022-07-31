package Beings;

import java.awt.*;

public class mario extends Entity{
    public mario(){
        setWeightless(true);
        setCordX(300);
        setCordY(500);
    }

    @Override
    public void update() {
        //TODO impl update to monster Mario
    }


    @Override
    public Color getColor() {
        return Color.RED;
    }


}
