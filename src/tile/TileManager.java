package tile;

import com.company.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapNumber;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapNumber = new int[gp.worldMaxCol][gp.worldMaxRow];
        getTileImage();
        loadMap("/world01.txt");
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tree.png"));
            tile[3].collision = true;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath)
    {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int column = 0;
            int row = 0;

            while (column<=gp.worldMaxCol && row<gp.worldMaxRow)
            {
                String line = br.readLine();
                while (column<gp.worldMaxCol)
                {
                    String[] numbers;
                    numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[column]);
                    mapNumber[column][row] = num;
                    column++;
                }
                if (column == gp.worldMaxCol)
                {
                    column = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int worldColumn = 0;
        int worldRow = 0;
        while (worldColumn <= gp.worldMaxCol && worldRow < gp.worldMaxRow)
        {
            int tileNumber = mapNumber[worldColumn][worldRow];
            int worldX = worldColumn*gp.tileSize;
            int worldY = worldRow*gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize>gp.player.worldX - gp.player.screenX && worldX - gp.tileSize<gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize>gp.player.worldY - gp.player.screenY && worldY - gp.tileSize<gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNumber].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }
            worldColumn++;

            if (worldColumn == gp.worldMaxCol)
            {
                worldColumn = 0;
                worldRow++;
            }
        }
    }
}
