package launcher;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    
    private Helicopter(String name, Coordinates coordinates)
    {   
    }

    @Override
    public void updateConditions()
    {
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
    }
}