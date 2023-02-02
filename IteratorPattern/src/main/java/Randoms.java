import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomIterator<Integer>();
    }

    public class RandomIterator<Integer> implements Iterator<java.lang.Integer> {
        Random random = new Random();

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public java.lang.Integer next() {
            return min + random.nextInt(max - min);
        }
    }
}
