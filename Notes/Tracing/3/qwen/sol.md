# Quiz - Code Trace

## TracingProblem Class

```java
class TracingProblem {
    public int temp = 4, x, sum = 2;

    public TracingProblem() {
        this.x = 3;
        sum += x;
        temp--;
    }

    public void methodA(TracingProblem t5) {
        int x = 1;
        methodB(this);
        this.temp = t5.temp + x;  
        this.x = x + (++sum);
        sum = sum + this.x;
        System.out.println(this.x + " " + temp + " " + sum);
    }

    public void methodB(TracingProblem t1) {
        this.temp = t1.temp + t1.x;
        this.x = t1.sum + sum;
        t1.x += this.x;
        System.out.println(this.x + " " + this.temp + " " + t1.x);
    }
}
```

## Tester Class

```java
public class Tester {
    public static void main(String[] args) {
        TracingProblem t1 = new TracingProblem();
        TracingProblem t3 = new TracingProblem();
        t3.methodA(t1);
    }
}
```

---

## **Main Method Execution**

```java
TracingProblem t1 = new TracingProblem();
```
- Creates `TracingProblem` object `t1` with initial field values:
  - `t1.temp = 4`
  - `t1.x = 0` (default value)
  - `t1.sum = 2` (explicit initialization)

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
temp--;
```

**Step 1:** `this.x = 3`  
→ `t1.x = 3`

**Step 2:** `sum += x`  
→ `sum = 2 + 3 = 5` → `t1.sum = 5`

**Step 3:** `temp--`  
→ `temp = 4 - 1 = 3` → `t1.temp = 3`

**State after t1 construction:**
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`

## **Second Object Creation: t3**

```java
TracingProblem t3 = new TracingProblem();
```
- Creates new object `t3` with initial field values:
  - `t3.temp = 4`
  - `t3.x = 0`
  - `t3.sum = 2`

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
temp--;
```

**Step 1:** `this.x = 3`  
→ `t3.x = 3`

**Step 2:** `sum += x`  
→ `sum = 2 + 3 = 5` → `t3.sum = 5`

**Step 3:** `temp--`  
→ `temp = 4 - 1 = 3` → `t3.temp = 3`

**State after t3 construction:**
- `t3.temp = 3`
- `t3.x = 3`
- `t3.sum = 5`

## **Call: t3.methodA(t1)**

```java
t3.methodA(t1);
```
- Parameter: `t5 = t1` (references `t1`)
- Current state:
  - `t3.temp = 3`, `t3.x = 3`, `t3.sum = 5`
  - `t1.temp = 3`, `t1.x = 3`, `t1.sum = 5`

**Inside methodA(TracingProblem t5):**
```java
int x = 1;
methodB(this);
this.temp = t5.temp + x;
this.x = x + (++sum);
sum = sum + this.x;
System.out.println(this.x + " " + temp + " " + sum);
```

**Step 1:** `int x = 1;`  
- Local variable `x = 1` (shadows instance `x`)

**Step 2:** `methodB(this);`  
- Calls `t3.methodB(t3)` because `this` refers to `t3`
- Passes `t3` as argument → inside `methodB`, parameter `t1` references `t3`

---

### **Inside methodB(TracingProblem t1):**
```java
this.temp = t1.temp + t1.x;
this.x = t1.sum + sum;
t1.x += this.x;
System.out.println(this.x + " " + this.temp + " " + t1.x);
```

- `this` → `t3`
- `t1` (parameter) → `t3` (same object)

**Step 1:** `this.temp = t1.temp + t1.x`  
- `t1.temp = 3`, `t1.x = 3`
- `this.temp = 3 + 3 = 6` → `t3.temp = 6`

**Step 2:** `this.x = t1.sum + sum`  
- `t1.sum = 5`, `sum = 5` (both are `t3.sum`)
- `this.x = 5 + 5 = 10` → `t3.x = 10`

**Step 3:** `t1.x += this.x`  
- `t1.x = 10`, `this.x = 10`
- `t1.x = 10 + 10 = 20`
- Since `t1` and `this` refer to the same object (`t3`), `t3.x` is now `20`
- So `this.x = 20` after this line

**Step 4:** `System.out.println(this.x + " " + this.temp + " " + t1.x);`  
- `this.x = 20`
- `this.temp = 6`
- `t1.x = 20` (same field)
- Output: `20 6 20`

### **Back to methodA (after methodB returns):**

- Local `x = 1`
- `t5` references `t1`

**Step 3:** `this.temp = t5.temp + x`  
- `t5.temp = t1.temp = 3`, `x = 1`
- `this.temp = 3 + 1 = 4` → `t3.temp = 4`

**Step 4:** `this.x = x + (++sum)`  
- `sum = 5` → `++sum = 6` → `t3.sum = 6`
- `this.x = 1 + 6 = 7` → `t3.x = 7`

**Step 5:** `sum = sum + this.x`  
- `sum = 6 + 7 = 13` → `t3.sum = 13`

**Step 6:** `System.out.println(this.x + " " + temp + " " + sum);`  
- `this.x = 7`, `temp = 4`, `sum = 13`
- Output: `7 4 13`

## Final Output

The program produces the following output:
```
20 6 20
7 4 13
```

## Final State Summary

### Object t1:
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`
- ✅ **Unchanged** after constructor and method calls (only read via `t5.temp`)

