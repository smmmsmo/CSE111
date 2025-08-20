# Code Trace

## FinalT6A Class

```java
public class FinalT6A {
  public static int temp = 3;
  public int sum;
  public int y = 2;
  public FinalT6A(int x, int p) {
    temp += 3;
    y = temp - p;
    sum = FinalT6A.temp + x;
    System.out.println(x + " " + y + " " + sum);
  }
  public void methodA() {
    int x = 0, y = 0;
    y = y + this.y;
    x = this.y + 2 + temp;
    sum = x + y + methodB(temp, y);
    System.out.println(x + " " + y + " " + sum);
  }
  public int methodB(int temp, int n) {
    int x = 0;
    y = y + (++temp);
    x = x + 2 + n;
    sum = sum + x + y;
    System.out.println(x + " " + y + " " + sum);
    return sum;
  }
}
```

## Test10 Class

```java
public class Test10 {
  public static void main(String[] args) {
    FinalT6A q1 = new FinalT6A(2, 1);
    q1.methodA();
    FinalT6A q2 = new FinalT6A(3, 1);
    q2.methodB(7, 8);
  }
}
```

## Main Execution

```java
FinalT6A q1 = new FinalT6A(2, 1);
```
- Creates `FinalT6A` object `q1` with:
  - `y = 2`
  - `sum = 0`
  - Static `FinalT6A.temp = 3`
- Passes `x = 2`, `p = 1`.

**Inside constructor:**
```java
temp += 3;
y = temp - p;
sum = FinalT6A.temp + x;
System.out.println(x + " " + y + " " + sum);
```
- `temp += 3` → `FinalT6A.temp = 3 + 3 = 6`
- `y = temp - p = 6 - 1 = 5`
- `sum = FinalT6A.temp + x = 6 + 2 = 8`
- Print: `2 5 8`

**State after constructor:**
- `q1.y = 5`
- `q1.sum = 8`
- `FinalT6A.temp = 6`

## methodA Call
```java
q1.methodA();
```
- Current state:
  - `q1.y = 5`, `q1.sum = 8`, `FinalT6A.temp = 6`

**Inside methodA:**
```java
int x = 0, y = 0;
y = y + this.y;
x = this.y + 2 + temp;
sum = x + y + methodB(temp, y);
System.out.println(x + " " + y + " " + sum);
```
- `int x = 0, y = 0`
- `y = y + this.y = 0 + 5 = 5` (local `y`)
- `x = this.y + 2 + temp = 5 + 2 + 6 = 13` (local `x`)
- Calls `methodB(temp, y) = methodB(6, 5)`.

**Inside methodB(6, 5):**
- Parameters: `temp = 6`, `n = 5`
- `int x = 0`
- `y = y + (++temp) = 5 + (7) = 12` (local `temp` becomes 7)
- `x = x + 2 + n = 0 + 2 + 5 = 7`
- `sum = sum + x + y = 8 + 7 + 12 = 27`
- Print: `7 12 27`
- Return: `27`

**Back to methodA:**
- `sum = x + y + methodB(6, 5) = 13 + 5 + 27 = 45`
- Print: `13 5 45`

**State after methodA:**
- `q1.y = 12`
- `q1.sum = 45`
- `FinalT6A.temp = 6`

## Second Constructor Call
```java
FinalT6A q2 = new FinalT6A(3, 1);
```
- Creates `FinalT6A` object `q2` with:
  - `y = 2`
  - `sum = 0`
  - `FinalT6A.temp = 6`
- Passes `x = 3`, `p = 1`.

**Inside constructor:**
- `temp += 3` → `FinalT6A.temp = 6 + 3 = 9`
- `y = temp - p = 9 - 1 = 8`
- `sum = FinalT6A.temp + x = 9 + 3 = 12`
- Print: `3 8 12`

**State after constructor:**
- `q1.y = 12`
- `q1.sum = 45`
- `q2.y = 8`
- `q2.sum = 12`
- `FinalT6A.temp = 9`

## methodB Call
```java
q2.methodB(7, 8);
```
- Parameters: `temp = 7`, `n = 8`
- Current state:
  - `q2.y = 8`, `q2.sum = 12`, `FinalT6A.temp = 9`
- `int x = 0`
- `y = y + (++temp) = 8 + (8) = 16` (local `temp` becomes 8)
- `x = x + 2 + n = 0 + 2 + 8 = 10`
- `sum = sum + x + y = 12 + 10 + 16 = 38`
- Print: `10 16 38`

## Final Output
The program produces the following output:
```
2 5 8
7 12 27
13 5 45
3 8 12
10 16 38
```

## Final State Summary
- `q1.y = 12`
- `q1.sum = 45`
- `q2.y = 16`
- `q2.sum = 38`
- `FinalT6A.temp = 9`