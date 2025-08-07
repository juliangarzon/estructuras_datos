/**
 * ZooManager Class - Advanced Data Structure Management
 * 
 * This class demonstrates advanced concepts using the Animal interface:
 * - Managing arrays of interface types
 * - Searching and filtering operations
 * - Statistics and analysis
 * - Basic algorithms on collections
 * 
 * This shows how interfaces make code flexible and reusable!
 * 
 * @author Data Structures Course  
 * @version 1.0
 */
import java.util.Scanner;

public class ZooManager {
    
    // The main data structure - an array of Animals
    private Animal[] animals;
    private int currentSize;  // How many animals we actually have
    private final int MAX_CAPACITY; // Maximum zoo capacity
    private String zooName;
    
    /**
     * Constructor for ZooManager.
     * 
     * @param zooName Name of the zoo
     * @param maxCapacity Maximum number of animals the zoo can hold
     */
    public ZooManager(String zooName, int maxCapacity) {
        this.zooName = zooName;
        this.MAX_CAPACITY = maxCapacity;
        this.animals = new Animal[maxCapacity];  // Create the array
        this.currentSize = 0;
    }
    
    /**
     * Adds an animal to the zoo.
     * This demonstrates adding to an array-based data structure.
     * 
     * @param animal The animal to add
     * @return true if added successfully, false if zoo is full
     */
    public boolean addAnimal(Animal animal) {
        if (currentSize >= MAX_CAPACITY) {
            System.out.println("❌ Zoo is full! Cannot add " + animal.getSpecies());
            return false;
        }
        
        animals[currentSize] = animal;
        currentSize++;
        System.out.println("✅ Added " + animal.getSpecies() + " to " + zooName);
        return true;
    }
    
    /**
     * Removes an animal from the zoo by name.
     * This demonstrates searching and removal in arrays.
     * 
     * @param name Name of the animal to remove
     * @return true if removed successfully
     */
    public boolean removeAnimal(String name) {
        int indexToRemove = -1;
        
        // Search for the animal
        for (int i = 0; i < currentSize; i++) {
            if (animals[i].getInfo().contains("Name: " + name)) {
                indexToRemove = i;
                break;
            }
        }
        
        if (indexToRemove == -1) {
            System.out.println("❌ Animal named '" + name + "' not found in zoo");
            return false;
        }
        
        Animal removedAnimal = animals[indexToRemove];
        
        // Shift all elements after the removed one to the left
        for (int i = indexToRemove; i < currentSize - 1; i++) {
            animals[i] = animals[i + 1];
        }
        
        animals[currentSize - 1] = null;  // Clear the last position
        currentSize--;
        
        System.out.println("✅ Removed " + removedAnimal.getSpecies() + " named '" + name + "'");
        return true;
    }
    
