# Java Code Trace - TracingProblem v2

## Design Class

```java
class TracingProblem 
{ 
  public int temp = 4, x, sum = 2; 
  public TracingProblem() 
  { 
    this.x = 3; 
    sum += x; 
    temp --; 
  } 
  public void methodA(TracingProblem t5){ 
    int x = 1; 
    methodB(this); 
    this.temp = t5.temp + x;   
    this.x = x + (++sum); 
    sum = sum + this.x; 
    System.out.println( this.x + " " + temp+ " " + sum); 
  } 
  public void methodB(TracingProblem t1){ 
    this.temp = t1.temp + t1.x; 
    this.x =  t1.sum + sum; 
    t1.x += this.x; 
    System.out.println(this.x + " " +this.temp+ " " +t1.x); 
  } 
} 
```

## Tester Class

```java
public class Tester 
{ 
public static void main(String[] args) { 
       TracingProblem t1 = new TracingProblem(); 
       TracingProblem t3 = new TracingProblem(); 
       t3.methodA(t1); 
   } 
}
```

---

## **Main Method Execution**

```java
TracingProblem t1 = new TracingProblem();
```

## First TracingProblem Constructor Call
- Creates `TracingProblem` object `t1` with initial instance variables:
  - `t1.temp = 4`
  - `t1.x = 0` (default)
  - `t1.sum = 2`

**Inside TracingProblem() constructor:**
```java
this.x = 3; 
sum += x; 
temp --;
```

**Constructor execution line by line:**
```
Step 1: this.x = 3
        t1.x = 3

Step 2: sum += x
        t1.sum = 2 + 3 = 5

Step 3: temp --
        t1.temp = 4 - 1 = 3
```

**State after t1 creation:**
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`

## Second Object Creation
```java
TracingProblem t3 = new TracingProblem();
```

## Second TracingProblem Constructor Call
- Creates `TracingProblem` object `t3` with initial instance variables:
  - `t3.temp = 4`
  - `t3.x = 0` (default)
  - `t3.sum = 2`

**Inside TracingProblem() constructor:**
```java
this.x = 3; 
sum += x; 
temp --;
```

**Constructor execution line by line:**
```
Step 1: this.x = 3
        t3.x = 3

Step 2: sum += x
        t3.sum = 2 + 3 = 5

Step 3: temp --
        t3.temp = 4 - 1 = 3
```

**State after t3 creation:**
- `t3.temp = 3`
- `t3.x = 3`
- `t3.sum = 5`

## methodA Call
```java
t3.methodA(t1);
```

**Inside methodA(TracingProblem t5) on t3:**
- Parameter: `t5` references `t1` object

**Current State before methodA:**
- `t3.temp = 3`
- `t3.x = 3`
- `t3.sum = 5`
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`

**methodA Code:**
```java
int x = 1; 
methodB(this); 
this.temp = t5.temp + x;   
this.x = x + (++sum); 
sum = sum + this.x; 
System.out.println( this.x + " " + temp+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 1
        Creates local variable x = 1 (shadows instance x)

Step 2: methodB(this)
        Call methodB(t3) - passing t3 as parameter
```

## Nested methodB Call
**Inside methodB(TracingProblem t1) on t3:**
- Called on object: `t3`
- Parameter: `t1` references `t3` object (this)

**Current State before methodB:**
- `t3.temp = 3`
- `t3.x = 3`
- `t3.sum = 5`

**methodB Code:**
```java
this.temp = t1.temp + t1.x; 
this.x =  t1.sum + sum; 
t1.x += this.x; 
System.out.println(this.x + " " +this.temp+ " " +t1.x);
```

**methodB execution line by line:**

```
Step 1: this.temp = t1.temp + t1.x
        t3.temp = t3.temp + t3.x (since t1 parameter = t3)
        t3.temp = 3 + 3 = 6

Step 2: this.x = t1.sum + sum
        t3.x = t3.sum + t3.sum (since t1 parameter = t3, sum = t3.sum)
        t3.x = 5 + 5 = 10

Step 3: t1.x += this.x
        t3.x += t3.x (since t1 parameter = t3)
        t3.x = 10 + 10 = 20

Step 4: Print "20 6 20" (this.x, this.temp, t1.x)
        All refer to t3's updated values: t3.x=20, t3.temp=6, t3.x=20
```

**State after methodB:**
- `t3.temp = 6`
- `t3.x = 20`
- `t3.sum = 5`

**Back to methodA:**
```
Step 3: this.temp = t5.temp + x
        t3.temp = t1.temp + 1 (t5 = t1, local x = 1)
        t3.temp = 3 + 1 = 4

Step 4: this.x = x + (++sum)
        t3.sum = 5 + 1 = 6 (pre-increment)
        t3.x = 1 + 6 = 7 (local x = 1)

Step 5: sum = sum + this.x
        t3.sum = 6 + 7 = 13

Step 6: Print "7 4 13" (this.x, temp, sum)
```

## Final Output
The program produces the following output:
```
20 6 20
7 4 13
```

## Final State Summary
**t1 object:**
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`

**t3 object:**
- `t3.temp = 4`
- `t3.x = 7`
- `t3.sum = 13`