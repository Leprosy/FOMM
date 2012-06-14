/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
public class Event {
    public int id;
    public int code;
    public int X;
    public int Y;
    public String parameter;
    public boolean alive;
    
    public static final int KILL_EVENT = 0;
    public static final int MESSAGE = 1;
    public static final int MESSAGE_ONETIME = 2;
    public static final int CONFIRM = 3;
    public static final int INPUT = 4;
    public static final int IF = 5;
    public static final int EXIT = 6;

    /* public static final int TELEPORT = 3;
    public static final int SEARCH_TREASURE = 4;
    public static final int SEARCH_TRAP = 5; */
    public static final int CHANGE_MAP = 9;
    

    public Event(int id, int code, String par, int x, int y) {
        this.id        = id;
        this.code      = code;
        this.parameter = par;
        this.alive     = true;

        this.X = x;
        this.Y = y;
    }
}
