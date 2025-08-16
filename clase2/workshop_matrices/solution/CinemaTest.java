/**
 * Cinema Test - Complete Solution with Extended Testing
 */
public class CinemaTest {
    public static void main(String[] args) {
        System.out.println("=== CINEMA RESERVATION SYSTEM ===\n");
        
        // Create a small cinema (5 rows, 8 columns)
        System.out.println("Creating cinema...");
        Cinema cinema = new Cinema(5, 8);
        
        // Show empty cinema
        System.out.println("\n--- Initial Cinema Layout ---");
        cinema.displaySeats();
        
        // Make some reservations
        System.out.println("--- Making Individual Reservations ---");
        cinema.reserveSeat(2, 3);  // Center seats
        cinema.reserveSeat(2, 4);
        cinema.reserveSeat(1, 2);
        cinema.reserveSeat(1, 3);
        cinema.reserveSeat(0, 0);  // Corner seat
        cinema.reserveSeat(4, 7);  // Last seat in last row
        
        // Show cinema after reservations
        System.out.println("\n--- Cinema After Reservations ---");
        cinema.displaySeats();
        
        // Try to reserve an already taken seat
        System.out.println("--- Trying to Reserve Taken Seat ---");
        if (!cinema.reserveSeat(2, 3)) {
            System.out.println("Could not reserve seat [2,3] - as expected!");
        }
        
        // Cancel a reservation
        System.out.println("\n--- Canceling Reservation ---");
        cinema.cancelReservation(0, 0);
        System.out.println("After canceling seat [0,0]:");
        cinema.displaySeats();
        
        // Show statistics
        System.out.println("--- Cinema Statistics ---");
        System.out.println("Total capacity: " + cinema.getTotalCapacity() + " seats");
        System.out.println("Reserved seats: " + cinema.getTotalReservations());
        System.out.println("Available seats: " + cinema.countAvailableSeats());
        System.out.printf("Occupancy: %.1f%%\n", cinema.getOccupancyPercentage());
        
        // Test boundary conditions
        System.out.println("\n--- Testing Invalid Positions ---");
        System.out.println("Trying invalid seat [10,10]:");
        cinema.reserveSeat(10, 10);
        
        System.out.println("Trying negative indices [-1,0]:");
        cinema.reserveSeat(-1, 0);
        
        // Test group reservation
        System.out.println("\n--- Group Reservation Test ---");
        System.out.println("Reserving 3 consecutive seats in row 3:");
        cinema.reserveGroup(3, 2, 3);  // Reserve seats 2, 3, 4 in row 3
        cinema.displaySeats();
        
        // Try to reserve overlapping group
        System.out.println("Trying to reserve overlapping group:");
        cinema.reserveGroup(3, 3, 3);  // Should fail
        
        // Find best seat
        System.out.println("\n--- Finding Best Available Seat ---");
        int[] bestSeat = cinema.findBestSeat();
        if (bestSeat != null) {
            System.out.println("Best seat is at row " + bestSeat[0] + ", column " + bestSeat[1]);
            cinema.reserveSeat(bestSeat[0], bestSeat[1]);
        }
        
        // Show row occupancy
        cinema.showRowOccupancy();
        
        // Fill more seats to test near-full cinema
        System.out.println("\n--- Filling More Seats ---");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.random() > 0.4) {  // 60% chance to reserve
                    cinema.reserveSeat(i, j);
                }
            }
        }
        
        // Show final state
        System.out.println("\n--- Final Cinema State ---");
        cinema.displaySeats();
        
        // Final statistics
        System.out.println("--- Final Statistics ---");
        System.out.println("Total capacity: " + cinema.getTotalCapacity() + " seats");
        System.out.println("Reserved seats: " + cinema.getTotalReservations());
        System.out.println("Available seats: " + cinema.countAvailableSeats());
        System.out.printf("Occupancy: %.1f%%\n", cinema.getOccupancyPercentage());
        
        // Show row occupancy for busy cinema
        cinema.showRowOccupancy();
        
        // Check specific seats
        System.out.println("\n--- Checking Specific Seats ---");
        System.out.println("Is seat [0,0] available? " + cinema.isSeatAvailable(0, 0));
        System.out.println("Is seat [2,3] available? " + cinema.isSeatAvailable(2, 3));
        System.out.println("Is seat [10,10] available? " + cinema.isSeatAvailable(10, 10));
    }
}