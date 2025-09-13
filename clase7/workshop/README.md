# Stack Workshop: Parenthesis Validator 🎯

## Introduction
In this workshop, you'll implement a parenthesis validator using Java's Stack data structure. This is a classic problem that demonstrates the power of stacks in solving real-world programming challenges.

## Problem Statement
You need to create a program that validates whether parentheses, brackets, and braces in a string are properly balanced and nested.

### Valid Examples ✅
- `"()"`
- `"()[]{}"`
- `"{[()]}"`
- `"((()))"`
- `"public void method() { if (true) { return; } }"`

### Invalid Examples ❌
- `"(]"` - Mismatched types
- `"([)]"` - Incorrect nesting
- `"((("` - Unclosed parentheses
- `")))"` - Extra closing parentheses
- `"{[(])}"` - Improper nesting order

## How Stacks Solve This Problem 🧠

### The Algorithm Concept:
1. **Opening brackets** `(`, `[`, `{` → Push onto stack
2. **Closing brackets** `)`, `]`, `}` → Check if it matches the top of stack
3. **End of string** → Stack should be empty

### Why Stack is Perfect:
- The **last opened** bracket must be the **first closed** (LIFO)
- Stack naturally handles nested structures
- O(n) time complexity, O(n) space complexity

## Your Task 📋

### Step 1: Create the Validator Class
Create a class called `ParenthesisValidator` with the following structure:

```java
public class ParenthesisValidator {
    // TODO: Add any necessary attributes

    public ParenthesisValidator() {
        // TODO: Initialize your validator
    }

    public boolean isValid(String expression) {
        // TODO: Implement validation logic
        // This method should return true if valid, false otherwise
    }

    // TODO: Add any helper methods you need
}
```

### Step 2: Implement the Logic
Your `isValid` method should:
1. Create a Stack to track opening brackets
2. Iterate through each character in the expression
3. Handle opening and closing brackets appropriately
4. Return the correct validation result

### Step 3: Create a Test Class
Create `TestValidator.java` to test your implementation:

```java
public class TestValidator {
    public static void main(String[] args) {
        ParenthesisValidator validator = new ParenthesisValidator();

        // Test cases
        String[] validCases = {
            "()",
            "()[]{}",
            "{[()]}",
            "((()))",
            ""  // Empty string is valid
        };

        String[] invalidCases = {
            "(]",
            "([)]",
            "(((",
            ")))",
            "{[(])}"
        };

        // TODO: Test your validator with these cases
        // Print results for each test
    }
}
```

## Stack Operations Reference 📚

Here's how to use Stack in Java:

```java
import java.util.Stack;

// Create a stack
Stack<Character> stack = new Stack<>();

// Push - Add element to top
stack.push('(');

// Pop - Remove and return top element
char top = stack.pop();  // Throws EmptyStackException if empty

// Peek - View top without removing
char current = stack.peek();  // Throws EmptyStackException if empty

// Check if empty
boolean isEmpty = stack.isEmpty();

// Get size
int size = stack.size();
```

## Implementation Hints 💡

### Hint 1: Character Matching
Think about how to check if a closing bracket matches an opening one:
```java
// Example approach (you need to implement this logic)
// If you see ')', the top of stack should be '('
// If you see ']', the top of stack should be '['
// If you see '}', the top of stack should be '{'
```

### Hint 2: Edge Cases to Consider
- What if the string is empty?
- What if there are non-bracket characters?
- What if the stack is empty when you encounter a closing bracket?
- What if the stack is not empty after processing all characters?

### Hint 3: Algorithm Pseudocode
```
FOR each character in expression:
    IF character is opening bracket:
        // What should you do?
    ELSE IF character is closing bracket:
        // What checks do you need?
        // What if stack is empty?
        // What if brackets don't match?
    ELSE:
        // Non-bracket character - skip or handle?

AFTER processing all characters:
    // What should the stack look like if valid?
```

## Bonus Challenges 🚀

Once your basic validator works, try these extensions:

### Challenge 1: Enhanced Validator
Modify your validator to:
- Ignore non-bracket characters (currently might be failing on text)
- Return the position of the first error
- Support custom bracket pairs

### Challenge 2: Expression Evaluator
Create a simple calculator that:
- Evaluates expressions like `"2 + (3 * 4)"`
- Respects parenthesis precedence
- Uses TWO stacks (one for numbers, one for operators)

### Challenge 3: HTML Tag Validator
Adapt your validator to check HTML tags:
- `<div><p></p></div>` ✅ Valid
- `<div><p></div></p>` ❌ Invalid

## Testing Your Solution 🧪

Your solution should correctly identify:
1. **Balanced**: Equal opening and closing brackets
2. **Properly Nested**: Correct order of closing
3. **Matched Types**: Each `(` with `)`, `[` with `]`, etc.

### Expected Output Example:
```
Testing valid cases:
"()" -> Valid ✓
"()[]{}" -> Valid ✓
"{[()]}" -> Valid ✓

Testing invalid cases:
"(]" -> Invalid ✗
"([)]" -> Invalid ✗
```

## Common Mistakes to Avoid ⚠️

1. **Forgetting empty stack check** before calling `pop()` or `peek()`
2. **Not handling empty strings** (they should be valid!)
3. **Only checking bracket count** (equal count doesn't mean valid)
4. **Not clearing the stack** between validations if reusing

## Submission Requirements 📝

Your submission should include:
1. `ParenthesisValidator.java` - Your main implementation
2. `TestValidator.java` - Test cases demonstrating your solution works
3. Comments explaining your approach
4. Handle all test cases provided

## Learning Objectives 🎓

After completing this workshop, you should understand:
- How stacks naturally solve nesting problems
- When to use Stack vs other data structures
- Real-world applications of LIFO principle
- Time and space complexity analysis

---

**Good luck! Remember: The key is understanding WHY stack is perfect for this problem.** 🏆