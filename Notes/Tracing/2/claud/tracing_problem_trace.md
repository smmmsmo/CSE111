# Java Code Trace - TracingProblem

## Design Class

```java
class TracingProblem 
{
  public int temp = 4;
  public int y = 2, x, sum;
  public TracingProblem()
  {
    this.x = 3;
    sum += x;
  }
  public TracingProblem(TracingProblem obj)
  {
    this.y = temp - 2;
    obj.y = x + temp - 1;
    obj.methodA(this.y);   //what if this.methodA(this.y) or methodA(this.y)?
  }
  public void methodA(int y){
    int [] n = {2,5};
    int x = 1;
    this.y = y + this.methodB(n)+(temp++) + this.y;     //what if just y?
    x = this.x + (++n[0]);
    sum = sum + x + y;
    System.out.println( x + " " + y+ " " + sum);
  }
  public void methodB(int m, int n){
    TracingProblem t4 = new TracingProblem(this);
    this.y = this.y + m;
    this.x = t4.temp + temp - n;
    System.out.println(this.x + " " +sum+ " " +y);
  }
  public int methodB(int [] arr){
    this.y += arr[1];
    arr[0] ++;
    this.x = this.y + 1 + temp;
    System.out.println(this.x + " " +sum+ " " +y);
    return this.y --;
  }
}
```

## Tester Class

```java
public class Tester
{
public static void main(String[] args) {
       TracingProblem t1 = new TracingProblem();
       TracingProblem t2 = new TracingProblem(t1);
       TracingProblem t3 = null;
       t3 = t2;
       t3.methodB(2, 4);
       t2.methodA(3);
   }
}
```

---

## **Main Method Execution**

```java
TracingProblem t1 = new TracingProblem();
```

## TracingProblem Default Constructor Call
- Creates `TracingProblem` object `t1` with initial instance variables:
  - `t1.temp = 4`
  - `t1.y = 2`
  - `t1.x = 0` (default)
  - `t1.sum = 0` (default)

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
```

**Constructor execution line by line:**
```
Step 1: this.x = 3
        t1.x = 3

Step 2: sum += x
        sum = 0 + 3 = 3
```

**State after t1 creation:**
- `t1.temp = 4`
- `t1.y = 2`
- `t1.x = 3`
- `t1.sum = 3`

## Second Object Creation with Copy Constructor
```java
TracingProblem t2 = new TracingProblem(t1);
```

## TracingProblem Copy Constructor Call
- Creates `TracingProblem` object `t2` with initial instance variables:
  - `t2.temp = 4`
  - `t2.y = 2`
  - `t2.x = 0` (default)
  - `t2.sum = 0` (default)
- Parameter: `obj` references `t1`

**Inside TracingProblem(TracingProblem obj) constructor:**
```java
this.y = temp - 2;
obj.y = x + temp - 1;
obj.methodA(this.y);
```

**Constructor execution line by line:**
```
Step 1: this.y = temp - 2
        t2.y = 4 - 2 = 2

Step 2: obj.y = x + temp - 1
        t1.y = 0 + 4 - 1 = 3 (t2.x is 0, t2.temp is 4)

Step 3: obj.methodA(this.y)
        Call t1.methodA(2)
```

## Nested methodA Call (First Call)
**Inside methodA(int y) on t1:**
- Parameter: `y = 2`

**Current State:**
- `t1.temp = 4`
- `t1.y = 3`
- `t1.x = 3`
- `t1.sum = 3`

**methodA Code:**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(n)+(temp++) + this.y;
x = this.x + (++n[0]);
sum = sum + x + y;
System.out.println( x + " " + y+ " " + sum);
```

**methodA execution line by line:**
```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 1
        Creates local variable x = 1 (shadows instance x)

Step 3: this.y = y + this.methodB(n)+(temp++) + this.y
        Need to evaluate: 2 + methodB([2,5]) + 4 + this.y
        Call methodB([2,5]) first
```

## Nested methodB(int[] arr) Call
**Inside methodB(int[] arr) on t1:**
- Parameter: `arr` references array [2, 5]

