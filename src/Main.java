/**
 *  Runs the program by initializing the dungeon and player and then starts the game loop
 */
public class Main
{
    public static Dungeon dungeon;
    public static Player player;

    /**
     *  Runs the init and update method
     */
    public static void main(String[] args) throws Exception
    {
        init();
        update();
    }

    /**
     *  Initializes the variables dungeon and player, and prints starting text
     */
    public static void init() throws Exception
    {
        dungeon = new Dungeon("dungeon.txt");
        player = new Player(1,10,10,100);
        Input.init();
        System.out.println("Controls are w to go up, s to go down, a to go left, and d to go right, and exit to quit");
        System.out.println("Hit enter to execute the command");
    }

    /**
     *  Creates the game loop that checks for commands in order to update the game
     */
    public static void update() throws PlayerOutOfBoundsException
    {
        boolean isRunning = true;
        while(isRunning)
        {
            Display.render();
            Input.update();
            player.update();
            if(Input.EXIT) break;
        }
    }
}
