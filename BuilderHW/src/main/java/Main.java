public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Person mother = new PersonBuilder()
                .name("July")
                .surname("Johns")
                .age(31)
                .city("Moscow")
                .build();

        Person son = mother.newChildBuilder()
                .name("Victor")
                .build();

        System.out.println(mother.getName() + " " + mother.getSurname() + " has a son, named " + son.getName() + " " + son.getSurname());
        System.out.println(son.getName() + " is born at " + son.getCity() + " and he is " + son.getAge() + " years old.");

//        try {
//            new PersonBuilder().build();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }

        try {
            new PersonBuilder().age(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
