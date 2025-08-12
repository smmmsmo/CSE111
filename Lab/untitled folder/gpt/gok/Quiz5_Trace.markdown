# Quiz 5 - ADU Trace

## Quiz5 Class and Related Classes

```java
class Foo {
  public int bar, buz;
  public Foo(int bar, int buz) {
    this.bar = bar;
    this.buz = buz;
  }
}

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

public class LabTester {
  public static void main(String[] args) {
    Foo p = new Foo(3, 4);
    Quiz5 q = new Quiz5(p);
    q.methodA(4, 8);
  }
}
```

## Expected Output

```
2 21 10
4 40 29
5 17 86
```

---

### Method Execution Flow

#### 1. **Main Method Execution**

**Initial State:** No objects created yet.

- `Foo p = new Foo(3, 4);`
  - Creates `Foo` object `p` with `p.bar = 3`, `p.buz = 4`.

- `Quiz5 q = new Quiz5(p);`
  - Initializes `Quiz5` object `q` with instance variables: `sum = 12`, `x = 2`, `y = 6`, `foo = null`.
  - Passes `p` to the constructor.

**State:** `p = {bar = 3, buz = 4}`, `q = {sum = 12, x = 2, y = 6, foo = null}`

#### 2. **Constructor Execution**

**Initial State:** `q.sum = 12`, `q.x = 2`, `q.y = 6`, `q.foo = null`, `p = {bar = 3, buz = 4}`

**Constructor Code:**
```java
foo = f;
int x = this.foo.buz + y;
sum = sum + (f.bar--) + y;
System.out.println(foo.bar + " " + sum + " " + x);
sum -= 10;
```

- **Step 1: `foo = f;`**
  - `f = p`, so `q.foo = p`.
  - `q.foo = {bar = 3, buz = 4}`.

- **Step 2: `int x = this.foo.buz + y;`**
  - `this.foo.buz = q.foo.buz = 4`
  - `y = q.y = 6`
  - `x = 4 + 6 = 10` (local variable `x`, not `q.x`).

- **Step 3: `sum = sum + (f.bar--) + y;`**
  - `sum = q.sum = 12`
  - `f.bar = q.foo.bar = 3`
  - `f.bar--` uses 3, then decrements `f.bar` to 2.
  - `y = q.y = 6`
  - `sum = 12 + 3 + 6 = 21`
  - `q.sum = 21`, `q.foo.bar = 2`.

- **Step 4: `System.out.println(foo.bar + " " + sum + " " + x);`**
  - `foo.bar = q.foo.bar = 2`
  - `sum = q.sum = 21`
  - `x = 10` (local)
  - Output: `2 21 10`.

- **Step 5: `sum -= 10;`**
  - `q.sum = 21 - 10 = 11`.

**State After Constructor:**
- `q = {sum = 11, x = 2, y = 6, foo = {bar = 2, buz = 4}}`
- `p = {bar = 2, buz = 4}`
- Output: `2 21 10`

#### 3. **Method Call `q.methodA(4, 8)`**

**Initial State:** `q.sum = 11`, `q.x = 2`, `q.y = 6`, `q.foo = {bar = 2, buz = 4}`

**methodA Code:**
```java
bar = 3 + bar - this.foo.bar;
x = bar + 12 + y;
y = foo.buz + buz + bar;
sum = y + methodB(foo.buz, foo) + foo.buz;
System.out.println(bar + " " + y + " " + sum);
```

- **Step 1: `bar = 3 + bar - this.foo.bar;`**
  - `bar = 4` (parameter)
  - `this.foo.bar = q.foo.bar = 2`
  - `bar = 3 + 4 - 2 = 5` (local `bar`).

- **Step 2: `x = bar + 12 + y;`**
  - `bar = 5` (local)
  - `y = q.y = 6`
  - `x = 5 + 12 + 6 = 23`
  - `q.x = 23` (instance variable).

- **Step 3: `y = foo.buz + buz + bar;`**
  - `foo.buz = q.foo.buz = 4`
  - `buz = 8` (parameter)
  - `bar = 5` (local)
  - `y = 4 + 8 + 5 = 17`
  - `q.y = 17`.

- **Step 4: `sum = y + methodB(foo.buz, foo) + foo.buz;`**
  - `y = q.y = 17`
  - `foo.buz = q.foo.buz = 4`
  - `foo = q.foo`
  - Call `methodB(4, q.foo)`.

#### 4. **Nested Call `methodB(4, q.foo)`**

**Current State:** `q.sum = 11`, `q.x = 23`, `q.y = 17`, `q.foo = {bar = 2, buz = 4}`

**methodB Code:**
```java
int sum = bar + buz.bar + x;
buz.buz = sum + this.sum;
System.out.println(bar + " " + buz.buz + " " + sum);
return sum;
```

- **Step 4.1: `int sum = bar + buz.bar + x;`**
  - `bar = 4` (parameter)
  - `buz = q.foo`, so `buz.bar = q.foo.bar = 2`
  - `x = q.x = 23`
  - `sum = 4 + 2 + 23 = 29` (local `sum`).

- **Step 4.2: `buz.buz = sum + this.sum;`**
  - `sum = 29` (local)
  - `this.sum = q.sum = 11`
  - `buz.buz = q.foo.buz = 29 + 11 = 40`
  - `q.foo.buz = 40`, `p.buz = 40`.

- **Step 4.3: `System.out.println(bar + " " + buz.buz + " " + sum);`**
  - `bar = 4`
  - `buz.buz = q.foo.buz = 40`
  - `sum = 29` (local)
  - Output: `4 40 29`.

- **Step 4.4: `return sum;`**
  - Returns `29`.

- **Back to `methodA`:**
  - `sum = y + methodB(foo.buz, foo) + foo.buz`
  - `y = q.y = 17`
  - `methodB(...) = 29`
  - `foo.buz = q.foo.buz = 40`
  - `sum = 17 + 29 + 40 = 86`
  - `q.sum = 86`.

- **Step 5: `System.out.println(bar + " " + y + " " + sum);`**
  - `bar = 5` (local)
  - `y = q.y = 17`
  - `sum = q.sum = 86`
  - Output: `5 17 86`.

**Final State:**
- `q = {sum = 86, x = 23, y = 17, foo = {bar = 2, buz = 40}}`
- `p = {bar = 2, buz = 40}`
- Output: `2 21 10`, `4 40 29`, `5 17 86`

### Variable State Tracking

| Step | q.sum | q.x | q.y | q.foo.bar | q.foo.buz | Action |
|------|-------|-----|-----|-----------|-----------|--------|
| 1    | 12    | 2   | 6   | -         | -         | Initial (before constructor) |
| 2    | 12    | 2   | 6   | 3         | 4         | After `foo = f` |
| 3    | 21    | 2   | 6   | 2         | 4         | After `sum = sum + (f.bar--) + y` |
| 4    | 11    | 2   | 6   | 2         | 4         | After `sum -= 10` |
| 5    | 11    | 23  | 17  | 2         | 4         | `methodA`: Steps 1–3 |
| 6    | 11    | 23  | 17  | 2         | 40        | `methodB`: Steps 1–2 |
| 7    | 86    | 23  | 17  | 2         | 40        | After `methodA` completes |

### Final Answer

The output of the program is:
```
2 21 10
4 40 29
5 17 86
```