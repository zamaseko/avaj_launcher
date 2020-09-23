package launcher;

// import java.util.*;
import java.io.*;

public class Simulator {
    public static int repeat;
   // public static PrintWriter writer;

    public static void main(String[] args) {

        BufferedReader bf = null;
        WeatherTower wtow = new WeatherTower();
        if (args.length < 1)
        {
            System.out.println("EY my man where is the scenario.txt");
            return;
        }
        String file = args[0];
        try
        {
            bf = new BufferedReader(new FileReader(file));
            String s_line = bf.readLine();
            int rev = 1;
            String[] a;

            while ((s_line != null))
            {
                if (rev == 1)
                {
                    try
                    {
                        repeat = Integer.parseInt(s_line);
                        if (repeat < 0)
                        {
                            System.out.println("Only positive numbers are allowed.");
                            return;
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Scenario.txt first number should be a digit.");
                        return;
                    }
                }
                else
                {
                    a = s_line.split(" ");
                    if (a.length == 1 && a[0].isEmpty()) // Do not consider empty lines
                        continue;
                    if (a.length != 5) {
                        System.out.println("These scenarios" + rev + " should only have 5 parameters.");
                        return;
                }
                try
                {
                    AircraftFactory.newAircraft(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]),
                                Integer.parseInt(a[4])).registerTower(wtow);
                }
                catch (NumberFormatException e)
                {
                    
                    System.out.println("The coordinates should only be numbers.");
                    System.out.println("Check line " + rev + ".");
                      //  return;
                }
                catch (Exception e) 
                {
                    System.out.println("Invaild Aircraft type on line " + rev + ".");
                       // return;
                }
            }
            rev++;
            }
        } catch (Exception e){
            System.out.println("Reading file failed error: " + e.getMessage() + ".");
            return;
        }
        finally 
        {
            try
            {
                if (bf != null)
                bf.close();

            }
            catch (IOException e) {
                System.err.format("IOException: %s%n hello", e);
            }
        }

        while (repeat > 0) {
            wtow.changeWeather();
            repeat--;
        }
        System.out.println("The vehicles went and got flewed out!");
    }

}
