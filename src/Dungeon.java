/**
 *  Creates a dungeon object based on a given text file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dungeon
{

    private Scanner sc;
    private File dungeon;

    private char[][] map;
    private int width, height;


    /**
     *  Creates the dungeon object with a new scanner that uses the dungeon file as an input, creates a char array
     *  to store the data from the file, and then calls the populate method to populate that array
     */
    public Dungeon(String path) throws FileNotFoundException
    {
        this.dungeon = new File(path);
        sc = new Scanner(dungeon);

        width = sc.nextInt();
        height = sc.nextInt();

        map = new char[height][width];

        populate();
    }

    /**
     *  Uses two nested for loops in order to popoulate the array, takes an entire line of text as a string, and then
     *  seperates the String into characters to add to the array
     */
    public void populate()
    {
        for(int i = 0; i < height; i++)
        {
            String line = sc.next();
            for(int j = 0; j < width; j++)
            {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 's') map[i][j] = ' ';
            }
        }
        sc.close();
    }

    /**
     *  detects if the position is a wall based on the coordinates
     */
    public boolean isWall(int x, int y)
    {
        if(map[y][x] == '#') return true;
        else return false;
    }

    /**
     *  detects if the position is a void based on the coordinates
     */
    public boolean isVoid(int x, int y)
    {
        if(map[y][x] == ' ') return true;
        else return false;
    }

    /**
     *  Gets the map array for other classes use
     */
    public char[][] getMap()
    {
        return map;
    }

    /**
     *  Gets the map height
     */
    public int getHeight() {
        return height;
    }

    /**
     *  Gets the map width
     */
    public int getWidth() {
        return width;
    }
}
