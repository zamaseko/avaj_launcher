package launcher;

//import java.util.*;
import java.io.*;

public class Simulator {
    public static int rep;
    public static PrintWriter writer;

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        WeatherTower weatherTower = new WeatherTower();
        //AircraftFactory aircraftFactory = new AircraftFactory(){};

        if (args.length < 1) {
            System.out.println("Error: Enter a file");
            return;
        }
        //MayDay may = new MayDay();
        String filename = args[0];
        //File simulationFile = new File("Simulation.txt");
        //= may.createFile();
        // try {
        //     writer = new PrintWriter(simulationFile);
        // } catch (FileNotFoundException e) {
        //     System.out.println("Error message: " + e.getMessage());
        //     return;
        // }

        // if(simulationFile.exists())
        //     writer.println("");
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            int scenarioLine = 1;
            String[] arr;

            while ((line = bufferedReader.readLine()) != null) {
                if (scenarioLine == 1) {
                    try {
                        rep = Integer.parseInt(line);
                        if (rep < 0) {
                            System.out.println("First line of scenario file must be a POSITIVE number!.");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("First line of scenario file must be a number.");
                        return;
                    }
                } else {
                    arr = line.split(" ");
                    if (arr.length == 1 && arr[0].isEmpty()) // Do not consider empty lines
                        continue;
                    if (arr.length != 5) {
                        System.out.println("Line " + scenarioLine + " must have 5 parameters.");
                        return;
                    }
                    try {
                        AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
                                Integer.parseInt(arr[4])).registerTower(weatherTower);
                    } catch (NumberFormatException e) {
                        System.out.println("Longitude ,Latitude and Height must to be numbers.");
                        System.out.println("Check line " + scenarioLine + ".");
                        return;
                    }catch (Exception ex) {
                        System.out.println("Invaild Aircraft type on line " + scenarioLine + ".");
                        return;
                    }

                }
                scenarioLine++;
            }
            //bufferedReader.close();
            
        } catch (Exception e) {
            System.out.println("Reading file failed error: " + e.getMessage() + ".");
            return;
        }
        finally {
            try {
                if (bufferedReader != null)
                bufferedReader.close();

            } catch (IOException ex) {
                System.err.format("IOException: %s%n hello", ex);
            }
        }

        while (rep > 0) {
            //writer.println("\n---------------->\n");
            weatherTower.changeWeather();
            rep--;
        }
        //writer.close();
        System.out.println("Simulation Completed!");
    }

}
