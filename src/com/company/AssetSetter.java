package com.company;

import object.OBJ_Bone;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){

        gp.obj[0] = new OBJ_Bone();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Bone();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;
    }
}
