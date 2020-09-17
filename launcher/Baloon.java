package launcher;

private class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions()
    {
        String wch = new weatherTower.getWeather(coordinates);
        switch(wch)
        {
            case "SUN": 
            break ;

            case "RAIN":
            break ;

            case "FOG":
            break ;

            case "SNOW":
            break ;

        }


    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
    }
}