**Current State:**
- `t1.temp = 4`
- `t1.y = 3`
- `t1.x = 3`
- `t1.sum = 3`

**methodB(int[] arr) Code:**
```java
this.y += arr[1];
arr[0] ++;
this.x = this.y + 1 + temp;
System.out.println(this.x + " " +sum+ " " +y);
return this.y --;
```

**methodB(int[] arr) execution line by line:**
```
Step 1: this.y += arr[1]
        t1.y = 3 + 5 = 8

Step 2: arr[0] ++
        arr[0] = 2 + 1 = 3 (n[0] becomes 3)

Step 3: this.x = this.y + 1 + temp
        t1.x = 8 + 1 + 4 = 13

Step 4: Print "13 3 8" (this.x, sum, this.y)

Step 5: return this.y --
        Returns 8, then t1.y = 8 - 1 = 7
```

**Back to methodA:**
```
Step 3 (continued): this.y = y + this.methodB(n) + (temp++) + this.y
                    t1.y = 2 + 8 + 4 + 7 = 21 (temp becomes 5 after post-increment)

Step 4: x = this.x + (++n[0])
        x = 13 + 4 = 17 (n[0] becomes 4 after pre-increment)

Step 5: sum = sum + x + y
        sum = 3 + 17 + 2 = 22

Step 6: Print "17 2 22" (local x, parameter y, sum)
```

**State after first methodA:**
- `t1.temp = 5`
- `t1.y = 21`
- `t1.x = 13`
- `t1.sum = 22`

**State after t2 constructor:**
- `t2.temp = 4`
- `t2.y = 2`
- `t2.x = 0`
- `t2.sum = 0`

## Reference Assignment
```java
TracingProblem t3 = null;
t3 = t2;
```
- `t3` now references the same object as `t2`

## First methodB(int, int) Call
```java
t3.methodB(2, 4);
```

**Inside methodB(int m, int n) on t2 (via t3):**
- Parameters: `m = 2`, `n = 4`

**Current State:**
- `t2.temp = 4`
- `t2.y = 2`
- `t2.x = 0`
- `t2.sum = 0`

**methodB(int m, int n) Code:**
```java
TracingProblem t4 = new TracingProblem(this);
this.y = this.y + m;
this.x = t4.temp + temp - n;
System.out.println(this.x + " " +sum+ " " +y);
```

**methodB(int m, int n) execution line by line:**
```
Step 1: TracingProblem t4 = new TracingProblem(this)
        Creates new TracingProblem t4 using copy constructor with t2 as parameter
        This triggers another copy constructor call...
```

## Nested TracingProblem Copy Constructor Call (t4 creation)
- Creates `TracingProblem` object `t4` with initial instance variables:
  - `t4.temp = 4`
  - `t4.y = 2`
  - `t4.x = 0` (default)
  - `t4.sum = 0` (default)
- Parameter: `obj` references `t2`

**Constructor execution:**
```
Step 1: this.y = temp - 2
        t4.y = 4 - 2 = 2

Step 2: obj.y = x + temp - 1
        t2.y = 0 + 4 - 1 = 3 (t4.x is 0, t4.temp is 4)

Step 3: obj.methodA(this.y)
        Call t2.methodA(2)
```

## Deeply Nested methodA Call (Second Call)
**Inside methodA(int y) on t2:**
- Parameter: `y = 2`

**Current State:**
- `t2.temp = 4`
- `t2.y = 3`
- `t2.x = 0`
- `t2.sum = 0`

**methodA execution line by line:**
```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 1
        Creates local variable x = 1

Step 3: this.y = y + this.methodB(n)+(temp++) + this.y
        Need to evaluate: 2 + methodB([2,5]) + 4 + this.y
        Call methodB([2,5]) first
```

## Deeply Nested methodB(int[] arr) Call
**Inside methodB(int[] arr) on t2:**
- Parameter: `arr` references array [2, 5]

**Current State:**
- `t2.temp = 4`
- `t2.y = 3`
- `t2.x = 0`
- `t2.sum = 0`

