# Java Code Trace - oop_beforeMid_tracing

## Design Class

```java
class oop_beforeMid_tracing { 
    public int temp = 4; 
    public int sum; 
    public int y; 
    public int x; 
    public void methodA(int y){ 
        int [] n = {2,5}; 
        int x = 1; 
        this.y = y + this.methodB(x, this.y)+(temp++) + this.y;     //what if just y? 
        x = this.x + 2 + (++n[0]); 
        sum = sum + x + y; 
        System.out.println( x + " " + y+ " " + sum); 
    } 
    public int methodB(int m, int n){ 
        this.y = this.y + m; 
        this.x = this.y + 2 + temp - n; 
        System.out.println(this.x + " " +sum+ " " +y); 
        return this.y; 
    } 
} 
```

## Tester Class

```java
public class Tester 
{ 
public static void main(String[] args) { 
    oop_beforeMid_tracing t1 = new oop_beforeMid_tracing(); 
    t1.methodA(5); 
    oop_beforeMid_tracing t2 = new oop_beforeMid_tracing(); 
    t2.methodA(3); 
    oop_beforeMid_tracing t3 = null; 
    t3 = t1; 
    t3.methodB(2, 4); 
} 
}
```

---

## **Main Method Execution**

```java
oop_beforeMid_tracing t1 = new oop_beforeMid_tracing();
```
- Creates `oop_beforeMid_tracing` object `t1` with default instance variables:
  - `t1.temp = 4`
  - `t1.sum = 0` (default int value)
  - `t1.y = 0` (default int value)
  - `t1.x = 0` (default int value)

## First methodA Call
```java
t1.methodA(5);
```

**Inside methodA(int y):**
- Parameter: `y = 5`

**Current State:**
- `t1.temp = 4`
- `t1.sum = 0`
- `t1.y = 0`
- `t1.x = 0`

**methodA Code:**
```java
int [] n = {2,5}; 
int x = 1; 
this.y = y + this.methodB(x, this.y)+(temp++) + this.y;
x = this.x + 2 + (++n[0]); 
sum = sum + x + y; 
System.out.println( x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 1
        Creates local variable x = 1 (shadows instance x)

Step 3: this.y = y + this.methodB(x, this.y)+(temp++) + this.y
        Need to evaluate: 5 + methodB(1, 0) + 4 + this.y
        Call methodB(1, 0) first
```

## Nested methodB Call (First Call)
**Inside methodB(int m, int n):**
- Parameters: `m = 1`, `n = 0`

**Current State:**
- `t1.temp = 4`
- `t1.sum = 0`
- `t1.y = 0`
- `t1.x = 0`

**methodB Code:**
```java
this.y = this.y + m; 
this.x = this.y + 2 + temp - n; 
System.out.println(this.x + " " +sum+ " " +y); 
return this.y;
```

**methodB execution line by line:**

```
Step 1: this.y = this.y + m
        this.y = 0 + 1 = 1

Step 2: this.x = this.y + 2 + temp - n
        this.x = 1 + 2 + 4 - 0 = 7

Step 3: Print "7 0 1" (this.x, sum, this.y)

Step 4: Return this.y = 1
```

**Back to methodA:**
```
Step 3 (continued): this.y = y + this.methodB(1, 0) + (temp++) + this.y
                    this.y = 5 + 1 + 4 + 1 = 11 (temp becomes 5 after post-increment)

Step 4: x = this.x + 2 + (++n[0])
        x = 7 + 2 + 3 = 12 (n[0] becomes 3 after pre-increment)

Step 5: sum = sum + x + y
        sum = 0 + 12 + 5 = 17

Step 6: Print "12 5 17" (local x, parameter y, sum)
```

**State after first methodA:**
- `t1.temp = 5`
- `t1.sum = 17`
- `t1.y = 11`
- `t1.x = 7`

## Second Object Creation
```java
oop_beforeMid_tracing t2 = new oop_beforeMid_tracing();
```
- Creates `oop_beforeMid_tracing` object `t2` with default instance variables:
  - `t2.temp = 4`
  - `t2.sum = 0`
  - `t2.y = 0`
  - `t2.x = 0`

## Second methodA Call
```java
t2.methodA(3);
```

**Inside methodA(int y):**
- Parameter: `y = 3`

**Current State:**
- `t2.temp = 4`
- `t2.sum = 0`
- `t2.y = 0`
- `t2.x = 0`

**methodA execution line by line:**

```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 1
        Creates local variable x = 1

Step 3: this.y = y + this.methodB(x, this.y)+(temp++) + this.y
        Need to evaluate: 3 + methodB(1, 0) + 4 + this.y
        Call methodB(1, 0) first
```

## Nested methodB Call (Second Call)
**Inside methodB(int m, int n):**
- Parameters: `m = 1`, `n = 0`

**Current State:**
- `t2.temp = 4`
- `t2.sum = 0`
- `t2.y = 0`
- `t2.x = 0`

**methodB execution line by line:**

```
Step 1: this.y = this.y + m
        this.y = 0 + 1 = 1

Step 2: this.x = this.y + 2 + temp - n
        this.x = 1 + 2 + 4 - 0 = 7

Step 3: Print "7 0 1" (this.x, sum, this.y)

Step 4: Return this.y = 1
```

**Back to methodA:**
```
Step 3 (continued): this.y = y + this.methodB(1, 0) + (temp++) + this.y
                    this.y = 3 + 1 + 4 + 1 = 9 (temp becomes 5 after post-increment)

Step 4: x = this.x + 2 + (++n[0])
        x = 7 + 2 + 3 = 12 (n[0] becomes 3 after pre-increment)

Step 5: sum = sum + x + y
        sum = 0 + 12 + 3 = 15

Step 6: Print "12 3 15" (local x, parameter y, sum)
```

**State after second methodA:**
- `t2.temp = 5`
- `t2.sum = 15`
- `t2.y = 9`
- `t2.x = 7`

## Reference Assignment
```java
oop_beforeMid_tracing t3 = null;
t3 = t1;
```
- `t3` now references the same object as `t1`

## Third methodB Call
```java
t3.methodB(2, 4);
```

**Inside methodB(int m, int n):**
- Parameters: `m = 2`, `n = 4`
- Called on `t1` object (since `t3` references `t1`)

**Current State:**
- `t1.temp = 5`
- `t1.sum = 17`
- `t1.y = 11`
- `t1.x = 7`

**methodB execution line by line:**

```
Step 1: this.y = this.y + m
        this.y = 11 + 2 = 13

Step 2: this.x = this.y + 2 + temp - n
        this.x = 13 + 2 + 5 - 4 = 16

Step 3: Print "16 17 13" (this.x, sum, this.y)

Step 4: Return this.y = 13 (not used)
```

## Final Output
The program produces the following output:
```
7 0 1
12 5 17
7 0 1
12 3 15
16 17 13
```

## Final State Summary
**t1 object:**
- `t1.temp = 5`
- `t1.sum = 17`
- `t1.y = 13`
- `t1.x = 16`

**t2 object:**
- `t2.temp = 5`
- `t2.sum = 15`
- `t2.y = 9`
- `t2.x = 7`

**t3 reference:** Points to the same object as t1