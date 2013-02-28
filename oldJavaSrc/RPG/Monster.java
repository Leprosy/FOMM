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
    public String name;

    public short hp;

    public byte ac;
    public byte spd;
    public byte dmg;

    public Monster(byte x, byte y, String name) {
        this.X     = x;
        this.Y     = y;
        this.total = 1;
        this.hp    = 20;
        this.spd   = (byte)(Math.random() * 5 + 10);
        this.name  = name;
    }
}
