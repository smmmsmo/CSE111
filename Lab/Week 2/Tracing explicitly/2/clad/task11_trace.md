# Java Code Trace - Task11

## Task11 Class

```java
class Task11 { 
   public int p = 3, y = 2, sum; 
   public void methodA(){ 
       int x = 0, y = 0; 
       y = y + this.y; 
       x = sum + 2 + p; 
       sum = x + y + methodB(p, y); 
       System.out.println(x + " " + y+ " " + sum); 
   } 
   public int methodB(int p, int n){ 
       int x = 0; 
       y = y + (++p); 
       x = x + 2 + n; 
       sum = sum + x + y; 
       System.out.println(x + " " + y+ " " + sum); 
       return sum; 
   } 
}
```

## Tester11 Class

```java
public class Tester11 { 
   public static void main(String [] args){ 
       Task11 t1 = new Task11(); 
       t1.methodA(); 
       t1.methodA(); 
   } 
}
```

---

## **Main Method Execution**

```java
Task11 t1 = new Task11();
```
- Creates `Task11` object `t1` with instance variables:
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
sum = x + y + methodB(p, y); 
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

Step 4: sum = x + y + methodB(p, y)
        Need to evaluate: 5 + 2 + methodB(3, 2)
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
y = y + (++p); 
x = x + 2 + n; 
sum = sum + x + y; 
System.out.println(x + " " + y+ " " + sum); 
return sum;
```

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = y + (++p)
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
Step 4 (continued): sum = x + y + methodB(3, 2)
                    t1.sum = 5 + 2 + 10 = 17

Step 5: Print "5 2 17" (local x, local y, sum)
```

**State after first methodA:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 17`

## Second methodA Call
```java
t1.methodA();
```

**Inside methodA() on t1:**

**Current State:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 17`

**methodA execution line by line:**

```
Step 1: int x = 0, y = 0
        Creates local variables x = 0, y = 0

Step 2: y = y + this.y
        y = 0 + 6 = 6 (local y + instance y)

Step 3: x = sum + 2 + p
        x = 17 + 2 + 3 = 22

Step 4: sum = x + y + methodB(p, y)
        Need to evaluate: 22 + 6 + methodB(3, 6)
        Call methodB(3, 6) first
```

## Nested methodB Call (Second Call)
**Inside methodB(int p, int n) on t1:**
- Parameters: `p = 3`, `n = 6`

**Current State:**
- `t1.p = 3`
- `t1.y = 6`
- `t1.sum = 17`

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = y + (++p)
        p = 3 + 1 = 4 (pre-increment of parameter p)
        t1.y = 6 + 4 = 10 (instance y = instance y + incremented parameter p)

Step 3: x = x + 2 + n
        x = 0 + 2 + 6 = 8

Step 4: sum = sum + x + y
        t1.sum = 17 + 8 + 10 = 35

Step 5: Print "8 10 35" (local x, instance y, sum)

Step 6: return sum
        Returns 35
```

**Back to methodA:**
```
Step 4 (continued): sum = x + y + methodB(3, 6)
                    t1.sum = 22 + 6 + 35 = 63

Step 5: Print "22 6 63" (local x, local y, sum)
```

## Final Output
The program produces the following output:
```
4 6 10
5 2 17
8 10 35
22 6 63
```

## Final State Summary
**t1 object:**
- `t1.p = 3`
- `t1.y = 10`
- `t1.sum = 63`