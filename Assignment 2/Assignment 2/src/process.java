public class process {
    private int ID;
    private int ariTime;
    private int burstLength;
    private int priority;
    private int tickets;
    private int ST;
    private int CT;
    private int TAT;
    private int WT;
    private int RT;

    public process(int id, int ariTime, int burstLength, int priority) {
        this.ID = id;
        this.ariTime = ariTime;
        this.burstLength = burstLength;
        this.priority = priority;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public void setStartTime(int ST) {
        this.ST = ST;
    }

    public void setCompTime(int CT) {
        this.CT = CT;
        setTAT();
    }

    private void setTAT() {
        this.TAT = this.CT - this.ariTime;
        setWT();
    }

    private void setWT() {
        this.WT = this.TAT - this.burstLength;
        setRT();
    }

    private void setRT() {
        this.RT = this.ST - this.ariTime;
    }

    public int getID(){
        return ID;
    }

    public int getAriTime(){
        return ariTime;
    }

    public int getBurstLength(){
        return burstLength;
    }

    public int getPriority(){
        return priority;
    }

    public int getTickets(){
        return tickets;
    }

    public double getWT() {
        return this.WT;
    }

    public double getRT() {
        return this.RT;
    }

    public double getTAT() {
        return this.TAT;
    }
}
