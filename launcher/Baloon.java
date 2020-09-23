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
        String wch = weatherTower.getWeather(this.coordinates);
        MayDay may = new MayDay();
        switch(wch)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 2);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + " Its too hot for the baloon, its about to burst" );
            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "When it rains it pours " );
            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Its too foggy, where did the baloon go" );
            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Snow too heavy, this is going to be hard" );
            break ;
        }
        if(this.coordinates.getHeight() <= 0)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
            may.writeRecord("Hello Tower: I'm going down" + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "preparing for landing" );
            this.weatherTower.unregister(this);
            may.writeRecord("Hello Tower: Clear the runway for landing," + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "is about to land" );
        }
        else if(this.coordinates.getHeight() >= 100)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
            may.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Ey yo my man you flying too high" );
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        MayDay warn = new MayDay();
        warn.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "is registered" );
    }
}
