import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int listSize;
        int sizeBound;
        int filterBound;

        Random random = new Random();
        List<Integer> result = new ArrayList<>(); // Для формирования начального списка по заданным длине и границе.

        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();

        logger.log("Start the Program.");
        logger.log("Ask user to enter input data for list.");

        System.out.println("Please, enter listSize.");
        listSize = scanner.nextInt();

        System.out.println("Please, enter sizeBound.");
        sizeBound = scanner.nextInt();

        // Заполняем начальный список согласно заданным длине и границе.
        for(int i = 0; i < listSize; i++) {
            int number = random.nextInt(sizeBound);
            if (number == 0) {
                number = number + 1;
                result.add(number);
            } else {
                result.add(number);
            }
        }

        logger.log("Form the list.");
        System.out.println("List: " + result);

        logger.log("Ask user to input filterBound.");

        System.out.println("Please, enter a filterBound.");
        filterBound = scanner.nextInt();
        Filter filter = new Filter(filterBound); // Не понадобился =(

        logger.log("Filtration begin.");

        filter.filterOut(result); // Логика фильтрации чисел, подходящих условию “число больше filterBound”.

        logger.log(filter.filterOut(result).size() + " elements from list of " + listSize + " passed the filtration.");
        logger.log("Show the result on display.");
        System.out.println("Filtered result is: " + filter.filterOut(result));

        logger.log("Exit the Program");
    }
}
