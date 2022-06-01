import java.util.ArrayList;
import java.lang.Math;
public class Encounter 
{
    private ArrayList<String> settings;
    private ArrayList<Monster> monsters;
    private boolean monster;
    private int monsterTemp;
    
    public Encounter()
    {
        monsters = new ArrayList<Monster>();
                 monsters.add(new Monster("wolf", 2, 20, 5)); //on this scale, Strength is 1-10, Evasion is 1-100, and Health is 1-15
                monsters.add(new Monster("bear", 4, 10, 10)); //if one stat is high, the others should be lower, special cases apply
              monsters.add(new Monster("vampire", 3, 25, 8)); //ive tried to make the stats easier to read at the sacrifice of the lines looking horrible, feel free to change on your version
               monsters.add(new Monster("zombie", 3, 25, 8));
                 monsters.add(new Monster("slime", 1, 5, 5));
               monsters.add(new Monster("goblin", 2, 30, 5));
         monsters.add(new Monster("goblin king", 2, 10, 10));
            monsters.add(new Monster("beholder", 5, 20, 15));
          monsters.add(new Monster("giant slime", 1, 5, 10));
              monsters.add(new Monster("dragon", 6, 15, 15));
                  monsters.add(new Monster("hag", 2, 10, 4));
                  monsters.add(new Monster("imp", 2, 40, 2));
                  monsters.add(new Monster("ogre", 5, 5, 8));
           monsters.add(new Monster("elemental", 2, 20, 10));
              monsters.add(new Monster("serpent", 4, 30, 5));
                monsters.add(new Monster("witch", 2, 40, 6));
        
        
        settings = new ArrayList<String>();
        settings.add(" forest");
        settings.add(" swamp");
        settings.add(" plains");
        settings.add(" cave");
        settings.add("n abandoned castle"); //the 'n' is there because abandoned starts with a vowel, and the intro is going to say "you are in a X
        settings.add(" plateau");
        settings.add(" valley");
        
        if((int)(Math.random() *10) >=5)
            monster = false;
        else
            monster = true;
        
        monsterTemp = (int)(Math.random() * monsters.size());
    }
    
    public Monster monsterStats()
    {
        return monsters.get(monsterTemp);
    }
    
    public boolean isMonster()
    {
        return monster;
    }
    
    public String getMonsterName()
    {
        return monsters.get(monsterTemp).getName();
    }
    
    public String flavorText()
    {
        String text = "";
        int setting = (int)(Math.random() * settings.size());
        
        if(monster == true)
            text =  "You are walking through a" + settings.get(setting) + " when you encounter a " + monsters.get(monsterTemp).getName();
        else
            text =  "You are walking through a" + settings.get(setting) + " you do not encounter any monsters";
        return text;
    }
}