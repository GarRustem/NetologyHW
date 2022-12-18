import java.io.*;
import java.util.Scanner;

public class Basket {
    protected String[] products;
    protected int[] prices;
    protected int[] goodsQuantity = new int[3];
    protected int totalPrice = 0;
    protected int count = 0;
    protected int product;
    protected int quantity;

    protected FileWriter basketFile;

    public Basket(String[] products, int[] prices) {
        this.products = products;
        this.prices = prices;
    }
    Scanner scanner = new Scanner(System.in);

    public void addToCart(int count, int[] goodsQuantity) {
        this.count = count;
        this.goodsQuantity = goodsQuantity;

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
            String delimiter = ",";

            if ("end".equals(input)) {
                break;
            } else if (input.contains(delimiter)) {

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

                saveTxt(goodsQuantity, product);

            } else {
                System.out.println("You must input product number and its quantity, separated by comma in format NUMBER,NUMBER");
                break;
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

    public void saveTxt(int[] goodsQuantity, int product) {
        try {
                basketFile = new FileWriter(".//productBasket.txt", true);
                basketFile.write(products[product - 1]);
                basketFile.write("\t");
                basketFile.write(" - ");
                basketFile.write("\t");
                basketFile.write(String.valueOf(goodsQuantity[product - 1]));
                basketFile.write("\n");
                basketFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Basket loadFromTxtFile (File basketFile) throws IOException {
        if (!basketFile.exists()) {
            basketFile = new File(".//productList.txt");
        }
        return Basket.loadFromTxtFile(basketFile);
    }
}
