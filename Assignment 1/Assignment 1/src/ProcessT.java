public class ProcessT implements Runnable{
    private int id;
    private int numOfChild;
    private RNG rand = new RNG();
    private int time;

    public ProcessT(int id){
        this.numOfChild = rand.randNumChild();
        this.id = id;
        this.time = rand.sleepTime() * 1000;
    }

    @Override
    public void run() {
        try{
            System.out.println("Waiting for process to be created...");
            Thread.sleep(time);
            System.out.println("Created process in index " + id);

            Kolonel q = new Kolonel();

            for (int i = 0; i < numOfChild; i++) {
                q.Create(id);
            }
            q.Destroy(id);
            System.out.println("Deleted process in index " + id);

            if (id == 0) {
                System.out.println("All process ended!!!");
            }

        }catch (Exception e){}
    }
}
