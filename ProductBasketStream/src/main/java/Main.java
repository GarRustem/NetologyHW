import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

        String[] products = {"Milk", "Coffee", "Sugar"};
        int[] prices = {20, 300, 150};
        Basket basket = new Basket(products, prices);
        Behavior behavior = new Behavior();
        File file = new File(behavior.loadFileName);
        File textFile = new File(".//productBasket.txt");

        if (behavior.doLoad) {
            switch (behavior.loadFormat) {
                case "json":
                    basket = Basket.loadFromJson(file);
                    break;
                case "txt":
                    basket = Basket.loadFromTextFile(file);
                    break;
            }
        } else {
            basket = new Basket(products, prices);
        }

        try {
            if (textFile.exists()) {
                Basket restoredBasket = Basket.loadFromTextFile(textFile);
                restoredBasket.printCart();
            } else {
                textFile.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Program is broken");
        }

        basket.addToCard(basket.count, basket.goodsQuantity);

        basket.printCart();

        basket.saveTextFile(textFile);

        basket.saveJson(file);
    }
}


