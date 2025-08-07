/**
 * Rabbit Class - Concrete Implementation of Animal Interface
 * 
 * This class implements the Animal interface, providing specific
 * behaviors for a rabbit. This demonstrates how an interface
 * can be implemented in a specific way for each animal type.
 * 
 * Key Concepts:
 * - Implements keyword connects class to interface
 * - Must implement ALL methods from the interface
 * - Can add additional methods specific to rabbits
 * - Uses @Override annotation for interface methods
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Rabbit implements Animal {
    
    // Instance variables (attributes) specific to rabbits
    private String furColor;
    private double earLength;  // in centimeters
    private int age;
    private String name;
    private boolean isWild;
    
    /**
     * Constructor for Rabbit class.
     * Initializes a rabbit with specific characteristics.
     * 
     * @param name The rabbit's name
     * @param furColor The color of the rabbit's fur
     * @param earLength The length of the rabbit's ears in cm
     * @param age The rabbit's age in years
     * @param isWild Whether the rabbit is wild or domestic
     */
    public Rabbit(String name, String furColor, double earLength, int age, boolean isWild) {
        this.name = name;
        this.furColor = furColor;
        this.earLength = earLength;
        this.age = age;
        this.isWild = isWild;
    }
    
    /**
     * Simple constructor with default values.
     * Creates a young domestic rabbit.
     * 
     * @param name The rabbit's name
     * @param furColor The color of the rabbit's fur
     */
    public Rabbit(String name, String furColor) {
        this(name, furColor, 15.0, 1, false);  // Calls the main constructor
    }
    
    /**
     * Implementation of eat() method from Animal interface.
     * Describes how rabbits eat.
     */
    @Override
    public void eat() {
        System.out.println(name + " the rabbit nibbles on carrots, lettuce, and hay 🥕🥬");
        if (!isWild) {
            System.out.println("  (This domestic rabbit enjoys fresh vegetables from the garden)");
        } else {
            System.out.println("  (This wild rabbit forages for grass and wild plants)");
        }
    }
    
    /**
     * Implementation of sleep() method from Animal interface.
     * Describes how rabbits sleep.
     */
    @Override
    public void sleep() {
        if (isWild) {
            System.out.println(name + " the rabbit sleeps in a cozy burrow underground");
        } else {
            System.out.println(name + " the rabbit curls up in a soft hay bed");
        }
        System.out.println("  (Rabbits sleep with their eyes partially open to stay alert!)");
    }
    
    /**
     * Implementation of makeSound() method from Animal interface.
     * Rabbits are generally quiet animals.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " the rabbit stays quiet... *soft nose twitching*");
        System.out.println("  (Fun fact: Rabbits only make sounds when very happy or scared)");
    }
    
    /**
     * Implementation of move() method from Animal interface.
     * Describes the characteristic hopping movement of rabbits.
     */
    @Override
    public void move() {
        System.out.println(name + " the rabbit hops quickly with powerful hind legs! 🐰");
        System.out.println("  *hop* *hop* *hop* - Can reach speeds up to 35 mph!");
    }
    
    /**
     * Implementation of getSpecies() method from Animal interface.
     * 
     * @return The species name
     */
    @Override
    public String getSpecies() {
        return "Rabbit (Oryctolagus cuniculus)";
    }
    
    /**
     * Implementation of getAge() method from Animal interface.
     * 
     * @return The rabbit's age
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * Implementation of getInfo() method from Animal interface.
     * Provides formatted information about the rabbit.
     * 
     * @return Formatted string with rabbit details
     */
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Rabbit Information ===\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Species: ").append(getSpecies()).append("\n");
        info.append("Age: ").append(age).append(" years\n");
        info.append("Fur Color: ").append(furColor).append("\n");
        info.append("Ear Length: ").append(earLength).append(" cm\n");
        info.append("Type: ").append(isWild ? "Wild" : "Domestic").append("\n");
        return info.toString();
    }
    
    // ===== RABBIT-SPECIFIC METHODS (not from interface) =====
    
    /**
     * Makes the rabbit dig a burrow.
     * This is a behavior specific to rabbits.
     */
    public void dig() {
        System.out.println(name + " the rabbit digs a burrow with strong front paws");
        System.out.println("  *scratch* *scratch* - Creating a safe underground home!");
    }
    
    /**
     * Makes the rabbit wiggle its ears.
     * Rabbits use ear movement for communication and temperature regulation.
     */
    public void wiggleEars() {
        System.out.println(name + " the rabbit wiggles its " + earLength + " cm long ears");
        System.out.println("  (Rabbits can rotate their ears 270 degrees to detect sounds!)");
    }
    
    /**
     * Makes the rabbit perform a binky (jump for joy).
     * This is a sign of a happy rabbit!
     */
    public void binky() {
        System.out.println(name + " the rabbit does a BINKY! *jumps and twists in the air*");
        System.out.println("  (This acrobatic jump means the rabbit is very happy!)");
    }
    
    /**
     * Makes the rabbit thump its foot.
     * Rabbits thump to warn others of danger.
     */
    public void thumpFoot() {
        System.out.println(name + " the rabbit THUMPS its powerful hind foot!");
        System.out.println("  *THUMP* (Warning signal to other rabbits!)");
    }
    
    // ===== GETTER AND SETTER METHODS =====
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getFurColor() {
        return furColor;
    }
    
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
    public double getEarLength() {
        return earLength;
    }
    
    public void setEarLength(double earLength) {
        this.earLength = earLength;
    }
    
    public void setAge(int age) {
        if (age >= 0) {  // Basic validation
            this.age = age;
        }
    }
    
    public boolean isWild() {
        return isWild;
    }
    
    public void setWild(boolean wild) {
        isWild = wild;
    }
    
    /**
     * String representation of the rabbit.
     * Useful for debugging and quick display.
     * 
     * @return A string describing the rabbit
     */
    @Override
    public String toString() {
        return "Rabbit{name='" + name + "', age=" + age + ", furColor='" + furColor + "'}";
    }
}