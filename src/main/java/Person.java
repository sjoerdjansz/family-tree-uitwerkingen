import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Person> siblings = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private Person mother;
    private Person father;
    private Person partner;
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
        if(partner.partner != this) {
            partner.setPartner(this);
        }
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;

        if (!mother.children.contains(this)) {
            mother.children.add(this);
        } else {
            System.out.println("Mother of child has already been set");
        }
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
        if (!father.children.contains(this)) {
            father.children.add(this);
        } else {
            System.out.println("Father of child has already been set");
        }
    }

    public List<Person> getSiblings() {
        return siblings;
    }


    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addParents(Person father, Person mother) {
        setFather(father);
        setMother(mother);
    }

    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);

            if ("male".equalsIgnoreCase(sex)) {
                child.setFather(this);
            } else if ("female".equalsIgnoreCase(sex)) {
                child.setMother(this);
            }
        } else {
            System.out.println("Child already added!");
        }
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSiblings(Person sibling) {
        if (!siblings.contains(sibling)) {
            siblings.add(sibling);
        } else {
            System.out.println("Sibling already added!");
        }
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child : children) {
            grandChildren.addAll(child.getChildren());
        }

        return grandChildren;
    }


    public List<Pet> getPetsFromGrandChildren() {
        var grandChildren = this.getGrandChildren();

        System.out.println(this.getName() + " has " + this.getGrandChildren().size() + " grandchildren");
        if(grandChildren.isEmpty()) {
            System.out.println("No grandchildren found");
        }
        List<Pet> pets = new ArrayList<>();

        for(Person grandChild : grandChildren) {
            System.out.println("Looking for pets...");
            pets.addAll(grandChild.getPets());
        }
        System.out.println("Pets from grandchildren found: " + pets.size());
        return pets;
    }


    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
