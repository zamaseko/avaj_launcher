package launcher;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        WeatherProvider.getProvider();
        return WeatherProvider.getCurrentWeather(coordinates);
    }
    
    void changeWeather()
    {
        this.conditionsChanged();
    }
}