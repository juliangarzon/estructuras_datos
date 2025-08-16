/**
 * Cinema Seat Reservation System - Complete Solution
 */
public class Cinema {
    private boolean[][] seats;  // true = reserved, false = available
    private int rows;
    private int columns;
    private int totalReservations;
    
    /**
     * Constructor - Initialize the cinema
     */
    public Cinema(int rows, int columns) {
        this.seats = new boolean[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.totalReservations = 0;
        System.out.println("Cinema created with " + rows + " rows and " + columns + " seats per row");
        System.out.println("Total capacity: " + (rows * columns) + " seats");
    }
    
    /**
     * Display all seats in the cinema
     * O = available, X = reserved
     */
    public void displaySeats() {
        System.out.println("\n     === SCREEN ===");
        
        // Print column numbers
        System.out.print("     ");
        for (int j = 0; j < columns; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();
        
        // Print each row with row number
        for (int i = 0; i < rows; i++) {
            System.out.printf("%-4d ", i);  // Row number
            for (int j = 0; j < columns; j++) {
                if (seats[i][j]) {
                    System.out.print(" X ");  // Reserved
                } else {
                    System.out.print(" O ");  // Available
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Reserve a seat
     */
    public boolean reserveSeat(int row, int col) {
        // Check if row is valid
        if (row < 0 || row >= rows) {
            System.out.println("❌ Invalid row number! Must be between 0 and " + (rows - 1));
            return false;
        }
        
        // Check if column is valid
        if (col < 0 || col >= columns) {
            System.out.println("❌ Invalid column number! Must be between 0 and " + (columns - 1));
            return false;
        }
        
        // Check if seat is already reserved
        if (seats[row][col]) {
            System.out.println("❌ Seat [" + row + "," + col + "] is already reserved!");
            return false;
        }
        
        // Reserve the seat
        seats[row][col] = true;
        totalReservations++;
        System.out.println("✅ Seat [" + row + "," + col + "] reserved successfully!");
        return true;
    }
    
    /**
     * Cancel a reservation
     */
    public boolean cancelReservation(int row, int col) {
        // Check if row and col are valid
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            System.out.println("❌ Invalid seat position!");
            return false;
        }
        
        // Check if seat is actually reserved
        if (!seats[row][col]) {
            System.out.println("❌ Seat [" + row + "," + col + "] is not reserved!");
            return false;
        }
        
        // Cancel the reservation
        seats[row][col] = false;
        totalReservations--;
        System.out.println("✅ Reservation for seat [" + row + "," + col + "] cancelled successfully!");
        return true;
    }
    
    /**
     * Count available seats
     */
    public int countAvailableSeats() {
        int count = 0;
        
        // Use nested loops to go through all seats
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!seats[i][j]) {  // If seat is available (false)
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Check if a specific seat is available
     */
    public boolean isSeatAvailable(int row, int col) {
        // Check bounds first
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            return false;
        }
        
        // Return true if seat is available (false in array)
        return !seats[row][col];
    }
    
    /**
     * Get total reservations
     */
    public int getTotalReservations() {
        return totalReservations;
    }
    
    /**
     * Get occupancy percentage
     */
    public double getOccupancyPercentage() {
        int totalSeats = rows * columns;
        return (totalReservations * 100.0) / totalSeats;
    }
    
    /**
     * Get total capacity
     */
    public int getTotalCapacity() {
        return rows * columns;
    }
    
    // === BONUS METHODS ===
    
    /**
     * Reserve multiple consecutive seats in a row
     */
    public boolean reserveGroup(int row, int startCol, int numSeats) {
        // Check if row is valid
        if (row < 0 || row >= rows) {
            System.out.println("❌ Invalid row number!");
            return false;
        }
        
        // Check if we have enough columns
        if (startCol < 0 || startCol + numSeats > columns) {
            System.out.println("❌ Not enough seats in the row!");
            return false;
        }
        
        // First check if all seats are available
        for (int j = startCol; j < startCol + numSeats; j++) {
            if (seats[row][j]) {
                System.out.println("❌ Seat [" + row + "," + j + "] is already reserved. Cannot reserve group.");
                return false;
            }
        }
        
        // If all are available, reserve them
        for (int j = startCol; j < startCol + numSeats; j++) {
            seats[row][j] = true;
            totalReservations++;
        }
        
        System.out.println("✅ Reserved " + numSeats + " consecutive seats in row " + row);
        return true;
    }
    
    /**
     * Find the best available seat (closest to center)
     */
    public int[] findBestSeat() {
        int centerRow = rows / 2;
        int centerCol = columns / 2;
        
        int bestRow = -1;
        int bestCol = -1;
        double minDistance = Double.MAX_VALUE;
        
        // Find available seat closest to center
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!seats[i][j]) {  // If seat is available
                    // Calculate distance to center
                    double distance = Math.sqrt(Math.pow(i - centerRow, 2) + Math.pow(j - centerCol, 2));
                    if (distance < minDistance) {
                        minDistance = distance;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        
        if (bestRow == -1) {
            System.out.println("❌ No available seats!");
            return null;
        }
        
        System.out.println("✅ Best available seat found at [" + bestRow + "," + bestCol + "]");
        return new int[]{bestRow, bestCol};
    }
    
    /**
     * Show row occupancy statistics
     */
    public void showRowOccupancy() {
        System.out.println("\n--- Row Occupancy ---");
        
        for (int i = 0; i < rows; i++) {
            int reserved = 0;
            for (int j = 0; j < columns; j++) {
                if (seats[i][j]) reserved++;
            }
            
            double percentage = (reserved * 100.0) / columns;
            System.out.printf("Row %d: ", i);
            
            // Visual bar
            int barLength = 10;
            int filledBars = (int) (percentage / 10);
            for (int b = 0; b < barLength; b++) {
                if (b < filledBars) {
                    System.out.print("█");
                } else {
                    System.out.print("░");
                }
            }
            System.out.printf(" %.0f%% (%d/%d)\n", percentage, reserved, columns);
        }
    }
}