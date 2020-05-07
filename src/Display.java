/**
 *  Renders the game to console
 */

public class Display {

    /**
     *  Uses two nested for loops in order to print the dungeon and player position
     *  to the console
     */
    public static void render()
    {
        for(int i = 0; i < Main.dungeon.getMap().length; i++)
        {
            for(int j = 0; j < Main.dungeon.getMap()[0].length; j++)
            {
                System.out.print(Main.dungeon.getMap()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
