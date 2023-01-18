import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {

    public static void main(String[] args) throws IOException {

        String[] products = {"Milk", "Coffee", "Sugar"};
        int[] prices = {20, 300, 150};
        Basket basket = new Basket(products, prices);
        File file = new File(".//basket.bin");

        try {
            if (file.exists()) {
                Basket restoredBasket = Basket.loadFromBin(file);
                restoredBasket.printCart();
            } else {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Program is broken");
        }

        basket.addToCard(basket.count, basket.goodsQuantity);

        basket.printCart();

        basket.saveBin(file);
    }
}
