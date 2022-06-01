
import java.util.ArrayList;
import java.util.Scanner;

public class GameStatus
{
    BinaryTree gameStatus;
    ItemMap items;
    Player character;
    
    public GameStatus()
    {
        gameStatus = new BinaryTree();
        items = new ItemMap();
        character = new Player();
                
    }
    
    public void execute()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Adventurer, To TextQuest! \nWould You Like To Begin Your Quest? \n Type: \"Yes\" to continue");
        String name = sc.nextLine();
        if(name.equals("Yes") || name.equals("yes"))
        {
            for(int x = 0; x < 7; x++)
            {
                encounterThing();
            }
            System.out.println("Congratulations! You have beaten TextQuest! You gather the treasure you have found and retire.");
        }
    }
    
    public void encounterThing()
    {
        
        Scanner sc = new Scanner(System.in);
        
        Encounter random = new Encounter();
        //gameStatus.addLeft(random, gameStatus.root());
        System.out.println(random.flavorText());
        if(random.isMonster() == true)
        {
            System.out.println(" Would you like to initiate combat? Or flee? Type \"Fight \"to fight, and \"Flee\" to flee.");
            String temp = sc.nextLine();
            if(temp.equals("Fight"))
                {
                    combat(random);
                }
            
            else if(temp.equals("Flee"))
            {
                int egg = (int)(Math.random()*10);
                if(egg >=5)
                {
                    System.out.println(" You manage to escape the monster, and continue your quest");
                    return;
                }
                else
                {
                    System.out.println(" You attempt to escape, but the monster catches up and initiates combat");
                    combat(random);
                }
            }
        }
        
        else if(random.isMonster() == false)
        {
            System.out.println(" You do not encounter anything in this area, type \"Continue\" to move on with your quest");
            if(sc.nextLine().equals("Continue"))
            return;
        }
    }
    
        
    public void combat(Encounter e)
    {
        Scanner sc = new Scanner(System.in);
        if(character.getCurrentHealth() == 0)
        {
            System.out.println("You died! Game over :( ");
        }
        if(e.monsterStats().health() <= 0 )
        {
            System.out.println("You have vanquished the monster! You collect your loot and continue on your way");
            Item randomItem = ((Item)(items.get((int)(Math.random() * items.size()))));
            System.out.println("You found a " + randomItem.getName());
            character.addItem(randomItem);
            e.monsterStats().setHealth();
            System.out.println("Type \"Continue\" to continue");
            if(sc.nextLine().equals("Continue"))
            return;
        }
        System.out.println("You are fighting a " + e.getMonsterName() + ", it has " + e.monsterStats().health() + " health" + "");
        System.out.println("Would you like to \"Attack\" or \"Use Potion\" ");
        System.out.println(" Type \"Attack\" to attack and \"Potion\" to use a potion");
        String egg = sc.nextLine();
        if(egg.equals("Attack") || sc.nextLine().equals("attack"))
                {
                    System.out.println("\nWhich weapon would you like to use?");  
                    for(int x = 0; x < character.getInventory().size(); x++)
                    {
                        if(character.getItem(x) instanceof Weapon)
                        {
                            System.out.println(character.getItem(x).getName());
                        }
                    }
                    System.out.println(" Type the name of the weapon you would like to use");
                     
                    String weap = sc.nextLine();
                    Weapon temp = null;
                    for(int x = 0; x < character.getInventory().size(); x++)
                    {
                        if(character.getItem(x) instanceof Weapon && character.getItem(x).getName().equals(weap))
                        {
                            temp = (Weapon)character.getItem(x);
                            break;
                        }
                    }
                    if(temp == null)
                    {
                        System.out.println("No weapon found, using shortsword");
                             
                        temp = (Weapon)character.getItem(0);
                    }
                    attackMonster(e, temp);
                }
        else if(egg.equals("Potion") || sc.nextLine().equals("potion"))
                {
                    System.out.println("Which Potion you would like to use");
                    for(int x = 0; x < character.getInventory().size(); x++)
                    {
                        if(character.getItem(x) instanceof Potion)
                        {
                            System.out.println(character.getItem(x).getName());
                        }
                    }
            
                    System.out.println( "Type the name of the potion you would like to use");
                    String pot = sc.nextLine();
                    Potion temp = null;
                    for(int x = 0; x < character.getInventory().size(); x++)
                    {
                        if(character.getItem(x) instanceof Potion && character.getItem(x).getName().equals(temp))
                        {
                            temp = (Potion)character.getItem(x);
                            break;
                        }
                    }
                    if(temp == null)
                    {
                        System.out.println("Potion not recognized, returning to combat screen");
                        combat(e);
                    }
                    usePotion(e, temp);
                }
        
    }
    
    public void usePotion(Encounter e, Potion p)
    {
        System.out.println("You are using " + p.getName());
        if(p.getHeal() > 0)
        {
            System.out.println("The potion heals you " + p.getHeal() + " hitpoints!");
            character.incrementHealth(p.getHeal());
        }
        if(p.getStrength() > 0)
        {
            System.out.println("The potion increases your strength by " + p.getStrength() + " points!");
            character.increaseStrength(p.getStrength());
        }
        
        combat(e);
        
    }
    
    public void attackMonster(Encounter e, Weapon w)
    {
        int temp = (int)(Math.random() * 100);
        System.out.println("\nYou are attacking a " + e.getMonsterName() + " with your " + w.getName());
        if(temp <= w.getAccuracy())
        {
            int temp1 = (int)(Math.random()*3) + character.getStrength() + w.getStrength();
            System.out.println("You hit the monster! You deal "+ temp1 + " damage!");
            e.monsterStats().decreaseHealth(temp1);
            
        }
        else
            System.out.println("You miss!");
        
        if(e.monsterStats().health() > 0)
        {
        System.out.println("The monster strikes back!");
        if((int)(Math.random()) * 100 <= 50)
            {
                int temp2 = e.monsterStats().attack();
                System.out.println("The monster strikes you");
                System.out.println("You take " + temp2 + " damage");
                character.decrementHealth(temp2);
                System.out.println("You now have " + character.getCurrentHealth() + " health remaining!");
            }
        }
        combat(e);
        
    }
}

