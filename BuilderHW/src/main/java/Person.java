public class Person {

    private String name;
    private String surname;
    private int age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void happyBirthday() {
        if(hasAge()) {
            int newAge = getAge() + 1;
            setAge(newAge);
        }
    }

    public boolean hasAge() {
        if(age < 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (city == null) {
            return false;
        } else {
            return true;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.surname(surname);
        builder.age(0);
        builder.city(city);
        return builder;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if(hasAge()) {
            return age;
        } else {
            return 0;
        }
    }

    public String getCity() {
            return city;
    }
}
