package launcher;

// import java.io.*;
// import java.lang.*;
import java.util.*;

public class MayDay{
    private Formatter x;

    public void createFile()
    {
        try
        {
            x = new Formatter("stimulator.txt");
        }
        catch(Exception e)
        {
            System.out.println("stimulator.txt was not created okkkrrr");
        }
    }
    public void writeRecord(String s)
    {
        try
        {
            x.format("%s\n");
        }
        catch(Exception e)
        {
            System.out.println("stimulator.txt was not populated Okkkrrr");;
        }
    }
    public void closeFile()
    {
        x.close(); 
    }

}
// import java.io.*;

// public class MayDay {
//     public void createFile() {
//         File cf = new File("stimulation.txt");
//         try
//         {
//            // cf.delete();
//             cf.createNewFile();
//         }
//         catch (Exception e) 
//         {
//             System.out.println("The record log was not successfully established");
//         }
//     }

//     public void writeRecord(String s)
//     {
//        // FileWriter wr;
//         try
//         {
//             FileWriter wr = new FileWriter("stimulation.txt", true);
//             wr.write("%s\n");
//             wr.close();
//         }
//         catch (IOException e) 
//         {
//             e.printStackTrace();
//         }
//     }
// }

        