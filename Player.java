
import java.util.ArrayList;

public class Player
{
    int currentHealth;
    int maxHealth;
    int speed;
    int strength;
    ArrayList<Item> inventory;
    
    
    public Player()
    {
        maxHealth = 15;
        currentHealth = maxHealth;
        strength = 1;
        inventory = new ArrayList<Item>();
        inventory.add(new Weapon("Shortsword", 1, 88));
        inventory.add(new Potion("Basic Medicine", 3, 0, 0));
        inventory.add(new Potion("Basic Medicine", 3, 0, 0));
    }
    
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    public Item getItem(int x)
    {
        return inventory.get(x);
    }
    
    public void addItem(Item i)//0 means duplicate, 1 means successful
    {
        inventory.add(i);
    }
    
    public boolean isInventoryEmpty()
    {
        return inventory.isEmpty();
    }
    
    public void setHealth(int h)
    {
        currentHealth = h;
    }
    
    public void decrementHealth(int x) //0 means player is dead, 1 means they successfully lost health
    {
       currentHealth-=x;
    }
    
    public void incrementHealth(int x) //0 means player is at max health, 1 means they successfully gained health
    {
        currentHealth+=x;
    }
    
    public int getCurrentHealth()
    {
        return currentHealth;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public void setStrength(int s)
    {
        strength = s;
    }
    
    public void increaseStrength(int s)
    {
        strength+=s;
    }
    
    public String toString()
    {
        return "You have " + currentHealth + " out of " + maxHealth + " hearts";
    }
    
}