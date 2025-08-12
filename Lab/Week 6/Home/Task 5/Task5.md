# Quiz 5 - Code Trace

## Foo Class

```java
class Foo {
  public int bar, buz;
  public Foo(int bar, int buz) {
    this.bar = bar;
    this.buz = buz;
  }
}
```

## Quiz5 Class

```java
class Quiz5 {
  public int sum = 12, x = 2, y = 6;
  public Foo foo;
  public Quiz5(Foo f) {
    foo = f;
    int x = this.foo.buz + y;
    sum = sum + (f.bar--) + y;
    System.out.println(foo.bar + " " + sum + " " + x);
    sum -= 10;
  }
  public void methodA(int bar, int buz) {
    bar = 3 + bar - this.foo.bar;
    x = bar + 12 + y;
    y = foo.buz + buz + bar;
    sum = y + methodB(foo.buz, foo) + foo.buz;
    System.out.println(bar + " " + y + " " + sum);
  }
  public int methodB(int bar, Foo buz) {
    int sum = bar + buz.bar + x;
    buz.buz = sum + this.sum;
    System.out.println(bar + " " + buz.buz + " " + sum);
    return sum;
  }
}
```

## LabTester Class

```java
public class LabTester {
  public static void main(String[] args) {
    Foo p = new Foo(3, 4);
    Quiz5 q = new Quiz5(p);
    q.methodA(4, 8);
  }
}
```


---
## **Main Method Execution**

```java
Foo p = new Foo(3, 4);
```
- Creates `Foo` object `p` with:
  - `p.bar = 3`
  - `p.buz = 4`

## Quiz5 Constructor Call
```java
Quiz5 q = new Quiz5(p);
```

- Initializes `Quiz5` object `q` with instance variables:
  - `sum = 12`
  - `x = 2`
  - `y = 6`
  - `foo = null`.
  - Passes `p` to the constructor.

**Inside Quiz5 constructor:**
- Parameter: `f` references the same `Foo` object as `p`
- `foo = f;` (so `foo` now references the Foo object)


**Constructor Code:**
```java
foo = f;
int x = this.foo.buz + y;
sum = sum + (f.bar--) + y;
System.out.println(foo.bar + " " + sum + " " + x);
sum -= 10;
```

**Constructor execution line by line:**

```
Step 1: foo = f (foo now references the Foo object)

Step 2: int x = this.foo.buz + y
        x = 4 + 6 = 10 (local variable, shadows instance x)

Step 3: sum = sum + (f.bar--) + y
        sum = 12 + 3 + 6 = 21 (f.bar becomes 2 after post-decrement)

Step 4: Print "2 21 10" (foo.bar, sum, local x)

Step 5: sum -= 10
        sum = 21 - 10 = 11
```

**State after constructor:**
- `q.sum = 11`
- `q.x = 2`
- `q.y = 6`
- `q.foo.bar = 2`
- `q.foo.buz = 4`
- `p.bar = 2`
- `p.buz = 4`

Output: `2 21 10`

## **MethodA Call**
```java
q.methodA(4, 8);
```

**Inside methodA(int bar, int buz):**
- Parameters: `bar = 4`, `buz = 8`

**Current State:**
- `q.sum = 11`
- `q.x = 2`
- `q.y = 6`
- `q.foo.bar = 2`
- `q.foo.buz = 4`


**methodA Code:**
```java
bar = 3 + bar - this.foo.bar;
x = bar + 12 + y;
y = foo.buz + buz + bar;
sum = y + methodB(foo.buz, foo) + foo.buz;
System.out.println(bar + " " + y + " " + sum);
```

**methodA execution line by line:**

```
Step 1: bar = 3 + bar - this.foo.bar
        bar = 3 + 4 - 2 = 5 (local parameter)

Step 2: x = bar + 12 + y
        x = 5 + 12 + 6 = 23 (instance variable)

Step 3: y = foo.buz + buz + bar
        y = 4 + 8 + 5 = 17 (instance variable)

Step 4: sum = y + methodB(foo.buz, foo) + foo.buz
        Need to call methodB(4, foo) first
```
## Nested methodB Call
**Inside methodB(int bar, Foo buz):**
- Parameters: `bar = 4`, `buz` references the Foo object

**Current State:**
- `q.sum = 11`
- `q.x = 23`
- `q.y = 17`
- `q.foo.bar = 2`
- `q.foo.buz = 4`

**methodB Code:**
```java
int sum = bar + buz.bar + x;
buz.buz = sum + this.sum;
System.out.println(bar + " " + buz.buz + " " + sum);
return sum;
```

**methodB execution line by line:**

```
Step 1: int sum = bar + buz.bar + x
        sum = 4 + 2 + 23 = 29 (local variable)

Step 2: buz.buz = sum + this.sum
        buz.buz = 29 + 11 = 40 (modifies foo.buz to 40)

Step 3: Print "4 40 29" (bar parameter, buz.buz, local sum)

Step 4: Return sum = 29
```

**Back to methodA:**
```
Step 4 (continued): sum = y + methodB(4, foo) + foo.buz
                    sum = 17 + 29 + 40 = 86

Step 5: Print "5 17 86" (local bar, instance y, instance sum)
```

## Final Output
The program produces the following output:
```
2 21 10
4 40 29
5 17 86
```

## Final State Summary
- `q.sum = 86`
- `q.x = 23`
- `q.y = 17`
- `q.foo.bar = 2`
- `q.foo.buz = 40`
- `p.bar = 2`
- `p.buz = 40`