/**
 * Cat Class - Concrete Implementation of Animal Interface
 * 
 * This class implements the Animal interface with behaviors
 * specific to cats. Notice how the same interface methods
 * are implemented differently than in the Rabbit class.
 * 
 * Key Concepts:
 * - Same interface, different implementation
 * - Cat-specific attributes and methods
 * - Demonstrates polymorphism in action
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Cat implements Animal {
    
    // Instance variables specific to cats
    private String name;
    private String breed;
    private String furPattern;  // tabby, solid, calico, etc.
    private int age;
    private int lives;  // The mythical "9 lives"
    private boolean isIndoor;
    private double weight;  // in kilograms
    
    /**
     * Full constructor for Cat class.
     * 
     * @param name The cat's name
     * @param breed The cat's breed (Persian, Siamese, etc.)
     * @param furPattern The pattern of the cat's fur
     * @param age The cat's age in years
     * @param isIndoor Whether the cat lives indoors
     * @param weight The cat's weight in kg
     */
    public Cat(String name, String breed, String furPattern, int age, boolean isIndoor, double weight) {
        this.name = name;
        this.breed = breed;
        this.furPattern = furPattern;
        this.age = age;
        this.lives = 9;  // All cats start with 9 lives!
        this.isIndoor = isIndoor;
        this.weight = weight;
    }
    
    /**
     * Simplified constructor with common defaults.
     * 
     * @param name The cat's name
     * @param breed The cat's breed
     */
    public Cat(String name, String breed) {
        this(name, breed, "tabby", 2, true, 4.5);
    }
    
    /**
     * Implementation of eat() method from Animal interface.
     * Cats are obligate carnivores!
     */
    @Override
    public void eat() {
        System.out.println(name + " the cat delicately eats fish and high-quality cat food 🐟");
        System.out.println("  *nibble nibble* (Cats are picky eaters!)");
        if (weight < 3.0) {
            System.out.println("  This cat needs more food - looking a bit thin!");
        } else if (weight > 6.0) {
            System.out.println("  This cat might need a diet - looking a bit chubby!");
        }
    }
    
    /**
     * Implementation of sleep() method from Animal interface.
     * Cats are champion sleepers!
     */
    @Override
    public void sleep() {
        System.out.println(name + " the cat curls up into a perfect circle and sleeps");
        System.out.println("  ZZZ... (Cats sleep 12-16 hours per day!)");
        if (isIndoor) {
            System.out.println("  Sleeping in a sunny spot by the window ☀️");
        } else {
            System.out.println("  Finding a cozy spot under the porch");
        }
    }
    
    /**
     * Implementation of makeSound() method from Animal interface.
     * The classic cat sound!
     */
    @Override
    public void makeSound() {
        System.out.println(name + " the cat says: Meow! 🐱");
        if (age < 1) {
            System.out.println("  *tiny mew* (Kitten voice!)");
        } else if (breed.equals("Siamese")) {
            System.out.println("  *LOUD MEOW* (Siamese cats are very vocal!)");
        } else {
            System.out.println("  *soft meow* (Calling for attention)");
        }
    }
    
    /**
     * Implementation of move() method from Animal interface.
     * Cats are graceful and stealthy.
     */
    @Override
    public void move() {
        System.out.println(name + " the cat walks silently with graceful steps");
        System.out.println("  *padding softly* (Cats walk on their toes - they're digitigrade!)");
    }
    
    /**
     * Implementation of getSpecies() method from Animal interface.
     * 
     * @return The species name with scientific name
     */
    @Override
    public String getSpecies() {
        return "Cat (Felis catus)";
    }
    
    /**
     * Implementation of getAge() method from Animal interface.
     * 
     * @return The cat's age in years
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * Implementation of getInfo() method from Animal interface.
     * 
     * @return Formatted string with cat details
     */
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Cat Information ===\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Species: ").append(getSpecies()).append("\n");
        info.append("Breed: ").append(breed).append("\n");
        info.append("Age: ").append(age).append(" years\n");
        info.append("Weight: ").append(weight).append(" kg\n");
        info.append("Fur Pattern: ").append(furPattern).append("\n");
        info.append("Lives Remaining: ").append(lives).append("/9\n");
        info.append("Lifestyle: ").append(isIndoor ? "Indoor" : "Outdoor").append("\n");
        return info.toString();
    }
    
    // ===== CAT-SPECIFIC METHODS (not from interface) =====
    
    /**
     * Makes the cat purr - a sign of contentment.
     * Purring has healing properties!
     */
    public void purr() {
        System.out.println(name + " the cat purrs contentedly: purrrrrrr... 😊");
        System.out.println("  (Purring at 25-50 Hz can promote healing!)");
    }
    
    /**
     * Makes the cat climb to high places.
     * Cats love vertical territory!
     */
    public void climb() {
        System.out.println(name + " the cat climbs up high with sharp claws!");
        if (isIndoor) {
            System.out.println("  *scrambles up the cat tree*");
        } else {
            System.out.println("  *scales the nearest tree effortlessly*");
        }
        System.out.println("  (Cats feel safer when they can survey from above)");
    }
    
    /**
     * The cat attempts to hunt.
     * Even well-fed cats have hunting instincts!
     * 
     * @return true if the hunt was successful, false otherwise
     */
    public boolean huntMouse() {
        System.out.println(name + " the cat enters stealth mode... 🐭");
        System.out.println("  *pupils dilate* *crouches low* *wiggles rear*");
        
        // Success depends on age and whether indoor/outdoor
        double successChance = isIndoor ? 0.3 : 0.7;
        if (age < 1 || age > 10) {
            successChance -= 0.2;  // Very young or old cats are less successful
        }
        
        boolean success = Math.random() < successChance;
        
        if (success) {
            System.out.println("  POUNCE! The hunt was successful! 🎯");
        } else {
            System.out.println("  The prey escaped! Better luck next time...");
        }
        
        return success;
    }
    
    /**
     * The cat kneads with its paws.
     * This behavior comes from kittenhood!
     */
    public void knead() {
        System.out.println(name + " the cat kneads with its paws");
        System.out.println("  *push* *push* *push* (Making biscuits!)");
        System.out.println("  (This comforting behavior comes from nursing as a kitten)");
    }
    
    /**
     * The cat grooms itself.
     * Cats spend 30-50% of their waking hours grooming!
     */
    public void groom() {
        System.out.println(name + " the cat carefully grooms its " + furPattern + " fur");
        System.out.println("  *lick* *lick* (Cats are very clean animals!)");
    }
    
    /**
     * The cat plays with a toy.
     * Play is important for cats' physical and mental health!
     * 
     * @param toy The toy to play with
     */
    public void playWith(String toy) {
        System.out.println(name + " the cat plays enthusiastically with " + toy);
        System.out.println("  *bat* *pounce* *kick* (Practicing hunting skills!)");
    }
    
    /**
     * The cat uses one of its nine lives.
     * Called when the cat has a close call!
     */
    public void useLife() {
        if (lives > 0) {
            lives--;
            System.out.println(name + " the cat used one life! " + lives + " remaining.");
            if (lives == 1) {
                System.out.println("  Be careful! Only one life left!");
            }
        } else {
            System.out.println(name + " has no more lives to spare!");
        }
    }
    
    /**
     * The cat shows affection by slow blinking.
     * This is called a "cat kiss"!
     */
    public void slowBlink() {
        System.out.println(name + " the cat gives you a slow blink 😊");
        System.out.println("  (This is a cat kiss - it means 'I love you'!)");
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
    
    public String getFurPattern() {
        return furPattern;
    }
    
    public void setFurPattern(String furPattern) {
        this.furPattern = furPattern;
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 30) {  // Cats can live up to 30 years!
            this.age = age;
        }
    }
    
    public int getLives() {
        return lives;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        if (weight > 0 && weight < 20) {  // Reasonable cat weight range
            this.weight = weight;
        }
    }
    
    /**
     * String representation of the cat.
     * 
     * @return A string describing the cat
     */
    @Override
    public String toString() {
        return "Cat{name='" + name + "', breed='" + breed + "', age=" + age + 
               ", lives=" + lives + "}";
    }
}