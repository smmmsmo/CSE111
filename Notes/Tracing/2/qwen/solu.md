# Quiz - Code Trace

## TracingProblem Class

```java
class TracingProblem {
    public int temp = 4;
    public int y = 2, x, sum;

    public TracingProblem() {
        this.x = 3;
        sum += x;
    }

    public TracingProblem(TracingProblem obj) {
        this.y = temp - 2;
        obj.y = x + temp - 1;
        obj.methodA(this.y);
    }

    public void methodA(int y) {
        int [] n = {2,5};
        int x = 1;
        this.y = y + this.methodB(n) + (temp++) + this.y;
        x = this.x + (++n[0]);
        sum = sum + x + y;
        System.out.println(x + " " + y + " " + sum);
    }

    public void methodB(int m, int n) {
        TracingProblem t4 = new TracingProblem(this);
        this.y = this.y + m;
        this.x = t4.temp + temp - n;
        System.out.println(this.x + " " + sum + " " + y);
    }

    public int methodB(int [] arr) {
        this.y += arr[1];
        arr[0]++;
        this.x = this.y + 1 + temp;
        System.out.println(this.x + " " + sum + " " + y);
        return this.y--;
    }
}
```

## Tester Class

```java
public class Tester {
    public static void main(String[] args) {
        TracingProblem t1 = new TracingProblem();
        TracingProblem t2 = new TracingProblem(t1);
        TracingProblem t3 = null;
        t3 = t2;
        t3.methodB(2, 4);
        t2.methodA(3);
    }
}
```

---

## **Main Method Execution**

```java
TracingProblem t1 = new TracingProblem();
```
- Calls no-argument constructor
- Initializes:
  - `t1.temp = 4`
  - `t1.y = 2` (explicit initialization)
  - `t1.x = 0`, `t1.sum = 0` (default values for int)

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
```
- `this.x = 3` → `t1.x = 3`
- `sum += x` → `sum = 0 + 3 = 3` → `t1.sum = 3`

**State after t1 creation:**
- `t1.temp = 4`
- `t1.y = 2`
- `t1.x = 3`
- `t1.sum = 3`

## **Second Object Creation: t2**

```java
TracingProblem t2 = new TracingProblem(t1);
```
- Calls parameterized constructor with `obj = t1`
- Creates new object `t2` with:
  - `t2.temp = 4`
  - `t2.y = 2` (from field initialization)
  - `t2.x = 0`, `t2.sum = 0` (default)

**Inside TracingProblem(TracingProblem obj):**
```java
this.y = temp - 2;
obj.y = x + temp - 1;
obj.methodA(this.y);
```

**Step 1:** `this.y = temp - 2`
- `temp = 4`, so `this.y = 4 - 2 = 2` → `t2.y = 2`

**Step 2:** `obj.y = x + temp - 1`
- `obj` is `t1`
- `x` is instance variable of `t2` → `t2.x = 0` (not initialized yet)
- `temp = 4` (of `t2`)
- `obj.y = 0 + 4 - 1 = 3` → `t1.y = 3`

**Step 3:** `obj.methodA(this.y)`
- `this.y = 2` (in `t2`)
- So call: `t1.methodA(2)`

---

## **Call: t1.methodA(2)**

```java
t1.methodA(2);
```

- Parameter: `y = 2` (local variable, shadows instance `y`)
- Current state of `t1`:
  - `t1.temp = 4`
  - `t1.y = 3` (updated in constructor)
  - `t1.x = 3`
  - `t1.sum = 3`

**Inside methodA(int y):**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(n) + (temp++) + this.y;
x = this.x + (++n[0]);
sum = sum + x + y;
System.out.println(x + " " + y + " " + sum);
```

**Step 1:** `int [] n = {2,5};`  
- Local array: `n[0] = 2`, `n[1] = 5`

**Step 2:** `int x = 1;`  
- Local variable `x = 1` (shadows instance `x`)

**Step 3:** `this.y = y + this.methodB(n) + (temp++) + this.y;`  
- Need to evaluate `this.methodB(n)` → calls `methodB(int[])` (overloaded)
- Passes `n = {2,5}`

### **Inside methodB(int [] arr):**
```java
this.y += arr[1];
arr[0]++;
this.x = this.y + 1 + temp;
System.out.println(this.x + " " + sum + " " + y);
return this.y--;
```

