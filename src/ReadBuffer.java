import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadBuffer {
    private ArrayList<Process> processes; 
    private Scanner input;

    private ProcessBuilder processBuilder; 

    public ReadBuffer(){
        processes = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public ArrayList<Process> getProcesses(String filePath ) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int countOfLine=0; 
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", "); 
            int arrivalTime = Integer.parseInt(parts[0]);
            int priority = Integer.parseInt(parts[1]);
            int duration = Integer.parseInt(parts[2]);

            java.lang.Process processBuilder = Runtime.getRuntime().exec("java out/production/Multilevel-Dispatcher-Shell/Builder");
            processes.add(new Process(countOfLine, priority, arrivalTime, duration,processBuilder)); 
            countOfLine+=1;
        }
        return processes; 
    }

}
