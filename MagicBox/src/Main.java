import java.util.Random;

public class Main {

    public static void main(String[] args) {

        MagicBox <String> stringMagicBox = new MagicBox<>(3);
        MagicBox <Integer> integerMagicBox = new MagicBox<>(5);

        stringMagicBox.add("Hat");
        stringMagicBox.add("Rabbit");
        stringMagicBox.add("Pigeon");

        integerMagicBox.add(3);
        integerMagicBox.add(5);
        integerMagicBox.add(7);
        integerMagicBox.add(9);
        integerMagicBox.add(11);

        String fromStringMB = stringMagicBox.pick();
        int fromIntegerMB = integerMagicBox.pick();

        System.out.println("From our boxes we take out " + fromIntegerMB + " " + fromStringMB + "s");
    }
}
