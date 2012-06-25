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
    public static final int MESSAGE_NPC = 3;

    public static final int CONFIRM = 4;
    public static final int INPUT = 5;
    public static final int IF = 6;

    public static final int TREASURE = 7;
    public static final int EXPERIENCE_PARTY = 8;
    public static final int EXPERIENCE_CHAR = 9;

    public static final int GIVE_QUEST = 10;
    public static final int END_QUEST = 11;
    public static final int IF_QUEST = 12;

    public static final int GIVE_AWARD = 13;
    public static final int GIVE_SKILL = 14;

    public static final int GIVE_QUESTITEM = 15;
    public static final int TAKE_QUESTITEM = 16;
    public static final int IF_QUESTITEM = 17;

    //public static final int STORE_BLACKSMITH = 40;
    public static final int CHOOSE_CHAR = 25;
    
    public static final int DAMAGE_PARTY = 30;
    public static final int DAMAGE_CHAR = 31;

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