**methodB(int[] arr) execution:**
```
Step 1: this.y += arr[1]
        t2.y = 3 + 5 = 8

Step 2: arr[0] ++
        arr[0] = 2 + 1 = 3

Step 3: this.x = this.y + 1 + temp
        t2.x = 8 + 1 + 4 = 13

Step 4: Print "13 0 8" (this.x, sum, this.y)

Step 5: return this.y --
        Returns 8, then t2.y = 8 - 1 = 7
```

**Back to nested methodA:**
```
Step 3 (continued): this.y = y + this.methodB(n) + (temp++) + this.y
                    t2.y = 2 + 8 + 4 + 7 = 21 (temp becomes 5 after post-increment)

Step 4: x = this.x + (++n[0])
        x = 13 + 4 = 17

Step 5: sum = sum + x + y
        sum = 0 + 17 + 2 = 19

Step 6: Print "17 2 19" (local x, parameter y, sum)
```

**State after nested methodA:**
- `t2.temp = 5`
- `t2.y = 21`
- `t2.x = 13`
- `t2.sum = 19`

**State after t4 constructor:**
- `t4.temp = 4`
- `t4.y = 2`
- `t4.x = 0`
- `t4.sum = 0`

**Back to methodB(int m, int n):**
```
Step 2: this.y = this.y + m
        t2.y = 21 + 2 = 23

Step 3: this.x = t4.temp + temp - n
        t2.x = 4 + 5 - 4 = 5

Step 4: Print "5 19 23" (this.x, sum, this.y)
```

**State after first methodB(int, int):**
- `t2.temp = 5`
- `t2.y = 23`
- `t2.x = 5`
- `t2.sum = 19`

## Final methodA Call
```java
t2.methodA(3);
```

**Inside methodA(int y) on t2:**
- Parameter: `y = 3`

**Current State:**
- `t2.temp = 5`
- `t2.y = 23`
- `t2.x = 5`
- `t2.sum = 19`

**methodA execution line by line:**
```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 1
        Creates local variable x = 1

Step 3: this.y = y + this.methodB(n)+(temp++) + this.y
        Need to evaluate: 3 + methodB([2,5]) + 5 + this.y
        Call methodB([2,5]) first
```

## Final methodB(int[] arr) Call
**Inside methodB(int[] arr) on t2:**
- Parameter: `arr` references array [2, 5]

**Current State:**
- `t2.temp = 5`
- `t2.y = 23`
- `t2.x = 5`
- `t2.sum = 19`

**methodB(int[] arr) execution:**
```
Step 1: this.y += arr[1]
        t2.y = 23 + 5 = 28

Step 2: arr[0] ++
        arr[0] = 2 + 1 = 3

Step 3: this.x = this.y + 1 + temp
        t2.x = 28 + 1 + 5 = 34

Step 4: Print "34 19 28" (this.x, sum, this.y)

Step 5: return this.y --
        Returns 28, then t2.y = 28 - 1 = 27
```

**Back to final methodA:**
```
Step 3 (continued): this.y = y + this.methodB(n) + (temp++) + this.y
                    t2.y = 3 + 28 + 5 + 27 = 63 (temp becomes 6 after post-increment)

Step 4: x = this.x + (++n[0])
        x = 34 + 4 = 38

Step 5: sum = sum + x + y
        sum = 19 + 38 + 3 = 60

Step 6: Print "38 3 60" (local x, parameter y, sum)
```

## Final Output
The program produces the following output:
```
13 3 8
17 2 22
13 0 8
17 2 19
5 19 23
34 19 28
38 3 60
```

## Final State Summary
**t1 object:**
- `t1.temp = 5`
- `t1.y = 21`
- `t1.x = 13`
- `t1.sum = 22`

**t2 object:**
- `t2.temp = 6`
- `t2.y = 63`
- `t2.x = 34`
- `t2.sum = 60`

**t3 reference:** Points to the same object as t2

**t4 object:** (created during execution, now out of scope)
- `t4.temp = 4`
- `t4.y = 2`
- `t4.x = 0`
- `t4.sum = 0`