import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class inputReader {
    private final ArrayList<process> processList = new ArrayList<>();
    private Scanner myReader;

    public void openFile(){
        try {
            myReader = new Scanner(new File("assignment2.txt"));
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public void readFile(){
        while (myReader.hasNextLine()) {
            int ID = Integer.parseInt(myReader.next());
            int ariTime = Integer.parseInt(myReader.next());
            int burstLength = Integer.parseInt(myReader.next());
            int priority = Integer.parseInt(myReader.next());
            process p = new process(ID, ariTime, burstLength, priority);
            processList.add(p);
        }
        scheduler s = new scheduler();
        s.addToRdyQueue(processList);
    }

    public void closeFile(){
        myReader.close();
    }
}