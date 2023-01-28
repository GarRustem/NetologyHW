import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.util.Scanner;

public class Basket implements Serializable {

    protected String[] products = {"Milk", "Coffee", "Sugar"};
    protected int[] prices = {20, 300, 150};
    protected int[] goodsQuantity = new int[3];
    protected int count;
    protected int totalPrice = 0;
    protected int product;
    protected int quantity;
    protected ClientLog clientLog = new ClientLog();

    public Basket(String[] products, int[] prices) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        this.products = products;
        this.prices = prices;
        this.goodsQuantity = new int[products.length];
        this.count = 0;
    }
//------------------------!!!!!!!!!!!!!!!!!!!!!--------------------------------- ВСЕ ЗАРАБОТАЛО, КОГДА ВЫНЕС Scanner scanner И String delimiter = "," В МЕТОД addToCard()
    private Basket() {
    }

//    Scanner scanner = new Scanner(System.in); - ВЫНЕС В СТРОЧКУ 35 - В МЕТОД addToCard() <------------------------!!!!!!!!!!!!!!!!!!!!!---------------------------------<

    public void addToCard(int count, int[] goodsQuantity) {
        Scanner scanner = new Scanner(System.in);
        String delimiter = ",";

        System.out.println("Goods, available for sale:");

        for (int i = 0; i < products.length; i++) {
            String k = products[i];
            int j = prices[i];
            count++;
            System.out.println(count + ". " + k + " for " + j + " RUR/100g");
        }

        while (true) {
            System.out.println("Please, enter the name of the product and its quantity, separated by a comma, or type end.");
            String input = scanner.nextLine();
//            String delimiter = ","; - ВЫНЕС В СТРОЧКУ 36 - В МЕТОД addToCard() <------------------------!!!!!!!!!!!!!!!!!!!!!---------------------------------<

            if ("end".equals(input)) {

                clientLog.exportAsCSV(new File(".//client.csv"));
                break;
            }

            if (input.contains(delimiter)) {
                String[] parts = input.split(",");

                if (parts.length != 2) {
                    System.out.println("The order must contains one position from product list and one number of quantity for this product. Please, try again.");
                    continue;
                }

                try {
                    product = Integer.parseInt(parts[0]);
                    quantity = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("You must type only digits, separated by comma, not symbols");
                    break;
                }

                if (product > 3 || quantity < 1 || quantity > 9) {
                    System.out.println("Please, enter a right option from product list: numbers 1-3 for product type and number 1-9 for its quantity.");
                    continue;
                }

                int productPrice = prices[product - 1];
                goodsQuantity[product - 1] += quantity;
                totalPrice += productPrice * quantity;
                clientLog.log(product, quantity);
            } else {
                System.out.println("You must input product number and its quantity, separated by comma in format NUMBER,NUMBER");
            }
        }
    }

    public void printCart() {
        System.out.println("Your order list is:");
        for (int i = 0; i <= goodsQuantity.length - 1; i++) {
            if (goodsQuantity[i] != 0) {
                System.out.println(products[i] + " " + goodsQuantity[i] + " pieces for " + prices[i] + " RUR/100g is "
                        + goodsQuantity[i] * prices[i] + " RUR total");
            }
        }
        System.out.println("Total price is: " + totalPrice);
    }

    public void saveTextFile(File file) throws IOException {
        try (PrintWriter output = new PrintWriter(file)) {
            output.println(products.length);
            for (String product : products) {
                output.println(product);
            }
            for (int price : prices) {
                output.println(price);
            }
            for (int quantity : goodsQuantity) {
                output.println(quantity);
            }
        }
    }
    public static Basket loadFromTextFile(File file) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        try (BufferedReader basketFromFile = new BufferedReader(new FileReader(file))) {
            Basket basket = new Basket();
            int size = Integer.parseInt(basketFromFile.readLine());
            basket.products = new String[size];
            basket.prices = new int[size];
            basket.goodsQuantity = new int[size];

                for (int i = 0; i < basket.products.length; i++) {
                    basket.products[i] = basketFromFile.readLine();
                }
                for (int i = 0; i < basket.products.length; i++) {
                    basket.prices[i] = Integer.parseInt(basketFromFile.readLine());
                }
                for (int i = 0; i < basket.products.length; i++) {
                    basket.goodsQuantity[i] = Integer.parseInt(basketFromFile.readLine());
                }
            return basket;
        }
    }
    public void saveJson (File file) throws IOException {
        try (PrintWriter output = new PrintWriter(file)) {
            Gson gson = new Gson();
            String saveJsonForm = gson.toJson(this);
            output.println(saveJsonForm);
        }
    }
    public static Basket loadFromJson (File file) throws IOException {
        try (BufferedReader basketFromFile = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
            String json = basketFromFile.readLine();
            return gson.fromJson(json, Basket.class);
        }
    }
}