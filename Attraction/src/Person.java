public class Person {

    String name;
    String surname;
    int tickets;

    public Person (String name, String surname, int tickets) {
        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " has left " + this.tickets + " tickets.";
    }

}
