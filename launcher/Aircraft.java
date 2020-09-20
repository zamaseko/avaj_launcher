package launcher;

public abstract class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId()
    {
        return idCounter++;
    }
}