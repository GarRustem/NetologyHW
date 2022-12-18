import java.io.File;

public class Main {

  public static void main(String[] args) throws Exception {

    String[] products = { "Milk", "Coffee", "Sugar" };
    int[] prices = { 20, 300, 150 };
    int[] goodsQuantity = new int[3];
    int count = 0;

    Basket basket = new Basket(products, prices);

    //Basket.loadFromTxtFile(new File(".//productList.txt")); // Не понимаю, почему не работает загрузка данных из файла.
    // хотя и без этого метода программа либо создает новый текстовый файл, либо заполняет существующий.

    basket.addToCart(count, goodsQuantity);

    basket.printCart();

    basket.saveTxt(goodsQuantity, basket.product);










































//    String[] products = { "Milk", "Coffee", "Sugar" };
//    int[] prices = { 20, 300, 150 };
//    int[] goodsQuantity = new int[3];
//    int totalPrice = 0;
//    int count = 0;

//    System.out.println("Goods, available for sale:");
//
//    for (int i = 0; i < products.length; i++) {
//      String k = products[i];
//      int j = prices[i];
//      count++;
//      System.out.println(count + ". " + k + " for " + j + " RUR/100g");
//    }
//
//    Scanner scanner = new Scanner(System.in);
//
//    while (true) {
//
//      System.out.println("Please, enter the name of the product and its quantity, separated by a comma, or type end.");
//
//      String input = scanner.nextLine();
//      String delimiter = ",";
//
//      if ("end".equals(input)) {
//        System.out.println("Your order list is:");
//        break;
//      } else if (input.contains(delimiter)) {
//
//        String[] parts = input.split(",");
//
//        if (parts.length != 2) {
//          System.out.println("The order must contains one position from product list and one number of quantity for this product. Please, try again.");
//          continue;
//        }
//
//        int product;
//        int quantity;
//
//        try {
//          product = Integer.parseInt(parts[0]);
//          quantity = Integer.parseInt(parts[1]);
//        } catch (NumberFormatException e) {
//          System.out.println("You must type only digits, separated by comma, not symbols");
//          break;
//        }
//        if (product > 3 || quantity < 1 || quantity > 9) {
//          System.out.println("Please, enter a right option from product list: numbers 1-3 for product type and number 1-9 for its quantity.");
//          continue;
//        }
//
//        int productPrice = prices[product - 1];
//        goodsQuantity[product - 1] += quantity;
//        totalPrice += productPrice * quantity;
//      } else {
//        System.out.println("You must input product number and its quantity, separated by comma in format NUMBER,NUMBER");
//        break;
//      }
//    }
//
//    for (int i = 0; i <= goodsQuantity.length - 1; i++) {
//      if (goodsQuantity[i] != 0) {
//        System.out.println(products[i] + " " + goodsQuantity[i] + " pieces for " + prices[i] + " RUR/100g is "
//            + goodsQuantity[i] * prices[i] + " RUR total");
//      }
//    }
//
//    System.out.println("Total price is: " + totalPrice);
  }
}
