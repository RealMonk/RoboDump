package Forces;

import Beings.Entity;
import Beings.Player;

public class Gravity implements Force{
    public int gravity = 2;

    @Override
    public void influence(Player ent){
        //TODO check coord precision lose on gravity application
        if (!ent.isWeightless()) {
            ent.cordY=(ent.cordY + gravity);
        }
    }
}
