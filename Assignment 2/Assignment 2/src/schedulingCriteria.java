import java.util.ArrayList;

public class schedulingCriteria {
    private double avgCpuUsage;
    private double avgWT;
    private double avgRT;
    private double avgTAT;

    public schedulingCriteria(ArrayList<process> pList, int clockTime, int idealTime) {
        criAvg(pList, clockTime, idealTime);
    }

    private void criAvg(ArrayList<process> pList, int clockTime, int idealTime) {
        for(int i = 0; i < pList.size(); i++){
            avgWT += pList.get(i).getWT();
            avgRT += pList.get(i).getRT();
            avgTAT += pList.get(i).getTAT();
        }
        avgCpuUsage = ((clockTime-idealTime) * 100.0) / clockTime;
        avgWT /= pList.size();
        avgRT /= pList.size();
        avgTAT /= pList.size();

        printer print = new printer();
        print.printCriAvg(avgCpuUsage, avgWT, avgRT, avgTAT);
    }
}
