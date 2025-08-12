# Quiz - Code Trace

## oop_beforeMid_tracing Class

```java
class oop_beforeMid_tracing { 
    public int temp = 4;
    public int sum;
    public int y;
    public int x;
    public void methodA(int y){
        int [] n = {2,5};
        int x = 1;
        this.y = y + this.methodB(x, this.y)+(temp++) + this.y;
        x = this.x + 2 + (++n[0]);
        sum = sum + x + y;
        System.out.println( x + " " + y+ " " + sum);
    }
    public int methodB(int m, int n){
        this.y = this.y + m;
        this.x = this.y + 2 + temp - n;
        System.out.println(this.x + " " +sum+ " " +y);
        return this.y;
    }
}
```

## Tester Class

```java
public class Tester {
    public static void main(String[] args) {
        oop_beforeMid_tracing t1 = new oop_beforeMid_tracing();
        t1.methodA(5);
        oop_beforeMid_tracing t2 = new oop_beforeMid_tracing();
        t2.methodA(3);
        oop_beforeMid_tracing t3 = null;
        t3 = t1;
        t3.methodB(2, 4);
    }
}
```

---

## **Main Method Execution**

```java
oop_beforeMid_tracing t1 = new oop_beforeMid_tracing();
```
- Creates `oop_beforeMid_tracing` object `t1` with:
  - `t1.temp = 4`
  - `t1.sum = 0` (default value for int)
  - `t1.y = 0` (default value for int)
  - `t1.x = 0` (default value for int)

## **First Call: t1.methodA(5)**

```java
t1.methodA(5);
```

- Parameter: `y = 5` (local variable, shadows instance `y`)

**Inside methodA(int y):**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(x, this.y) + (temp++) + this.y;
x = this.x + 2 + (++n[0]);
sum = sum + x + y;
System.out.println(x + " " + y + " " + sum);
```

**Step 1:** `int [] n = {2,5};`  
- Local array `n` created: `n[0] = 2`, `n[1] = 5`

**Step 2:** `int x = 1;`  
- Local variable `x = 1` (shadows instance `x`)

**Step 3:** `this.y = y + this.methodB(x, this.y) + (temp++) + this.y;`  
- Evaluate `this.methodB(x, this.y)` → `methodB(1, 0)`
- Passes `m = 1`, `n = 0`

### **Inside methodB(int m, int n):**
```java
this.y = this.y + m;
this.x = this.y + 2 + temp - n;
System.out.println(this.x + " " + sum + " " + y);
return this.y;
```

**Step 1:** `this.y = 0 + 1 = 1` → `t1.y = 1`  
**Step 2:** `this.x = 1 + 2 + 4 - 0 = 7` → `t1.x = 7`  
**Step 3:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 7`, `sum = 0`, `y = 1` (since `y` refers to `this.y`)  
- Output: `7 0 1`  
**Step 4:** Return `1`

### **Back to methodA (after methodB returns):**
- Return value = `1`
- `this.y = 5 + 1 + (temp++) + 1`
- `temp++` uses current value `4`, then increments to `5`
- `this.y = 5 + 1 + 4 + 1 = 11` → `t1.y = 11`
- `t1.temp = 5`

**Step 4:** `x = this.x + 2 + (++n[0]);`  
- `this.x = 7`, `n[0] = 2`, `++n[0] = 3`  
- `x = 7 + 2 + 3 = 12` (local variable)

**Step 5:** `sum = sum + x + y`  
- `sum = 0 + 12 + 5 = 17` → `t1.sum = 17`

**Step 6:** `System.out.println(x + " " + y + " " + sum);`  
- `x = 12`, `y = 5`, `sum = 17`  
- Output: `12 5 17`

**State after t1.methodA(5):**
- `t1.temp = 5`
- `t1.sum = 17`
- `t1.y = 11`
- `t1.x = 7`

## **Second Object Creation: t2**

```java
oop_beforeMid_tracing t2 = new oop_beforeMid_tracing();
```
- Creates new object `t2` with:
  - `t2.temp = 4`
  - `t2.sum = 0`
  - `t2.y = 0`
  - `t2.x = 0`

## **Call: t2.methodA(3)**

```java
t2.methodA(3);
```

- Parameter: `y = 3` (local variable)

**Inside methodA(int y):**
```java
int [] n = {2,5};
int x = 1;
this.y = y + this.methodB(x, this.y) + (temp++) + this.y;
x = this.x + 2 + (++n[0]);
sum = sum + x + y;
System.out.println(x + " " + y + " " + sum);
```

**Step 1:** `int [] n = {2,5};` → `n[0] = 2`, `n[1] = 5`  
**Step 2:** `int x = 1;` → local `x = 1`  
**Step 3:** `this.y = y + this.methodB(x, this.y) + (temp++) + this.y;`  
- Call `methodB(1, 0)`

### **Inside methodB(int m, int n):**
**Step 1:** `this.y = 0 + 1 = 1` → `t2.y = 1`  
**Step 2:** `this.x = 1 + 2 + 4 - 0 = 7` → `t2.x = 7`  
**Step 3:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 7`, `sum = 0`, `y = 1`  
- Output: `7 0 1`  
**Step 4:** Return `1`

### **Back to methodA:**
- `this.y = 3 + 1 + (temp++) + 1`
- `temp = 4` (used), then becomes `5`
- `this.y = 3 + 1 + 4 + 1 = 9` → `t2.y = 9`
- `t2.temp = 5`

**Step 4:** `x = this.x + 2 + (++n[0]);`  
- `this.x = 7`, `++n[0] = 3`  
- `x = 7 + 2 + 3 = 12`

**Step 5:** `sum = sum + x + y`  
- `sum = 0 + 12 + 3 = 15` → `t2.sum = 15`

**Step 6:** `System.out.println(x + " " + y + " " + sum);`  
- Output: `12 3 15`

**State after t2.methodA(3):**
- `t2.temp = 5`
- `t2.sum = 15`
- `t2.y = 9`
- `t2.x = 7`

## **Final Statements**

```java
oop_beforeMid_tracing t3 = null;
t3 = t1;
t3.methodB(2, 4);
```

- `t3` now references `t1`
- Call `t3.methodB(2, 4)` → same as `t1.methodB(2, 4)`

### **Inside methodB(int m, int n):**
```java
this.y = this.y + m;
this.x = this.y + 2 + temp - n;
System.out.println(this.x + " " + sum + " " + y);
return this.y;
```

**Step 1:** `this.y = 11 + 2 = 13` → `t1.y = 13`  
**Step 2:** `this.x = 13 + 2 + 5 - 4 = 16` → `t1.x = 16`  
**Step 3:** `System.out.println(this.x + " " + sum + " " + y);`  
- `this.x = 16`, `sum = 17`, `y = 13`  
- Output: `16 17 13`  
**Step 4:** Return value not used

## Final Output

The program produces the following output:
```
7 0 1
12 5 17
7 0 1
12 3 15
16 17 13
```

## Final State Summary

### Object t1 (also referenced by t3):
- `t1.temp = 5`
- `t1.sum = 17`
- `t1.y = 13`
- `t1.x = 16`

### Object t2:
- `t2.temp = 5`
- `t2.sum = 15`
- `t2.y = 9`
- `t2.x = 7`

### References:
- `t1` → object with final state above
- `t2` → separate object
- `t3` → same as `t1`