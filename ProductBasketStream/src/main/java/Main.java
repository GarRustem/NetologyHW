import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] products = {"Milk", "Coffee", "Sugar"};
        int[] prices = {20, 300, 150};
        Basket basket = new Basket(products, prices);
        File file = new File(".//productBasket.txt");

        try {
            if (file.exists()) {
                Basket.loadFromTextFile(file);
                basket.printCart();
            } else {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Program is broken");
        }

        basket.addToCard(basket.count, basket.goodsQuantity);

        basket.printCart();

        basket.saveTextFile(file);
    }
}
