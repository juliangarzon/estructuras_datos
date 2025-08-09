# Workshop: Cinema Seat Reservation System (30 minutes)

## Overview
Build a simple cinema seat reservation system using 2D arrays (matrices). This practical example will help you understand how to work with multidimensional arrays.

## What You'll Build
A cinema with rows and columns of seats where customers can:
- View available seats
- Reserve seats
- Cancel reservations
- See cinema statistics

## Part 1: Understanding the Cinema Layout (5 minutes)

Imagine a small cinema:
```
     Screen
   [--------]
   
   Col: 0 1 2 3 4
Row 0:  O O O O O
Row 1:  O O X O O  
Row 2:  X X O O O
Row 3:  O O O O O

O = Available
X = Reserved
```

In Java, this is a 2D array:
```java
boolean[][] seats = new boolean[4][5];  // 4 rows, 5 columns
// false = available, true = reserved
```

## Part 2: Create the Cinema Class (20 minutes)

### Basic Structure
```java
public class Cinema {
    private boolean[][] seats;  // true = reserved, false = available
    private int rows;
    private int columns;
    private int totalReservations;
    
    public Cinema(int rows, int columns) {
        // Initialize the cinema
    }
}
```

### Core Methods to Implement

#### 1. Display Seats (5 minutes)
```java
public void displaySeats() {
    // Print the screen
    // Print column numbers
    // For each row:
    //   Print row number
    //   Print each seat as 'O' (available) or 'X' (reserved)
}
```

**Expected Output:**
```
     === SCREEN ===
     0  1  2  3  4
0    O  O  O  O  O
1    O  O  X  O  O
2    X  X  O  O  O
3    O  O  O  O  O
```

#### 2. Reserve a Seat (5 minutes)
```java
public boolean reserveSeat(int row, int col) {
    // Check if row and col are valid
    // Check if seat is available
    // Reserve the seat (set to true)
    // Increment totalReservations
    // Return true if successful
}
```

#### 3. Cancel Reservation (5 minutes)
```java
public boolean cancelReservation(int row, int col) {
    // Check if row and col are valid
    // Check if seat is actually reserved
    // Make seat available (set to false)
    // Decrement totalReservations
    // Return true if successful
}
```

#### 4. Check Availability (5 minutes)
```java
public boolean isSeatAvailable(int row, int col) {
    // Check bounds
    // Return if seat is available
}

public int countAvailableSeats() {
    // Count all available seats
    // Hint: nested loop through all seats
}
```

## Part 3: Quick Test (5 minutes)

```java
public class CinemaTest {
    public static void main(String[] args) {
        // Create a 5x8 cinema (5 rows, 8 columns)
        Cinema cinema = new Cinema(5, 8);
        
        // Show initial cinema
        cinema.displaySeats();
        
        // Reserve some seats
        cinema.reserveSeat(2, 3);  // Middle seats
        cinema.reserveSeat(2, 4);
        cinema.reserveSeat(0, 0);  // Corner seat
        
        // Show cinema after reservations
        cinema.displaySeats();
        
        // Try to reserve an already reserved seat
        if (!cinema.reserveSeat(2, 3)) {
            System.out.println("Seat already taken!");
        }
        
        // Show statistics
        System.out.println("Available seats: " + cinema.countAvailableSeats());
    }
}
```

## Key Concepts to Remember

1. **2D Array Declaration:**
   ```java
   type[][] arrayName = new type[rows][columns];
   ```

2. **Accessing Elements:**
   ```java
   array[row][column]  // Order matters!
   ```

3. **Nested Loops for 2D Arrays:**
   ```java
   for (int i = 0; i < rows; i++) {      // Outer loop: rows
       for (int j = 0; j < columns; j++) { // Inner loop: columns
           // Process array[i][j]
       }
   }
   ```

## Bonus Features (If Time Permits)

1. **Find Best Available Seats:**
   ```java
   public int[] findCenterSeat() {
       // Find available seat closest to center
   }
   ```

2. **Reserve Multiple Seats Together:**
   ```java
   public boolean reserveGroup(int row, int startCol, int numSeats) {
       // Reserve consecutive seats for a group
   }
   ```

3. **Show Row Statistics:**
   ```java
   public void showRowOccupancy() {
       // Show how full each row is
   }
   ```

## Common Mistakes to Avoid

- **Index confusion:** Remember [row][column], not [column][row]
- **Bounds checking:** Always validate row and column indices
- **Off-by-one errors:** Arrays start at 0, not 1
- **Not using nested loops:** Most 2D array operations need two loops

## Real-World Applications

- Seating charts (theaters, planes, classrooms)
- Game boards (chess, tic-tac-toe, battleship)
- Spreadsheets and tables
- Image processing (pixels)
- Maps and grids

## Tips for Success

- Draw the matrix on paper first
- Test with small sizes (3x3) before going bigger
- Use meaningful variable names (row/col not i/j)
- Always check array bounds
- Test edge cases (corners, first/last row)

Have fun building your cinema!