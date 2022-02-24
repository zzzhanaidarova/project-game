package com.company;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp=gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.worldX + entity.solidArea.x;
        int entityRightX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.worldY + entity.solidArea.y;
        int entityBottomY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftColumn = entityLeftX/ gp.tileSize;
        int entityRightColumn = entityRightX/ gp.tileSize;
        int entityTopRow = entityTopY/ gp.tileSize;
        int entityBottomRow = entityBottomY/ gp.tileSize;

        int tile1, tile2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopY - entity.speed)/ gp.tileSize;
                tile1 = gp.tileManager.mapNumber[entityLeftColumn][entityTopRow];
                tile2 = gp.tileManager.mapNumber[entityRightColumn][entityTopRow];
                if (gp.tileManager.tile[tile1].collision == true || gp.tileManager.tile[tile2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomY + entity.speed)/ gp.tileSize;
                tile1 = gp.tileManager.mapNumber[entityLeftColumn][entityBottomRow];
                tile2 = gp.tileManager.mapNumber[entityRightColumn][entityBottomRow];
                if (gp.tileManager.tile[tile1].collision == true || gp.tileManager.tile[tile2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftColumn = (entityLeftX - entity.speed)/ gp.tileSize;
                tile1 = gp.tileManager.mapNumber[entityLeftColumn][entityTopRow];
                tile2 = gp.tileManager.mapNumber[entityLeftColumn][entityBottomRow];
                if (gp.tileManager.tile[tile1].collision == true || gp.tileManager.tile[tile2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightColumn = (entityRightX + entity.speed)/ gp.tileSize;
                tile1 = gp.tileManager.mapNumber[entityRightColumn][entityTopRow];
                tile2 = gp.tileManager.mapNumber[entityRightColumn][entityBottomRow];
                if (gp.tileManager.tile[tile1].collision == true || gp.tileManager.tile[tile2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
