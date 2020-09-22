package launcher;

import java.util.*;
import java.io.*;

public class Stimulator {
    public static WeatherTower t = new WeatherTower();
    public static int i;
    public static void main(String [] args) throws FileNotFoundException {
        if(args.length >= 1)
        {
            File f = new File(args[0]);
            Scanner scan = new Scanner(f);
            scan.nextLine();
            changeConditions();
            scan.close();
        }
        else 
        {
            System.out.println("Hheyi wena git me at least one argument");
        }
    }
    
    public static void validate(String str)
    {
        //AircraftFactory aircraftFactory = new AircraftFactory();
        String read;
        
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(str));
            String sp[]; 
            boolean z = true;
            int y = 1;
            while((read = br.readLine()) != null)
            {
                if(z != false && y == 1){
                    try {
                        i = Integer.parseInt(read);
                    } catch (NumberFormatException e) {
                        System.out.println("We only need positive numbers here okay");
                        return ;
                    }
                }
                else{
                    sp = read.split(" ");
                    if(sp.length != 5)
                    {
                        System.out.println("We want 5 parameters my G");
                    }
                    if( sp.length == 1)
                        continue ;
                    try
                    {
                        if(Integer.parseInt(sp[2]) < 0 || Integer.parseInt(sp[3]) < 0 || Integer.parseInt(sp[4]) < 0)
                        {
                            System.out.println("No negative coordinates allowed");
                        }
                        else
                        {
                            AircraftFactory.newAircraft(sp[0], sp[1], Integer.parseInt(sp[2]), Integer.parseInt(sp[3]),
                                    Integer.parseInt(sp[4])).registerTower(t);
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error. Fix this" + read);
                        return ;
                    }
                }
                y++;
            }
        }
        catch (Exception e)
        {
            System.out.println("Reading file error");
            return ;
        }
    }
    public static void changeConditions(){
        while (i > 0){
            t.changeWeather();
            i--;
        }
    }
}

