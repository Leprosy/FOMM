package RPG;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrojas
 */
public class Tile { // implements Serializable {
    public byte base;
    public byte wall;
    public byte thing;

    public final byte IMPASSABLE = 0;
    public final byte DOOR       = 1;
    public final byte GRATE      = 2;
    public final byte WATER      = 3;
    public final byte DEEPWATER  = 4;
    public final byte SECRET     = 5;

    public final byte FLAGS      = 6;

    public boolean[] flags;

    public Tile() {
        this.base  = 0;
        this.wall  = 0;
        this.thing = 0;
        this.flags = new boolean[FLAGS];
    }

    public char render() {
        return (char)this.wall;
    }
}