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
        String wch = weatherTower.getWeather(this.coordinates);
        MayDay may = new MayDay();
        switch(wch)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() , coordinates.getHeight() + 2);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Suns out, its going to be a pleasant ride" );

            break ;

            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Brace yourself, this is going to get bad" );

            break ;

            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "You will not be able to see s**t" );
            break ;

            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 12);
                may.writeRecord(this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Its gonna be a bumpy ride" );

            break ;
        }
        if(this.coordinates.getHeight() >= 100)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
            may.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "Ey yo my man you flying too high" );
        }
        else if(this.coordinates.getHeight() <= 0)
        {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
            may.writeRecord("Hello Tower: I'm going down " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "preparing for landing" );
            this.weatherTower.unregister(this);
            may.writeRecord("Hello Tower:  Clear the runway for landing," + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+"): " + "is about to land" );

        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        MayDay warn = new MayDay();
        warn.writeRecord("Hello Tower: " + this.getClass().getSimpleName() + "#" + this.name + "("+this.id+")" + "is registered");
    
    }
}