public class Zoo {

    static final int MAX_ANIMALS = 25;
    Animal[] animals = new Animal[MAX_ANIMALS];

    String name;
    String city;
    final int nbrCages;
    int nbrAnimals;

    Zoo() {
        this.nbrCages = MAX_ANIMALS;
    }

    Zoo(String name, String city, int nbrCages) {

        this.name = name;
        this.city = city;

        if (nbrCages > MAX_ANIMALS) {
            this.nbrCages = MAX_ANIMALS;
        } else {
            this.nbrCages = nbrCages;
        }
    }

    void displayzooInfo() {

        System.out.println("Zoo Name: " + this.name);
        System.out.println("City: " + this.city);
        System.out.println("Number of Cages: " + this.nbrCages);
    }

    void displayAnimals() {

        System.out.println("Animals in the zoo:");

        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    int searchAnimal(Animal animal) {

        for (int i = 0; i < nbrAnimals; i++) {

            if (animals[i].name.equals(animal.name)) {

                return i;
            }
        }

        return -1;
    }

    boolean addAnimal(Animal animal) {

        // Vérifier si l'animal existe déjà
        if (searchAnimal(animal) != -1) {
            System.out.println("Animal " + animal.name + " already exists.");

            return false;
        }

        if (isZooFull()) {
            System.out.println("Zoo is full.");
            return false;
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
        System.out.println("Animal " + animal.name + " added to the zoo.");

        return true;
    }

    boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }

        nbrAnimals--;
        animals[nbrAnimals] = null;

        return true;
    }

    boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    int numberOfAnimals() {
        return nbrAnimals;
    }

    Zoo compareZoo(Zoo zoo1, Zoo zoo2) {
        if (zoo1.numberOfAnimals() >= zoo2.numberOfAnimals()) {
            return zoo1;

        } else {

            return zoo2;
        }
    }
}
