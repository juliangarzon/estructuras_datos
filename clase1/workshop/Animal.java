/**
 * Animal Interface - Abstract Data Type (ADT)
 * 
 * This interface defines the contract that all animals must follow.
 * It specifies WHAT operations must be available, but not HOW they work.
 * 
 * In Data Structures terms:
 * - This is an ADT (Abstract Data Type)
 * - It defines operations without implementation
 * - Multiple concrete classes can implement it differently
 * 
 * @author Data Structures Course
 * @version 1.0
 */
public interface Animal {
    
    /**
     * Makes the animal eat.
     * Each animal will eat different food in its own way.
     */
    void eat();
    
    /**
     * Makes the animal sleep.
     * Different animals have different sleeping patterns.
     */
    void sleep();
    
    /**
     * Makes the animal produce its characteristic sound.
     * Some animals might not make any sound at all.
     */
    void makeSound();
    
    /**
     * Makes the animal move in its characteristic way.
     * Could be walking, hopping, flying, swimming, etc.
     */
    void move();
    
    /**
     * Returns the species name of the animal.
     * 
     * @return A String representing the species
     */
    String getSpecies();
    
    /**
     * Returns the age of the animal in years.
     * 
     * @return The age as an integer
     */
    int getAge();
    
    /**
     * Returns information about the animal as a formatted string.
     * 
     * @return A String with animal details
     */
    String getInfo();
}