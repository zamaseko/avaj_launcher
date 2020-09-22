package launcher;

import java.util.*;
import java.io.*;

public class Stimulator {
    public static WeatherTower tow = new WeatherTower();
    public static int i = 1;
    public static int rev;
    static  List<String> str = new ArrayList<>();

    public static void main(String[] args)
    {
        if(args.length <= 0)
            System.out.println("Error message");
        else
        {
            try    
            {
                File f =  new File(args[0]);
                Scanner scan = new Scanner(f);
                scan.hasNextLine();
                while(scan.hasNextLine())
                {
                    str.add(scan.nextLine());
                }
                scan.close();
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}

