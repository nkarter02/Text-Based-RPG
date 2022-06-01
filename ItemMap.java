/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alecw
 */
import java.util.ArrayList;

public class ItemMap<Item> {
    
    private ArrayList<Item> list;
    private int size; 
    
    public ItemMap()
    {
        list = new ArrayList();
     //   Weapon sword = new Weapon("Sword",2);
        list.add( (Item)new Weapon("Sword",2,90)    );
        list.add( (Item)new Weapon("Axe",4,60)      );
        list.add( (Item)new Weapon("Spear",3,80 )   );
        list.add( (Item)new Weapon("Crossbow",7,70) );
        list.add( (Item)new Weapon("Whip",1,100)     );
        list.add( (Item)new Weapon("Mace",3,60)     );
        list.add( (Item)new Weapon("Katana",6,60)                );
        list.add( (Item)new Weapon("Baton",1,100));
        list.add( (Item)new Weapon("Halberd",5,70)      );
        list.add( (Item)new Weapon("Sai",4,70));
        
        list.add( (Item)new Potion("Healing Herbs", 2, 0, 0));
        list.add( (Item)new Potion("Medicine", 5, 0, 0));
        list.add( (Item)new Potion("Tonic", 0, 3, 20));
        list.add( (Item)new Potion("Antidote", 10, 0, 0));
        list.add( (Item)new Potion("Ether", 2, 2, 10));
        list.add( (Item)new Potion("Elixir", 5, 5, 20));
        list.add( (Item)new Potion("Basic Medicine", 3, 0, 0));
    }
    
    public Item get(int key)
    {
        
       Item item = list.get(key);
       if(item instanceof Weapon);
       {
           list.remove(key);
       }
       return item;
        
    }
    
    public Item returnRandom()
    {
        return get((int)(Math.random()*list.size()));
    }
    
    public Item remove(int key)
    {
        Item removed = list.get((int)key);
        list.remove((int)key);
        size--;
        return removed;
    }
    
    public int size()
    {
        return size;
    }
    
    
    
}