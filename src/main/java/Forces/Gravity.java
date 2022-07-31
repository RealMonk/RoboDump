package Forces;

import Beings.Entity;

public class Gravity implements Force{
    public double gravity = 2;

    @Override
    public void influence(Entity ent){
        //TODO check coord precision lose on gravity application
        if (!ent.isWeightless()) {
            ent.setCordY((int) (ent.getCordY() + gravity));
        }
    }
}
