package launcher;

import java.util.*;
import java.io.*;

public class Stimulator {
 

    public static void main(String[] args)
    {
//        List<String> s = new ArrayList<>();
        WeatherTower tower = new WeatherTower();
        ArrayList<Flyable> flyables = new ArrayList<>();

        try
        {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            MayDay may = new MayDay();

            int i;
            try
            {
                i = Integer.parseInt(s);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Error params: Enter the valid stimulations");
            }
            System.out.println(i + "stimulations to run");

            String line;
            while(line = br.readLine() != null)
            {
                String array[] = line.split(" ");
                if(array.length != 5)
                    System.out.println("hey");
                try
                {
                    flyables.add(AircraftFactory.newAircraft(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4])));
                }
                catch(NumberFormatException e)
                {
                    System.out.println("hello");
                }
            }
        }
        catch(Exception e)
        {
            System.out.print("Bye Bye");
        }
        if(args.length <= 0)
            System.out.println("Enter at least one Argument man!!");
        else
            System.out.println("Enter file: " + args[0] );
    }
}

