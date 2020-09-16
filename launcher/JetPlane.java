package launcher;

private class JetPlane extends Aircraft implements Flyable{
    private WeatherProvider weatherProvider;
    private JetPlane(String name, Coordinates coordinates)
    {
    }

    @Override
    public void updateConditions() 
    {
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
    }
}
