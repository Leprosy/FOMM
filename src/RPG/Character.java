/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
public class Character {
    public byte hp;
    public byte sp;
    
    public byte str;
    public byte wis;
    public byte end;
    public byte lck;
    public byte per;
    public byte acc;
    public byte spd;
    public byte age;
    
    public byte level;

    public byte exp;
    
    public byte clss;

    public String name;

    public Character(int i) {
        this.hp = (byte)(Math.random() * 10 + 10);
        this.sp = (byte)(Math.random() * 10 + 10);
        
        this.str = (byte)(Math.random() * 10 + 10);
        this.wis = (byte)(Math.random() * 10 + 10);
        this.end = (byte)(Math.random() * 10 + 10);
        this.lck = (byte)(Math.random() * 10 + 10);
        this.per = (byte)(Math.random() * 10 + 10);
        this.acc = (byte)(Math.random() * 10 + 10);
        this.spd = (byte)(Math.random() * 10 + 10);
        this.spd = (byte)(Math.random() * 10 + 10);
        this.age = (byte)(Math.random() * 10 + 18);

        this.clss = (byte)(Math.random() * 8);
        
        this.name = "player" + i;
        
        this.exp   = 0;
        this.level = 1;
    }
}
