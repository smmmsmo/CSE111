# Code Trace

## B Class

```java
class B {
  public static int x;
  public int y = 4;
  public int temp = -5;
  public int sum = 2;
  public B() {
    y = temp + 3;
    sum = 3 + temp + 3;
    temp -= 2;
  }
  public B(B b) {
    sum = b.sum;
    x = b.x;
    b.methodB(1, 3);
  }
  public void methodA(int m, int n) {
    int x = 2;
    y = y + m + (temp++);
    x = x + 7 + n;
    sum = sum + x + y;
    System.out.println(x + " " + y + " " + sum);
  }
  public void methodB(int m, int n) {
    int y = 0;
    y = y + this.y;
    x = this.y + 3 + temp;
    methodA(x, y);
    sum = x + y + sum;
    System.out.println(x + " " + y + " " + sum);
  }
}
```

## Main Execution

```java
B b1 = new B();
```
- Creates `B` object `b1` with:
  - `y = 4`
  - `temp = -5`
  - `sum = 2`
  - Static `x = 0`

**Inside default constructor:**
```java
y = temp + 3;
sum = 3 + temp + 3;
temp -= 2;
```
- `y = -5 + 3 = -2`
- `sum = 3 + (-5) + 3 = 1`
- `temp = -5 - 2 = -7`

**State after constructor:**
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`
- `B.x = 0`

## Copy Constructor Call
```java
B b2 = new B(b1);
```
- Initializes `B` object `b2` with:
  - `y = 4`
  - `temp = -5`
  - `sum = 2`
- Passes `b1` to the copy constructor.

**Inside copy constructor:**
```java
sum = b.sum;
x = b.x;
b.methodB(1, 3);
```
- `sum = b1.sum = 1`
- `x = b1.x = 0` (static `x`)
- Calls `b1.methodB(1, 3)`.

**methodB(1, 3) execution:**
- Parameters: `m = 1`, `n = 3`
- Current state:
  - `b1.y = -2`, `b1.temp = -7`, `b1.sum = 1`, `B.x = 0`
- `int y = 0`
- `y = y + this.y = 0 + (-2) = -2` (local `y`)
- `x = this.y + 3 + temp = -2 + 3 + (-7) = -6` (static `x`)
- Calls `methodA(-6, -2)`.

**methodA(-6, -2) execution:**
- Parameters: `m = -6`, `n = -2`
- `int x = 2`
- `y = y + m + (temp++) = -2 + (-6) + (-7) = -15` (`temp` becomes `-6`)
- `x = x + 7 + n = 2 + 7 + (-2) = 7` (local `x`)
- `sum = sum + x + y = 1 + 7 + (-15) = -7`
- Print: `7 -15 -7`

**Back to methodB:**
- `sum = x + y + sum = -6 + (-2) + (-7) = -15`
- Print: `-6 -2 -15`

**State after copy constructor:**
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -15`
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`
- `B.x = -6`

## methodA Call
```java
b1.methodA(3, 2);
```
- Parameters: `m = 3`, `n = 2`
- Current state:
  - `b1.y = -15`, `b1.temp = -6`, `b1.sum = -15`, `B.x = -6`
- `int x = 2`
- `y = y + m + (temp++) = -15 + 3 + (-6) = -18` (`temp` becomes `-5`)
- `x = x + 7 + n = 2 + 7 + 2 = 11` (local `x`)
- `sum = sum + x + y = -15 + 11 + (-18) = -22`
- Print: `11 -18 -22`

**State after methodA:**
- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`
- `B.x = -6`

## methodB Call
```java
b2.methodB(1, 2);
```
- Parameters: `m = 1`, `n = 2`
- Current state:
  - `b2.y = 4`, `b2.temp = -5`, `b2.sum = 1`, `B.x = -6`
- `int y = 0`
- `y = y + this.y = 0 + 4 = 4` (local `y`)
- `x = this.y + 3 + temp = 4 + 3 + (-5) = 2` (static `x`)
- Calls `methodA(2, 4)`.

**methodA(2, 4) execution:**
- Parameters: `m = 2`, `n = 4`
- `int x = 2`
- `y = y + m + (temp++) = 4 + 2 + (-5) = 1` (`temp` becomes `-4`)
- `x = x + 7 + n = 2 + 7 + 4 = 13` (local `x`)
- `sum = sum + x + y = 1 + 13 + 1 = 15`
- Print: `13 1 15`

**Back to methodB:**
- `sum = x + y + sum = 2 + 4 + 15 = 21`
- Print: `2 4 21`

## Final Output
The program produces the following output:
```
7 -15 -7
-6 -2 -15
11 -18 -22
13 1 15
2 4 21
```

## Final State Summary
- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`
- `b2.y = 1`
- `b2.temp = -4`
- `b2.sum = 21`
- `B.x = 2`