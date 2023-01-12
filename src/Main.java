import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.SystemColor.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
            ReadBuffer in = new ReadBuffer(); 
            
            ArrayList<Process> processes = in.getProcesses("giriş.txt");
            
            ArrayList<ProcessProcessing> gantt = new Scheduling().getSchedular(processes);
            
            System.out.print(gantt.toString().replace(", ",""));
    }
}