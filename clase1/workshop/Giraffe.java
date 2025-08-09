/**
 * Giraffe Class - Implementation of Animal Interface
 * 
 * This class shows how a giraffe implements the same
 * interface with its own unique behaviors and characteristics.
 * Giraffes are the tallest land animals with distinctive features.
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Giraffe implements Animal {
    
    // Instance variables specific to giraffes
    private String name;
    private String subspecies;  // Masai, Reticulated, etc.
    private double height;      // in meters
    private double weight;      // in kilograms
    private int age;
    private String neckPattern; // spot pattern description
    private boolean isMale;
    private int energyLevel;    // 1-10 scale
    private String habitat;     // savanna, forest, etc.
    
    /**
     * Full constructor for Giraffe class.
     * 
     * @param name The giraffe's name
     * @param subspecies The giraffe's subspecies
     * @param height The giraffe's height in meters
     * @param weight The giraffe's weight in kg
     * @param age The giraffe's age in years
     * @param neckPattern Description of the neck pattern
     * @param isMale Whether the giraffe is male
     * @param energyLevel The giraffe's energy level (1-10)
     * @param habitat The giraffe's habitat
     */
    public Giraffe(String name, String subspecies, double height, double weight, 
                   int age, String neckPattern, boolean isMale, int energyLevel, String habitat) {
        this.name = name;
        this.subspecies = subspecies;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.neckPattern = neckPattern;
        this.isMale = isMale;
        this.energyLevel = Math.min(10, Math.max(1, energyLevel));
        this.habitat = habitat;
    }
    
    /**
     * Simple constructor with defaults.
     * Creates a young adult Masai giraffe.
     * 
     * @param name The giraffe's name
     */
    public Giraffe(String name) {
        this(name, "Masai", 4.5, 800.0, 5, "brown spots on cream", false, 8, "savanna");
    }
    
    /**
     * Implementation of eat() method from Animal interface.
     * Giraffes are herbivores that eat leaves from tall trees.
     */
    @Override
    public void eat() {
        System.out.println(name + " the giraffe reaches up to eat leaves from the acacia tree! 🦒");
        System.out.println("  *stretches neck high* - Using that " + height + "m height!");
        
        if (height > 5.0) {
            System.out.println("  *reaches the highest branches* - Only the tallest giraffes can reach these!");
        } else {
            System.out.println("  *reaches medium-height branches* - Still growing taller!");
        }
        
        System.out.println("  *chews slowly and methodically* - Giraffes spend 16-20 hours eating per day!");
        System.out.println("  *uses long tongue to strip leaves* - Tongue is 50cm long!");
    }
    
    /**
     * Implementation of sleep() method from Animal interface.
     * Giraffes sleep very little and often standing up.
     */
    @Override
    public void sleep() {
        System.out.println(name + " the giraffe takes a short nap...");
        
        if (Math.random() > 0.7) {
            System.out.println("  *lies down carefully* - Giraffes rarely lie down to sleep!");
            System.out.println("  *sleeps for only 10-20 minutes* - Very short sleepers!");
        } else {
            System.out.println("  *stands and dozes* - Most giraffes sleep while standing!");
            System.out.println("  *head droops slightly* - Quick power nap!");
        }
        
        System.out.println("  *wakes up alert* - Giraffes only sleep 30 minutes to 2 hours per day!");
    }
    
    /**
     * Implementation of makeSound() method from Animal interface.
     * Giraffes are generally quiet animals.
     */
    @Override
    public void makeSound() {
        if (isMale && age > 8) {
            System.out.println(name + " the giraffe makes a deep cough-like sound! 🦒");
            System.out.println("  *deep resonant cough* - Male giraffes make this sound to attract females!");
        } else {
            System.out.println(name + " the giraffe is mostly silent...");
            System.out.println("  *gentle breathing* - Giraffes are very quiet animals!");
            System.out.println("  *occasional snort* - They rarely vocalize!");
        }
    }
    
    /**
     * Implementation of move() method from Animal interface.
     * Giraffes move in a distinctive way due to their long legs.
     */
    @Override
    public void move() {
        if (energyLevel > 7) {
            System.out.println(name + " the giraffe gallops gracefully across the savanna!");
            System.out.println("  *long strides* - Can reach speeds of 60 km/h!");
            System.out.println("  *neck bobs up and down* - Unique galloping style!");
        } else if (energyLevel > 4) {
            System.out.println(name + " the giraffe walks slowly and gracefully");
            System.out.println("  *ambles along* - Both legs on one side move together!");
            System.out.println("  *long neck sways gently* - Elegant movement!");
        } else {
            System.out.println(name + " the giraffe stands still, surveying the landscape");
            System.out.println("  *tall and majestic* - Using height to spot predators!");
        }
    }
    
    /**
     * Implementation of getSpecies() method from Animal interface.
     * 
     * @return The species name
     */
    @Override
    public String getSpecies() {
        return "Giraffe (Giraffa camelopardalis)";
    }
    
    /**
     * Implementation of getAge() method from Animal interface.
     * 
     * @return The giraffe's age
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * Implementation of getInfo() method from Animal interface.
     * 
     * @return Formatted string with giraffe details
     */
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Giraffe Information ===\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Species: ").append(getSpecies()).append("\n");
        info.append("Subspecies: ").append(subspecies).append("\n");
        info.append("Age: ").append(age).append(" years\n");
        info.append("Height: ").append(height).append(" meters\n");
        info.append("Weight: ").append(weight).append(" kg\n");
        info.append("Neck Pattern: ").append(neckPattern).append("\n");
        info.append("Gender: ").append(isMale ? "Male" : "Female").append("\n");
        info.append("Energy Level: ").append(energyLevel).append("/10\n");
        info.append("Habitat: ").append(habitat).append("\n");
        return info.toString();
    }
    
    // ===== GIRAFFE-SPECIFIC METHODS (not from interface) =====
    
    /**
     * Makes the giraffe stretch its neck to reach high branches.
     * Giraffes can reach leaves up to 6 meters high!
     */
    public void stretchNeck() {
        System.out.println(name + " the giraffe stretches its neck to maximum height!");
        System.out.println("  *extends neck upward* - Can reach " + (height + 1.5) + "m high!");
        System.out.println("  *uses prehensile tongue* - Can wrap tongue around branches!");
    }
    
    /**
     * Makes the giraffe engage in necking (male combat).
     * Male giraffes fight by swinging their necks at each other.
     */
    public void necking() {
        if (isMale && age > 5) {
            System.out.println(name + " the male giraffe engages in necking combat!");
            System.out.println("  *swings neck powerfully* - Testing strength and dominance!");
            System.out.println("  *clashes with another male* - Neck-to-neck combat!");
            System.out.println("  *determines hierarchy* - Winner gets mating rights!");
        } else {
            System.out.println(name + " is not old enough or not male for necking combat.");
        }
    }
    
    /**
     * Makes the giraffe drink water.
     * Giraffes must spread their legs to reach the ground.
     */
    public void drinkWater() {
        System.out.println(name + " the giraffe carefully approaches the water hole...");
        System.out.println("  *spreads front legs wide* - Must bend down to drink!");
        System.out.println("  *lowers head slowly* - Vulnerable position for predators!");
        System.out.println("  *drinks quickly* - Giraffes are vulnerable when drinking!");
        System.out.println("  *raises head and looks around* - Checking for danger!");
    }
    
    /**
     * Makes the giraffe use its height to spot predators.
     * Giraffes have excellent eyesight and can see far distances.
     */
    public void spotPredators() {
        System.out.println(name + " the giraffe uses its height advantage to scan the horizon!");
        System.out.println("  *turns head slowly* - Can see up to 1.5 km away!");
        System.out.println("  *spots movement* - Excellent eyesight from this height!");
        if (Math.random() > 0.8) {
            System.out.println("  *alerts other animals* - Giraffes often spot danger first!");
        }
    }
    
    /**
     * Makes the giraffe give birth (if female).
     * Giraffe calves are born from a standing position.
     */
    public void giveBirth() {
        if (!isMale && age > 5) {
            System.out.println(name + " the female giraffe gives birth to a calf!");
            System.out.println("  *stands during birth* - Giraffes give birth standing up!");
            System.out.println("  *calf drops 2 meters* - Newborn falls to the ground!");
            System.out.println("  *calf stands within an hour* - Amazing adaptation!");
        } else {
            System.out.println(name + " cannot give birth (not female or too young).");
        }
    }
    
    /**
     * Makes the giraffe browse for food.
     * Giraffes are browsers, not grazers.
     */
    public void browse() {
        System.out.println(name + " the giraffe browses for leaves and twigs!");
        System.out.println("  *selective feeding* - Chooses the most nutritious leaves!");
        System.out.println("  *avoids thorns* - Can eat thorny acacia leaves!");
        System.out.println("  *eats for hours* - Giraffes spend most of their day eating!");
    }
    
    /**
     * Makes the giraffe run from danger.
     * Giraffes can run surprisingly fast despite their size.
     */
    public void flee() {
        System.out.println(name + " the giraffe flees from danger!");
        System.out.println("  *gallops away* - Can reach 60 km/h!");
        System.out.println("  *long strides* - Each stride can be 5 meters long!");
        System.out.println("  *neck bobs rhythmically* - Unique running style!");
    }
    
    /**
     * Makes the giraffe socialize with other giraffes.
     * Giraffes are social animals that form loose herds.
     */
    public void socialize() {
        System.out.println(name + " the giraffe socializes with other giraffes!");
        System.out.println("  *gentle neck rubbing* - Giraffes show affection this way!");
        System.out.println("  *stands close together* - Form loose social bonds!");
        System.out.println("  *shares feeding spots* - Cooperative browsing!");
    }
    
    // ===== GETTER AND SETTER METHODS =====
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSubspecies() {
        return subspecies;
    }
    
    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        if (height >= 2.0 && height <= 6.0) {  // Reasonable giraffe height
            this.height = height;
        }
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        if (weight > 0 && weight < 2000) {  // Reasonable giraffe weight
            this.weight = weight;
        }
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 30) {  // Giraffes can live up to 30 years
            this.age = age;
        }
    }
    
    public String getNeckPattern() {
        return neckPattern;
    }
    
    public void setNeckPattern(String neckPattern) {
        this.neckPattern = neckPattern;
    }
    
    public boolean isMale() {
        return isMale;
    }
    
    public void setMale(boolean male) {
        isMale = male;
    }
    
    public int getEnergyLevel() {
        return energyLevel;
    }
    
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = Math.min(10, Math.max(1, energyLevel));
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    /**
     * String representation of the giraffe.
     * 
     * @return A string describing the giraffe
     */
    @Override
    public String toString() {
        return "Giraffe{name='" + name + "', subspecies='" + subspecies + "', height=" + height + 
               "m, age=" + age + ", male=" + isMale + "}";
    }
} 