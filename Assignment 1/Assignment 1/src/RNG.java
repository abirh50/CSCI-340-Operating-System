import java.util.Random;

public class RNG {
    private int min;
    private int max;
    private int r;

    private Random rand = new Random();

    public int randNumChild(){
        min = 0;
        max = 5;

        r = rand.nextInt(max - min + 1) + min;

        return r;
    }

    public int sleepTime(){
        min = 11;
        max = 30;

        r = rand.nextInt(max - min + 1) + min;

        return r;
    }
}
