package launcher;

import java.io.*;

public class Simulator {
    public static int repeat;
    public static void main(String[] args) {

        BufferedReader bf = null;
        WeatherTower wtow = new WeatherTower();

        if (args.length < 1) {
            System.out.println("Ey my man, where is the scenario.txt file");
            return;
        }
        String file = args[0];
        try
        {
            bf = new BufferedReader(new FileReader(file));
            String s_line;
            int scene = 1;
            String[] arr;

            while ((s_line = bf.readLine()) != null)
            {
                if(scene == 1)
                {
                    try
                    {
                        repeat = Integer.parseInt(s_line);
                        if (repeat < 0) 
                        {
                            System.out.println("This should be a positive number!.");
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("This should not be anything other than a number.");
                    }
                }
                else 
                {
                    arr = s_line.split(" ");
                    if (arr.length == 1 && arr[0].isEmpty())
                        continue;
                    if (arr.length != 5)
                    {
                        System.out.println("That scenario line " + scene + " should have 5 parameters.");
                    }
                    try
                    {
                        AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4])).registerTower(wtow);
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("The coordinates should only be numbers, nothing else." + "\n" + "Go back and loo at line " + scene);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Look at line" + scene + "This is not a valid vehicles, my love.");
                    }

                }
                scene++;
            }
            
        } catch (Exception e)
        {
            System.out.println("The was a error reading the selected file: " + e.getMessage() + ".");
            return;
        }
        finally
        {
            try
            {
                if (bf != null)
                bf.close();

            }
            catch (IOException ex)
            {
                System.err.format("IOException: %s%n hey", ex);
            }
        }

        while (repeat > 0)
        {
            wtow.changeWeather();
            repeat--;
        }
        System.out.println("Hey yo, all the aircrafts got flewed out man!");
    }

}
