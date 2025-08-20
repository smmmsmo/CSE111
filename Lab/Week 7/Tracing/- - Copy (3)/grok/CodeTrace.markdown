# Code Trace

## Tracing Class

```java
class Tracing {
  public static int x = 0, y = 0;
  public int a, b;
  public Tracing(int a, int b) {
    this.a = a;
    this.b = b;
    x += 1;
    y += 2;
  }
  public void methodA(int a) {
    this.a = x + a;
    this.b = this.b + this.a + this.methodB();
    System.out.println(this.a + " " + this.b + " " + x);
  }
  public int methodB() {
    this.b = y - this.b + this.a;
    System.out.println(this.a + " " + this.b + " " + x);
    x += this.b;
    return this.b;
  }
  public void methodB(Tracing t1) {
    t1.b = this.y - t1.b + this.b;
    System.out.println(t1.a + " " + t1.b + " " + x);
  }
}
```

## Test9 Class

```java
public class Test9 {
  public static void main(String[] args) {
    Tracing t1 = new Tracing(2, 3);
    t1.methodA(1);
    Tracing t2 = new Tracing(3, 4);
    t2.methodA(2);
    t1.methodB(t2);
    t2.methodB(t2);
  }
}
```

## Main Execution

```java
Tracing t1 = new Tracing(2, 3);
```
- Creates `Tracing` object `t1` with:
  - `a = 0`, `b = 0`
  - Static `Tracing.x = 0`, `Tracing.y = 0`
- Passes `a = 2`, `b = 3`.

**Inside constructor:**
```java
this.a = a;
this.b = b;
x += 1;
y += 2;
```
- `this.a = 2`
- `this.b = 3`
- `x += 1` → `Tracing.x = 0 + 1 = 1`
- `y += 2` → `Tracing.y = 0 + 2 = 2`

**State after constructor:**
- `t1.a = 2`
- `t1.b = 3`
- `Tracing.x = 1`
- `Tracing.y = 2`

## methodA Call on t1
```java
t1.methodA(1);
```
- Parameter: `a = 1`
- Current state:
  - `t1.a = 2`, `t1.b = 3`, `Tracing.x = 1`, `Tracing.y = 2`
- `this.a = x + a = 1 + 1 = 2`
- `this.b = this.b + this.a + this.methodB()` requires calling `methodB()`.

**Inside methodB():**
- `this.b = y - this.b + this.a = 2 - 3 + 2 = 1`
- Print: `2 1 1`
- `x += this.b` → `Tracing.x = 1 + 1 = 2`
- Return: `1`

**Back to methodA:**
- `this.b = this.b + this.a + this.methodB() = 3 + 2 + 1 = 6`
- Print: `2 6 2`

**State after methodA:**
- `t1.a = 2`
- `t1.b = 6`
- `Tracing.x = 2`
- `Tracing.y = 2`

## Second Constructor Call
```java
Tracing t2 = new Tracing(3, 4);
```
- Creates `Tracing` object `t2` with:
  - `a = 0`, `b = 0`
  - `Tracing.x = 2`, `Tracing.y = 2`