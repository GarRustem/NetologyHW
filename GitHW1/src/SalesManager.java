public class SalesManager {
    protected long[] sales;

    public SalesManager(long[] sales) {
        this.sales = sales;
    }
    public long max() {
        long max = -1;
        for (long sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }

    public long min() {
        long min = 10;
        for (long sale : sales) {
            if (sale < min) {
                min = sale;
            }
        }
        return min;
    }

    public long stat(long min, long max) {
        long average = 0;
        for (int i = 0; i < sales.length; i++) {
            average = average + sales[i];
        }
        return (average - min - max)/(sales.length - 2);
    }
}
