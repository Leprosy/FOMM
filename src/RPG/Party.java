/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.util.ArrayList;

/**
 *
 * @author mrojas
 */
public class Party {
    public int X, Y;
    public short facing;
    public short gold;
    public short gems;
    public short food;

    public Character[] chars;

    public ArrayList quests;
    public ArrayList quest_items;

    public Party(int x, int y) {
        this.X = x;
        this.Y = y;
        this.facing = 0;
        this.gold = 2000;
        this.gems = 30;

        this.chars = new Character[2];
        this.chars[0] = new Character(1);
        this.chars[1] = new Character(2);

        this.quest_items = new ArrayList();
        this.quests      = new ArrayList();
    }

    public void right() {
        this.facing++;

        if (this.facing == 4) {
            this.facing = 0;
        }
    }

    public void left() {
        this.facing--;
        
        if (this.facing == -1) {
            this.facing = 3;
        }
    }
}
