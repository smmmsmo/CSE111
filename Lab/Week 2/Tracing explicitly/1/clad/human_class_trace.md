# Java Code Trace - Human Class

## Human Class

```java
public class Human{
    public int age;
    public double height;
}
```

## Test Sequence

```java
Human h1 = new Human();
Human h2 = new Human();
h1.age = 21;
h1.height = 5.5;
System.out.println(h1.age);
System.out.println(h1.height);
h2.height = h1.height - 3;
System.out.println(h2.height);
h2.age = h1.age++;
System.out.println(h1.age);
h2 = h1;
System.out.println(h2.age);
System.out.println(h2.height);
h2.age++;
h2.height++;
System.out.println(h1.age);
System.out.println(h1.height);
h1.age = ++h2.age;
System.out.println(h2.age);
System.out.println(h2.height);
```

---

## **Statement Execution**

### Object Creation

```java
Human h1 = new Human();
```
- Creates `Human` object `h1` with default values:
  - `h1.age = 0` (default int value)
  - `h1.height = 0.0` (default double value)

```java
Human h2 = new Human();
```
- Creates `Human` object `h2` with default values:
  - `h2.age = 0` (default int value)
  - `h2.height = 0.0` (default double value)

### Initial Assignments

```java
h1.age = 21;
```
- `h1.age = 21`

```java
h1.height = 5.5;
```
- `h1.height = 5.5`

**Current State:**
- `h1.age = 21`
- `h1.height = 5.5`
- `h2.age = 0`
- `h2.height = 0.0`

### Print Statements

```java
System.out.println(h1.age);
```
**Output:** `21`

```java
System.out.println(h1.height);
```
**Output:** `5.5`

### Height Calculation

```java
h2.height = h1.height - 3;
```
- `h2.height = 5.5 - 3 = 2.5`

```java
System.out.println(h2.height);
```
**Output:** `2.5`

### Post-increment Assignment

```java
h2.age = h1.age++;
```
- `h2.age = 21` (current value of h1.age)
- `h1.age = 22` (incremented after assignment)

```java
System.out.println(h1.age);
```
**Output:** `22`

**Current State:**
- `h1.age = 22`
- `h1.height = 5.5`
- `h2.age = 21`
- `h2.height = 2.5`

### Reference Assignment

```java
h2 = h1;
```
- `h2` now references the same object as `h1`
- The original `h2` object becomes eligible for garbage collection

**Current State:**
- `h1.age = 22`
- `h1.height = 5.5`
- `h2` references the same object as `h1`

```java
System.out.println(h2.age);
```
**Output:** `22` (h2 now refers to the same object as h1)

```java
System.out.println(h2.height);
```
**Output:** `5.5` (h2 now refers to the same object as h1)

### Modifying Through h2 Reference

```java
h2.age++;
```
- Increments the age of the object referenced by both h1 and h2
- `age = 22 + 1 = 23`

```java
h2.height++;
```
- Increments the height of the object referenced by both h1 and h2
- `height = 5.5 + 1 = 6.5`

**Current State:**
- Both h1 and h2 refer to the same object with:
  - `age = 23`
  - `height = 6.5`

```java
System.out.println(h1.age);
```
**Output:** `23` (modified through h2 reference)

```java
System.out.println(h1.height);
```
**Output:** `6.5` (modified through h2 reference)

### Pre-increment Assignment

```java
h1.age = ++h2.age;
```
- Pre-increment h2.age: `23 + 1 = 24`
- Assign to h1.age: `h1.age = 24`
- Since h1 and h2 refer to the same object, both operations affect the same age field

```java
System.out.println(h2.age);
```
**Output:** `24`

```java
System.out.println(h2.height);
```
**Output:** `6.5`

## Final Output
The program produces the following output:
```
21
5.5
2.5
22
22
5.5
23
6.5
24
6.5
```

## Final State Summary
**Single object referenced by both h1 and h2:**
- `age = 24`
- `height = 6.5`

**Original h2 object:** Garbage collected after `h2 = h1` assignment