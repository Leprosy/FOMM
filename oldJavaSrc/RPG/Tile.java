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

    public static final byte IMPASSABLE  = 0;
    public static final byte DOOR        = 1;
    public static final byte GRATE       = 2;
    public static final byte WATER       = 3;
    public static final byte DEEPWATER   = 4;
    public static final byte SECRET      = 5;
    public static final byte DENSE_TREES = 6;
    public static final byte MOUNTAIN    = 7;

    public static final byte FLAGS = 8;

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