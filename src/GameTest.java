import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest
{
    @Test
    public void test() throws Exception
    {
        Main.init();
        Dungeon dungeon = new Dungeon("dungeon.txt");


        //player level up and attribute test
        Player player = new Player(1, 10, 10, 100);
        assertEquals(0, player.getExperience());
        player.levelUp();
        assertEquals(2, player.getLevel());
        assertEquals(200, player.getHealth());
        assertEquals(15, player.getStrength());
        assertEquals(15, player.getArmor());

        //over max value stats
        Player player2 = new Player(1, 200, 30000, 100);
        player2.attributeCheck();
        assertEquals(100, player2.getArmor());
        assertEquals(100, player2.getStrength());

        //under max value stats
        Player player3 = new Player(1, -100, -2, 100);
        player3.attributeCheck();
        assertEquals(0, player3.getArmor());
        assertEquals(0, player3.getStrength());


        //dungeon boolean tests
        assertEquals(false, dungeon.isWall(0,0));
        assertEquals(true, dungeon.isVoid(0,0));

    }
}