    /**
     * Feeds all animals in the zoo.
     * This demonstrates iteration over interface arrays.
     */
    public void feedAllAnimals() {
        if (currentSize == 0) {
            System.out.println("No animals to feed in " + zooName);
            return;
        }
        
        System.out.println("\n🍽️ FEEDING TIME at " + zooName + "!");
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].eat();
            System.out.println();
        }
    }
    
    /**
     * Makes all animals sleep.
     * Shows polymorphism - same method call, different behaviors.
     */
    public void napTime() {
        if (currentSize == 0) {
            System.out.println("No animals for nap time in " + zooName);
            return;
        }
        
        System.out.println("\n😴 NAP TIME at " + zooName + "!");
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].sleep();
            System.out.println();
        }
    }
    
    /**
     * Conducts a morning sound check.
     * Each animal makes their characteristic sound!
     */
    public void morningSoundCheck() {
        if (currentSize == 0) {
            System.out.println("Silent morning - no animals in " + zooName);
            return;
        }
        
        System.out.println("\n🌅 MORNING SOUND CHECK at " + zooName + "!");
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].makeSound();
            System.out.println();
        }
    }
    
    /**
     * Organizes exercise time for all animals.
     * Each animal moves in their own way!
     */
    public void exerciseTime() {
        if (currentSize == 0) {
            System.out.println("No animals need exercise in " + zooName);
            return;
        }
        
        System.out.println("\n🏃 EXERCISE TIME at " + zooName + "!");
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].move();
            System.out.println();
        }
    }
    
    /**
     * Finds and returns all animals of a specific type.
     * This demonstrates type checking and filtering.
     * 
     * @param animalType The class type to search for (Cat.class, Rabbit.class, etc.)
     * @return Array of animals matching the type
     */
    @SuppressWarnings("unchecked")
    public <T extends Animal> T[] findAnimalsByType(Class<T> animalType) {
        // First pass: count how many animals match
        int count = 0;
        for (int i = 0; i < currentSize; i++) {
            if (animalType.isInstance(animals[i])) {
                count++;
            }
        }
        
        // Create array of the right size and type
        T[] result = (T[]) java.lang.reflect.Array.newInstance(animalType, count);
        
        // Second pass: fill the result array
        int resultIndex = 0;
        for (int i = 0; i < currentSize; i++) {
            if (animalType.isInstance(animals[i])) {
                result[resultIndex] = (T) animals[i];
                resultIndex++;
            }
        }
        
        return result;
    }
    
    /**
     * Finds the oldest animal in the zoo.
     * This demonstrates finding maximum/minimum values.
     * 
     * @return The oldest animal, or null if zoo is empty
     */
    public Animal findOldestAnimal() {
        if (currentSize == 0) {
            return null;
        }
        
        Animal oldest = animals[0];
        for (int i = 1; i < currentSize; i++) {
            if (animals[i].getAge() > oldest.getAge()) {
                oldest = animals[i];
            }
        }
        
        return oldest;
    }
    
    /**
     * Finds the youngest animal in the zoo.
     * 
     * @return The youngest animal, or null if zoo is empty
     */
    public Animal findYoungestAnimal() {
        if (currentSize == 0) {
            return null;
        }
        
        Animal youngest = animals[0];
        for (int i = 1; i < currentSize; i++) {
            if (animals[i].getAge() < youngest.getAge()) {
                youngest = animals[i];
            }
        }
        
        return youngest;
    }
    
    /**
     * Calculates the average age of all animals.
     * This demonstrates basic statistical operations.
     * 
     * @return Average age, or 0 if no animals
     */
    public double getAverageAge() {
        if (currentSize == 0) {
            return 0;
        }
        
        int totalAge = 0;
        for (int i = 0; i < currentSize; i++) {
            totalAge += animals[i].getAge();
        }
        
        return (double) totalAge / currentSize;
    }
    
    /**
     * Generates comprehensive zoo statistics.
     * This shows how to analyze a collection of data.
     */
    public void generateZooReport() {
        System.out.println("\n📊 COMPREHENSIVE ZOO REPORT");
        System.out.println("═".repeat(60));
        System.out.println("Zoo Name: " + zooName);
        System.out.println("Current Capacity: " + currentSize + "/" + MAX_CAPACITY);
        System.out.println("Occupancy Rate: " + String.format("%.1f", (100.0 * currentSize / MAX_CAPACITY)) + "%");
        
        if (currentSize == 0) {
            System.out.println("No animals currently in the zoo.");
            return;
        }
        
        // Count different types of animals
        int rabbitCount = findAnimalsByType(Rabbit.class).length;
        int catCount = findAnimalsByType(Cat.class).length;
        int dogCount = findAnimalsByType(Dog.class).length;
        int birdCount = findAnimalsByType(Bird.class).length;
        
        System.out.println("\n🐾 ANIMAL POPULATION:");
        if (rabbitCount > 0) System.out.println("  Rabbits: " + rabbitCount);
        if (catCount > 0) System.out.println("  Cats: " + catCount);
        if (dogCount > 0) System.out.println("  Dogs: " + dogCount);
        if (birdCount > 0) System.out.println("  Birds: " + birdCount);
        
        // Age statistics
        Animal oldest = findOldestAnimal();
        Animal youngest = findYoungestAnimal();
        double avgAge = getAverageAge();
        
        System.out.println("\n📈 AGE STATISTICS:");
        System.out.println("  Average Age: " + String.format("%.1f", avgAge) + " years");
        System.out.println("  Oldest Animal: " + oldest.getSpecies() + " (Age: " + oldest.getAge() + ")");
        System.out.println("  Youngest Animal: " + youngest.getSpecies() + " (Age: " + youngest.getAge() + ")");
        
        // List all animals
        System.out.println("\n📋 COMPLETE ANIMAL ROSTER:");
        for (int i = 0; i < currentSize; i++) {
            System.out.println("  " + (i + 1) + ". " + animals[i].getSpecies() + 
                             " (Age: " + animals[i].getAge() + ")");
        }
    }
    
    /**
     * Performs special activities with specific animal types.
     * This demonstrates casting and using specific methods.
     */
    public void performSpecialActivities() {
        if (currentSize == 0) {
            System.out.println("No animals for special activities.");
            return;
        }
        
        System.out.println("\n🎭 SPECIAL ACTIVITY TIME!");
        System.out.println("═".repeat(50));
        
        // Cat-specific activities
        Cat[] cats = findAnimalsByType(Cat.class);
        if (cats.length > 0) {
            System.out.println("\n🐱 CAT ACTIVITIES:");
            for (Cat cat : cats) {
                cat.purr();
                cat.climb();
                if (Math.random() > 0.5) {
                    cat.huntMouse();
                }
                System.out.println();
            }
        }
        
        // Rabbit-specific activities
        Rabbit[] rabbits = findAnimalsByType(Rabbit.class);
        if (rabbits.length > 0) {
            System.out.println("\n🐰 RABBIT ACTIVITIES:");
            for (Rabbit rabbit : rabbits) {
                rabbit.wiggleEars();
                rabbit.dig();
                rabbit.binky();
                System.out.println();
            }
        }
        
        // Dog-specific activities
        Dog[] dogs = findAnimalsByType(Dog.class);
        if (dogs.length > 0) {
            System.out.println("\n🐕 DOG ACTIVITIES:");
            for (Dog dog : dogs) {
                dog.wagTail();
                dog.fetch("ball");
                dog.doTrick("sit");
                System.out.println();
            }
        }
        
        // Bird-specific activities
        Bird[] birds = findAnimalsByType(Bird.class);
        if (birds.length > 0) {
            System.out.println("\n🐦 BIRD ACTIVITIES:");
            for (Bird bird : birds) {
                bird.sing("morning");
                bird.preen();
                if (bird.canFly()) {
                    bird.takeOff();
                    bird.land();
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Sorts animals by age (youngest to oldest).
     * This demonstrates a basic sorting algorithm.
     */
    public void sortAnimalsByAge() {
        if (currentSize <= 1) {
            return;  // Already sorted or empty
        }
        
        // Simple bubble sort
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - i - 1; j++) {
                if (animals[j].getAge() > animals[j + 1].getAge()) {
                    // Swap animals
                    Animal temp = animals[j];
                    animals[j] = animals[j + 1];
                    animals[j + 1] = temp;
                }
            }
        }
        
        System.out.println("✅ Animals sorted by age (youngest to oldest)");
    }
    
    /**
     * Lists all animals in the zoo with detailed information.
     */
    public void listAllAnimals() {
        if (currentSize == 0) {
            System.out.println("No animals in " + zooName);
            return;
        }
        
        System.out.println("\n📋 ALL ANIMALS in " + zooName + ":");
        System.out.println("═".repeat(60));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.println("\n" + (i + 1) + ". " + animals[i].getInfo());
        }
    }
    
    /**
     * Interactive method to let user add animals to the zoo.
     * This demonstrates user input and object creation.
     */
    public void interactiveAddAnimal() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n🆕 ADD NEW ANIMAL TO ZOO");
        System.out.println("═".repeat(30));
        System.out.println("Choose animal type:");
        System.out.println("1. Cat");
        System.out.println("2. Rabbit");
        System.out.println("3. Dog");
        System.out.println("4. Bird");
        System.out.print("Enter choice (1-4): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        
        Animal newAnimal = null;
        
        switch (choice) {
            case 1:
                System.out.print("Enter cat breed: ");
                String breed = scanner.nextLine();
                newAnimal = new Cat(name, breed);
                break;
                
            case 2:
                System.out.print("Enter fur color: ");
                String color = scanner.nextLine();
                newAnimal = new Rabbit(name, color);
                break;
                
            case 3:
                System.out.print("Enter dog breed: ");
                String dogBreed = scanner.nextLine();
                newAnimal = new Dog(name, dogBreed);
                break;
                
            case 4:
                System.out.print("Enter bird species: ");
                String species = scanner.nextLine();
                newAnimal = new Bird(name, species);
                break;
                
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        if (newAnimal != null) {
            addAnimal(newAnimal);
        }
    }
    
    // ===== GETTER METHODS =====
    
    public int getCurrentSize() {
        return currentSize;
    }
    
    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }
    
    public String getZooName() {
        return zooName;
    }
    
    public boolean isFull() {
        return currentSize >= MAX_CAPACITY;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /**
     * Returns a copy of all animals (for safety).
     * 
     * @return Array copy of current animals
     */
    public Animal[] getAllAnimals() {
        Animal[] copy = new Animal[currentSize];
        for (int i = 0; i < currentSize; i++) {
            copy[i] = animals[i];
        }
        return copy;
    }
    
    /**
     * String representation of the zoo.
     * 
     * @return Basic zoo information
     */
    @Override
    public String toString() {
        return "ZooManager{" +
                "zooName='" + zooName + '\'' +
                ", currentSize=" + currentSize +
                ", maxCapacity=" + MAX_CAPACITY +
                ", occupancy=" + String.format("%.1f", (100.0 * currentSize / MAX_CAPACITY)) + "%" +
                '}';
    }
    
    /**
     * Demo method showing ZooManager capabilities.
     * This is like a "main" method for testing the class.
     */
    public static void demoZooManager() {
        System.out.println("🦁 ZOOKEEPER DATA STRUCTURES DEMO 🦁");
        System.out.println("═".repeat(60));
        
        // Create a zoo
        ZooManager zoo = new ZooManager("Data Structures Wildlife Park", 10);
        
        // Add various animals
        zoo.addAnimal(new Cat("Whiskers", "Persian", "white", 5, 4.5, true));
        zoo.addAnimal(new Rabbit("Bugs", "gray", 18.0, 3, true));
        zoo.addAnimal(new Dog("Rex", "German Shepherd", "large", 4, 30.0, "brown", true, 8));
        zoo.addAnimal(new Bird("Eagle", "Eagle", "brown", 8, 200.0, true, false, "mountains", 80));
        zoo.addAnimal(new Cat("Garfield", "Tabby", "orange", 6, 7.0, true));
        zoo.addAnimal(new Rabbit("Cottontail", "white", 15.0, 1, false));
        
        // Demonstrate zoo operations
        zoo.generateZooReport();
        zoo.feedAllAnimals();
        zoo.morningSoundCheck();
        zoo.performSpecialActivities();
        
        // Demonstrate data analysis
        System.out.println("\n🔍 DATA ANALYSIS DEMO:");
        System.out.println("Oldest animal: " + zoo.findOldestAnimal().getSpecies());
        System.out.println("Youngest animal: " + zoo.findYoungestAnimal().getSpecies());
        System.out.println("Average age: " + String.format("%.1f", zoo.getAverageAge()) + " years");
        
        // Show sorting
        zoo.sortAnimalsByAge();
        System.out.println("\nAnimals after sorting by age:");
        for (Animal animal : zoo.getAllAnimals()) {
            System.out.println("  " + animal.getSpecies() + " (Age: " + animal.getAge() + ")");
        }
        
        System.out.println("\n🎉 ZooManager demo completed!");
    }
}