**Step 1:** `this.y += arr[1]`  
- `this.y = 3`, `arr[1] = 5` → `this.y = 3 + 5 = 8` → `t1.y = 8`

**Step 2:** `arr[0]++`  
- `arr[0] = 2` → becomes `3` (modifies local array in methodA)

**Step 3:** `this.x = this.y + 1 + temp`  
- `this.x = 8 + 1 + 4 = 13` → `t1.x = 13`

**Step 4:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 13`, `sum = 3`, `y = 8` (instance `t1.y`)  
- Output: `13 3 8`

**Step 5:** `return this.y--`  
- Returns `8`, then decrements `this.y` to `7`  
- So `t1.y = 7` after return

### **Back to methodA (after methodB returns):**
- Return value = `8`
- Now compute:
  ```
  this.y = y + 8 + (temp++) + this.y
         = 2 + 8 + (temp++) + 7
  ```

- `temp = 4` (used), then incremented to `5`
- `this.y = 2 + 8 + 4 + 7 = 21` → `t1.y = 21`
- `t1.temp = 5`

**Step 4:** `x = this.x + (++n[0]);`  
- `this.x = 13` (t1.x)
- `n[0] = 3` (was incremented to 3 in methodB), `++n[0] = 4`
- `x = 13 + 4 = 17` (local x)

**Step 5:** `sum = sum + x + y`  
- `sum = 3 + 17 + 2 = 22` → `t1.sum = 22`

**Step 6:** `System.out.println(x + " " + y + " " + sum);`  
- `x = 17`, `y = 2`, `sum = 22`  
- Output: `17 2 22`

**State after t1.methodA(2):**
- `t1.temp = 5`
- `t1.y = 21`
- `t1.x = 13`
- `t1.sum = 22`

**Constructor of t2 now complete.**

**State of t2 after constructor:**
- `t2.temp = 4`
- `t2.y = 2` (set in constructor)
- `t2.x = 0` (not changed)
- `t2.sum = 0`

## **Next Statement**

```java
TracingProblem t3 = null;
t3 = t2;
t3.methodB(2, 4);
```

- `t3` now references `t2`
- Call `t3.methodB(2, 4)` → calls `methodB(int, int)` on `t2`

### **Inside methodB(int m, int n):**
```java
TracingProblem t4 = new TracingProblem(this);
this.y = this.y + m;
this.x = t4.temp + temp - n;
System.out.println(this.x + " " + sum + " " + y);
```

**Step 1:** `TracingProblem t4 = new TracingProblem(this);`  
- Calls copy constructor with `obj = t2` (since `this = t2`)
- Create new object `t4`

#### **Inside TracingProblem(TracingProblem obj):**
- `obj = t2`
- `this` is `t4`

**Step 1:** `this.y = temp - 2`  
- `temp = 4` → `t4.y = 4 - 2 = 2`

**Step 2:** `obj.y = x + temp - 1`  
- `obj = t2`, `x = t4.x = 0` (not initialized), `temp = 4` (t4's)
- `t2.y = 0 + 4 - 1 = 3`

**Step 3:** `obj.methodA(this.y)`  
- `this.y = 2` (in `t4`)
- So call: `t2.methodA(2)`

---

## **Call: t2.methodA(2)**

```java
t2.methodA(2);
```

- Parameter: `y = 2` (local)
- Current state of `t2`:
  - `t2.temp = 4`
  - `t2.y = 3` (just updated)
  - `t2.x = 0`
  - `t2.sum = 0`

**Inside methodA(int y):**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(n) + (temp++) + this.y;
x = this.x + (++n[0]);
sum = sum + x + y;
System.out.println(x + " " + y + " " + sum);
```

**Step 1:** `int [] n = {2,5};` → `n[0]=2`, `n[1]=5`  
**Step 2:** `int x = 1;` → local `x = 1`  
**Step 3:** `this.y = y + this.methodB(n) + (temp++) + this.y;`  
- Call `this.methodB(n)` → `methodB(int[])` on `t2`

