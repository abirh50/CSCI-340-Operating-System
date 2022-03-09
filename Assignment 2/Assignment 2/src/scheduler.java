import java.util.*;

public class scheduler {
    private final ArrayList<process> ReadyQueue = new ArrayList<>();
    private final ArrayList<process> won = new ArrayList<>();
    private final int SPN = 10;
    private final int LPN = 100;
    private final int M = 200;
    private int totalNumberTickets;

    public void addToRdyQueue(ArrayList<process> pList) {
        for (process i: pList) {
            i.setTickets(genLotteryTickets(i.getPriority()));
            totalNumberTickets += i.getTickets();
            ReadyQueue.add(i);
        }

        nextRunningProcess(pList);
    }

    private void nextRunningProcess(ArrayList<process> pList) {
        printer print = new printer();
        print.intro();

        CPU c = new CPU();

        while(!ReadyQueue.isEmpty()) {
            int counter = 0;
            int winner = new Random().nextInt(totalNumberTickets + 1);
            int current = 0;
            while (current < ReadyQueue.size()) {
                counter = counter + ReadyQueue.get(current).getTickets();
                if (counter > winner) {
                    c.startProcess(ReadyQueue.get(current));
                    this.won.add(ReadyQueue.get(current));
                    ReadyQueue.remove(current);

                    break;
                }
                current++;
            }
        }

        c.allFin();

        schedulingCriteria sc = new schedulingCriteria(won, c.getClockTime(), c.getIdealTime());
    }

    private int genLotteryTickets(int P) {
        return (int) ((1 - (P - SPN) * 1.0 / (LPN - SPN + 1)) * M);
    }
}
