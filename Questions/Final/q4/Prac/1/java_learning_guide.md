# Java Object Construction and Method Overriding - Key Learning Points

## The Critical Discovery

This session revealed a **fundamental but often misunderstood** aspect of Java's object construction process: **when instance variable initializers actually execute** during inheritance and method overriding.

## Key Learning Points

### 1. True Java Object Construction Order

Most developers think instance variables are initialized first, but that's **wrong**. Here's the actual order:

1. **Memory Allocation** - All variables get default values (int = 0, boolean = false, objects = null)
2. **Superclass Constructor Execution** - Complete execution including any method calls
3. **Instance Variable Initializers** - `public int y = 4;` type declarations run here
4. **Current Class Constructor Body** - The code inside `{ }` of constructor

### 2. Method Overriding During Construction

When a superclass constructor calls a method that's overridden in the subclass:
- The **overridden version** (subclass) executes, not the superclass version
- This happens **before** instance variables are initialized to their declared values
- Instance variables only have **default values** during this execution

### 3. Static vs Instance Variables

- **Static variables**: Initialized when class is first loaded, shared across all instances
- **Instance variables**: Each object gets its own copy, initialized **after** superclass constructor

### 4. The Dangerous Pattern

Calling overridable methods from constructors is risky because:
- Subclass method runs before subclass instance variables are initialized
- This can lead to unexpected behavior and subtle bugs
- The overridden method works with default values, not declared initializer values

## Complete Working Code

```java
class P {
    public static int a = 1;
    public int x = 2, sum = 3;

    public P() {
        a = ++a + x;
        sum += a;
        methodP(1);  // Dangerous: calls overridable method
    }
    
    public void methodP(int k) {
        x = a + k;
        sum = sum + x;
        System.out.println("P: " + x + " " + sum + " " + a);
    }
}

class C extends P {
    public static int b = 2;
    public int y = 4;  // This initializes AFTER parent constructor!
    
    public C(int z) {
        super();  // Parent constructor runs first
        b = b + z + a;
        sum = sum + b;
    }
    
    @Override
    public void methodP(int k) {
        // y is still 0 (default) when called from parent constructor!
        y = b + k + a;
        x = y - k;
        sum = sum + y;
        System.out.println("C: " + x + " " + y + " " + sum + " " + b);
    }
}

public class HardQ1Main {
    public static void main(String[] args) {
        P p1 = new C(2);     // Creates C object, stores in P reference
        C c1 = new C(3);     // Creates C object, stores in C reference
        System.out.println(c1.y);  // Prints 4 (initialized value)
        p1.methodP(2);       // Calls C's methodP (polymorphism)
        c1.methodP(1);       // Calls C's methodP
    }
}
```

## Expected Output

```
C: 6 7 14 2
C: 15 16 26 8
4
C: 25 27 49 18
C: 25 26 70 18
```

## Visual Timeline

### Object Creation: `new C(2)`

```
Step 1: Memory Allocation
├── P.a = 1, C.b = 2 (static variables already initialized)
├── Object memory allocated
├── All instance variables = default values
│   ├── x = 0, sum = 0 (not 2,3 yet!)
│   └── y = 0 (not 4 yet!)

Step 2: P() Constructor Execution
├── x = 2, sum = 3 (P's initializers run first in constructor)
├── a = ++a + x → a = 2 + 2 = 4 (static P.a becomes 4)
├── sum += a → sum = 3 + 4 = 7
├── methodP(1) called
│   └── C's overridden methodP executes!
│       ├── y = 0 (still default value!)
│       ├── y = b + k + a → y = 2 + 1 + 4 = 7
│       ├── x = y - k → x = 7 - 1 = 6
│       ├── sum = sum + y → sum = 7 + 7 = 14
│       └── Output: "C: 6 7 14 2"

Step 3: Instance Variable Initialization (CRUCIAL STEP!)
├── y = 4 (declared initializer overwrites the 7!)
├── Other instance variables already initialized in P()

Step 4: C(2) Constructor Body
├── b = b + z + a → b = 2 + 2 + 4 = 8 (static C.b becomes 8)
├── sum = sum + b → sum = 14 + 8 = 22
└── Construction complete

Final State: x = 6, sum = 22, y = 4 (not 7!)
```

### Object Creation: `new C(3)`

```
Step 1: Fresh Memory Allocation
├── Static variables unchanged: P.a = 4, C.b = 8
├── New instance variables = default values
│   └── y = 0 (fresh instance)

Step 2: P() Constructor Execution
├── x = 2, sum = 3 (fresh instance initializers)
├── a = ++a + x → a = ++4 + 2 = 7 (static P.a becomes 7)
├── sum += a → sum = 3 + 7 = 10
├── methodP(1) called
│   └── C's overridden methodP executes!
│       ├── y = 0 (default for this instance)
│       ├── y = b + k + a → y = 8 + 1 + 7 = 16
│       ├── x = y - k → x = 16 - 1 = 15
│       ├── sum = sum + y → sum = 10 + 16 = 26
│       └── Output: "C: 15 16 26 8"

Step 3: Instance Variable Initialization
├── y = 4 (overwrites the 16!)

Step 4: C(3) Constructor Body
├── b = b + z + a → b = 8 + 3 + 7 = 18 (static C.b becomes 18)
└── sum = sum + b → sum = 26 + 18 = 44

Final State: x = 15, sum = 44, y = 4 (not 16!)
```

### Method Calls from main()

```
System.out.println(c1.y) → Output: 4
├── y was reset to 4 by instance initializer after construction

p1.methodP(2) → C's methodP executes (polymorphism)
├── y = b + k + a → y = 18 + 2 + 7 = 27
├── x = y - k → x = 27 - 2 = 25  
├── sum = sum + y → sum = 22 + 27 = 49
└── Output: "C: 25 27 49 18"

c1.methodP(1) → C's methodP executes
├── y = b + k + a → y = 18 + 1 + 7 = 26
├── x = y - k → x = 26 - 1 = 25
├── sum = sum + y → sum = 44 + 26 = 70
└── Output: "C: 25 26 70 18"
```

## Best Practices Learned

1. **Avoid calling overridable methods from constructors** - they execute before instance variables are properly initialized

2. **Understand the construction timeline** - instance variable initializers run after parent constructor, not before

3. **Be careful with inheritance and polymorphism** - method resolution happens at runtime based on actual object type

4. **Static variables are shared** - changes affect all instances and persist across object creations

5. **Each instance has separate instance variables** - but they share the same static variables

## Why This Matters

This behavior can cause subtle bugs in real applications where:
- Subclass methods depend on properly initialized instance variables
- Constructor logic assumes certain initialization order
- Polymorphic method calls happen during object construction

Understanding this timeline is crucial for writing robust Java applications with inheritance hierarchies.