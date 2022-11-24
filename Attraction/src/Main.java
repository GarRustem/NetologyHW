import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<Person> generateClients() {

        List <Person> person = new LinkedList<>();
        person.add(new Person("Olga", "Alekseevna", 9));
        person.add(new Person("Andrey", "Aleksandrov", 11));
        person.add(new Person("Alex", "Smith", 10));
        person.add(new Person("Samantha", "Johns", 8));
        person.add(new Person("Mikhail", "Semenov", 12));
        return person;
    }

    public static void main(String[] args) {

        Queue<Person> queue = new LinkedList<>(generateClients());

        while(!queue.isEmpty()) {
            Person person = queue.poll();
            person.setTickets(person.getTickets() - 1);
            System.out.println(person.getName() + " " + person.getSurname() + " has ride attraction and left " + person.getTickets() + " tickets.");
            if (person.getTickets() > 0) {
                queue.offer(person);
            }
        }
    }
}
