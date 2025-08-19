# Code Trace - A

## A Class
```java
class A {
  public int temp = 3, sum = 9, y = 4, x = 0;
  public A() {
    int sum = 7;
    y = temp - 5;
    sum = temp + 2;
    temp -= 2;
    this.x = sum + temp + y;
  }
  public A(int y, int temp) {
    y = temp - 1 + x;
    sum = temp + 2 - x;
    temp -= 2;
  }
  public void methodA(int m, int[] n) {
    int x = 0;
    y = y + m + methodB(x, m);
    x = this.x + 2 + (++n[0]);
    sum = sum + x + y;
    n[0] = sum + 2;
    System.out.println(n[0] + " " + y + " " + sum);
  }
  public int methodB(int m, int n) {
    int[] y = {0};
    this.y = y[0] + this.y + m;
    x = this.y + 2 + temp - n;
    sum = x + y[0] + this.sum;
    System.out.println(y[0] + " " + temp + " " + sum);
    return y[0];
  }
}
```

## Tester9 Class
```java
public class Tester9 {
  public static void main(String args[]) {
    int[] x = {35};
    A a1 = new A();
    A a2 = new A(-5, -7);
    a1.methodA(1, x);
    a2.methodA(1, x);
  }
}
```

---

## **Main Method Execution**
```java
int[] x = {35};
A a1 = new A();
A a2 = new A(-5, -7);
a1.methodA(1, x);
a2.methodA(1, x);
```

**Execution line by line:**

```
Step 1: int[] x = {35}
        Creates array x with x[0] = 35

Step 2: A a1 = new A()
        Creates a1 with temp = 3, sum = 9, y = 4, x = 0
        Calls no-arg constructor
```

**No-arg Constructor Execution:**
```
Step 1: int sum = 7
        Local sum = 7 (shadows instance sum)

Step 2: y = temp - 5
        this.temp = 3, so this.y = 3 - 5 = -2

Step 3: sum = temp + 2
        Local sum = 3 + 2 = 5

Step 4: temp -= 2
        this.temp = 3 - 2 = 1

Step 5: this.x = sum + temp + y
        Local sum = 5, this.temp = 1, this.y = -2
        this.x = 5 + 1 + (-2) = 4
```

**State After a1 Constructor:**
- `a1.temp = 1`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 4`
- `x[0] = 35`

```
Step 3: A a2 = new A(-5, -7)
        Creates a2 with temp = 3, sum = 9, y = 4, x = 0
        Calls constructor A(-5, -7)
```

**Parameterized Constructor Execution:**
```
Step 1: y = temp - 1 + x
        Local y = -5, local temp = -7, this.x = 0
        Local y = -7 - 1 + 0 = -8 (instance y unchanged)

Step 2: sum = temp + 2 - x
        Local temp = -7, this.x = 0, so this.sum = -7 + 2 - 0 = -5

Step 3: temp -= 2
        Local temp = -7 - 2 = -9 (instance temp unchanged)
```

**State After a2 Constructor:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`
- `x[0] = 35`

## **First methodA Call: a1.methodA(1, x)**
**Parameters and State:**
- `m = 1`, `n[0] = 35`
- `a1`: `temp = 1`, `sum = 9`, `y = -2`, `x = 4`
- `a2`: `temp = 3`, `sum = -5`, `y = 4`, `x = 0`

**methodA Code:**
```java
int x = 0;
y = y + m + methodB(x, m);
x = this.x + 2 + (++n[0]);
sum = sum + x + y;
n[0] = sum + 2;
System.out.println(n[0] + " " + y + " " + sum);
```

**Execution line by line:**

```
Step 1: int x = 0
        Local x = 0 (shadows this.x)

Step 2: y = y + m + methodB(x, m)
        this.y = -2, m = 1, calls methodB(0, 1)
```

**Nested methodB Call: methodB(0, 1)**
- **Parameters:** `m = 0`, `n = 1`
- **State:** `this.temp = 1`, `this.sum = 9`, `this.y = -2`, `this.x = 4`

