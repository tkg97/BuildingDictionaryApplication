package algorithms.string;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {
    
    @Override
    public int compare(Pair p1, Pair p2) {
        if(p1.frequency < p2.frequency) {
            return 1;
        }
        else if (p1.frequency > p2.frequency) {
            return -1;
        }
        return 0;
    }
}
