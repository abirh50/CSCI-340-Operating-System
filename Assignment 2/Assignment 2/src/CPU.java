public class CPU {
    private int clockTime = 0;
    private printer print = new printer();
    private int idealTime = 0;

    public void startProcess(process p) {
        while(clockTime < p.getAriTime()){
            print.printIdle(clockTime);
            clockTime++;
            idealTime++;
        }

        p.setStartTime(clockTime);

        for(int i = 0; i < p.getBurstLength(); i++){
            print.isRunning(clockTime, p.getID());
            clockTime++;
        }
        p.setCompTime(clockTime);

        print.finished(clockTime, p.getID());
    }

    public void allFin() {
        print.allProcessDone(clockTime);
    }

    public int getClockTime(){
        return clockTime;
    }

    public int getIdealTime() {
        return idealTime;
    }
}
