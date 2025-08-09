/**
 * Test your Cinema implementation
 * Time: 5 minutes
 */
public class CinemaTest {
    public static void main(String[] args) {
        System.out.println("=== CINEMA RESERVATION SYSTEM ===\n");
        
        // Step 1: Create a small cinema (4 rows, 6 columns)
        System.out.println("Creating cinema...");
        Cinema cinema = new Cinema(4, 6);
        
        // Step 2: Show empty cinema
        System.out.println("\n--- Initial Cinema Layout ---");
        cinema.displaySeats();
        
        // Step 3: Reserve some seats
        System.out.println("--- Making Reservations ---");
        cinema.reserveSeat(1, 2);  // Row 1, Column 2
        cinema.reserveSeat(1, 3);  // Row 1, Column 3
        cinema.reserveSeat(2, 2);  // Row 2, Column 2
        cinema.reserveSeat(2, 3);  // Row 2, Column 3
        cinema.reserveSeat(0, 0);  // Corner seat
        cinema.reserveSeat(3, 5);  // Last seat in last row
        
        // Step 4: Show cinema after reservations
        System.out.println("\n--- Cinema After Reservations ---");
        cinema.displaySeats();
        
        // Step 5: Try to reserve an already taken seat
        System.out.println("--- Trying to Reserve Taken Seat ---");
        if (!cinema.reserveSeat(1, 2)) {
            System.out.println("Could not reserve seat [1,2]");
        }
        
        // Step 6: Cancel a reservation
        System.out.println("\n--- Canceling Reservation ---");
        cinema.cancelReservation(0, 0);
        cinema.displaySeats();
        
        // Step 7: Show statistics
        System.out.println("--- Cinema Statistics ---");
        System.out.println("Total seats: " + (4 * 6));
        System.out.println("Reserved seats: " + cinema.getTotalReservations());
        System.out.println("Available seats: " + cinema.countAvailableSeats());
        System.out.printf("Occupancy: %.1f%%\n", cinema.getOccupancyPercentage());
        
        // Bonus tests (if you have time):
        System.out.println("\n--- Bonus Tests ---");
        // Try invalid seat positions
        System.out.println("Trying invalid seat [10,10]:");
        cinema.reserveSeat(10, 10);
        
        // Try negative indices
        System.out.println("Trying negative indices [-1,0]:");
        cinema.reserveSeat(-1, 0);
    }
}