### Object t3:
- `t3.temp = 4`
- `t3.x = 7`
- `t3.sum = 13`

### References:
- `t1` → object with state: `temp=3`, `x=3`, `sum=5`
- `t3` → object with final state: `temp=4`, `x=7`, `sum=13`

> 🔍 **Key Insight**: In `methodB`, both `this` and the parameter `t1` refer to the **same object** (`t3`). Therefore, updating `t1.x` directly modifies `this.x`. After `t1.x += this.x`, the field value becomes `20`, and both `this.x` and `t1.x` reflect this updated value. This explains the first output line: `20 6 20`.# Quiz - Code Trace

## TracingProblem Class

```java
class TracingProblem {
    public int temp = 4, x, sum = 2;

    public TracingProblem() {
        this.x = 3;
        sum += x;
        temp--;
    }

    public void methodA(TracingProblem t5) {
        int x = 1;
        methodB(this);
        this.temp = t5.temp + x;  
        this.x = x + (++sum);
        sum = sum + this.x;
        System.out.println(this.x + " " + temp + " " + sum);
    }

    public void methodB(TracingProblem t1) {
        this.temp = t1.temp + t1.x;
        this.x = t1.sum + sum;
        t1.x += this.x;
        System.out.println(this.x + " " + this.temp + " " + t1.x);
    }
}
```

## Tester Class

```java
public class Tester {
    public static void main(String[] args) {
        TracingProblem t1 = new TracingProblem();
        TracingProblem t3 = new TracingProblem();
        t3.methodA(t1);
    }
}
```

---

## **Main Method Execution**

```java
TracingProblem t1 = new TracingProblem();
```
- Creates `TracingProblem` object `t1` with initial field values:
  - `t1.temp = 4`
  - `t1.x = 0` (default value)
  - `t1.sum = 2` (explicit initialization)

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
temp--;
```

**Step 1:** `this.x = 3`  
→ `t1.x = 3`

**Step 2:** `sum += x`  
→ `sum = 2 + 3 = 5` → `t1.sum = 5`

**Step 3:** `temp--`  
→ `temp = 4 - 1 = 3` → `t1.temp = 3`

**State after t1 construction:**
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`

## **Second Object Creation: t3**

```java
TracingProblem t3 = new TracingProblem();
```
- Creates new object `t3` with initial field values:
  - `t3.temp = 4`
  - `t3.x = 0`
  - `t3.sum = 2`

**Inside TracingProblem() constructor:**
```java
this.x = 3;
sum += x;
temp--;
```

**Step 1:** `this.x = 3`  
→ `t3.x = 3`

**Step 2:** `sum += x`  
→ `sum = 2 + 3 = 5` → `t3.sum = 5`

