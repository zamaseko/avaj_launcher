package launcher;

public abstract class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coo = new Coordinates(longitude, latitude, height);
        Baloon ba = new Baloon(name, coo);
        if(type.equals("Baloon"))
            return ba;
        JetPlane jp = new JetPlane(name, coo);
        if(type.equals("JetPlane"))
            return jp;
        Helicopter h = new Helicopter(name, coo);
        if (type.equals("Helicopter"))
            return h;
        return (null);
    }
}
