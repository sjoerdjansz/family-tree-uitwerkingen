import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testPersonProperties() {

        // arrange
        Person hans = new Person("Hans", "Jansz", 60, "male");

        // act en assert
        assertEquals("Hans", hans.getName());
        assertEquals("Jansz", hans.getLastName());
        assertEquals(60, hans.getAge());
        assertEquals("male", hans.getSex());

    }
}