**Step 3:** `temp--`  
→ `temp = 4 - 1 = 3` → `t3.temp = 3`

**State after t3 construction:**
- `t3.temp = 3`
- `t3.x = 3`
- `t3.sum = 5`

## **Call: t3.methodA(t1)**

```java
t3.methodA(t1);
```
- Parameter: `t5 = t1` (references `t1`)
- Current state:
  - `t3.temp = 3`, `t3.x = 3`, `t3.sum = 5`
  - `t1.temp = 3`, `t1.x = 3`, `t1.sum = 5`

**Inside methodA(TracingProblem t5):**
```java
int x = 1;
methodB(this);
this.temp = t5.temp + x;
this.x = x + (++sum);
sum = sum + this.x;
System.out.println(this.x + " " + temp + " " + sum);
```

**Step 1:** `int x = 1;`  
- Local variable `x = 1` (shadows instance `x`)

**Step 2:** `methodB(this);`  
- Calls `t3.methodB(t3)` because `this` refers to `t3`
- Passes `t3` as argument → inside `methodB`, parameter `t1` references `t3`

---

### **Inside methodB(TracingProblem t1):**
```java
this.temp = t1.temp + t1.x;
this.x = t1.sum + sum;
t1.x += this.x;
System.out.println(this.x + " " + this.temp + " " + t1.x);
```

- `this` → `t3`
- `t1` (parameter) → `t3` (same object)

**Step 1:** `this.temp = t1.temp + t1.x`  
- `t1.temp = 3`, `t1.x = 3`
- `this.temp = 3 + 3 = 6` → `t3.temp = 6`

**Step 2:** `this.x = t1.sum + sum`  
- `t1.sum = 5`, `sum = 5` (both are `t3.sum`)
- `this.x = 5 + 5 = 10` → `t3.x = 10`

**Step 3:** `t1.x += this.x`  
- `t1.x = 10`, `this.x = 10`
- `t1.x = 10 + 10 = 20`
- Since `t1` and `this` refer to the same object (`t3`), `t3.x` is now `20`
- So `this.x = 20` after this line

**Step 4:** `System.out.println(this.x + " " + this.temp + " " + t1.x);`  
- `this.x = 20`
- `this.temp = 6`
- `t1.x = 20` (same field)
- Output: `20 6 20`

### **Back to methodA (after methodB returns):**

- Local `x = 1`
- `t5` references `t1`

**Step 3:** `this.temp = t5.temp + x`  
- `t5.temp = t1.temp = 3`, `x = 1`
- `this.temp = 3 + 1 = 4` → `t3.temp = 4`

**Step 4:** `this.x = x + (++sum)`  
- `sum = 5` → `++sum = 6` → `t3.sum = 6`
- `this.x = 1 + 6 = 7` → `t3.x = 7`

**Step 5:** `sum = sum + this.x`  
- `sum = 6 + 7 = 13` → `t3.sum = 13`

**Step 6:** `System.out.println(this.x + " " + temp + " " + sum);`  
- `this.x = 7`, `temp = 4`, `sum = 13`
- Output: `7 4 13`

## Final Output

The program produces the following output:
```
20 6 20
7 4 13
```

## Final State Summary

### Object t1:
- `t1.temp = 3`
- `t1.x = 3`
- `t1.sum = 5`
- ✅ **Unchanged** after constructor and method calls (only read via `t5.temp`)

### Object t3:
- `t3.temp = 4`
- `t3.x = 7`
- `t3.sum = 13`

### References:
- `t1` → object with state: `temp=3`, `x=3`, `sum=5`
- `t3` → object with final state: `temp=4`, `x=7`, `sum=13`

> 🔍 **Key Insight**: In `methodB`, both `this` and the parameter `t1` refer to the **same object** (`t3`). Therefore, updating `t1.x` directly modifies `this.x`. After `t1.x += this.x`, the field value becomes `20`, and both `this.x` and `t1.x` reflect this updated value. This explains the first output line: `20 6 20`.