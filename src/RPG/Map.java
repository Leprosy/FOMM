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

    public Monster[] monsters;

    public Map(String file) throws Exception {
        DataInputStream os = new DataInputStream(new FileInputStream(getClass().getResource("/Assets/maps/" + file).getFile()));

        //Read
        int W = os.readByte();
        int H = os.readByte();

        this.width = W;
        this.height = H;

        this.tiles = new Tile[W][H];

        this.startX = os.readByte();
        this.startY = os.readByte();

        // Load bytes of map
        for (int i = 0; i < W; ++i) {
            for (int j = 0; j < H; ++j) {
                this.tiles[i][j] = new RPG.Tile();
                this.tiles[i][j].base = os.readByte();
                this.tiles[i][j].wall = os.readByte();
                this.tiles[i][j].thing = os.readByte();

                for (int k = 0; k < this.tiles[i][j].flags.length; ++k) {
                    this.tiles[i][j].flags[k] = os.readBoolean();
                }
            }
        }

        // Events, triggers
        // Format : [x][y][code][param]
        this.events = new Event[4];
        this.events[0] = new Event(0, Event.MESSAGE_NPC, "Crag Hack, The Barbarian;There you will have some exp...", 5, 5);
        this.events[1] = new Event(0, Event.CHOOSE_CHAR, "", 5, 5);
        this.events[2] = new Event(0, Event.DAMAGE_CHAR, "10", 5, 5);
        this.events[3] = new Event(0, Event.EXPERIENCE_CHAR, "2000", 5, 5);
        //this.events[1] = new Event(0, Event.MESSAGE_ONETIME, "This is the END OF THE WORLD!", 15, 15);

        /*this.events[2] = new Event(0, Event.CONFIRM, "Are you sure you want to do it?", 6, 6);
        this.events[3] = new Event(1, Event.IF, "ok;2;4", 6, 6);
        this.events[4] = new Event(2, Event.GIVE_QUEST, "1;Go see Sir Canegm in (2,2) if you want to conclude this quest", 6, 6);
        this.events[5] = new Event(3, Event.EXIT, "", 6, 6);
        this.events[6] = new Event(4, Event.MESSAGE, "Come back when you're sure... :(", 6, 6);

        this.events[7] = new Event(0, Event.INPUT, "Tell me the password...", 7, 6);
        this.events[8] = new Event(1, Event.IF, "rosebud;2;4", 7, 6);
        this.events[9] = new Event(2, Event.MESSAGE, "Cool!", 7, 6);
        this.events[10] = new Event(3, Event.EXIT, "", 7, 6);
        this.events[11] = new Event(4, Event.MESSAGE, "Incorrect!", 7, 6);

        this.events[12] = new Event(0, Event.IF_QUEST, "1;3;1", 2, 2);
        this.events[13] = new Event(1, Event.MESSAGE_NPC, "Sir Canegm, The Paladin;You're not ready to talk to me. Come when you're worthy...", 2, 2);
        this.events[14] = new Event(2, Event.EXIT, null, 2, 2);
        this.events[15] = new Event(3, Event.MESSAGE_NPC, "Sir Canegm, happy to see you;You have succeed. Thanks...", 2, 2);
        this.events[16] = new Event(4, Event.END_QUEST, "1", 2, 2);

        this.events[17] = new Event(0, Event.IF_QUESTITEM, "1;1;3;1", 0, 3);
        this.events[18] = new Event(1, Event.MESSAGE_NPC, "Resurrectra, gnome;You don't have the crystal yet.", 0, 3);
        this.events[19] = new Event(2, Event.EXIT, null, 0, 3);
        this.events[20] = new Event(3, Event.MESSAGE_NPC, "Resurrectra, gnome;Thanks for the crystal.", 0, 3);
        this.events[21] = new Event(4, Event.TAKE_QUESTITEM, "1;1", 0, 3);

        this.events[22] = new Event(0, Event.MESSAGE_NPC, "A strange wizard...;Take this magic crystal...", 0, 9);
        this.events[23] = new Event(1, Event.GIVE_QUESTITEM, "1;A Magic Crystal;1", 0, 9);*/

        //Monsters
        this.monsters = new Monster[5];
        for (int i = 0; i < 5; ++i) {
            this.monsters[i] = new Monster((byte)(Math.random() * 15), (byte)(Math.random() * 15), "Giant cat");
        }

        // Dispose all the resources after using them
        os.close();
    }

    public Tile tile(int i, int j) {
        try {
            return this.tiles[i][j];
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean canReach(Party P, int dx, int dy) {
        Tile tmp = this.tile(P.X + dx, P.Y + dy);

        if (tmp.flags[RPG.Tile.IMPASSABLE] || //Tile is impassable
            (tmp.flags[RPG.Tile.WATER] && !P.canSwim()) || //Tile is water
            (tmp.flags[RPG.Tile.DENSE_TREES] && !P.canPathFind()) || //Tile is dense forest
            (tmp.flags[RPG.Tile.MOUNTAIN] && !P.canMountain()) //Mountaineering
                ) {
            return false;
        }
        return true;
    }

    public Object[] event(int i, int j) {
        ArrayList ev = new ArrayList();

        for (int a = 0; a < this.events.length; ++a) {
            if (this.events[a].X == i && this.events[a].Y == j && this.events[a].alive) {
                /**
                 * @todo: orientation event
                 */
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
