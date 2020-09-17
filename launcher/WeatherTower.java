package launcher;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    
    private void changeWeather()
    {
        return this.conditionsChange();
    }
}