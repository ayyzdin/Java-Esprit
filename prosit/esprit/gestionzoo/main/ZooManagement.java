package prosit.esprit.gestionzoo.main;

import prosit.esprit.gestionzoo.entities.Animal;
import prosit.esprit.gestionzoo.entities.Zoo;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String zooName;
        int nbrCages;

        do {
            System.out.print("Enter the zoo name: ");
            zooName = scanner.nextLine();
            if (zooName.trim().isEmpty()) {
                System.out.println("Error: zoo name cannot be empty.");
            }
        } while (zooName.trim().isEmpty());

        do {
            System.out.print("Enter the number of cages: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: please enter a number.");
                scanner.next();
                System.out.print("Enter the number of cages: ");
            }

            nbrCages = scanner.nextInt();

            if (nbrCages <= 0) {
                System.out.println("Error: number of cages must be positive.");
            }
        } while (nbrCages <= 0);

        Zoo myzoo = new Zoo(
                zooName,
                "Tunis",
                nbrCages
        );

        Zoo myzoo2 = new Zoo(
                "myzoo2",
                "London",
                15
        );

        Animal lion = new Animal();

        lion.setFamily("Felidae");
        lion.setName("Lion");
        lion.setAge(5);
        lion.setMammal(true);

        Animal elephant = new Animal(
                "Elephantidae",
                "Elephant",
                10,
                true
        );

        Animal tiger = new Animal(
                "Felidae",
                "Tiger",
                3,
                true
        );

        Animal crocodile = new Animal(
                "Crocodylidae",
                "Crocodile",
                7,
                false
        );

        Animal giraffe = new Animal(
                "Giraffidae",
                "Giraffe",
                4,
                true
        );

        Animal giraffe2 = new Animal(
                "Giraffidae",
                "Giraffe",
                5,
                false
        );

        Animal monkey = new Animal(
                "Cercopithecidae",
                "Monkey",
                2,
                true
        );

        myzoo.addAnimal(lion);
        myzoo.addAnimal(elephant);
        myzoo.addAnimal(tiger);
        myzoo.addAnimal(crocodile);
        myzoo.addAnimal(giraffe);

        System.out.println("\n========== ZOO INFO ==========");

        myzoo.displayzooInfo();

        System.out.println("\n========== ANIMALS ==========");

        myzoo.displayAnimals();

        System.out.println("\n========== SEARCH ==========");

        System.out.println("Position of giraffe: " + myzoo.searchAnimal(giraffe));

        System.out.println("Position of giraffe2: " + myzoo.searchAnimal(giraffe2));

        System.out.println("\n========== DUPLICATE TEST ==========");

        myzoo.addAnimal(giraffe);

        System.out.println("\n========== REMOVE ==========");

        boolean removed = myzoo.removeAnimal(tiger);

        System.out.println("Tiger removed: " + removed);

        System.out.println("\nAnimals after removing Tiger:");

        myzoo.displayAnimals();

        System.out.println("\n========== FULL TEST ==========");

        myzoo.addAnimal(monkey);

        Zoo smallZoo = new Zoo(
                "Small Zoo",
                "Tunis",
                2
        );

        smallZoo.addAnimal(
                new Animal(
                        "Felidae",
                        "Cat",
                        2,
                        true
                )
        );

        smallZoo.addAnimal(
                new Animal(
                        "Canidae",
                        "Dog",
                        4,
                        true
                )
        );

        boolean addedToFullZoo = smallZoo.addAnimal(
                new Animal(
                        "Equidae",
                        "Horse",
                        6,
                        true
                )
        );

        System.out.println("Is small zoo full? " + smallZoo.isZooFull());
        System.out.println("Horse added to full zoo: " + addedToFullZoo);

        System.out.println("\n========== COMPARE ZOOS ==========");

        myzoo2.addAnimal(
                new Animal(
                        "Felidae",
                        "Tiger",
                        3,
                        true
                )
        );

        myzoo2.addAnimal(
                new Animal(
                        "Felidae",
                        "Lion",
                        5,
                        true
                )
        );

        Zoo biggerZoo = myzoo.compareZoo(
                myzoo,
                myzoo2
        );

        System.out.println("Zoo with more animals: " + biggerZoo.getName());

        System.out.println("Number of animals: " + biggerZoo.numberOfAnimals());

        scanner.close();
    }
}
