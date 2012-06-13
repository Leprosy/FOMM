package RPG;

import java.io.DataInputStream;
import java.io.FileInputStream;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author mrojas
 */
public class Map {

    protected Tile[][] tiles;
    public int startX;
    public int startY;

    public Map(String file) {
        try {
            DataInputStream os = new DataInputStream(new FileInputStream(getClass().getResource("/Assets/maps/" + file).getFile()));

            //Read
            int W = os.readByte();
            int H = os.readByte();

            this.tiles = new Tile[W][H];

            this.startX = os.readByte();
            this.startY = os.readByte();

            // Save bytes of map
            for (int i = 0; i < W; ++i) {
                for (int j = 0; j < H; ++j) {
                    this.tiles[i][j] = new RPG.Tile();
                    this.tiles[i][j].base  = os.readByte();
                    this.tiles[i][j].wall  = os.readByte();
                    this.tiles[i][j].thing = os.readByte();

                    for (int k = 0; k < this.tiles[i][j].flags.length; ++k) {
                        this.tiles[i][j].flags[k] = os.readBoolean();
                    }
                }
            }

            // Dispose all the resources after using them
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {

    }
}
