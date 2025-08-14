# Java Code Trace - TracingX Class

## TracingX Class

```java
class TracingX {
  public int x, y = 1;
  public int metA(int y){
    y += x + 3;
    int temp = y + this.y;
    if (temp % 2 == 0){
      return temp;
    }
    TracingX t = new TracingX();
    t.y = this.x - (++x) + t.x;
    this.y = y + t.metA(t.x);
    System.out.println(x +" "+ y +" "+temp);
    return temp+this.y;
  }
}
```

## TesterX Class

```java
public class TesterX {
 public static void main(String[] args) {
   TracingX t1 = new TracingX();
   t1.y = t1.x = 5;
   TracingX t2 = new TracingX();
   t2.x = t1.metA(2);
   t2.y = t2.metA(4);
   System.out.println(t1.y +t1.x +" "+t2.x +" "+t2.y);
 }
}
```

---

## **Main Method Execution**

```java
TracingX t1 = new TracingX();
```
- Creates `TracingX` object `t1` with instance variables:
  - `t1.x = 0` (default int value)
  - `t1.y = 1`

```java
t1.y = t1.x = 5;
```
- Assignment from right to left: `t1.x = 5`, then `t1.y = 5`

**State after assignments:**
- `t1.x = 5`
- `t1.y = 5`

```java
TracingX t2 = new TracingX();
```
- Creates `TracingX` object `t2` with instance variables:
  - `t2.x = 0` (default int value)
  - `t2.y = 1`

## First metA Call
```java
t2.x = t1.metA(2);
```

**Inside metA(int y) on t1:**
- Parameter: `y = 2`

**Current State:**
- `t1.x = 5`
- `t1.y = 5`

**metA Code:**
```java
y += x + 3;
int temp = y + this.y;
if (temp % 2 == 0){
  return temp;
}
TracingX t = new TracingX();
t.y = this.x - (++x) + t.x;
this.y = y + t.metA(t.x);
System.out.println(x +" "+ y +" "+temp);
return temp+this.y;
```

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 2 + 5 + 3 = 10 (parameter y += instance x + 3)

Step 2: int temp = y + this.y
        temp = 10 + 5 = 15 (temp = parameter y + instance y)

Step 3: if (temp % 2 == 0)
        15 % 2 = 1 (not equal to 0)
        Condition is false, continue to else block

Step 4: TracingX t = new TracingX()
        Creates new TracingX object t with:
        t.x = 0, t.y = 1

Step 5: t.y = this.x - (++x) + t.x
        t1.x = 5 + 1 = 6 (pre-increment of instance x)
        t.y = 5 - 6 + 0 = -1 (t.y = old this.x - new this.x + t.x)

Step 6: this.y = y + t.metA(t.x)
        Need to evaluate: 10 + t.metA(0)
        Call metA(0) on new object t
```

## Nested metA Call (First Nested)
**Inside metA(int y) on t (new object):**
- Parameter: `y = 0`

**Current State:**
- `t.x = 0`
- `t.y = -1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 0 + 0 + 3 = 3 (parameter y += instance x + 3)

Step 2: int temp = y + this.y
        temp = 3 + (-1) = 2 (temp = parameter y + instance y)

Step 3: if (temp % 2 == 0)
        2 % 2 = 0 (equal to 0)
        Condition is true

Step 4: return temp
        Returns 2
```

**Back to first metA call on t1:**
```
Step 6 (continued): this.y = y + t.metA(0)
                    t1.y = 10 + 2 = 12

Step 7: System.out.println(x +" "+ y +" "+temp)
        Print "6 10 15" (instance x, parameter y, temp)

Step 8: return temp+this.y
        Returns 15 + 12 = 27
```

**Back to main:**
```
t2.x = 27
```

**State after first metA call:**
- `t1.x = 6`
- `t1.y = 12`
- `t2.x = 27`
- `t2.y = 1`

## Second metA Call
```java
t2.y = t2.metA(4);
```

**Inside metA(int y) on t2:**
- Parameter: `y = 4`

**Current State:**
- `t2.x = 27`
- `t2.y = 1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 4 + 27 + 3 = 34 (parameter y += instance x + 3)

Step 2: int temp = y + this.y
        temp = 34 + 1 = 35 (temp = parameter y + instance y)

Step 3: if (temp % 2 == 0)
        35 % 2 = 1 (not equal to 0)
        Condition is false, continue to else block

Step 4: TracingX t = new TracingX()
        Creates new TracingX object t with:
        t.x = 0, t.y = 1

Step 5: t.y = this.x - (++x) + t.x
        t2.x = 27 + 1 = 28 (pre-increment of instance x)
        t.y = 27 - 28 + 0 = -1 (t.y = old this.x - new this.x + t.x)

Step 6: this.y = y + t.metA(t.x)
        Need to evaluate: 34 + t.metA(0)
        Call metA(0) on new object t
```

## Nested metA Call (Second Nested)
**Inside metA(int y) on t (second new object):**
- Parameter: `y = 0`

**Current State:**
- `t.x = 0`
- `t.y = -1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 0 + 0 + 3 = 3 (parameter y += instance x + 3)

Step 2: int temp = y + this.y
        temp = 3 + (-1) = 2 (temp = parameter y + instance y)

Step 3: if (temp % 2 == 0)
        2 % 2 = 0 (equal to 0)
        Condition is true

Step 4: return temp
        Returns 2
```

**Back to second metA call on t2:**
```
Step 6 (continued): this.y = y + t.metA(0)
                    t2.y = 34 + 2 = 36

Step 7: System.out.println(x +" "+ y +" "+temp)
        Print "28 34 35" (instance x, parameter y, temp)

Step 8: return temp+this.y
        Returns 35 + 36 = 71
```

**Back to main:**
```
t2.y = 71
```

**State after second metA call:**
- `t1.x = 6`
- `t1.y = 12`
- `t2.x = 28`
- `t2.y = 71`

## Final Print Statement
```java
System.out.println(t1.y +t1.x +" "+t2.x +" "+t2.y);
```

**Calculation:**
- `t1.y + t1.x = 12 + 6 = 18`
- Print "18 28 71"

## Final Output
The program produces the following output:
```
6 10 15
28 34 35
18 28 71
```

## Final State Summary
**t1 object:**
- `t1.x = 6`
- `t1.y = 12`

**t2 object:**
- `t2.x = 28`
- `t2.y = 71`

**Temporary objects created (no longer accessible):**
- Two temporary TracingX objects were created during the nested calls, each with final state `x = 0, y = -1`

---

## **Key Tracing Elements Demonstrated:**

### 1. Conditional Logic
- `if (temp % 2 == 0)` determines execution path
- Even `temp` values cause early return
- Odd `temp` values continue to complex logic

### 2. Object Creation Within Methods
- New `TracingX` objects created during method execution
- Temporary objects with their own state

### 3. Pre-increment Operations
- `++x` increments before use in expression
- Affects both the increment and the calculation

### 4. Recursive Method Calls
- `metA` calls itself on newly created objects
- Nested calls must complete before returning to caller

### 5. Parameter vs Instance Variable Shadowing
- Parameter `y` shadows instance variable `y`
- `this.y` explicitly references instance variable