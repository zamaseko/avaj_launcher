package launcher;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates)
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
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 2);
            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
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
