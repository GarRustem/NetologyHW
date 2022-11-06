import java.util.Random;

public class MagicBox <T> {

    protected final int MAX_ITEM;
    protected T [] items;

    public MagicBox(int max_item) {
        MAX_ITEM = max_item;
        items = (T[]) new Object [MAX_ITEM];
    }

    public boolean add (T item) {
        boolean flag = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public T pick () {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                throw new RuntimeException("The Box is not fulfilled.");
            }
        }
        Random random = new Random();
        int index = random.nextInt(MAX_ITEM);
        return items[index];
    }
}
