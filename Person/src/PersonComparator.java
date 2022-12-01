import java.util.Comparator;

public class PersonComparator implements Comparator <Person> {

    private int limit;
    public PersonComparator(int limit) {
        this.limit = limit;
    }

    @Override
    public int compare(Person o1, Person o2) {

        String[] royalSurnameA = o1.getSurname().split(" ");
        String[] royalSurnameB = o2.getSurname().split(" ");

        if (royalSurnameA.length == royalSurnameB.length || royalSurnameA.length >= limit && royalSurnameB.length >= limit) {
            return Integer.compare(o1.getAge(), o2.getAge());
        } else {
            return Integer.compare(royalSurnameA.length, royalSurnameB.length);
        }
    }
}



