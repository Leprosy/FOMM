package RPG;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrojas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tile T = new Tile();
System.out.println(T);
        System.exit(0);
        Map M   = new Map("map1");
        Party P = new Party(M.startX, M.startY);
        char key;

        System.out.println("MMmake\n======\n");

        try {
            while ((key = (char)System.in.read()) != 'x') {
                switch(key) {
                    case 'u':
                        P.y--;
                        break;
                    case 'd':
                        P.y++;
                        break;
                    case 'l':
                        P.x--;
                        break;
                    case 'r':
                        P.x++;
                        break;
                    default :
                        break;
                }
                M.render(P);
            }

            System.out.println("bye!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
