package launcher;
import java.util.*;

public abstract class Tower
{
    private List<Flyable> observer = new ArrayList<Flyable>();
    public void register(Flyable flyable)
    {}
    public void unregister(Flyable flyable)
    {}
    protected void conditonsChanged()
    {}
}