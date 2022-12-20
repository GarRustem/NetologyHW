import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class Test {

    //    @BeforeEach
    Person person = new Person("Alex", "Orlov", 30);

    @org.junit.jupiter.api.Test
    public void testMainPositive() {
        // Condition
        final int condition = person.getTickets();
        // Expected
        final int expected = 30;
        // Check
        Assertions.assertEquals(expected, condition);
    }

    @org.junit.jupiter.api.Test
    public void testMainNegative() {
        // Condition
        final String condition = person.getName();
        // Expected
        final String expected = "John";
        // Check
        Assertions.assertEquals(expected, condition);
    }

    @org.junit.jupiter.api.Test
    public void testMainExceptions() {
        // TestData
        final int[] i = new int[1]; // Почему не работает вариант final int i; с последующим () -> i = condition/j?
        final int j = 0;
        // Condition
        final int condition = person.getTickets();
        // Expected ArithmeticException
        // Check
        Assertions.assertThrows(ArithmeticException.class, () -> i[0] = condition/j);
    }
}
