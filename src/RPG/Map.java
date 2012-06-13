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
    protected Event[] events;
    public int startX;
    public int startY;
    public int width;
    public int height;

    public Map(String file) {
        try {
            DataInputStream os = new DataInputStream(new FileInputStream(getClass().getResource("/Assets/maps/" + file).getFile()));

            //Read
            int W = os.readByte();
            int H = os.readByte();

            this.width  = W;
            this.height = H;

            this.tiles = new Tile[W][H];

            this.startX = os.readByte();
            this.startY = os.readByte();

            // Load bytes of map
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

            // Events, triggers
            this.events = new Event[3];
            this.events[0] = new Event(0, "This is a demo", 6, 6);
            this.events[1] = new Event(0, "Are you in the begining?", 0, 0);
            this.events[2] = new Event(0, "This is the END OF THE WORLD!", 15, 15);

            // Dispose all the resources after using them
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Tile tile(int i, int j) {
        try {
            return this.tiles[i][j];
        } catch(Exception e) {
            return null;
        }
    }
}
