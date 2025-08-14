## Main Method Execution

```java
A a1 = new A();
```
- Creates an `A` object `a1` with explicit and default instance variable values:
  - `a1.temp = 3` (explicitly initialized)
  - `a1.sum = 9` (explicitly initialized)
  - `a1.y = 4` (explicitly initialized)
  - `a1.x = 0` (explicitly initialized)
- Calls the no-arg constructor.

**No-arg Constructor Code:**
```java
int sum = 7;
y = temp - 5;
sum = temp + 2;
this.x = sum + --temp + y;
```

**Constructor execution line by line:**

```
Step 1: int sum = 7
        Local variable sum = 7 (shadows a1.sum)

Step 2: y = temp - 5
        a1.y = 3 - 5 = -2

Step 3: sum = temp + 2
        sum = 3 + 2 = 5 (local sum)

Step 4: this.x = sum + --temp + y
        --temp = 3 - 1 = 2 (pre-decrement, a1.temp = 2)
        a1.x = 5 + 2 + (-2) = 5 (local sum, a1.y)
```

**State after constructor:**
- `a1.temp = 2`
- `a1.sum = 9` (instance sum unchanged due to shadowing)
- `a1.y = -2`
- `a1.x = 5`

```java
A a2 = new A(-5, -7);
```
- Creates an `A` object `a2` with:
  - `a2.temp = 3`
  - `a2.sum = 9`
  - `a2.y = 4`
  - `a2.x = 0`
- Calls the parameterized constructor with `y = -5`, `temp = -7`.

**Parameterized Constructor Code:**
```java
y = temp - 1 + x;
sum = temp + 2 - x;
temp -= 2;
```

**Constructor execution line by line:**

```
Step 1: y = temp - 1 + x
        y = -7 - 1 + 0 = -8 (local y, parameter temp, a2.x)
        a2.y unchanged (local y shadows instance y)

Step 2: sum = temp + 2 - x
        a2.sum = -7 + 2 - 0 = -5 (parameter temp, a2.x)

Step 3: temp -= 2
        temp = -7 - 2 = -9 (local temp, parameter)
        a2.temp unchanged
```

**State after constructor:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

## methodA Call (a1.methodA(1, 2))

```java
a1.methodA(1, 2);
```
- Calls `methodA` on `a1` with parameters `m = 1`, `n = 2`.

