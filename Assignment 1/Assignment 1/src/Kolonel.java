import java.util.LinkedList;

public class Kolonel {
    private static String[] PCBs = new String[100];
    private LinkedList<PCB_structure> child;
    private Thread t;

    public Thread Create(int p){
        int qIndex = findFreeIndex();

        PCB_structure q;

        child = new LinkedList<PCB_structure>();

        if(PCBs[qIndex] == null){
            PCBs[qIndex] = String.valueOf(p);
            q = new PCB_structure(p, qIndex);
            child.add(q);
            t = new Thread(new ProcessT(qIndex));
            t.start();

            try{
                t.join();
            }catch (Exception e){}
        }

        return t;
    }

    public void Destroy(int p){
        int pId = Integer.parseInt(PCBs[p]);
        PCBs[p] = null;
    }

    private int findFreeIndex(){
        boolean free = false;
        int id = 0;
        for (int i = 0; i < PCBs.length; i++){
            if(PCBs[i] == null){
                id = i;
                free = true;
                break;
            }
        }

        if(!free){
            System.out.println("No free PCB index found!!!!");
            System.out.println("Ending program.");
            System.exit(-1);
        }

        return id;
    }
}
