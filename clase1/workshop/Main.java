/**
 * Main Class - Demonstration of Interfaces and Polymorphism
 * 
 * This class demonstrates the key concepts of the workshop:
 * 1. Interface implementation
 * 2. Polymorphism in action
 * 3. Type checking and casting
 * 4. Working with arrays of interface types
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO THE ANIMAL KINGDOM WORKSHOP!  ║");
        System.out.println("║      Learning Interfaces & Polymorphism    ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // ========== PART 1: Creating Specific Animals ==========
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 1: Creating Specific Animal Objects");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        // Create rabbits with different constructors
        Rabbit wildRabbit = new Rabbit("Bugs", "gray", 18.0, 3, true);
        Rabbit petRabbit = new Rabbit("Snowball", "white");
        
        // Create cats with different constructors
        Cat houseCat = new Cat("Whiskers", "Persian", "solid white", 5, true, 5.2);
        Cat streetCat = new Cat("Tom", "Mixed");
        
        // Display their information
        System.out.println(wildRabbit.getInfo());
        System.out.println(houseCat.getInfo());
        
        // ========== PART 2: Basic Behaviors ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 2: Testing Basic Animal Behaviors");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        System.out.println(">>> Wild Rabbit Behaviors:");
        wildRabbit.eat();
        wildRabbit.move();
        wildRabbit.makeSound();
        wildRabbit.sleep();
        
        System.out.println("\n>>> House Cat Behaviors:");
        houseCat.eat();
        houseCat.move();
        houseCat.makeSound();
        houseCat.sleep();
        
        // ========== PART 3: Specific Behaviors ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 3: Animal-Specific Behaviors");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        System.out.println(">>> Rabbit-Specific Actions:");
        petRabbit.wiggleEars();
        petRabbit.dig();
        petRabbit.binky();
        petRabbit.thumpFoot();
        
        System.out.println("\n>>> Cat-Specific Actions:");
        houseCat.purr();
        houseCat.climb();
        houseCat.knead();
        houseCat.groom();
        houseCat.slowBlink();
        boolean huntSuccess = streetCat.huntMouse();
        if (huntSuccess) {
            System.out.println("  " + streetCat.getName() + " is a skilled hunter!");
        }
        
        // ========== PART 4: POLYMORPHISM DEMONSTRATION ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 4: The Magic of Polymorphism! ✨");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        // KEY CONCEPT: We can treat specific animals as generic Animals
        System.out.println(">>> Treating specific animals as generic Animals:");
        Animal genericAnimal1 = wildRabbit;  // A Rabbit IS-A Animal
        Animal genericAnimal2 = houseCat;    // A Cat IS-A Animal
        
        System.out.println("\nCalling interface methods on generic Animal references:");
        System.out.println("genericAnimal1 (actually a Rabbit):");
        genericAnimal1.makeSound();
        
        System.out.println("\ngenericAnimal2 (actually a Cat):");
        genericAnimal2.makeSound();
        
        // Demonstrate method that works with ANY animal
        System.out.println("\n>>> Using a method that accepts ANY Animal:");
        performDailyRoutine(wildRabbit);
        System.out.println();
        performDailyRoutine(houseCat);
        
        // ========== PART 5: Arrays of Animals ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 5: Managing a Zoo with Arrays");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        // Create an array that can hold ANY type of Animal
        Animal[] zoo = new Animal[6];
        
        // Fill the zoo with different animals
        zoo[0] = new Rabbit("Thumper", "brown", 16.0, 2, false);
        zoo[1] = new Cat("Felix", "Siamese", "pointed", 4, true, 4.0);
        zoo[2] = new Rabbit("Roger", "white", 20.0, 5, true);
        zoo[3] = new Cat("Garfield", "Tabby", "orange tabby", 8, true, 8.5);
        zoo[4] = new Rabbit("Cottontail", "gray", 14.0, 1, true);
        zoo[5] = new Cat("Luna", "Russian Blue", "solid gray", 3, false, 3.8);
        
        System.out.println("Our zoo has " + zoo.length + " animals!\n");
        
        // Make all animals introduce themselves
        System.out.println(">>> Zoo Roll Call - All Animals Make Sounds:");
        for (int i = 0; i < zoo.length; i++) {
            System.out.print((i + 1) + ". ");
            zoo[i].makeSound();
        }
        
        // Feed all animals
        System.out.println("\n>>> Feeding Time at the Zoo:");
        feedAllAnimals(zoo);
        
        // ========== PART 6: Type Checking and Casting ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 6: Type Checking and Casting");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        System.out.println(">>> Identifying Animals and Using Specific Methods:\n");
        
        for (Animal animal : zoo) {
            System.out.println("Checking animal: " + animal.getSpecies());
            
            // Use instanceof to check the actual type
            if (animal instanceof Rabbit) {
                System.out.println("  ✓ This is a Rabbit!");
                Rabbit rabbit = (Rabbit) animal;  // Safe casting
                System.out.print("  ");
                rabbit.wiggleEars();  // Now we can use Rabbit-specific methods
                
                if (rabbit.isWild()) {
                    System.out.println("  (This is a wild rabbit)");
                } else {
                    System.out.println("  (This is a domestic rabbit)");
                }
                
            } else if (animal instanceof Cat) {
                System.out.println("  ✓ This is a Cat!");
                Cat cat = (Cat) animal;  // Safe casting
                System.out.print("  ");
                cat.purr();  // Now we can use Cat-specific methods
                
                if (cat.getBreed().equals("Tabby") && cat.getName().equals("Garfield")) {
                    System.out.println("  (Hey, it's Garfield! Better hide the lasagna!)");
                }
            }
            System.out.println();
        }
        
        // ========== PART 7: Statistics and Analysis ==========
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 7: Zoo Statistics");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        // Count different types of animals
        int rabbitCount = 0;
        int catCount = 0;
        int totalAge = 0;
        Animal oldestAnimal = zoo[0];
        
        for (Animal animal : zoo) {
            if (animal instanceof Rabbit) {
                rabbitCount++;
            } else if (animal instanceof Cat) {
                catCount++;
            }
            
            totalAge += animal.getAge();
            
            if (animal.getAge() > oldestAnimal.getAge()) {
                oldestAnimal = animal;
            }
        }
        
        System.out.println("Zoo Population Statistics:");
        System.out.println("  • Total Animals: " + zoo.length);
        System.out.println("  • Rabbits: " + rabbitCount);
        System.out.println("  • Cats: " + catCount);
        System.out.println("  • Average Age: " + (totalAge / zoo.length) + " years");
        System.out.println("  • Oldest Animal: " + oldestAnimal.getInfo());
        
        // ========== PART 8: Interactive Demonstration ==========
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("PART 8: Special Demonstrations");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        // Demonstrate cat hunting
        System.out.println(">>> Cat Hunting Competition:");
        for (Animal animal : zoo) {
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.print(cat.getName() + " attempts to hunt: ");
                if (cat.huntMouse()) {
                    System.out.println("SUCCESS! 🏆");
                } else {
                    System.out.println("Failed - better luck next time!");
                }
            }
        }
        
        // Demonstrate rabbit happiness
        System.out.println("\n>>> Happy Rabbit Dance (Binky Party!):");
        for (Animal animal : zoo) {
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                System.out.print(rabbit.getName() + ": ");
                rabbit.binky();
            }
        }
        
        // ========== CONCLUSION ==========
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         WORKSHOP COMPLETED! 🎉             ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ You've learned:                            ║");
        System.out.println("║ ✓ How to create and use interfaces        ║");
        System.out.println("║ ✓ How to implement interfaces in classes  ║");
        System.out.println("║ ✓ The power of polymorphism               ║");
        System.out.println("║ ✓ Type checking with instanceof           ║");
        System.out.println("║ ✓ Safe casting between types              ║");
        System.out.println("║                                            ║");
        System.out.println("║ Next: Try creating your own animals!      ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    /**
     * Helper method that performs a daily routine for any animal.
     * This demonstrates polymorphism - we don't need to know
     * what specific type of animal it is!
     * 
     * @param animal Any object that implements the Animal interface
     */
    public static void performDailyRoutine(Animal animal) {
        System.out.println("\n=== Daily Routine for " + animal.getSpecies() + " ===");
        System.out.println("Morning:");
        animal.eat();
        System.out.println("\nMidday:");
        animal.move();
        animal.makeSound();
        System.out.println("\nEvening:");
        animal.sleep();
    }
    
    /**
     * Feeds all animals in the array.
     * Another example of polymorphism in action.
     * 
     * @param animals Array of any animals
     */
    public static void feedAllAnimals(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].eat();
        }
    }
    
    /**
     * Finds the oldest animal in an array.
     * Works with any type of animal!
     * 
     * @param animals Array of animals to search
     * @return The oldest animal, or null if array is empty
     */
    public static Animal findOldestAnimal(Animal[] animals) {
        if (animals == null || animals.length == 0) {
            return null;
        }
        
        Animal oldest = animals[0];
        for (Animal animal : animals) {
            if (animal.getAge() > oldest.getAge()) {
                oldest = animal;
            }
        }
        return oldest;
    }
}