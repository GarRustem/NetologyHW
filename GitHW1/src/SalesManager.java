public class SalesManager {
    protected int[] sales;

    public SalesManager(int[] sales) {
        this.sales = sales;
    }
    public int max() {
        int max = -1;
        for (int sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }

    public int min() {
        int min = 10;
        for (int sale : sales) {
            if (sale < min) {
                min = sale;
            }
        }
        return min;
    }

    public int stat(int min, int max) {
        int average = 0;
        for (int i = 0; i < sales.length; i++) {
            average = average + sales[i];
        }
        return (average - min - max)/(sales.length - 2);
    }
}
