import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personProperties() {

        // arrange
        Person hans = new Person("Hans", "Jansz", 30, "male");
        Person child = new Person("Child", "Jansz", 3, "male");
        Person father = new Person("Father", "Jansz", 70, "male");
        Person mother = new Person("Mother", "Jansz", 68, "female");
        hans.addParents(father, mother);
        hans.addChild(child);
        Pet cat = new Pet("Kitty", 10, "Vuilnisbak");
        hans.addPet(cat);

        // act en assert
        assertEquals("Hans", hans.getName());
        assertEquals("Jansz", hans.getLastName());
        assertEquals(30, hans.getAge());
        assertEquals("male", hans.getSex());
        assertEquals(father, hans.getFather());
        assertEquals(mother, hans.getMother());
        assertEquals(List.of(cat), hans.getPets());
        assertEquals(List.of(child), hans.getChildren());
        assertEquals(List.of(child), father.getGrandChildren());
    }

    @Test
    public void addChildAndSetRightParent() {
        // arrange
        Person child = new Person("Child", "Jansz", 3, "male");
        Person father = new Person("Father", "Jansz", 70, "male");

        // act
        father.addChild(child);

        // assert: kind staat in lijst van de vader
        assertTrue(father.getChildren().contains(child));

        // assert: childs vader is gezet
        assertEquals(father, child.getFather());


        // assert: checken of de moeder niet per ongeluk (ook) is gezet
        assertNull(child.getMother());
    }

    @Test
    public void addPetToPerson() {

        // arrange
        Person sjoerd = new Person("Sjoerd", "Jansz", 35, "male");
        Pet cat = new Pet("Umberto", 10, "Britse Korthaar");

        // act
        sjoerd.addPet(cat);

        // assert
        // checken of er duplicates in zitten
        assertEquals(1, sjoerd.getPets().size());
        // checken of het cat object in de Pets list zit
        assertTrue(sjoerd.getPets().contains(cat));
    }

    @Test
    public void getGrandChildren() {
        // arrange
        Person fred = new Person("Fred", "Jansz", 69, "male");
        Person nelleke = new Person("Nelleke", "Sijens", 67, "female");
        Person jasper = new Person("Jasper", "Jansz", 33, "male");
        Person cato = new Person("Cato", "Jansz", 3, "female");
        Person abel = new Person("Abel", "Jansz", 1, "male");

        // act
        fred.addChild(jasper);
        jasper.addChild(cato);
        jasper.addChild(abel);
        // assert
        assertEquals(2, fred.getGrandChildren().size());
        assertEquals(jasper.getChildren(), fred.getGrandChildren());
        assertTrue(fred.getGrandChildren().contains(abel));
        assertTrue(fred.getGrandChildren().contains(cato));
    }

}