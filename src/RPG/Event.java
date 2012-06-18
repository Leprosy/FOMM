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
    public static final int TREASURE = 6;
    public static final int EXPERIENCE_PARTY = 7;
    public static final int EXPERIENCE_ONE = 8;
    public static final int GIVE_QUEST = 9;
    public static final int END_QUEST = 10;
    public static final int GIVE_AWARD = 11;
    public static final int GIVE_SKILL = 12;
    public static final int NPC_MESSAGE = 13;
    public static final int IF_QUEST = 14;
    
    public static final int STORE_BLACKSMITH = 40;


    /* public static final int TELEPORT = 3;
    public static final int SEARCH_TREASURE = 4;
    public static final int SEARCH_TRAP = 5; */
    public static final int CHANGE_MAP = 99;
    public static final int EXIT = 100;
    

    public Event(int id, int code, String par, int x, int y) {
        this.id        = id;
        this.code      = code;
        this.parameter = par;
        this.alive     = true;

        this.X = x;
        this.Y = y;
    }
}
