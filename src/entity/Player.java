package entity;

import com.company.GamePanel;
import com.company.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler key;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(0, 0, 48, 48);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize*4;
        worldY = gp.tileSize*4;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/dog_up1.png") );
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/dog_up2.png") );
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/dog_down1.png") );
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/dog_down2.png") );
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/dog_left1.png") );
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/dog_left2.png") );
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/dog_right1.png") );
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/dog_right2.png") );

        }catch(IOException e){

            e.printStackTrace();
        }
    }
    public void update() {
        if(key.bottomUp)
        {
            direction = "up";
        }
        else if (key.bottomDown)
        {
            direction = "down";
        }
        else if (key.bottomLeft)
        {
            direction = "left";
        }
        else if (key.bottomRight)
        {
            direction = "right";
        }

        //checking collision with tiles
        collisionOn = false;
        gp.collisionChecker.checkTile(this);

        //if collision is false, then player can move
        if (collisionOn == false)
        {
            switch (direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
