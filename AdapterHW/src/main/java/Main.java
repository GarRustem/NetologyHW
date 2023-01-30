public class Main {

    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        int pow = calc.pow(2,4);
        int sum = calc.sum(5,7);
        int mult = calc.mult(7,9);

        System.out.println("Result of pow is: " + pow + " \n" + "Result of sum is: " + sum + " \n" + "Result of mult is: " + mult + " \n");
    }
}
