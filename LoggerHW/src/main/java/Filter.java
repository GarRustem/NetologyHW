import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int filterNum;

    public Filter(int filterNum) {
        this.filterNum = filterNum;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        return result;
    }
}
