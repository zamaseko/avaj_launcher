package launcher;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
        "SUN",
        "RAIN",
        "FOG",
        "SNOW"
    };

    private WeatherProvider(){}

    public static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }
    public static String getCurrentWeather(Coordinates coordinates)
    {
        int wco = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight(); 
        return weather[wco % 4];
    }
}