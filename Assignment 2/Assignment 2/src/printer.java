public class printer {
    public void intro() {
        System.out.println("Lottery Scheduling Algorithm");
        System.out.println("============================================================");
    }

    public void isRunning(int clockTime, int id) {
        System.out.printf("<system time %5d> process %5d is running\n", clockTime, id);
    }

    public void finished(int clockTime, int id) {
        System.out.printf("<system time %5d> process %5d is finished....\n", clockTime, id);
    }

    public void allProcessDone(int clockTime) {
        System.out.printf("<system time %5d> All processes finished......\n", clockTime);
    }

    public void printCriAvg(double avgCpuUsage, double avgWT, double avgRT, double avgTAT) {
        System.out.println("============================================================");
        System.out.printf("Average CPU usage:       %7.2f%%\n" +
                          "Average waiting time:    %7.2f\n" +
                          "Average response time:   %7.2f\n" +
                          "Average turnaround time: %7.2f\n", avgCpuUsage, avgWT, avgRT, avgTAT);
        System.out.println("============================================================");
    }

    public void printIdle(int clockTime) {
        System.out.printf("<system time %5d> CPU is idle\n", clockTime);
    }
}
