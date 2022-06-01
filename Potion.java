
import java.util.ArrayList;

public class Potion extends Item
{
    private String name;
    private int heal, strength, speed;
    
    public Potion(String n, int h, int st, int sp)
    {
        name = n;
        heal = h;
        strength = st;
        speed = sp;
        
    }

    public String getName()
    {
        return name;
    }
    
    
    public int getStrength()
    {
        return strength;
    }
    
    public int getHeal()
    {
        return heal;
    }
    
    public int getSpeed()
    {
        return speed;
    }
}
