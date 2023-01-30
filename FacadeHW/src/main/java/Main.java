public class Main {

    public static void main(String[] args) {

        BinOps bins = new BinOps();

        String sum = bins.sum("10","12");
        String mult = bins.mult("15","17");

        System.out.println("Result of sum is: " + sum + " \n" + "Result of mult is: " + mult + " \n");
    }
}
