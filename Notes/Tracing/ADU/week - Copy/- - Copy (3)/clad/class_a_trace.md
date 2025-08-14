# Java Code Trace - Class B

## Class B

```java
class B{
  public int x = 3, y = 5, temp = -5, sum = 2;
  public B(){
    y = temp + 3 ;
    sum = 3 + temp + 2;
    temp -= 2;
  }
  public B(B b){
    sum = b.sum;
    x = b.x + 2;
    b.methodB(2,3);
    sum += x;
  }
  public void methodA(int m, int n){
    int x = 2;
    y = y + m + (temp++);
    x = x + 5 +  n;
    sum = sum + x + y;
    System.out.println(x + " " + y+ " " + sum); 
  }
  public void methodB(int m, int n){ 
    int  y = 0;
    y = y + this.y;
    x = this.y + 2 + temp;
    methodA(x, y);
    sum = x + y + sum;
    System.out.println(x + " " + y+ " " + sum);
  }
}
```

## Tester Class

```java
public class Tester {
   public static void main(String args []){
    B b1 = new B();
    B b2 = new B(b1);
    b1.methodA(1, 2);
    b2.methodB(3, 2);
   }
}
```

---

## **Main Method Execution**

```java
B b1 = new B();
```
- Creates `B` object `b1` using default constructor

## First Object Creation - Default Constructor
**Inside B() constructor on b1:**

**Initial field values:**
- `b1.x = 3`
- `b1.y = 5`
- `b1.temp = -5`
- `b1.sum = 2`

**Constructor Code:**
```java
y = temp + 3 ;
sum = 3 + temp + 2;
temp -= 2;
```

**Constructor execution line by line:**

```
Step 1: y = temp + 3
        b1.y = -5 + 3 = -2 (instance y = instance temp + 3)

Step 2: sum = 3 + temp + 2
        b1.sum = 3 + (-5) + 2 = 0 (instance sum = 3 + instance temp + 2)

Step 3: temp -= 2
        b1.temp = -5 - 2 = -7 (instance temp -= 2)
```

**State after b1 constructor:**
- `b1.x = 3`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 0`

## Second Object Creation - Copy Constructor
```java
B b2 = new B(b1);
```
- Creates `B` object `b2` using copy constructor with b1 reference

**Inside B(B b) constructor on b2:**
- Parameter: `b = b1` (reference to b1)

**Initial field values:**
- `b2.x = 3`
- `b2.y = 5`
- `b2.temp = -5`
- `b2.sum = 2`

**Constructor Code:**
```java
sum = b.sum;
x = b.x + 2;
b.methodB(2,3);
sum += x;
```

**Constructor execution line by line:**

```
Step 1: sum = b.sum
        b2.sum = 0 (instance sum = b1.sum)

Step 2: x = b.x + 2
        b2.x = 3 + 2 = 5 (instance x = b1.x + 2)

Step 3: b.methodB(2,3)
        Call methodB(2,3) on b1 object
```

## Nested methodB Call (During b2 Constructor)
**Inside methodB(int m, int n) on b1:**
- Parameters: `m = 2`, `n = 3`

**Current State:**
- `b1.x = 3`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 0`

**methodB Code:**
```java
int  y = 0;
y = y + this.y;
x = this.y + 2 + temp;
methodA(x, y);
sum = x + y + sum;
System.out.println(x + " " + y+ " " + sum);
```

**methodB execution line by line:**

```
Step 1: int y = 0
        Creates local variable y = 0 (shadows instance y)

Step 2: y = y + this.y
        y = 0 + (-2) = -2 (local y = local y + instance y)

Step 3: x = this.y + 2 + temp
        b1.x = -2 + 2 + (-7) = -7 (instance x = instance y + 2 + instance temp)

Step 4: methodA(x, y)
        Call methodA(-7, -2) on b1
```

## Nested methodA Call (During methodB)
**Inside methodA(int m, int n) on b1:**
- Parameters: `m = -7`, `n = -2`

**Current State:**
- `b1.x = -7`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 0`

**methodA Code:**
```java
int x = 2;
y = y + m + (temp++);
x = x + 5 +  n;
sum = sum + x + y;
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 2
        Creates local variable x = 2

Step 2: y = y + m + (temp++)
        temp_value = -7 (current value of instance temp)
        b1.temp = -7 + 1 = -6 (post-increment of instance temp)
        b1.y = -2 + (-7) + (-7) = -16 (instance y = instance y + m + old temp value)

Step 3: x = x + 5 + n
        x = 2 + 5 + (-2) = 5 (local x = local x + 5 + n)

