import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // для удобства оценки работы программы можно задать i < 10 и раскомментировать строки 22-26.
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println(persons); // Для i < 10 вместо i < 10_000_000 в строке 11 - удобство проверки работы программы.

        for(Person person : persons) { // Для i < 10 вместо i < 10_000_000 в строке 11 - удобство проверки работы программы.
            System.out.println(person.getAge());
        }

        infant(persons);

        duty(persons);

        worker(persons);
    }

    private static void worker(Collection<Person> persons) {
        List <String> worker = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getEducation().equals(Education.HIGHER) && person.getAge() < 65 && person.getSex().equals(Sex.MAN)
                        || person.getAge() > 18
                        && person.getAge() < 60 && person.getSex().equals(Sex.WOMAN) && person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::getFamily)
                .toList();
        System.out.println("Workers with higher degree from list is: " + worker + " by count: " + worker.size());
    }

    private static void duty(Collection<Person> persons) {
        List <String> duty = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 27)
                .map(Person::getFamily)
                .toList(); // можно ли вывести еще и количество человек? (именно в терминальной части потока задать такую возможность)
        System.out.println("Persons under duty is: " + duty + " by count: " + duty.size());
    }

    private static void infant(Collection<Person> persons) {
        int infant = (int) persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Count for infant persons from list is: " + infant);
    }
}
