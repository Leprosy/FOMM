package RPG;

import java.io.DataInputStream;
import java.io.FileInputStream;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author mrojas
 */
public class Map {

    protected Tile[][] tiles;
    public int startX;
    public int startY;

    public Map(String file) {
        try {
            DataInputStream os = new DataInputStream(new FileInputStream(file));
            for (int i=0;i<12;++i) {
                System.out.println(os.readByte());
            }
            /*FileReader fl = new FileReader(file);
            BufferedReader in = new BufferedReader(fl);
            String str;

            // Read the start point from file
            this.startX = Integer.parseInt(in.readLine());
            this.startY = Integer.parseInt(in.readLine());

            // Read the map size from file
            int width = Integer.parseInt(in.readLine());
            int height = Integer.parseInt(in.readLine());

            // Init object map size
            this.tiles      = new Tile[height][width];

            byte[][] base   = new byte[height][width];
            byte[][] walls  = new byte[height][width];
            byte[][] things = new byte[height][width];
            byte[][] flags  = new byte[height][width];

            // Populate the map from file
            // Base
            for (int i = 0; i < height * 4; ++i) {
                str = in.readLine();

                for (int j = 0; j < width; ++j) {
                    if (i < height) {
                        base[i][j] = (byte)str.charAt(j);
                    } else if (i < height * 2) {
                        walls[i - height][j] = (byte)str.charAt(j);
                    } else if (i < height * 3) {
                        things[i - (height * 2)][j] = (byte)str.charAt(j);
                    } else {
                        flags[i - (height * 3)][j] = (byte)str.charAt(j);
                    }
                }
            }

            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    this.tiles[i][j] = new Tile(base[i][j], walls[i][j], things[i][j], flags[i][j]);
                }
            }

            // Dispose all the resources after using them
            fl.close();
            in.close(); */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @todo : eliminate Party from here, debug code only!
     */
    public void render(Party P) {
        for (int i = 0; i < this.tiles.length; ++i) {
            for (int j = 0; j < this.tiles[i].length; ++j) {
                if (P.x == j && P.y == i) {
                    System.out.print('*');
                } else {
                    System.out.print(this.tiles[i][j].render());
                }
            }

            System.out.println("");
        }

        System.out.println("--------");

    }
}
