package launcher;

import java.io.*;

public class MayDay {
    public void createFile() {
        File cf = new File("stimulation.txt");
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
       // FileWriter wr;
        try
        {
            FileWriter wr = new FileWriter("stimulation.txt", true);
            wr.write("%s\n");
            wr.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}

        