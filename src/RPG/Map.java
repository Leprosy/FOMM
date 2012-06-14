package RPG;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;


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
            // Format : [x][y][code][param]
            this.events = new Event[12];
            this.events[0] = new Event(0, Event.MESSAGE, "Are you in the begining?", 0, 0);
            this.events[1] = new Event(0, Event.MESSAGE_ONETIME, "This is the END OF THE WORLD!", 15, 15);

            this.events[2] = new Event(0, Event.CONFIRM, "Are you sure?", 6, 6);
            this.events[3] = new Event(1, Event.IF, "ok;2;4", 6, 6);
            this.events[4] = new Event(2, Event.MESSAGE, "You're sure!", 6, 6);
            this.events[5] = new Event(3, Event.EXIT, "", 6, 6);
            this.events[6] = new Event(4, Event.MESSAGE, "Come back when you're sure... :(", 6, 6);
            
            this.events[7] = new Event(0, Event.INPUT, "Tell me the password...", 7, 6);
            this.events[8] = new Event(1, Event.IF, "rosebud;2;4", 7, 6);
            this.events[9] = new Event(2, Event.MESSAGE, "Cool!", 7, 6);
            this.events[10] = new Event(3, Event.EXIT, "", 7, 6);
            this.events[11] = new Event(4, Event.MESSAGE, "Incorrect!", 7, 6);
            

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

    public Object[] event(int i, int j) {
        ArrayList ev = new ArrayList();

        for (int a = 0; a < this.events.length; ++a) {
            if (this.events[a].X == i && this.events[a].Y == j && this.events[a].alive) { /** @todo: orientation event */
                ev.add(this.events[a]);
            }
        }

        if (ev.isEmpty()) {
            return null;
        } else {
            return ev.toArray();
        }
    }

    public void killEvent(int i) {
        for (int a = 0; a < this.events.length; ++a) {
            if (this.events[a].id == i) {
                this.events[a].alive = false;
            }
        }
    }
}
