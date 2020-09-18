package launcher;

import java.util.*;
import java.io.*;

public class Stimulator {
    public static void main(String[] args) {
        List<String> in = new ArrayList<>();
        try 
        {
            File f = new File(args[0]);
            Scanner scan = new Scanner(f);
            MayDay may = new MayDay();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        
    }
}
