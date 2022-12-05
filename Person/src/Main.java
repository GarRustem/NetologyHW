import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> person = new ArrayList<>();
        person.add(new Person("Alex", "Smirnov", 75));
        person.add(new Person("Sarah", "Mirn Torn", 44));
        person.add(new Person("Olga", "Taar Helga Ivanova Mishina", 31));
        person.add(new Person("Boris", "Nikiforov", 26));
        person.add(new Person("Mikhail", "Abcdefgqwerty", 26));
        person.add(new Person("Haar", "Khart Tron Loassar", 55));
        person.add(new Person("Var", "Kaart Hort Maassar", 32));
        person.add(new Person("FivePartSurname", "Qwe Rty Uio Asd Zxc", 31));
        person.add(new Person("SixPartSurname", "Qaz Wsx Edc Rfv Tgb Yhn", 19));


        System.out.println(person); // Проверка стандартного порядка для List

        person.sort((Person o1, Person o2) -> {
            int limit = 5; // Все фамилии с количеством слов 5 и более считаются одинаковыми и сравниваются по возрасту.
            String[] royalSurnameA = o1.getSurname().split(" ");
            String[] royalSurnameB = o2.getSurname().split(" ");

            if (royalSurnameA.length == royalSurnameB.length || royalSurnameA.length >= limit && royalSurnameB.length >= limit) {
                return Integer.compare(o1.getAge(), o2.getAge());
            } else {
                return Integer.compare(royalSurnameA.length, royalSurnameB.length);
            }
        });

        System.out.println(person); // Проверка заданной сортировки. Как реализовать обратную сортировку, чтобы первым шел самый знатный?
    }
}
