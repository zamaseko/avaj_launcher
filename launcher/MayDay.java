package launcher;

import java.io.*;

public class MayDay {
    public void createFile() {
        File cf = new File("Simulation.txt");
        try
        {
           // cf.delete();
            cf.createNewFile();
        }
        catch (Exception e) 
        {
            System.out.println("The record log was not successfully established");
        }
    }

    public void writeRecord(String s)
    {
        FileWriter wr;
        try
        {
            wr = new FileWriter("Simulation.txt", true);
            wr.write(s + "\n");
            wr.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}

        