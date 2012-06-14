/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

/**
 *
 * @author mrojas
 */
public class Party {
    public int X, Y;
    public short facing;
    public short money;
    public short food;

    public Party(int x, int y) {
        this.X = x;
        this.Y = y;
        this.facing = 0;
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
            this.facing = 0;
        }
    }
}
