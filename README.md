
# SalesManager
Для работы с программой необходимо создать объект класса **SalesManager()**, в аргумент которого передается одномерный массив целочисленных типов данных, где каждый элемент массива - дневная выручка.
Для определения максимального значения дневной выручки необходимо посредством точечной нотации вызвать метод **max()** созданного объекта класса **SalesManager()**.
Так как метод **max()** возвращает максимальное значение из содержащихся в массиве, <ins>*нужно присвоить данное значение переменной*</ins>, чтобы можно было вывести его на экран.

###### Ниже приведен пример реализации программы

```public class Main {
    public static void main(String[] args) {

        SalesManager salesManager = new SalesManager(new int[]{1,29,4,12,13,19,21,25,26,27});

        int maxElement = salesManager.max();

        System.out.println(maxElement);

    }
}
```
###### Результат работы программы - значение **29**
