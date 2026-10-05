package prosit.esprit.gestionzoo.entities;

public class Zoo {
    public static final int MAX_ANIMALS = 25;

    private Animal[] animals = new Animal[MAX_ANIMALS];
    private String name;
    private String city;
    private final int nbrCages;
    private int nbrAnimals;

    public Zoo() {
        this.nbrCages = MAX_ANIMALS;
    }

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;

        if (nbrCages > MAX_ANIMALS) {
            this.nbrCages = MAX_ANIMALS;
        } else {
            this.nbrCages = nbrCages;
        }
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void displayzooInfo() {
        System.out.println("Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of Cages: " + nbrCages);
    }

    public void displayAnimals() {
        System.out.println("Animals in the zoo:");

        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }

        return -1;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Zoo is full.");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("Animal " + animal.getName() + " already exists.");
            return false;
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
        System.out.println("Animal " + animal.getName() + " added to the zoo.");

        return true;
    }

    public boolean removeAnimal(Animal animal) {
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

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public int numberOfAnimals() {
        return nbrAnimals;
    }

    public Zoo compareZoo(Zoo zoo1, Zoo zoo2) {
        if (zoo1.numberOfAnimals() >= zoo2.numberOfAnimals()) {
            return zoo1;
        }

        return zoo2;
    }
}
