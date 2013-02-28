/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
class Item {
    public final static String[] itemTypes = {
        "Leather",
        "Wooden",
        "Brass",
        "Iron",
        "Steel",
        "Gold",
        "Obsidian"
    };

    public byte type;
    public byte mod1;
    public byte mod2;
    public byte spell;

    public Item() {
        
    }
}
