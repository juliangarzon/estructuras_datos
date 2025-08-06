/**
 * Dog Class - Another Implementation of Animal Interface
 * 
 * This class shows how a third animal type implements the same
 * interface with its own unique behaviors and characteristics.
 * Dogs are social, loyal animals with distinct behaviors.
 * 
 * This is an EXERCISE SOLUTION for students to compare with their work.
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Dog implements Animal {
    
    // Instance variables specific to dogs
    private String name;
    private String breed;
    private String size;  // small, medium, large
    private int age;
    private boolean isTrained;
    private double weight;  // in kilograms
    private String furColor;
    private int energyLevel;  // 1-10 scale
    
    /**
     * Full constructor for Dog class.
     * 
     * @param name The dog's name
     * @param breed The dog's breed (Labrador, Poodle, etc.)
     * @param size The dog's size category
     * @param age The dog's age in years
     * @param weight The dog's weight in kg
     * @param furColor The color of the dog's fur
     * @param isTrained Whether the dog is trained
     * @param energyLevel The dog's energy level (1-10)
     */
    public Dog(String name, String breed, String size, int age, double weight, 
               String furColor, boolean isTrained, int energyLevel) {
        this.name = name;
        this.breed = breed;
        this.size = size;
        this.age = age;
        this.weight = weight;
        this.furColor = furColor;
        this.isTrained = isTrained;
        this.energyLevel = Math.min(10, Math.max(1, energyLevel)); // Ensure 1-10
    }
    
    /**
     * Simple constructor with defaults.
     * Creates a young, untrained medium-sized dog.
     * 
     * @param name The dog's name
     * @param breed The dog's breed
     */
    public Dog(String name, String breed) {
        this(name, breed, "medium", 2, 20.0, "brown", false, 7);
    }
    
    /**
     * Implementation of eat() method from Animal interface.
     * Dogs are omnivores with enthusiastic eating habits!
     */
    @Override
    public void eat() {
        System.out.println(name + " the dog eagerly eats kibble and treats! 🦴");
        System.out.println("  *CHOMP CHOMP CHOMP* ... *wags tail excitedly*");
        
        if (size.equals("large")) {
            System.out.println("  (This big dog needs lots of food - about " + 
                             (weight * 0.03) + " kg per day!)");
        } else if (size.equals("small")) {
            System.out.println("  (This little dog only needs about " + 
                             (weight * 0.04) + " kg of food per day)");
        }
        
        System.out.println("  *looks at you with hopeful eyes for more*");
    }
    
    /**
     * Implementation of sleep() method from Animal interface.
     * Dogs sleep less than cats but still enjoy their rest.
     */
    @Override
    public void sleep() {
        System.out.println(name + " the dog circles three times and lies down");
        
        if (age < 1) {
            System.out.println("  *puppy sleeps deeply* (Puppies need 18-20 hours of sleep!)");
        } else if (age > 8) {
            System.out.println("  *senior dog rests peacefully* (Older dogs sleep more)");
        } else {
            System.out.println("  *snores contentedly* (Adult dogs sleep 12-14 hours per day)");
        }
        
        if (Math.random() > 0.5) {
            System.out.println("  ... *legs twitch* (Dreaming of chasing squirrels!)");
        }
    }
    
    /**
     * Implementation of makeSound() method from Animal interface.
     * Dogs have various vocalizations.
     */
    @Override
    public void makeSound() {
        if (size.equals("small")) {
            System.out.println(name + " the " + breed + " says: Yip yip yip! 🐕");
            System.out.println("  (Small dog, big personality!)");
        } else if (size.equals("large")) {
            System.out.println(name + " the " + breed + " says: WOOF WOOF! 🐕");
            System.out.println("  (Deep, powerful bark!)");
        } else {
            System.out.println(name + " the " + breed + " says: Woof woof! 🐕");
            System.out.println("  (Friendly bark!)");
        }
    }
    
    /**
     * Implementation of move() method from Animal interface.
     * Dogs move in various ways depending on energy and mood.
     */
    @Override
    public void move() {
        if (energyLevel > 7) {
            System.out.println(name + " the dog RUNS enthusiastically with tongue out!");
            System.out.println("  *zoom zoom zoom* - So much energy!");
        } else if (energyLevel > 4) {
            System.out.println(name + " the dog trots along happily");
            System.out.println("  *trot trot trot* - Steady pace with tail wagging");
        } else {
            System.out.println(name + " the dog walks slowly, sniffing everything");
            System.out.println("  *sniff sniff* - Exploring the world through scent");
        }
    }
    
    /**
     * Implementation of getSpecies() method from Animal interface.
     * 
     * @return The species name
     */
    @Override
    public String getSpecies() {
        return "Domestic Dog (Canis familiaris)";
    }
    
    /**
     * Implementation of getAge() method from Animal interface.
     * 
     * @return The dog's age
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * Implementation of getInfo() method from Animal interface.
     * 
     * @return Formatted string with dog details
     */
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Dog Information ===\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Species: ").append(getSpecies()).append("\n");
        info.append("Breed: ").append(breed).append("\n");
        info.append("Age: ").append(age).append(" years");
        
        // Add age in "dog years"
        int dogYears = age * 7;
        info.append(" (").append(dogYears).append(" in dog years)\n");
        
        info.append("Size: ").append(size).append("\n");
        info.append("Weight: ").append(weight).append(" kg\n");
        info.append("Fur Color: ").append(furColor).append("\n");
        info.append("Energy Level: ").append(energyLevel).append("/10\n");
        info.append("Training: ").append(isTrained ? "Trained" : "Not trained yet").append("\n");
        return info.toString();
    }
    
    // ===== DOG-SPECIFIC METHODS (not from interface) =====
    
    /**
     * Makes the dog wag its tail.
     * The universal sign of a happy dog!
     */
    public void wagTail() {
        System.out.println(name + " the dog wags tail enthusiastically!");
        if (energyLevel > 7) {
            System.out.println("  *SUPER FAST WAGGING* - Whole body wiggling with joy!");
        } else {
            System.out.println("  *wag wag wag* - Happy to see you!");
        }
    }
    
    /**
     * Makes the dog fetch an object.
     * Most dogs love to play fetch!
     * 
     * @param item The item to fetch
     * @return true if the dog brings it back
     */
    public boolean fetch(String item) {
        System.out.println(name + " sees the " + item + "...");
        System.out.println("  *RUNS after the " + item + "*");
        
        boolean bringsBack = isTrained ? 0.9 : 0.5;
        boolean success = Math.random() < bringsBack;
        
        if (success) {
            System.out.println("  *brings the " + item + " back* Good dog!");
            wagTail();
            return true;
        } else {
            System.out.println("  *gets distracted by a butterfly*");
            System.out.println("  (Might need more training!)");
            return false;
        }
    }
    
    /**
     * Makes the dog perform a trick.
     * Only works if the dog is trained!
     * 
     * @param trick The trick to perform
     */
    public void doTrick(String trick) {
        if (isTrained) {
            System.out.println(name + " performs: " + trick + "!");
            switch(trick.toLowerCase()) {
                case "sit":
                    System.out.println("  *sits perfectly* Good dog!");
                    break;
                case "roll over":
                    System.out.println("  *rolls over* So talented!");
                    break;
                case "play dead":
                    System.out.println("  *dramatically falls over* Oscar-worthy performance!");
                    break;
                case "shake":
                    System.out.println("  *offers paw* Nice to meet you!");
                    break;
                default:
                    System.out.println("  *tilts head confused* Haven't learned that one yet!");
            }
        } else {
            System.out.println(name + " looks at you confused...");
            System.out.println("  *tilts head* (This dog needs training first!)");
        }
    }
    
    /**
     * Makes the dog howl.
     * Dogs howl to communicate over long distances!
     */
    public void howl() {
        System.out.println(name + " the dog points nose to the sky...");
        System.out.println("  AWOOOOOOOOO! 🌙");
        System.out.println("  (Channeling their inner wolf!)");
    }
    
    /**
     * Makes the dog dig.
     * Dogs dig for various reasons!
     */
    public void dig() {
        System.out.println(name + " the dog starts digging enthusiastically!");
        System.out.println("  *dig dig dig* - Dirt flying everywhere!");
        if (Math.random() > 0.7) {
            System.out.println("  Found a buried toy from last week!");
        }
    }
    
    /**
     * Makes the dog protect its territory.
     * Dogs are naturally protective!
     */
    public void guard() {
        System.out.println(name + " the dog stands alert, guarding the area");
        if (size.equals("large")) {
            System.out.println("  *intimidating stance* - This is a serious guard dog!");
        } else if (size.equals("small")) {
            System.out.println("  *fierce tiny bark* - Small but mighty protector!");
        } else {
            System.out.println("  *watchful eyes* - On duty!");
        }
    }
    
    /**
     * The dog shows affection.
     * Dogs are known for their loyalty and love!
     */
    public void showAffection() {
        System.out.println(name + " the dog shows love!");
        System.out.println("  *gives kisses* *leans against you* *happy whimpers*");
        System.out.println("  (Dogs are the best friends anyone could have!)");
        wagTail();
    }
    
    /**
     * Trains the dog.
     * Training makes dogs better companions!
     */
    public void train() {
        if (!isTrained) {
            isTrained = true;
            System.out.println(name + " has been trained! Now knows basic commands.");
            System.out.println("  *proud dog stance* Ready to be the best dog!");
        } else {
            System.out.println(name + " learns an advanced trick!");
            System.out.println("  This dog is getting smarter every day!");
        }
    }
    
    /**
     * The dog plays with another dog.
     * Dogs are social animals!
     * 
     * @param otherDog Another dog to play with
     */
    public void playWith(Dog otherDog) {
        System.out.println(name + " plays with " + otherDog.getName() + "!");
        System.out.println("  *chase* *wrestle* *play bow* *zoomies*");
        System.out.println("  Both dogs are having a great time!");
        
        // Both dogs lose some energy
        this.energyLevel = Math.max(1, this.energyLevel - 2);
        otherDog.energyLevel = Math.max(1, otherDog.energyLevel - 2);
    }
    
    // ===== GETTER AND SETTER METHODS =====
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        if (size.equals("small") || size.equals("medium") || size.equals("large")) {
            this.size = size;
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 25) {  // Dogs can live up to 25 years
            this.age = age;
        }
    }
    
    public boolean isTrained() {
        return isTrained;
    }
    
    public void setTrained(boolean trained) {
        isTrained = trained;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        if (weight > 0 && weight < 100) {  // Reasonable dog weight
            this.weight = weight;
        }
    }
    
    public String getFurColor() {
        return furColor;
    }
    
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
    public int getEnergyLevel() {
        return energyLevel;
    }
    
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = Math.min(10, Math.max(1, energyLevel));
    }
    
    /**
     * String representation of the dog.
     * 
     * @return A string describing the dog
     */
    @Override
    public String toString() {
        return "Dog{name='" + name + "', breed='" + breed + "', age=" + age + 
               ", trained=" + isTrained + "}";
    }
}