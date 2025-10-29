import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    public void testPetProperties() {
        // arrange
        Pet dog = new Pet("Doge", 12, "Labradoodle");

        // act & assert
        assertEquals("Doge", dog.getName());
        assertEquals(12, dog.getAge());
        assertEquals("Labradoodle", dog.getSpecies());
    }
}