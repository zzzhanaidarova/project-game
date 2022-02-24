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
    Tile[] tile;
    int mapNumber[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapNumber = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/map01.txt");
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/water.png"));
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

            while (column<gp.maxScreenCol && row<gp.maxScreenRow)
            {
                String line = br.readLine();
                while (column<gp.maxScreenCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[column]);
                    mapNumber[column][row] = num;
                    column++;
                }
                if (column == gp.maxScreenCol)
                {
                    column = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){
        }
    }

    public void draw(Graphics2D g2){
        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (column<=gp.maxScreenCol && row<gp.maxScreenRow)
        {
            int tileNumber = mapNumber[column][row];
            g2.drawImage(tile[tileNumber].image, x, y, gp.tileSize, gp.tileSize, null);
            column++;
            x += gp.tileSize;
            if (column == gp.maxScreenCol)
            {
                column = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
