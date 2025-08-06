/**
 * Bird Class - Flying Implementation of Animal Interface
 * 
 * This class demonstrates how an animal with unique characteristics
 * (flying) can implement the same interface. Birds introduce new
 * concepts like flight and different movement patterns.
 * 
 * This is a BONUS EXAMPLE to show interface flexibility.
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public class Bird implements Animal {
    
    // Instance variables specific to birds
    private String name;
    private String species;  // Cardinal, Eagle, Parrot, etc.
    private String featherColor;
    private int age;
    private double wingspan;  // in centimeters
    private boolean canFly;
    private boolean isMigratory;
    private String habitat;  // forest, desert, city, etc.
    private int flightSpeed;  // km/h when flying
    
    /**
     * Full constructor for Bird class.
     * 
     * @param name The bird's name
     * @param species The bird's species
     * @param featherColor Primary feather color
     * @param age The bird's age in years
     * @param wingspan The bird's wingspan in cm
     * @param canFly Whether this bird can fly
     * @param isMigratory Whether this bird migrates
     * @param habitat The bird's preferred habitat
     * @param flightSpeed The bird's flying speed in km/h
     */
    public Bird(String name, String species, String featherColor, int age, 
                double wingspan, boolean canFly, boolean isMigratory, 
                String habitat, int flightSpeed) {
        this.name = name;
        this.species = species;
        this.featherColor = featherColor;
        this.age = age;
        this.wingspan = wingspan;
        this.canFly = canFly;
        this.isMigratory = isMigratory;
        this.habitat = habitat;
        this.flightSpeed = flightSpeed;
    }
    
    /**
     * Simple constructor for common birds.
     * Creates a small flying bird.
     * 
     * @param name The bird's name
     * @param species The bird's species
     */
    public Bird(String name, String species) {
        this(name, species, "brown", 2, 30.0, true, false, "forest", 25);
    }
    
    /**
     * Implementation of eat() method from Animal interface.
     * Birds have diverse diets depending on their species.
     */
    @Override
    public void eat() {
        System.out.println(name + " the " + species + " searches for food...");
        
        // Different birds eat different things
        switch(species.toLowerCase()) {
            case "eagle":
            case "hawk":
                System.out.println("  *swoops down* Catches a fish with sharp talons! 🐟");
                break;
            case "hummingbird":
                System.out.println("  *hovers at flower* Sips sweet nectar with long beak 🌺");
                break;
            case "parrot":
                System.out.println("  *cracks open* Enjoys nuts and seeds 🥜");
                break;
            case "robin":
                System.out.println("  *pecks ground* Finds juicy worms and insects 🐛");
                break;
            case "owl":
                System.out.println("  *silent hunt* Catches a mouse in the darkness 🐭");
                break;
            default:
                System.out.println("  *pecks around* Finds seeds and small insects");
        }
        
        System.out.println("  (Birds need to eat frequently to maintain energy for flight!)");
    }
    
    /**
     * Implementation of sleep() method from Animal interface.
     * Birds have interesting sleeping habits!
     */
    @Override
    public void sleep() {
        System.out.println(name + " the " + species + " prepares to sleep...");
        
        if (species.toLowerCase().equals("owl")) {
            System.out.println("  *finds tree cavity during day* Owls are nocturnal!");
            System.out.println("  ZZZ... (Sleeping while the world is awake)");
        } else {
            System.out.println("  *finds safe branch* Tucks head under wing");
            System.out.println("  ZZZ... (Birds can sleep with one eye open to watch for danger!)");
        }
        
        if (wingspan > 100) {  // Large birds
            System.out.println("  (Large birds like this need safe, high perches)");
        }
    }
    
    /**
     * Implementation of makeSound() method from Animal interface.
     * Birds are known for their diverse vocalizations!
     */
    @Override
    public void makeSound() {
        switch(species.toLowerCase()) {
            case "parrot":
                System.out.println(name + " the parrot says: Hello! Pretty bird! 🦜");
                if (Math.random() > 0.7) {
                    System.out.println("  *mimics phone ringing* RING RING!");
                }
                break;
            case "eagle":
                System.out.println(name + " the eagle calls: SCREEEECH! 🦅");
                System.out.println("  (A majestic call that echoes across the mountains)");
                break;
            case "owl":
                System.out.println(name + " the owl hoots: Hoo hoo hoo! 🦉");
                System.out.println("  (A haunting sound in the night)");
                break;
            case "robin":
                System.out.println(name + " the robin sings: Tweet tweet chirp! 🐦");
                System.out.println("  (A cheerful morning song)");
                break;
            case "crow":
                System.out.println(name + " the crow caws: CAW CAW CAW! 🐦‍⬛");
                System.out.println("  (Crows are incredibly intelligent!)");
                break;
            case "hummingbird":
                System.out.println(name + " the hummingbird chirps softly: chirp chirp");
                System.out.println("  *wings humming at 80 beats per second*");
                break;
            default:
                System.out.println(name + " the " + species + " chirps melodiously!");
                System.out.println("  Tweet tweet! (Each bird has its own unique song)");
        }
    }
    
    /**
     * Implementation of move() method from Animal interface.
     * Birds have the most diverse movement patterns!
     */
    @Override
    public void move() {
        if (canFly) {
            if (wingspan < 20) {  // Small birds
                System.out.println(name + " the " + species + " flutters quickly through the air!");
                System.out.println("  *rapid wing beats* - Small birds are incredibly agile!");
            } else if (wingspan > 150) {  // Large birds
                System.out.println(name + " the " + species + " soars majestically on thermal currents!");
                System.out.println("  *barely flaps wings* - Using air currents efficiently");
            } else {  // Medium birds
                System.out.println(name + " the " + species + " flies gracefully at " + 
                                 flightSpeed + " km/h");
                System.out.println("  *steady wing beats* - Perfect flying form");
            }
            
            if (isMigratory) {
                System.out.println("  (This bird can fly thousands of kilometers during migration!)");
            }
        } else {
            // Flightless birds
            System.out.println(name + " the " + species + " runs quickly on strong legs");
            System.out.println("  *can't fly but moves fast on ground*");
            if (species.toLowerCase().equals("penguin")) {
                System.out.println("  (But swims like a fish underwater!)");
            }
        }
    }
    
    /**
     * Implementation of getSpecies() method from Animal interface.
     * 
     * @return The species name with bird classification
     */
    @Override
    public String getSpecies() {
        return species + " (Class: Aves - Birds)";
    }
    
    /**
     * Implementation of getAge() method from Animal interface.
     * 
     * @return The bird's age
     */
    @Override
    public int getAge() {
        return age;
    }
    
    /**
     * Implementation of getInfo() method from Animal interface.
     * 
     * @return Formatted string with bird details
     */
    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== Bird Information ===\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Species: ").append(getSpecies()).append("\n");
        info.append("Age: ").append(age).append(" years\n");
        info.append("Feather Color: ").append(featherColor).append("\n");
        info.append("Wingspan: ").append(wingspan).append(" cm\n");
        info.append("Can Fly: ").append(canFly ? "Yes" : "No").append("\n");
        info.append("Flight Speed: ").append(flightSpeed).append(" km/h\n");
        info.append("Migratory: ").append(isMigratory ? "Yes" : "No").append("\n");
        info.append("Habitat: ").append(habitat).append("\n");
        return info.toString();
    }
    
    // ===== BIRD-SPECIFIC METHODS (not from interface) =====
    
    /**
     * Makes the bird take off and fly.
     * Only works if the bird can fly!
     */
    public void takeOff() {
        if (canFly) {
            System.out.println(name + " the " + species + " spreads its wings...");
            System.out.println("  *flap flap flap* ... LIFT OFF! 🚀");
            System.out.println("  Now soaring " + (wingspan * 10) + " meters above ground!");
        } else {
            System.out.println(name + " the " + species + " cannot fly");
            System.out.println("  *flaps wings unsuccessfully* (This bird is flightless)");
        }
    }
    
    /**
     * Makes the bird land safely.
     */
    public void land() {
        if (canFly) {
            System.out.println(name + " the " + species + " circles and prepares to land...");
            System.out.println("  *gentle touchdown* Landed safely on a branch!");
        } else {
            System.out.println(name + " the " + species + " is already on the ground!");
        }
    }
    
    /**
     * Makes the bird build a nest.
     * Different birds build different types of nests!
     */
    public void buildNest() {
        System.out.println(name + " the " + species + " starts building a nest...");
        
        switch(species.toLowerCase()) {
            case "eagle":
                System.out.println("  *builds massive stick nest* This nest can weigh over 1000kg!");
                break;
            case "hummingbird":
                System.out.println("  *weaves tiny nest* About the size of a golf ball!");
                break;
            case "robin":
                System.out.println("  *shapes mud and grass* A perfect cup-shaped nest!");
                break;
            case "penguin":
                System.out.println("  *arranges pebbles* Penguins make nests from stones!");
                break;
            default:
                System.out.println("  *gathers twigs and leaves* Building a cozy home!");
        }
    }
    
    /**
     * Makes the bird preen (clean) its feathers.
     * Essential for flight and insulation!
     */
    public void preen() {
        System.out.println(name + " the " + species + " carefully preens its " + 
                         featherColor + " feathers");
        System.out.println("  *arranges feathers with beak* Must keep feathers perfect for flight!");
        System.out.println("  (Birds spend 10% of their day preening!)");
    }
    
    /**
     * Makes the bird sing a song.
     * Different from makeSound() - this is musical!
     * 
     * @param timeOfDay Morning, afternoon, or evening
     */
    public void sing(String timeOfDay) {
        System.out.println(name + " the " + species + " sings a beautiful " + 
                         timeOfDay + " song!");
        
        if (timeOfDay.toLowerCase().equals("morning")) {
            System.out.println("  ♪♫ Tweet-chirp-trill-chirp! ♫♪ (Dawn chorus!)");
        } else if (timeOfDay.toLowerCase().equals("evening")) {
            System.out.println("  ♪♫ Soft melodic warbling ♫♪ (Peaceful evening song)");
        } else {
            System.out.println("  ♪♫ Happy chirping melody ♫♪");
        }
    }
    
    /**
     * Makes the bird migrate (if it's a migratory species).
     * 
     * @param destination Where the bird is migrating to
     */
    public void migrate(String destination) {
        if (isMigratory && canFly) {
            System.out.println(name + " the " + species + " begins migration to " + destination + "!");
            System.out.println("  *joins flock* Flying thousands of kilometers!");
            System.out.println("  (Using magnetic fields and stars for navigation)");
        } else if (!isMigratory) {
            System.out.println(name + " the " + species + " doesn't migrate - stays home year-round");
        } else {
            System.out.println(name + " the " + species + " cannot migrate without flight");
        }
    }
    
    /**
     * Makes the bird hunt for prey.
     * Different hunting strategies for different birds.
     * 
     * @return true if hunt was successful
     */
    public boolean hunt() {
        if (species.toLowerCase().contains("eagle") || 
            species.toLowerCase().contains("hawk") || 
            species.toLowerCase().contains("owl")) {
            
            System.out.println(name + " the " + species + " enters hunting mode...");
            System.out.println("  *keen eyes scanning* ... *silent approach* ...");
            
            boolean success = Math.random() > 0.4; // Predatory birds are skilled
            
            if (success) {
                System.out.println("  *STRIKE!* Successful hunt! 🎯");
                return true;
            } else {
                System.out.println("  The prey escaped this time...");
                return false;
            }
        } else {
            System.out.println(name + " the " + species + " forages for seeds and insects");
            System.out.println("  *pecking and searching* (Not a predatory bird)");
            return true; // Always finds something
        }
    }
    
    /**
     * Makes the bird lay eggs.
     * The miracle of bird reproduction!
     * 
     * @param numEggs Number of eggs to lay
     */
    public void layEggs(int numEggs) {
        System.out.println(name + " the " + species + " lays " + numEggs + " eggs in the nest");
        
        if (numEggs == 1) {
            System.out.println("  One precious egg! (Large birds usually lay fewer eggs)");
        } else if (numEggs <= 3) {
            System.out.println("  A small clutch - each egg is precious!");
        } else {
            System.out.println("  A big family coming! (Smaller birds often lay more eggs)");
        }
        
        System.out.println("  *sits protectively on nest* Now begins the incubation period...");
    }
    
    /**
     * The bird teaches its young to fly.
     * Parental care in action!
     */
    public void teachFlying() {
        if (canFly) {
            System.out.println(name + " the " + species + " teaches the young ones to fly!");
            System.out.println("  *demonstrates wing technique* Watch and learn, little ones!");
            System.out.println("  *encourages from branch* Come on, you can do it!");
        } else {
            System.out.println(name + " the " + species + " teaches other important survival skills");
            System.out.println("  (Since this bird can't fly, teaches running and foraging instead)");
        }
    }
    
    // ===== GETTER AND SETTER METHODS =====
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBirdSpecies() {
        return species;
    }
    
    public void setBirdSpecies(String species) {
        this.species = species;
    }
    
    public String getFeatherColor() {
        return featherColor;
    }
    
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 100) {  // Some birds live very long!
            this.age = age;
        }
    }
    
    public double getWingspan() {
        return wingspan;
    }
    
    public void setWingspan(double wingspan) {
        if (wingspan > 0) {
            this.wingspan = wingspan;
        }
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public boolean isMigratory() {
        return isMigratory;
    }
    
    public void setMigratory(boolean migratory) {
        isMigratory = migratory;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    public int getFlightSpeed() {
        return flightSpeed;
    }
    
    public void setFlightSpeed(int flightSpeed) {
        if (flightSpeed >= 0) {
            this.flightSpeed = flightSpeed;
        }
    }
    
    /**
     * String representation of the bird.
     * 
     * @return A string describing the bird
     */
    @Override
    public String toString() {
        return "Bird{name='" + name + "', species='" + species + "', age=" + age + 
               ", canFly=" + canFly + "}";
    }
}