Step 4: sum = sum + x + y
        b1.sum = 0 + 5 + (-16) = -11 (instance sum = instance sum + local x + instance y)

Step 5: Print "5 -16 -11" (local x, instance y, instance sum)
```

**Back to methodB on b1:**
```
Step 5: sum = x + y + sum
        b1.sum = -7 + (-2) + (-11) = -20 (instance sum = instance x + local y + instance sum)

Step 6: Print "-7 -2 -20" (instance x, local y, instance sum)
```

**State after methodB call on b1:**
- `b1.x = -7`
- `b1.y = -16`
- `b1.temp = -6`
- `b1.sum = -20`

**Back to b2 constructor:**
```
Step 4: sum += x
        b2.sum = 0 + 5 = 5 (instance sum += instance x)
```

**State after b2 constructor:**
- `b2.x = 5`
- `b2.y = 5`
- `b2.temp = -5`
- `b2.sum = 5`

## First methodA Call
```java
b1.methodA(1, 2);
```

**Inside methodA(int m, int n) on b1:**
- Parameters: `m = 1`, `n = 2`

**Current State:**
- `b1.x = -7`
- `b1.y = -16`
- `b1.temp = -6`
- `b1.sum = -20`

**methodA execution line by line:**

```
Step 1: int x = 2
        Creates local variable x = 2

Step 2: y = y + m + (temp++)
        temp_value = -6 (current value of instance temp)
        b1.temp = -6 + 1 = -5 (post-increment of instance temp)
        b1.y = -16 + 1 + (-6) = -21 (instance y = instance y + m + old temp value)

Step 3: x = x + 5 + n
        x = 2 + 5 + 2 = 9 (local x = local x + 5 + n)

Step 4: sum = sum + x + y
        b1.sum = -20 + 9 + (-21) = -32 (instance sum = instance sum + local x + instance y)

Step 5: Print "9 -21 -32" (local x, instance y, instance sum)
```

**State after first methodA:**
- `b1.x = -7`
- `b1.y = -21`
- `b1.temp = -5`
- `b1.sum = -32`

## Second methodB Call
```java
b2.methodB(3, 2);
```

**Inside methodB(int m, int n) on b2:**
- Parameters: `m = 3`, `n = 2`

**Current State:**
- `b2.x = 5`
- `b2.y = 5`
- `b2.temp = -5`
- `b2.sum = 5`

**methodB execution line by line:**

```
Step 1: int y = 0
        Creates local variable y = 0 (shadows instance y)

Step 2: y = y + this.y
        y = 0 + 5 = 5 (local y = local y + instance y)

Step 3: x = this.y + 2 + temp
        b2.x = 5 + 2 + (-5) = 2 (instance x = instance y + 2 + instance temp)

Step 4: methodA(x, y)
        Call methodA(2, 5) on b2
```

## Nested methodA Call (During second methodB)
**Inside methodA(int m, int n) on b2:**
- Parameters: `m = 2`, `n = 5`

**Current State:**
- `b2.x = 2`
- `b2.y = 5`
- `b2.temp = -5`
- `b2.sum = 5`

**methodA execution line by line:**

```
Step 1: int x = 2
        Creates local variable x = 2

Step 2: y = y + m + (temp++)
        temp_value = -5 (current value of instance temp)
        b2.temp = -5 + 1 = -4 (post-increment of instance temp)
        b2.y = 5 + 2 + (-5) = 2 (instance y = instance y + m + old temp value)

Step 3: x = x + 5 + n
        x = 2 + 5 + 5 = 12 (local x = local x + 5 + n)

Step 4: sum = sum + x + y
        b2.sum = 5 + 12 + 2 = 19 (instance sum = instance sum + local x + instance y)

Step 5: Print "12 2 19" (local x, instance y, instance sum)
```

**Back to methodB on b2:**
```
Step 5: sum = x + y + sum
        b2.sum = 2 + 5 + 19 = 26 (instance sum = instance x + local y + instance sum)

Step 6: Print "2 5 26" (instance x, local y, instance sum)
```

**State after second methodB:**
- `b2.x = 2`
- `b2.y = 2`
- `b2.temp = -4`
- `b2.sum = 26`

## Final Output
The program produces the following output:
```
5 -16 -11
-7 -2 -20
9 -21 -32
12 2 19
2 5 26
```

## Final State Summary
**b1 object:**
- `b1.x = -7`
- `b1.y = -21`
- `b1.temp = -5`
- `b1.sum = -32`

**b2 object:**
- `b2.x = 2`
- `b2.y = 2`
- `b2.temp = -4`
- `b2.sum = 26`