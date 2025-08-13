# Java Code Trace - Class A

## Class A

```java
public class A {
  public int temp = 4;
  public int sum, y, x;
  public void methodA(int m){
      int [] n = {2,5};
      int x = 0;
      y = m + this.methodB(x++,m)+(temp++);
      x = this.x + 2 + n[0];
      sum = sum + x + y;
      n[0] = sum + 2;
      System.out.println(n[0]+" " + x+ " " + sum);
  }
  public int methodB(int m, int n){
      int y = 4 + this.y + m;
      x = this.y + y + (++temp) - n;
      sum = x + y + this.sum;
      System.out.println(y+ " " + this.x + " " +sum);
      return x;
  }
}
```

## Tester Class

```java
public class Tester {
   public static void main(String [] args){
       A t1 = new A();
       t1.methodA(5);
       A t2 = new A();
       t2.methodB(12, 2);
   }
}
```

---

## **Main Method Execution**

```java
A t1 = new A();
```
- Creates `A` object `t1` with instance variables:
  - `t1.temp = 4`
  - `t1.sum = 0` (default int value)
  - `t1.y = 0` (default int value)
  - `t1.x = 0` (default int value)

## First methodA Call
```java
t1.methodA(5);
```

**Inside methodA(int m) on t1:**
- Parameter: `m = 5`

**Current State:**
- `t1.temp = 4`
- `t1.sum = 0`
- `t1.y = 0`
- `t1.x = 0`

**methodA Code:**
```java
int [] n = {2,5};
int x = 0;
y = m + this.methodB(x++,m)+(temp++);
x = this.x + 2 + n[0];
sum = sum + x + y;
n[0] = sum + 2;
System.out.println(n[0]+" " + x+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int [] n = {2,5}
        Creates local array n with values [2, 5]

Step 2: int x = 0
        Creates local variable x = 0 (shadows instance x)

Step 3: y = m + this.methodB(x++,m)+(temp++)
        Need to evaluate: 5 + methodB(0, 5) + 4
        x++ passes 0, then local x becomes 1
        temp++ passes 4, then temp becomes 5
        Call methodB(0, 5) first
```

## Nested methodB Call
**Inside methodB(int m, int n) on t1:**
- Parameters: `m = 0`, `n = 5`

**Current State:**
- `t1.temp = 5` (incremented from post-increment in methodA)
- `t1.sum = 0`
- `t1.y = 0`
- `t1.x = 0`

**methodB Code:**
```java
int y = 4 + this.y + m;
x = this.y + y + (++temp) - n;
sum = x + y + this.sum;
System.out.println(y+ " " + this.x + " " +sum);
return x;
```

**methodB execution line by line:**

```
Step 1: int y = 4 + this.y + m
        y = 4 + 0 + 0 = 4 (local variable y)

Step 2: x = this.y + y + (++temp) - n
        t1.x = 0 + 4 + 6 - 5 = 5 (temp becomes 6 after pre-increment)

Step 3: sum = x + y + this.sum
        t1.sum = 5 + 4 + 0 = 9

Step 4: Print "4 5 9" (local y, this.x, sum)

Step 5: return x
        Returns 5 (instance x value)
```

**State after nested methodB:**
- `t1.temp = 6`
- `t1.sum = 9`
- `t1.y = 0`
- `t1.x = 5`

**Back to methodA:**
```
Step 3 (continued): y = m + this.methodB(0, 5) + (temp++)
                    t1.y = 5 + 5 + 4 = 14 (temp was 4 when passed, now 6)

Step 4: x = this.x + 2 + n[0]
        x = 5 + 2 + 2 = 9 (local x)

Step 5: sum = sum + x + y
        t1.sum = 9 + 9 + 14 = 32

Step 6: n[0] = sum + 2
        n[0] = 32 + 2 = 34

Step 7: Print "34 9 32" (n[0], local x, sum)
```

**State after first methodA:**
- `t1.temp = 6`
- `t1.sum = 32`
- `t1.y = 14`
- `t1.x = 5`

## Second Object Creation
```java
A t2 = new A();
```
- Creates `A` object `t2` with instance variables:
  - `t2.temp = 4`
  - `t2.sum = 0` (default int value)
  - `t2.y = 0` (default int value)
  - `t2.x = 0` (default int value)

## Second methodB Call
```java
t2.methodB(12, 2);
```

**Inside methodB(int m, int n) on t2:**
- Parameters: `m = 12`, `n = 2`

**Current State:**
- `t2.temp = 4`
- `t2.sum = 0`
- `t2.y = 0`
- `t2.x = 0`

**methodB execution line by line:**

```
Step 1: int y = 4 + this.y + m
        y = 4 + 0 + 12 = 16 (local variable y)

Step 2: x = this.y + y + (++temp) - n
        t2.x = 0 + 16 + 5 - 2 = 19 (temp becomes 5 after pre-increment)

Step 3: sum = x + y + this.sum
        t2.sum = 19 + 16 + 0 = 35

Step 4: Print "16 19 35" (local y, this.x, sum)

Step 5: return x
        Returns 19 (not used)
```

## Final Output
The program produces the following output:
```
4 5 9
34 9 32
16 19 35
```

## Final State Summary
**t1 object:**
- `t1.temp = 6`
- `t1.sum = 32`
- `t1.y = 14`
- `t1.x = 5`

**t2 object:**
- `t2.temp = 5`
- `t2.sum = 35`
- `t2.y = 0`
- `t2.x = 19`