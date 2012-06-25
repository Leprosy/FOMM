/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
public class Monster {
    public byte X;
    public byte Y;
    public byte total;

    public short hp;
    public short ac;

    public Monster(byte x, byte y) {
        this.X     = x;
        this.Y     = y;
        this.total = 1;
        this.hp    = 20;
    }
}
