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
        this.food = 20;

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

    public void addQuest(int id, String name) {
        this.quests.add(new Quest(id, name));
    }

    public void removeQuest(int id) {
        Quest tmp;

        for (int i = 0; i < this.quests.size(); ++i) {
            tmp = (Quest)this.quests.get(i);
            
            if (tmp.id == id) {
                this.quests.remove(i);
            }
        }        
    }

    public boolean hasQuest(int id) {
        Quest tmp;

        for (int i = 0; i < this.quests.size(); ++i) {
            tmp = (Quest)this.quests.get(i);

            if (tmp.id == id) {
                return true;
            }
        }

        return false;
    }
    
    public void addQuestItem(int id, String name, int total) {
        QuestItem tmp = this._hasQuestItem(id, total);

        if (tmp != null) {
            tmp.total += total;
        } else {
            this.quest_items.add(new QuestItem(id, name, total));
        }
    }

    public void removeQuestItem(int id, int total) {
        QuestItem tmp = this._hasQuestItem(id, 1);

        if (tmp != null) {
            if (tmp.total > total) {
                tmp.total -= total;
            } else {
                this.quest_items.remove(tmp);
            }
        }
    }

    public boolean hasQuestItem(int id, int total) {
        return this._hasQuestItem(id, total) != null;
    }

    protected QuestItem _hasQuestItem(int id, int total) {
        QuestItem tmp;

        for (int i = 0; i < this.quest_items.size(); ++i) {
            tmp = (QuestItem)this.quest_items.get(i);

            if (tmp.id == id && tmp.total >= total) {
                return tmp;
            }
        }

        return null;
    }
}
