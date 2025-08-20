# Quiz - Code Trace

## B Class

```java
class B{
  public static int x;
  public int y = 4;
  public int temp = -5;
  public int sum = 2;

  public B(){
    y = temp + 3;
    sum = 3 + temp + 3;
    temp -= 2;
  }

  public B(B b){
    sum = b.sum;
    x = b.x;
    b.methodB(1,3);
  }

  public void methodA(int m, int n){
    int x = 2;
    y = y + m + (temp++);
    x = x + 7 + n;
    sum = sum + x + y;
    System.out.println(x + " " + y+ " " + sum);  
  }

  public void methodB(int m, int n){    
    int  y = 0;
    y = y + this.y; 
    x = this.y + 3 + temp;
    methodA(x, y);
    sum = x + y + sum;
    System.out.println(x + " " + y+ " " + sum);
  }
}
```

## LabTester Class

```java
public class LabTester {
  public static void main(String[] args) {
    B b1 = new B();
    B b2 = new B(b1);
    b1.methodA(3, 2);
    b2.methodB(1, 2);
  }
}
```

---

## **Main Method Execution**

```java
B b1 = new B();
```

- Creates `B` object `b1` with initial values:
  - `x = 0` (static, default)
  - `y = 4`
  - `temp = -5`
  - `sum = 2`

**Inside constructor B():**
```
Step 1: y = temp + 3
        y = -5 + 3 = -2

Step 2: sum = 3 + temp + 3
        sum = 3 + (-5) + 3 = 1

Step 3: temp -= 2
        temp = -5 - 2 = -7
```

**State after b1 constructor:**
- `b1.x = 0` (static)
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`

---

```java
B b2 = new B(b1);
```
- Creates new object `b2` with initial values:
  - `y = 4`
  - `temp = -5`
  - `sum = 2`
  - `x = 0` (static)

**Inside constructor B(B b):**
```
Step 1: sum = b.sum
        sum = b1.sum = 1

Step 2: x = b.x
        x = b1.x = 0

Step 3: b.methodB(1,3) → calls b1.methodB(1,3)
```

---

## **b1.methodB(1,3) Execution (inside b2 constructor)**

Initial state of b1:
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`

```
Step 1: int y = 0
        y = 0 + this.y = -2

Step 2: x = this.y + 3 + temp
        x = -2 + 3 + (-7) = -6 (static variable updated)

Step 3: methodA(x, y) → methodA(-6, -2)
```

---

### **b1.methodA(-6, -2) Execution**

```
Step 1: int x = 2 (local variable)

Step 2: y = y + m + (temp++)
        y = -2 + (-6) + (-7) = -15
        temp becomes -6

Step 3: x = x + 7 + n
        x = 2 + 7 + (-2) = 7 (local x)

Step 4: sum = sum + x + y
        sum = 1 + 7 + (-15) = -7

Step 5: Print "7 -15 -7"
```

**State after b1.methodA:**
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -7`
- `x = -6` (static)

Output: `7 -15 -7`

---

### Back to **b1.methodB(1,3)**

```
Step 4: sum = x + y + sum
        sum = (-6) + (-2) + (-7) = -15

Step 5: Print "-6 -2 -15"
```

**Final state of b1 after methodB:**
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -15`
- `x = -6`

Output: `-6 -2 -15`

---

**State after b2 constructor finishes:**
- `b2.sum = 1`
- `b2.y = 4`
- `b2.temp = -5`
- `x = -6` (static)

---

```java
b1.methodA(3, 2);
```

**State before call:**
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -15`

Execution:
```
Step 1: int x = 2

Step 2: y = y + m + (temp++)
        y = -15 + 3 + (-6) = -18
        temp becomes -5

Step 3: x = x + 7 + n
        x = 2 + 7 + 2 = 11

Step 4: sum = sum + x + y
        sum = -15 + 11 + (-18) = -22

Step 5: Print "11 -18 -22"
```

Output: `11 -18 -22`

**State after call:**
- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`

---

```java
b2.methodB(1, 2);
```

**State before call:**
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`
- `x = -6`

Execution:
```
Step 1: int y = 0
        y = 0 + this.y = 4

Step 2: x = this.y + 3 + temp
        x = 4 + 3 + (-5) = 2 (static updated)

Step 3: methodA(x, y) → methodA(2, 4)
```

---

### **b2.methodA(2, 4) Execution**

```
Step 1: int x = 2

Step 2: y = y + m + (temp++)
        y = 4 + 2 + (-5) = 1
        temp = -4

Step 3: x = x + 7 + n
        x = 2 + 7 + 4 = 13 (local x)

Step 4: sum = sum + x + y
        sum = 1 + 13 + 1 = 15

Step 5: Print "13 1 15"
```

Output: `13 1 15`

**State after methodA:**  
- `b2.y = 1`
- `b2.temp = -4`
- `b2.sum = 15`

---

### Back to **b2.methodB(1,2)**

```
Step 4: sum = x + y + sum
        sum = 2 + 4 + 15 = 21

Step 5: Print "2 4 21"
```

Output: `2 4 21`

---

## **Final Output**

```
7 -15 -7
-6 -2 -15
11 -18 -22
13 1 15
2 4 21
```

## **Final State Summary**

- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`

- `b2.y = 1`
- `b2.temp = -4`
- `b2.sum = 21`

- `x = 2` (static)
