public class Main {

    public static void main(String[] args) {

        for (int r : new Randoms(90, 100)) {
            System.out.println("Случайное число: " + r);
            if (r > 98) {
                System.out.println("Давайте на этом закончим");
                break;
            }
        }
    }
}
