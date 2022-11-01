public class Main {
    public static void main(String[] args) {

        SalesManager salesManager = new SalesManager(new long[]{1,29,4,12,13,19,21,25,26,27});

        long maxElement = salesManager.max();

        long minElement = salesManager.min();

        long averageStat = salesManager.stat(minElement, maxElement);

        System.out.println(minElement);

        System.out.println(maxElement);

        System.out.println(averageStat);
    }
}
