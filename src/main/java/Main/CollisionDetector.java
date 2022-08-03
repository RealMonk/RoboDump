package Main;

import Beings.Entity;

public class CollisionDetector {
    GameJPanel gJP;
    public CollisionDetector(GameJPanel gJP) {
        this.gJP = gJP;
    }

    public void checkTile(Entity entity){
        int entityLeftCordX = entity.cordX + entity.collisionArea.x;
        int entityRightCordX = entity.cordX + entity.collisionArea.x + entity.collisionArea.width;
        int entityTopCordY = entity.cordY + entity.collisionArea.y;
        int entityBottomCordY = entity.cordY + entity.collisionArea.y + entity.collisionArea.height;

        int entityLeftCol = entityLeftCordX / gJP.tileSize;
        int entityRightCol = entityRightCordX / gJP.tileSize;
        int entityTopRow = entityTopCordY / gJP.tileSize;
        int entityBottomRow = entityBottomCordY / gJP.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case UP :
                entityTopRow = (entityTopCordY - entity.speed) / gJP.tileSize;
                tileNum1 = gJP.tileManager.world[entityLeftCol][entityTopRow];
                tileNum2 = gJP.tileManager.world[entityRightCol][entityTopRow];
                if (gJP.tileManager.tiles[tileNum1].collidable || gJP.tileManager.tiles[tileNum2].collidable) {
                    entity.collided = true;
                }

            case DOWN : {entityBottomRow = (entityTopCordY - entity.speed) / gJP.tileSize;}
        }
    }
}
