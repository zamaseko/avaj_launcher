package launcher;
import java.util.Random;

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
    public String getCurrentWeather(Coordinates coordinates)
    {
        Random rand = new Random();
        //int wco = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight(); 
        // return weather[wco % 4];
        return weather[rand.nextInt(4)];
    }
}