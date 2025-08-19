# Code Trace - TracingX

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
- Creates `TracingX` object `t1` with:
  - `t1.x = 0` (default int value)
  - `t1.y = 1` (initialized)

```java
t1.y = t1.x = 5;
```
- Sets `t1.x = 5`
- Sets `t1.y = 5`

```java
TracingX t2 = new TracingX();
```
- Creates `TracingX` object `t2` with:
  - `t2.x = 0` (default int value)
  - `t2.y = 1` (initialized)

## First metA Call: t1.metA(2)
```java
t2.x = t1.metA(2);
```

**Inside t1.metA(int y):**
- Parameter: `y = 2`

**Current State:**
- `t1.x = 5`
- `t1.y = 5`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 2 + 5 + 3 = 10 (parameter y)

Step 2: int temp = y + this.y
        temp = 10 + 5 = 15

Step 3: if (temp % 2 == 0)
        15 % 2 == 0? → 15 % 2 = 1, so false
        Condition is false, continue to else block

Step 4: TracingX t = new TracingX()
        Creates new TracingX object with x=0, y=1

Step 5: t.y = this.x - (++x) + t.x
        ++x increments t1.x from 5 to 6 (pre-increment)
        t.y = 5 - 6 + 0 = -1

Step 6: this.y = y + t.metA(t.x)
        Need to call t.metA(0) first
```

## Nested metA Call: t.metA(0)
**Inside t.metA(int y):**
- Parameter: `y = 0`

**Current State:**
- `t.x = 0`
- `t.y = -1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 0 + 0 + 3 = 3 (parameter y)

Step 2: int temp = y + this.y
        temp = 3 + (-1) = 2

Step 3: if (temp % 2 == 0)
        2 % 2 == 0? → true
        Return temp = 2
```

**Back to t1.metA(2):**
```
Step 6 (continued): this.y = y + t.metA(0)
                    t1.y = 10 + 2 = 12

Step 7: Print "6 10 15" (t1.x, parameter y, temp)

Step 8: Return temp + this.y = 15 + 12 = 27
```

**Back to main:**
```java
t2.x = t1.metA(2);
```
- `t2.x = 27`

**Current State after first call:**
- `t1.x = 6`
- `t1.y = 12`
- `t2.x = 27`
- `t2.y = 1`

## Second metA Call: t2.metA(4)
```java
t2.y = t2.metA(4);
```

**Inside t2.metA(int y):**
- Parameter: `y = 4`

**Current State:**
- `t2.x = 27`
- `t2.y = 1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 4 + 27 + 3 = 34 (parameter y)

Step 2: int temp = y + this.y
        temp = 34 + 1 = 35

Step 3: if (temp % 2 == 0)
        35 % 2 == 0? → 35 % 2 = 1, so false
        Condition is false, continue to else block

Step 4: TracingX t = new TracingX()
        Creates new TracingX object with x=0, y=1

Step 5: t.y = this.x - (++x) + t.x
        ++x increments t2.x from 27 to 28 (pre-increment)
        t.y = 27 - 28 + 0 = -1

Step 6: this.y = y + t.metA(t.x)
        Need to call t.metA(0) first
```

## Nested metA Call: t.metA(0)
**Inside t.metA(int y):**
- Parameter: `y = 0`

**Current State:**
- `t.x = 0`
- `t.y = -1`

**metA execution line by line:**

```
Step 1: y += x + 3
        y = 0 + 0 + 3 = 3 (parameter y)

Step 2: int temp = y + this.y
        temp = 3 + (-1) = 2

Step 3: if (temp % 2 == 0)
        2 % 2 == 0? → true
        Return temp = 2
```

**Back to t2.metA(4):**
```
Step 6 (continued): this.y = y + t.metA(0)
                    t2.y = 34 + 2 = 36

Step 7: Print "28 34 35" (t2.x, parameter y, temp)

Step 8: Return temp + this.y = 35 + 36 = 71
```

**Back to main:**
```java
t2.y = t2.metA(4);
```
- `t2.y = 71`

## Final Print Statement
```java
System.out.println(t1.y +t1.x +" "+t2.x +" "+t2.y);
```
- `t1.y + t1.x = 12 + 6 = 18`
- Output: `18 27 71`

## Final Output
The program produces the following output:
```
6 10 15
28 34 35
18 27 71
```

## Final State Summary
- `t1.x = 6`
- `t1.y = 12`
- `t2.x = 28`
- `t2.y = 71`