public class Monster 
{
    private String name;
    private int power, evasion, health, maxHealth;
    
    public Monster(String n, int p, int e, int h)
    {
        name = n;
        power = p;
        evasion = e;
        health = h;
        maxHealth = h;
        //evasion is chance of dodging an attack
    }
    
    public int attack()
    {
        return power;
    }
    
    public int speed()
    {
        return evasion;
    }
    
    public int health()
    {
        return health;
    }
    
    public void setHealth()
    {
        health = maxHealth;
    }
    
    public void decreaseHealth(int x)
    {
        health = health - x;
    }
    
    public String getName()
    {
        return name;
    }
}