**Current State:**
- `a1.temp = 2`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 5`
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodA Code:**
```java
int x = 0;
y = y + methodB(x, m) + m;
x = this.x + 2 + ++n;
sum = sum + y + methodB(n);
System.out.println(x + " " + y + " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 0
        Local variable x = 0 (shadows a1.x)

Step 2: y = y + methodB(x, m) + m
        Need to call methodB(0, 1) (local x, m = 1)
```

## Nested methodB Call (a1.methodB(0, 1))

**Inside methodB(int m, int n):**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a1.temp = 2`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 5`

**methodB(int m, int n) Code:**
```java
int y = 0;
this.y = y + this.y + m;
x = this.y + 2 + temp - n;
sum = x + y + this.sum;
System.out.println(y + " " + temp + " " + sum);
return y;
```

**methodB execution line by line:**

```
Step 1: int y = 0
        Local variable y = 0

Step 2: this.y = y + this.y + m
        a1.y = 0 + (-2) + 0 = -2

Step 3: x = this.y + 2 + temp - n
        a1.x = -2 + 2 + 2 - 1 = 1 (a1.y, a1.temp, n = 1)

Step 4: sum = x + y + this.sum
        a1.sum = 1 + 0 + 9 = 10 (a1.x, local y, a1.sum)

Step 5: Print "0 2 10" (local y, a1.temp, a1.sum)

Step 6: return y
        Returns local y = 0
```

**Back to methodA:**

```
Step 2 (continued): y = y + methodB(0, 1) + m
                    a1.y = -2 + 0 + 1 = -1 (a1.y, methodB return value, m = 1)

Step 3: x = this.x + 2 + ++n
        ++n = 2 + 1 = 3 (local n)
        x = 1 + 2 + 3 = 6 (local x, a1.x, n)

Step 4: sum = sum + y + methodB(n)
        Need to call methodB(3) (overloaded, single parameter)
```

## Nested methodB Call (a1.methodB(3))

**Inside methodB(int x):**
- Parameter: `x = 3`

**Current State:**
- `a1.temp = 2`
- `a1.sum = 10`
- `a1.y = -1`
- `a1.x = 1`

**methodB(int x) Code:**
```java
this.x = x + this.y;
x -= y + 2 + temp;
sum = x + y + this.sum;
return sum;
```

**methodB execution line by line:**

```
Step 1: this.x = x + this.y
        a1.x = 3 + (-1) = 2

Step 2: x -= y + 2 + temp
        x = 3 - ((-1) + 2 + 2) = 3 - 3 = 0 (local x, a1.y, a1.temp)

Step 3: sum = x + y + this.sum
        a1.sum = 0 + (-1) + 10 = 9 (local x, a1.y, a1.sum)

Step 4: return sum
        Returns a1.sum = 9
```

**Back to methodA:**

```
Step 4 (continued): sum = sum + y + methodB(3)
                    a1.sum = 10 + (-1) + 9 = 18 (a1.sum, a1.y, methodB return value)

Step 5: Print "6 -1 18" (local x, a1.y, a1.sum)
```

**State after methodA:**
- `a1.temp = 2`
- `a1.sum = 18`
- `a1.y = -1`
- `a1.x = 2`
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**Output so far:**
```
0 2 10
6 -1 18
```

## methodA Call (a2.methodA(1, 4))

```java
a2.methodA(1, 4);
```
- Calls `methodA` on `a2` with parameters `m = 1`, `n = 4`.

**Current State:**
- `a1.temp = 2`
- `a1.sum = 18`
- `a1.y = -1`
- `a1.x = 2`
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodA execution line by line:**

```
Step 1: int x = 0
        Local variable x = 0

Step 2: y = y + methodB(x, m) + m
        Need to call methodB(0, 1)
```

## Nested methodB Call (a2.methodB(0, 1))

**Inside methodB(int m, int n):**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodB execution line by line:**

```
Step 1: int y = 0
        Local variable y = 0

Step 2: this.y = y + this.y + m
        a2.y = 0 + 4 + 0 = 4

Step 3: x = this.y + 2 + temp - n
        a2.x = 4 + 2 + 3 - 1 = 8 (a2.y, a2.temp, n = 1)

Step 4: sum = x + y + this.sum
        a2.sum = 8 + 0 + (-5) = 3 (a2.x, local y, a2.sum)

Step 5: Print "0 3 3" (local y, a2.temp, a2.sum)

Step 6: return y
        Returns local y = 0
```

**Back to methodA:**

```
Step 2 (continued): y = y + methodB(0, 1) + m
                    a2.y = 4 + 0 + 1 = 5 (a2.y, methodB return value, m = 1)

Step 3: x = this.x + 2 + ++n
        ++n = 4 + 1 = 5 (local n)
        x = 8 + 2 + 5 = 15 (local x, a2.x, n)

Step 4: sum = sum + y + methodB(n)
        Need to call methodB(5)
```

## Nested methodB Call (a2.methodB(5))

**Inside methodB(int x):**
- Parameter: `x = 5`

**Current State:**
- `a2.temp = 3`
- `a2.sum = 3`
- `a2.y = 5`
- `a2.x = 8`

**methodB execution line by line:**

```
Step 1: this.x = x + this.y
        a2.x = 5 + 5 = 10

Step 2: x -= y + 2 + temp
        x = 5 - (5 + 2 + 3) = 5 - 10 = -5 (local x, a2.y, a2.temp)

Step 3: sum = x + y + this.sum
        a2.sum = -5 + 5 + 3 = 3 (local x, a2.y, a2.sum)

Step 4: return sum
        Returns a2.sum = 3
```

**Back to methodA:**

```
Step 4 (continued): sum = sum + y + methodB(5)
                    a2.sum = 3 + 5 + 3 = 11 (a2.sum, a2.y, methodB return value)

Step 5: Print "15 5 11" (local x, a2.y, a2.sum)
```

**State after methodA:**
- `a2.temp = 3`
- `a2.sum = 11`
- `a2.y = 5`
- `a2.x = 10`

**Output:**
```
0 2 10
6 -1 18
0 3 3
15 5 11
```

## Final State Summary
- **a1**:
  - `a1.temp = 2`
  - `a1.sum = 18`
  - `a1.y = -1`
  - `a1.x = 2`
- **a2**:
  - `a2.temp = 3`
  - `a2.sum = 11`
  - `a2.y = 5`
  - `a2.x = 10`