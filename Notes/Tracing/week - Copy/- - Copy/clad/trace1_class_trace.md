# Java Code Trace - Trace1 Class

## Trace1 Class

```java
class Trace1 { 
   public int p = 3, y = 2, sum; 
   public void methodA(){ 
       int x = 0, y = 0; 
       y = y + this.y; 
       x = sum + 2 + p; 
       sum = x + methodB(p, y) + this.y; 
       System.out.println(x + " " + y+ " " + sum); 
   } 
   public int methodB(int p, int n){ 
       int x = 0; 
       y = this.y + (++p); 
       x = x + 2 + n; 
       sum = sum + x + y; 
       System.out.println(x + " " + y+ " " + sum); 
       return sum; 
   } 
}
```

## Tester1 Class

```java
public class Tester1 { 
  public static void main(String [] args){ 
    Trace1 t1 = new Trace1(); 
    t1.methodA(); 
    t1.methodA(); 
    Trace1 t2 = new Trace1(); 
    System.out.println(t2.methodB(2,3)); 
   } 
}
```

---

## **Main Method Execution**

```java
Trace1 t1 = new Trace1();
```
- Creates `Trace1` object `t1` with instance variables:
  - `t1.p = 3`
  - `t1.y = 2`
  - `t1.sum = 0` (default int value)

## First methodA Call
```java
t1.methodA();
```

**Inside methodA() on t1:**

**Current State:**
- `t1.p = 3`
- `t1.y = 2`
- `t1.sum = 0`

**methodA Code:**
```java
int x = 0, y = 0; 
y = y + this.y; 
x = sum + 2 + p; 
sum = x + methodB(p, y) + this.y; 
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 0, y = 0
        Creates local variables x = 0, y = 0 (y shadows instance y)

Step 2: y = y + this.y
        y = 0 + 2 = 2 (local y + instance y)

Step 3: x = sum + 2 + p
        x = 0 + 2 + 3 = 5

Step 4: sum = x + methodB(p, y) + this.y
        Need to evaluate: 5 + methodB(3, 2) + 2
        Call methodB(3, 2) first
```

## Nested methodB Call (First Call)
**Inside methodB(int p, int n) on t1:**
- Parameters: `p = 3`, `n = 2`

**Current State:**
- `t1.p = 3`
- `t1.y = 2`
- `t1.sum = 0`

**methodB Code:**
```java
int x = 0; 
y = this.y + (++p); 
x = x + 2 + n; 
sum = sum + x + y; 
System.out.println(x + " " + y+ " " + sum); 
return sum;
```

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = this.y + (++p)
        p = 3 + 1 = 4 (pre-increment of parameter p)
        t1.y = 2 + 4 = 6 (instance y = instance y + incremented parameter p)

Step 3: x = x + 2 + n
        x = 0 + 2 + 2 = 4

Step 4: sum = sum + x + y
        t1.sum = 0 + 4 + 6 = 10

Step 5: Print "4 6 10" (local x, instance y, sum)

Step 6: return sum
        Returns 10
```

**Back to methodA:**
```
Step 4 (continued): sum = x + methodB(3, 2) + this.y
                    t1.sum = 5 + 10 + 6 = 21

Step 5: Print "5 2 21" (local x, local y, sum)
```

**State after first methodA:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 21`

## Second methodA Call
```java
t1.methodA();
```

**Inside methodA() on t1:**

**Current State:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 21`

**methodA execution line by line:**

```
Step 1: int x = 0, y = 0
        Creates local variables x = 0, y = 0

Step 2: y = y + this.y
        y = 0 + 6 = 6 (local y + instance y)

Step 3: x = sum + 2 + p
        x = 21 + 2 + 3 = 26

Step 4: sum = x + methodB(p, y) + this.y
        Need to evaluate: 26 + methodB(3, 6) + 6
        Call methodB(3, 6) first
```

## Nested methodB Call (Second Call)
**Inside methodB(int p, int n) on t1:**
- Parameters: `p = 3`, `n = 6`

**Current State:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 21`

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = this.y + (++p)
        p = 3 + 1 = 4 (pre-increment of parameter p)
        t1.y = 6 + 4 = 10 (instance y = instance y + incremented parameter p)

Step 3: x = x + 2 + n
        x = 0 + 2 + 6 = 8

Step 4: sum = sum + x + y
        t1.sum = 21 + 8 + 10 = 39

Step 5: Print "8 10 39" (local x, instance y, sum)

Step 6: return sum
        Returns 39
```

**Back to methodA:**
```
Step 4 (continued): sum = x + methodB(3, 6) + this.y
                    t1.sum = 26 + 39 + 10 = 75

Step 5: Print "26 6 75" (local x, local y, sum)
```

**State after second methodA:**
- `t1.p = 3`
- `t1.y = 10`
- `t1.sum = 75`

## Second Object Creation
```java
Trace1 t2 = new Trace1();
```
- Creates `Trace1` object `t2` with instance variables:
  - `t2.p = 3`
  - `t2.y = 2`
  - `t2.sum = 0` (default int value)

## Third methodB Call with Print
```java
System.out.println(t2.methodB(2,3));
```

**Inside methodB(int p, int n) on t2:**
- Parameters: `p = 2`, `n = 3`

**Current State:**
- `t2.p = 3`
- `t2.y = 2`
- `t2.sum = 0`

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = this.y + (++p)
        p = 2 + 1 = 3 (pre-increment of parameter p)
        t2.y = 2 + 3 = 5 (instance y = instance y + incremented parameter p)

Step 3: x = x + 2 + n
        x = 0 + 2 + 3 = 5

Step 4: sum = sum + x + y
        t2.sum = 0 + 5 + 5 = 10

Step 5: Print "5 5 10" (local x, instance y, sum)

Step 6: return sum
        Returns 10

Step 7: Print "10" (returned value from methodB)
```

## Final Output
The program produces the following output:
```
4 6 10
5 2 21
8 10 39
26 6 75
5 5 10
10
```

## Final State Summary
**t1 object:**
- `t1.p = 3`
- `t1.y = 10`
- `t1.sum = 75`

**t2 object:**
- `t2.p = 3`
- `t2.y = 5`
- `t2.sum = 10`