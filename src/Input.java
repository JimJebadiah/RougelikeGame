/**
 *  Checks for commands in order to update the game
 */

import java.util.Scanner;

public class Input
{

    public static boolean UP, DOWN, LEFT, RIGHT, EXIT = false;
    private static Scanner scanner;


    /**
     *  Initializes the scanner
     */
    public static void init()
    {
       scanner = new Scanner(System.in);
    }


    /**
     *  Gets the command from the scanner, initializes the boolean values and sets
     *  the booleans according to the input to true
     */
    public static void update()
    {
        String input = scanner.nextLine();
        input = input.toLowerCase();
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;

        if(input.equals("w") || input.equals("up")) UP = true;
        else if(input.equals("s") || input.equals("down")) DOWN = true;
        else if(input.equals("d") || input.equals("right")) RIGHT = true;
        else if(input.equals("a") || input.equals("left")) LEFT = true;
        else if(input.equals("exit")) EXIT = true;
        else System.out.println("Enter Valid Command!");
    }
}
