# Queue Workshop: Emergency Room Triage System 🏥

## Problem Statement

You are tasked with implementing a **Hospital Emergency Room Triage System** using Queues. In a real emergency room, patients are not served on a first-come, first-served basis. Instead, they are prioritized based on the severity of their condition. However, within each priority level, patients should be served in the order they arrived (FIFO).

## Scenario

The emergency room has 3 priority levels:
- **Priority 1 (CRITICAL)**: Life-threatening conditions
- **Priority 2 (URGENT)**: Serious but not immediately life-threatening
- **Priority 3 (STANDARD)**: Minor injuries or illnesses

Your system should:
1. Register new patients with their priority level
2. Call the next patient based on priority (Critical first, then Urgent, then Standard)
3. Within each priority, maintain FIFO order
4. Display waiting times and queue status
5. Handle patient departures (if they leave before being seen)

## Algorithm Design

```
ALGORITHM TriageSystem:

STRUCTURES:
- Create 3 separate Queues (one for each priority level)
- Patient object contains: {name, arrivalTime, priority, symptoms}

OPERATIONS:

1. REGISTER_PATIENT(patient, priority):
   - Add timestamp to patient
   - Based on priority (1, 2, or 3):
     - Add patient to corresponding queue
   - Return queue position within their priority level

2. CALL_NEXT_PATIENT():
   - IF critical_queue is not empty:
     - Remove and return first patient from critical_queue
   - ELSE IF urgent_queue is not empty:
     - Remove and return first patient from urgent_queue
   - ELSE IF standard_queue is not empty:
     - Remove and return first patient from standard_queue
   - ELSE:
     - Return "No patients waiting"

3. GET_WAITING_TIME(patient):
   - Find patient's queue based on priority
   - Count patients ahead in same queue
   - Count all patients in higher priority queues
   - Estimate time = (position × average_consultation_time)

4. DISPLAY_STATUS():
   - Show count for each priority queue
   - Show next patient for each non-empty queue
   - Show total patients waiting

5. REMOVE_PATIENT(patientName):
   - Search in all three queues
   - Remove if found
   - Return success/failure status
```

## Queue Operations Reference in Java

### Import Required Classes
```java
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
```

### Creating a Queue
```java
// Recommended: ArrayDeque (most efficient)
Queue<Patient> criticalQueue = new ArrayDeque<>();

// Alternative: LinkedList
Queue<Patient> urgentQueue = new LinkedList<>();
```

### Basic Queue Operations

| Operation | Method | Description | Return Value |
|-----------|--------|-------------|--------------|
| **Add to queue** | `offer(element)` | Adds element to the rear | `boolean` (true if successful) |
| **Remove from queue** | `poll()` | Removes and returns front element | Element or `null` if empty |
| **View front** | `peek()` | Returns front without removing | Element or `null` if empty |
| **Check if empty** | `isEmpty()` | Checks if queue is empty | `boolean` |
| **Get size** | `size()` | Returns number of elements | `int` |

### Code Examples

```java
// Adding patients to queue
Patient patient1 = new Patient("John Doe", "Chest pain");
criticalQueue.offer(patient1);

// Processing next patient
Patient nextPatient = criticalQueue.poll();
if (nextPatient != null) {
    System.out.println("Now seeing: " + nextPatient.getName());
}

// Checking who's next without removing
Patient upNext = criticalQueue.peek();

// Checking queue status
if (!urgentQueue.isEmpty()) {
    System.out.println("Urgent patients waiting: " + urgentQueue.size());
}
```

### Iterating Through a Queue (without removing)
```java
// To display all patients waiting
for (Patient p : criticalQueue) {
    System.out.println(p.getName() + " - Waiting");
}
```

### Removing Specific Element
```java
// To remove a patient who left
boolean removed = urgentQueue.remove(patientToRemove);
```

## Implementation Requirements

### Core Classes to Create

1. **Patient.java**
   - Properties: name, arrivalTime, priority, symptoms
   - Constructor and getters/setters
   - toString() method for display

2. **TriageSystem.java**
   - Three Queue<Patient> instances (one per priority)
   - Methods for all operations listed in the algorithm
   - Statistics tracking (total served, average wait time)

3. **EmergencyRoom.java** (Main class)
   - Interactive menu system
   - Options to:
     - Register new patient
     - Call next patient
     - View all waiting patients
     - Remove patient who left
     - View statistics
     - Exit system

## Expected Output Example

```
========= EMERGENCY ROOM TRIAGE SYSTEM =========

1. Register New Patient
2. Call Next Patient
3. View Waiting Patients
4. Patient Left Without Being Seen
5. View Statistics
6. Exit

Choose option: 1

Enter patient name: Alice Smith
Enter symptoms: Broken arm
Select priority:
  1 - CRITICAL
  2 - URGENT
  3 - STANDARD
Choice: 2

✓ Patient registered: Alice Smith
  Priority: URGENT
  Position in queue: 3
  Estimated wait: 45 minutes

-------------------------------------------------

Current Status:
CRITICAL:  2 patients waiting
URGENT:    3 patients waiting
STANDARD:  5 patients waiting

Next to be called: Bob Johnson (CRITICAL)
```

## Bonus Challenges

1. **Add Priority Upgrade**: After waiting 2 hours, STANDARD patients automatically upgrade to URGENT
2. **Multiple Doctors**: Simulate multiple doctors calling patients simultaneously
3. **Save/Load State**: Persist queue state to file and restore on program restart
4. **Statistics Dashboard**: Track and display:
   - Average wait time per priority
   - Busiest hours
   - Patient flow rate

## Testing Scenarios

Test your implementation with these scenarios:

1. **Empty Queues**: Calling next patient when all queues are empty
2. **Priority Order**: Add patients in mixed order, verify critical served first
3. **FIFO Within Priority**: Multiple patients same priority, verify order preserved
4. **Patient Removal**: Remove patient from middle of queue
5. **Large Volume**: Handle 50+ patients across priorities

## Grading Criteria

- **Functionality (40%)**: All operations work correctly
- **Algorithm Implementation (30%)**: Proper use of Queue data structure
- **Code Quality (20%)**: Clean, commented, well-organized code
- **User Interface (10%)**: Clear, intuitive menu system

## Submission

Submit the following files:
- Patient.java
- TriageSystem.java
- EmergencyRoom.java
- README.txt with any special instructions or assumptions

Good luck! Remember: In emergency medicine, proper triage saves lives! 🚑