/**
 * BONUS CHALLENGES - Only if you finish early!
 * Add these methods to your Cinema class
 */
public class BonusChallenges {
    
    /**
     * Challenge 1: Reserve multiple consecutive seats in a row
     * Useful for families or groups who want to sit together
     */
    public boolean reserveGroup(int row, int startCol, int numSeats) {
        // TODO: Check if all seats from startCol to startCol+numSeats-1 are available
        // TODO: If yes, reserve all of them
        // TODO: If any is taken, don't reserve any and return false
        
        // Hint: First check, then reserve (two separate loops)
        return false;
    }
    
    /**
     * Challenge 2: Find the best available seat (closest to center)
     * Returns [row, col] of the best seat, or null if cinema is full
     */
    public int[] findBestSeat() {
        // TODO: Calculate center position
        int centerRow = rows / 2;
        int centerCol = columns / 2;
        
        // TODO: Find available seat closest to center
        // Hint: Check seats in expanding squares around center
        
        return null;
    }
    
    /**
     * Challenge 3: Show which rows are most full
     */
    public void showRowOccupancy() {
        System.out.println("\n--- Row Occupancy ---");
        
        // TODO: For each row, count reserved seats and show percentage
        // Example output:
        // Row 0: ████░░░░░░ 40%
        // Row 1: ████████░░ 80%
    }
    
    /**
     * Challenge 4: Create a VIP section (first 2 rows)
     * VIP seats cost more, so track them separately
     */
    public boolean reserveVIPSeat(int row, int col) {
        // TODO: Check if seat is in VIP section (row < 2)
        // TODO: Reserve if available and track as VIP
        return false;
    }
    
    /**
     * Challenge 5: Suggest seats for different preferences
     */
    public int[] suggestSeat(String preference) {
        // TODO: Based on preference, suggest a seat
        // "front" - closest to screen (row 0)
        // "back" - farthest from screen (last row)
        // "aisle" - column 0 or last column
        // "center" - middle of cinema
        
        return null;
    }
}