# Java Code Tracing Template

## [Class Name] Class

```java
[Class code here]
```

## [Tester Class Name] Class

```java
[Tester code here]
```

---

## **Main Method Execution**

```java
[Object creation statement]
```
- Creates `[ClassName]` object `[objectName]` with instance variables:
  - `[objectName].[variable] = [value]`
  - `[objectName].[variable] = [value]` (default [type] value)

## [Method Name] Call
```java
[method call statement]
```

**Inside [methodName]([parameters]) on [objectName]:**
- Parameter: `[paramName] = [value]`

**Current State:**
- `[objectName].[variable] = [value]`
- `[objectName].[variable] = [value]`

**[methodName] Code:**
```java
[method code here]
```

**[methodName] execution line by line:**

```
Step 1: [statement]
        [explanation of what happens]

Step 2: [statement]
        [calculation/assignment details]

Step 3: [complex statement requiring nested call]
        Need to evaluate: [expression breakdown]
        Call [nestedMethod]([parameters]) first
```

## Nested [methodName] Call
**Inside [methodName]([parameters]) on [objectName]:**
- Parameters: `[param1] = [value]`, `[param2] = [value]`

**Current State:**
- `[objectName].[variable] = [value]`

**[methodName] Code:**
```java
[method code]
```

**[methodName] execution line by line:**

```
Step 1: [statement]
        [detailed explanation]

Step 2: [statement with calculation]
        [variable] = [calculation] = [result]

Step 3: Print "[output]" ([explanation of each value])

Step 4: return [value]
        Returns [value]
```

**Back to [callingMethod]:**
```
Step X (continued): [statement completion]
                    [final calculation] = [result]

Step Y: Print "[output]" ([explanation of values])
```

**State after [methodName]:**
- `[objectName].[variable] = [value]`
- `[objectName].[variable] = [value]`

## [Additional Method Calls/Object Creation]
[Repeat above pattern for each method call or object creation]

## Final Output
The program produces the following output:
```
[line 1 output]
[line 2 output]
[line 3 output]
```

## Final State Summary
**[objectName] object:**
- `[objectName].[variable] = [value]`
- `[objectName].[variable] = [value]`

**[objectName2] object:**
- `[objectName2].[variable] = [value]`
- `[objectName2].[variable] = [value]`

---

## **Key Tracing Elements to Remember:**

### 1. Object Creation
- Show initial values (explicit and default)
- Track instance variable states

### 2. Method Calls
- Show parameters passed
- Track local vs instance variables
- Handle variable shadowing
- Show current state before execution

### 3. Line-by-Line Execution
- Number each step
- Show calculations explicitly
- Handle pre/post increment operations
- Track array modifications
- Explain nested method calls

### 4. Variable Tracking
- Instance variables: `this.variable` or `objectName.variable`
- Local variables: `variable` (note shadowing)
- Parameters: clearly distinguish from instance variables
- Array elements: track index changes

### 5. Output Statements
- Show exactly what gets printed
- Explain which variables contribute to each output value
- Track method return values

### 6. State Management
- Show state before and after each method
- Track changes between multiple calls
- Handle multiple objects independently
- Show final state summary

### 7. Special Operations
- **Pre-increment (++var)**: increment first, then use
- **Post-increment (var++)**: use current value, then increment
- **Reference assignment**: show when objects share references
- **Parameter modification**: doesn't affect original variables outside method
- **Array operations**: track element changes
- **Method return values**: show how they're used in expressions