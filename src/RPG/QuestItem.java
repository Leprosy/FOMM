/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
public class QuestItem {
    public int id;
    public int total;
    public String name;

    public QuestItem(int id, String name, int total) {
        this.id     = id;
        this.name   = name;
        this.total  = total;
    }
}
