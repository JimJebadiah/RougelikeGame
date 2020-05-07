/**
 *  Creates a new player with attributes and the ability to move
 */
public class Player
{
    private int level, armor, strength, health, experience, x, y;

    /**
     *  Creates a new Player with a level, armor, strength, and health value, and then sets the position
     */
    public Player(int level, int armor, int strength, int health)
    {
        this.level = level;
        this.armor = armor;
        this.strength = strength;
        this.health = health;
        experience = 0;

        setPosition();
    }

    /**
     *  Calls the move method and attributeCheck method in one place
     */
    public void update() throws PlayerOutOfBoundsException
    {
        move();
        attributeCheck();
    }

    /**
     *  Finds the P character on the dungeon map in order to set the players x and y coords to its position
     */
    public void setPosition()
    {
        for(int i = 0; i < Main.dungeon.getMap().length; i++)
        {
            for(int j = 0; j < Main.dungeon.getMap()[0].length; j++)
            {
                if(Main.dungeon.getMap()[i][j] == 'P' || Main.dungeon.getMap()[i][j] == 'p')
                {
                    x = j;
                    y = i;
                    break;
                }
            }
        }
    }

    /**
     *  Checks the input booleans, if the next space is a void or a wall, and then moves the player in the
     *  desired direction by exchanging the characters in the array
     */
    public void move() throws PlayerOutOfBoundsException
    {
        //Move Up
        if(Input.UP)
        {
            if(y - 1 > 0)
            {
                if(!Main.dungeon.isWall(x, y-1))
                {
                    if(!Main.dungeon.isVoid(x, y - 1))
                    {
                       char temp = Main.dungeon.getMap()[y-1][x];
                       Main.dungeon.getMap()[y-1][x] = 'P';
                       Main.dungeon.getMap()[y][x] = temp;
                       y--;
                    }
                    else throw new PlayerOutOfBoundsException();
                }
                else System.out.println("You Bumped Into A Wall!");
            }
            else System.out.println("Out Of Bounds!");
        }
        //Move Down
        if(Input.DOWN)
        {
            if(y + 1 < Main.dungeon.getHeight())
            {
                if(!Main.dungeon.isWall(x, y + 1))
                {
                    if(!Main.dungeon.isVoid(x, y + 1))
                    {
                        char temp = Main.dungeon.getMap()[y + 1][x];
                        Main.dungeon.getMap()[y + 1][x] = 'P';
                        Main.dungeon.getMap()[y][x] = temp;
                        y++;
                    }
                    else throw new PlayerOutOfBoundsException();
                }
                else System.out.println("You Bumped Into A Wall!");
            }
            else System.out.println("Out Of Bounds!");
        }
        //Move Left
        if(Input.LEFT)
        {
            if(x - 1 > 0)
            {
                if(!Main.dungeon.isWall(x - 1, y))
                {
                    if(!Main.dungeon.isVoid(x - 1, y))
                    {
                        char temp = Main.dungeon.getMap()[y][x - 1];
                        Main.dungeon.getMap()[y][x - 1] = 'P';
                        Main.dungeon.getMap()[y][x] = temp;
                        x--;
                    }
                    else throw new PlayerOutOfBoundsException();
                }
                else System.out.println("You Bumped Into A Wall!");
            }
            else System.out.println("Out Of Bounds!");
        }
        //Move Right
        if(Input.RIGHT)
        {
            if(x + 1 < Main.dungeon.getWidth())
            {
                if(!Main.dungeon.isWall(x + 1, y))
                {
                    if(!Main.dungeon.isVoid(x + 1, y))
                    {
                        char temp = Main.dungeon.getMap()[y][x + 1];
                        Main.dungeon.getMap()[y][x + 1] = 'P';
                        Main.dungeon.getMap()[y][x] = temp;
                        x++;
                    }
                    else throw new PlayerOutOfBoundsException();
                }
                else System.out.println("You Bumped Into A Wall!");
            }
            else System.out.println("Out Of Bounds!");
        }
    }

    //if there was an enemy to attack
    /*  public int getAttackDamage(Enemy e)
        {
            return ((2 * strength) / (int) Math.sqrt(e.getArmor));
        }
    */

    /**
     *  Checks the attributes to make sure they don't go above or below their minimum or maximum values. If
     *  experience goes over 1000, calls the levelUp method
     */
    public void attributeCheck()
    {
        if(level < 0) level = 0;
        if(health < 0) health = 0;
        if(strength < 0) strength = 0;
        if(armor < 0) armor = 0;
        if(experience < 0) experience = 0;

        if(health > 1000) health = 1000;
        if(experience >= 1000) levelUp();
        if(strength > 100) strength = 100;
        if(armor > 100) armor = 100;
    }

    /**
     *  Increases the level and stats and sets experience to experience minus 1000 to allow rollover experience
     */
    public void levelUp()
    {
        level++;
        health += 100;
        strength += strength / level;
        armor += armor / level;
        experience = experience - 1000;
    }

    /**
     *  Gets the level
     */
    public int getLevel() {
        return level;
    }

    /**
     *  Sets the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *  Gets the health
     */
    public int getHealth() {
        return health;
    }

    /**
     *  Sets the health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *  Gets the armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     *  Sets the armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     *  Gets the experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     *  Sets the experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     *  Gets the experience
     */
    public int getStrength() {
        return strength;
    }

    /**
     *  Sets the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     *  Gets the x value
     */
    public int getX() {
        return x;
    }

    /**
     *  Gets the y value
     */
    public int getY() {
        return y;
    }

}