```
Step 1: int[] y = {0}
        Local y[0] = 0

Step 2: this.y = y[0] + this.y + m
        y[0] = 0, this.y = -2, m = 0, so this.y = 0 + (-2) + 0 = -2

Step 3: x = this.y + 2 + temp - n
        this.y = -2, this.temp = 1, n = 1
        this.x = -2 + 2 + 1 - 1 = 0

Step 4: sum = x + y[0] + this.sum
        this.x = 0, y[0] = 0, this.sum = 9
        this.sum = 0 + 0 + 9 = 9

Step 5: Print "0 1 9" (y[0], this.temp, this.sum)

Step 6: return y[0] = 0
```

**Output from methodB:** `0 1 9`

**Back to methodA:**
```
Step 2 (continued): y = y + m + methodB(x, m)
                    this.y = -2, m = 1, methodB returns 0
                    this.y = -2 + 1 + 0 = -1

Step 3: x = this.x + 2 + (++n[0])
        n[0] = 35, ++n[0] = 36, this.x = 4
        Local x = 4 + 2 + 36 = 42

Step 4: sum = sum + x + y
        this.sum = 9, local x = 42, this.y = -1
        this.sum = 9 + 42 + (-1) = 50

Step 5: n[0] = sum + 2
        this.sum = 50, so n[0] = 50 + 2 = 52

Step 6: Print "52 -1 50" (n[0], this.y, this.sum)
```

**State After a1.methodA:**
- `a1.temp = 1`
- `a1.sum = 50`
- `a1.y = -1`
- `a1.x = 0`
- `x[0] = 52`
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**Output from a1.methodA:** `0 1 9`, `52 -1 50`

## **Second methodA Call: a2.methodA(1, x)**
**Parameters and State:**
- `m = 1`, `n[0] = 52`
- `a2`: `temp = 3`, `sum = -5`, `y = 4`, `x = 0`
- `a1`: `temp = 1`, `sum = 50`, `y = -1`, `x = 0`

**Execution line by line:**

```
Step 1: int x = 0
        Local x = 0

Step 2: y = y + m + methodB(x, m)
        this.y = 4, m = 1, calls methodB(0, 1)
```

**Nested methodB Call: methodB(0, 1)**
- **Parameters:** `m = 0`, `n = 1`
- **State:** `this.temp = 3`, `this.sum = -5`, `this.y = 4`, `this.x = 0`

```
Step 1: int[] y = {0}
        Local y[0] = 0

Step 2: this.y = y[0] + this.y + m
        y[0] = 0, this.y = 4, m = 0, so this.y = 0 + 4 + 0 = 4

Step 3: x = this.y + 2 + temp - n
        this.y = 4, this.temp = 3, n = 1
        this.x = 4 + 2 + 3 - 1 = 8

Step 4: sum = x + y[0] + this.sum
        this.x = 8, y[0] = 0, this.sum = -5
        this.sum = 8 + 0 + (-5) = 3

Step 5: Print "0 3 3" (y[0], this.temp, this.sum)

Step 6: return y[0] = 0
```

**Output from methodB:** `0 3 3`

**Back to methodA:**
```
Step 2 (continued): y = y + m + methodB(x, m)
                    this.y = 4, m = 1, methodB returns 0
                    this.y = 4 + 1 + 0 = 5

Step 3: x = this.x + 2 + (++n[0])
        n[0] = 52, ++n[0] = 53, this.x = 8
        Local x = 8 + 2 + 53 = 63

Step 4: sum = sum + x + y
        this.sum = 3, local x = 63, this.y = 5
        this.sum = 3 + 63 + 5 = 71

Step 5: n[0] = sum + 2
        this.sum = 71, so n[0] = 71 + 2 = 73

Step 6: Print "73 5 71" (n[0], this.y, this.sum)
```

**State After a2.methodA:**
- `a2.temp = 3`
- `a2.sum = 71`
- `a2.y = 5`
- `a2.x = 8`
- `x[0] = 73`
- `a1.temp = 1`
- `a1.sum = 50`
- `a1.y = -1`
- `a1.x = 0`

**Output from a2.methodA:** `0 3 3`, `73 5 71`

## **Final Output**
The program produces the following output:
```
0 1 9
52 -1 50
0 3 3
73 5 71
```

## **Final State Summary**
- `a1.temp = 1`
- `a1.sum = 50`
- `a1.y = -1`
- `a1.x = 0`
- `a2.temp = 3`
- `a2.sum = 71`
- `a2.y = 5`
- `a2.x = 8`
- `x[0] = 73`