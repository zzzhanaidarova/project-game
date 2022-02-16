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

    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon.png") );
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon.png") );
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon.png") );
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon.png") );
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon_left1.png") );
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon_left2.png.png") );
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon_right1.png") );
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/pokemon_right2.png.png") );

        }catch(IOException e){

            e.printStackTrace();
        }
    }
    public void update() {
            if(key.bottomUp)
            {
                direction = "up";
                y -= speed;
            }
            else if (key.bottomDown)
            {
                direction = "down";
                y += speed;
            }
            else if (key.bottomLeft)
            {
                direction = "left";
                x -= speed;
            }
            else if (key.bottomRight)
            {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if(spriteCounter > 20){
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
        //g2.setColor(Color.getHSBColor(160, 200, 230));
        //g2.fillRect(x, y, gp.titleSize, gp.titleSize);

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
        g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);

    }

}
