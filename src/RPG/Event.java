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
    public int code;
    public int X;
    public int Y;
    public String parameter;
    
    public static final int MESSAGE = 0;

    public Event(int code, String par, int x, int y) {
        this.code      = code;
        this.parameter = par;

        this.X = x;
        this.Y = y;
    }
}
