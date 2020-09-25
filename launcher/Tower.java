package launcher;
import java.util.*;

public abstract class Tower
{
    private List <Flyable> observers = new ArrayList<Flyable>();
    public int land = 1;
    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }
    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
        land--;
    }
    protected void conditionsChanged()
    {
        int i = 0;
        while (i < observers.size())
        {
            observers.get(i++).updateConditions();
            if(land == 0)
            {
                i--;
                land = 1;
            }
        }
    }
}