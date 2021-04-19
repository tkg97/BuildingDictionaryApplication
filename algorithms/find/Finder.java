package algorithms.find;

import java.util.Comparator;
import java.util.List;

public interface Finder<T> {

    public List<T> getOrderedElements(List<T> elements, Comparator<T> orderComparator, int num);

}
