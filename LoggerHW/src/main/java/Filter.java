import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int filterNum;

    public Filter(int filterNum) {
        this.filterNum = filterNum;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> filtered = new ArrayList<>(); // Для формирования списка после фильтрации: составляется из чисел, больших проверочного.
        for (int number : source) {
            if (number > filterNum) {
                filtered.add(number);
            }
        }
        return filtered;
    }
}
