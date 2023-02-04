public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder city(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {
        if(age < 0 || age > 100) { //  || name.length() < 2 || surname.length() < 2
            throw new IllegalArgumentException("Incorrect data provided.");
        }

        if(name == null || surname == null) {
            throw new IllegalStateException("A Person must have name and surname.");
        }
        Person person;
        if(age > 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        return person;
    }

}
