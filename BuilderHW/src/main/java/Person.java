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
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public void happyBirthday() {
        int newAge = getAge() + 1;
        setAge(newAge);
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

//    @Override
//    public String toString() {return null;}
//    @Override
//    public int hashCode() {return 0;}

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.surname(this.surname);
        builder.age(0);
        builder.city(this.city);
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
        return age;
    }

    public String getCity() {
        return city;
    }
}