### **Inside methodB(int [] arr):**
**Step 1:** `this.y += arr[1]` → `t2.y = 3 + 5 = 8`  
**Step 2:** `arr[0]++` → `n[0] = 2 → 3`  
**Step 3:** `this.x = this.y + 1 + temp` → `t2.x = 8 + 1 + 4 = 13`  
**Step 4:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 13`, `sum = 0`, `y = 8` → Output: `13 0 8`  
**Step 5:** `return this.y--` → returns `8`, then `t2.y = 7`

### **Back to methodA:**
- `this.y = 2 + 8 + (temp++) + 7`
- `temp = 4` (used), becomes `5`
- `this.y = 2 + 8 + 4 + 7 = 21` → `t2.y = 21`
- `t2.temp = 5`

**Step 4:** `x = this.x + (++n[0]);`  
- `this.x = 13`, `n[0] = 3`, `++n[0] = 4`  
- `x = 13 + 4 = 17` (local)

**Step 5:** `sum = sum + x + y`  
- `sum = 0 + 17 + 2 = 19` → `t2.sum = 19`

**Step 6:** `System.out.println(x + " " + y + " " + sum);`  
- Output: `17 2 19`

**Back to methodB (in t2):**
- `t4` construction complete
- Continue with:
  ```java
  this.y = this.y + m;
  this.x = t4.temp + temp - n;
  System.out.println(this.x + " " + sum + " " + y);
  ```

**Step 2:** `this.y = this.y + m`  
- `this.y = 21`, `m = 2` → `t2.y = 23`

**Step 3:** `this.x = t4.temp + temp - n`  
- `t4.temp = 4`, `temp = 5` (t2.temp), `n = 4`  
- `this.x = 4 + 5 - 4 = 5` → `t2.x = 5`

**Step 4:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 5`, `sum = 19`, `y = 23` → Output: `5 19 23`

## **Final Call: t2.methodA(3)**

```java
t2.methodA(3);
```

- Parameter: `y = 3`
- Current state of `t2`:
  - `t2.temp = 5`
  - `t2.y = 23`
  - `t2.x = 5`
  - `t2.sum = 19`

**Inside methodA(int y):**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(n) + (temp++) + this.y;
x = this.x + (++n[0]);
sum = sum + x + y;
System.out.println(x + " " + y + " " + sum);
```

**Step 1:** `int [] n = {2,5};` → `n[0]=2`, `n[1]=5`  
**Step 2:** `int x = 1;` → local `x = 1`  
**Step 3:** `this.y = y + this.methodB(n) + (temp++) + this.y;`  
- Call `this.methodB(n)` → `methodB(int[])` on `t2`

### **Inside methodB(int [] arr):**
**Step 1:** `this.y += arr[1]` → `t2.y = 23 + 5 = 28`  
**Step 2:** `arr[0]++` → `n[0] = 2 → 3`  
**Step 3:** `this.x = this.y + 1 + temp` → `t2.x = 28 + 1 + 5 = 34`  
**Step 4:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 34`, `sum = 19`, `y = 28` → Output: `34 19 28`  
**Step 5:** `return this.y--` → returns `28`, then `t2.y = 27`

### **Back to methodA:**
- `this.y = 3 + 28 + (temp++) + 27`
- `temp = 5` (used), becomes `6`
- `this.y = 3 + 28 + 5 + 27 = 63` → `t2.y = 63`
- `t2.temp = 6`

**Step 4:** `x = this.x + (++n[0]);`  
- `this.x = 34`, `n[0] = 3`, `++n[0] = 4`  
- `x = 34 + 4 = 38` (local)

**Step 5:** `sum = sum + x + y`  
- `sum = 19 + 38 + 3 = 60` → `t2.sum = 60`

**Step 6:** `System.out.println(x + " " + y + " " + sum);`  
- Output: `38 3 60`

## Final Output

The program produces the following output:
```
13 3 8
17 2 22
13 0 8
17 2 19
5 19 23
34 19 28
38 3 60
```

## Final State Summary

### Object t1:
- `t1.temp = 5`
- `t1.y = 21`
- `t1.x = 13`
- `t1.sum = 22`

### Object t2:
- `t2.temp = 6`
- `t2.y = 63`
- `t2.x = 34`
- `t2.sum = 60`

### Object t4 (created inside methodB):
- `t4.temp = 4`
- `t4.y = 2`
- `t4.x = 0`
- `t4.sum = 0`

### References:
- `t1` → object with state above
- `t2` → object with state above
- `t3` → same as `t2`