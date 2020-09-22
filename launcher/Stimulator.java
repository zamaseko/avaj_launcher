package launcher;

import java.util.*;
import java.io.*;

public class Stimulator {
    public static WeatherTower tow = new WeatherTower();
    public static int i = 1;
    public static int repeat;
    static  List<String> str = new ArrayList<>();

    public static void main(String[] args)
    {
        if(args.length <= 0)
        {
            System.out.println("Eh bruh, where is the scenario text file");
            return ;
        }    
        else
        {
            try    
            {
                File f =  new File(args[0]);
                //Scanner scan = new Scanner(f);
               // MayDay may = new MayDay();
                // scan.hasNextLine();
                // may.createFile();

                // while(scan.hasNextLine())
                // {
                //     str.add(scan.nextLine());
                // }
                // scan.close();
            }
            catch(Exception e)
            {
                System.out.println("No file was found my dude");
                e.printStackTrace();
            }
        } 
        try
        {
            int i = 1;
            //String file = args[0];
            BufferedReader bf = new BufferedReader(new FileReader(args[0]));
            String[] arr;
            String read = bf.readLine();

            while(read != null)
            {
                arr = read.split(" ");
                if(i == 0)
                {
                    try
                    {
                        repeat = Integer.parseInt(read);
                        if(repeat < 0)
                            System.out.println("No negatives are permitted here, only positives");
                    }
                    catch(NumberFormatException e){
                        System.out.println("Only numbers/integers are allowed");
                    }
                }
                else 
                {
                    if(arr.length == 1)
                        continue;
                    if(arr.length != 5)
                        System.out.println("This" + i + "should have 5 params");
                }
                try
                {
                    AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), 
                        Integer.parseInt(arr[4])).registerTower(tow);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("The coordinates should only be digits");
                }
            }
            i++;
        } 
        catch(Exception e)
        {
            System.out.println("File not properly read");
        }
        while(repeat > 0)
        {
            tow.changeWeather();
            repeat--;
        }
    }
    
}

