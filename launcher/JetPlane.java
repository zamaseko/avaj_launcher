package launcher;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() 
    {
        String wch = weatherTower.getWeather(this.coordinates);
        switch(wch)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10 , coordinates.getHeight() + 5);
            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() - 3);
            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
            break ;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        // MayDay warn = new MayDay();
        // warn.writeRecord("Hello Tower: " );
    }
}
