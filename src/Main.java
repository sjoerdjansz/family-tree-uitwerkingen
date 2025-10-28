void main() {
    System.out.println("Hi, welcome to the Family Tree App!");

    Person sjoerd = new Person("Sjoerd", "Jansz", 35, "male");
    Person fred = new Person("Fred", "Jansz", 69, "male");
    Person nelleke = new Person("Nelleke", "Sijens", 67, "female");
    Pet umberto = new Pet("Umberto", 10, "Britse Korthaar");
    Pet ulysses = new Pet("Ulysses", 9, "Britse Korthaar");
    Person jasper = new Person("Jasper", "Jansz", 33, "male");
    Person anemone = new Person("Anemone", "van Arcken", 35, "female");
    Person nienke = new Person("Nienke", "Jansz", 30, "female");
    Person cato = new Person("Cato", "Jansz", 3, "female");
    Person abel = new Person("Abel", "Jansz", 1, "male");

    sjoerd.addParents(fred, nelleke);
    jasper.addParents(fred, nelleke);
    nienke.addParents(fred, nelleke);

    sjoerd.addSiblings(jasper);
    sjoerd.addSiblings(nienke);

    cato.addParents(jasper, anemone);
    abel.addParents(jasper, anemone);
    jasper.addSiblings(sjoerd);
    jasper.addSiblings(nienke);
    nienke.addSiblings(sjoerd);
    nienke.addSiblings(jasper);

    sjoerd.addPet(umberto);
    sjoerd.addPet(ulysses);

    System.out.println(fred.getGrandChildren().toString());
}
