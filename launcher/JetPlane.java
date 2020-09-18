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
        MayDay may = new MayDay();
        switch(wch)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10 , coordinates.getHeight() + 5);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Suns out, buns out, have fun." );

            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Rich people don't fly in the rain." );

            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight() - 3);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Nothing is going to be visible, my dear" );

            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "MayDay, MayDay, its gonna be a bumpy ride!!!!");

            break ;
        }
        if(this.coordinates.getHeight() >= 100)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
            may.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Ey yo my man you flying too high." );
        }
        else if(this.coordinates.getHeight() <= 0)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
            may.writeRecord("Hello Tower: I'm going down" + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "preparing for landing" );
            this.weatherTower.unregister(this);
            may.writeRecord("Hello Tower: Clear the runway for landing," + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "is about to land" );
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {        
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        MayDay warn = new MayDay();
        warn.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "is registered." );
    }
}
