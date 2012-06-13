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
    
    public static final int MESSAGE = 0;
    public static final int MESSAGE_ONETIME = 1;
    public static final int KILL_EVENT = 2;

    public Event(int id, int code, String par, int x, int y) {
        this.id        = id;
        this.code      = code;
        this.parameter = par;
        this.alive     = true;

        this.X = x;
        this.Y = y;
    }
}
