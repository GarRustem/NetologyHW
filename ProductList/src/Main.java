import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please, enter an option number: \t 1. Add a product; \t 2. Show product list; \t 3. Delete product from basket.");

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            try {
                if (Integer.parseInt(input) == 1) {
                    addProduct(list, scanner);
                } else if (Integer.parseInt(input) == 2) {
                    viewProductList(list);
                } else if (Integer.parseInt(input) == 3) {
                    deleteProduct(list, scanner);
                } else if (Integer.parseInt(input) == 4) {

                    searchProduct(list, scanner);
                } else {
                    System.out.println("You must use only numbers 1 - 4 to navigate through menu:\n1. Add a product;\n2. Show product list;\n3. Delete product from basket.\n4. Search a product from productList by productName");
                }
            } catch (Exception a) {
                System.out.println("You must use only numbers 1 - 4 to navigate through menu:\n1. Add a product;\n2. Show product list;\n3. Delete product from basket.\n4. Search a product from productList by productName");
            }
        }
    }

    private static void searchProduct(List<String> list, Scanner scanner) {
        String product = scanner.nextLine();
        String query = product.toLowerCase();
        String item;
        int count = 1;

        for (int i = 0; i < list.size(); i++) {
           item = list.get(i).toLowerCase();
           if (item.contains(query)) {
               System.out.println(count + ". " + list.get(i) + ".");
               count++;
           }
        }
    }

    private static void deleteProduct(List<String> list, Scanner scanner) {
        System.out.println("Please, enter a position number or product name which you need to delete from product list.");
        String delete = scanner.nextLine();
        int number;
        int index;

        try {
            number = Integer.parseInt(delete);
            if (number > list.size()) {
                System.out.println("You must use digits only for product number or characters only for product name - in accord to your actual product list.");
            } else {
                System.out.println("Product " + list.get(number - 1) + " deleted from your product list.");
                list.remove(number - 1);
                System.out.println("Your actual product list is: ");
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(j + 1 + ". " + list.get(j));
                }
            }
        } catch (Exception e) {
            if (list.contains(delete)) {
                index = list.indexOf(delete);
                System.out.println("Product " + list.get(index) + " deleted from your product list.");
                list.remove(delete);
                System.out.println("Your actual product list is: ");
                for (int k = 0; k < list.size(); k++) {
                    System.out.println(k + 1 + ". " + list.get(k));
                }
            } else {
                System.out.println("There is no product with name " + delete + " on your productList.");
            }
        }
    }

    private static void viewProductList(List<String> list) {
        System.out.println("Products from your list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    private static void addProduct(List<String> list, Scanner scanner) {
        System.out.println("Please, enter a product name.");
        String productName = scanner.nextLine();
        try {
            int wrongName = Integer.parseInt(productName); // check if productName is Integer.
            System.out.println("For name a product you must use only characters without digits and special symbols."); // ? How to restrict digits in productName (like "apple123") without using arrays?
        } catch (Exception m) {
            list.add(productName);
            System.out.println("Your product list contains " + list.size() + " position(s).");
        }
    }
}
