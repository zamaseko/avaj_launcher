package launcher;

public class Helicopter extends Aircraft implements Flyable
{
    WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates)
    {  
        super(name, coordinates);
    }

    @Override
    public void updateConditions()
    {
        String wch = new weatherTower.getWeather(this.coordinates);
        switch(wch)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() , coordinates.getHeight() + 2);
            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 12);
            break ;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        // MayDay warn = new MayDay();
        // warn.writeRecord("Hello Tower: " );
    }
}