# Code Trace - Class A

## A Class

```java
class A{
  public int temp = 3, sum = 9, y = 4, x = 0;
  public A(){
    int sum = 7;
    y = temp - 5;
    sum = temp + 2;    
    temp-=2;
    this.x = sum + temp + y;
  }
  public A(int y, int temp){
    y = temp - 1 + x;
    sum = temp + 2 -x;
    temp-=2;
  }
  public void methodA(int m, int [] n){
    int x = 0;
    y = y + m + methodB(x,m);
    x = this.x + 2 + (++n[0]);
    sum = sum + x + y;
    n[0] = sum + 2;
    System.out.println(n[0] + " " + y+ " " + sum); 
  }
  public int methodB(int m, int n){   
    int [] y = {0};
    this.y = y[0] + this.y + m;
    x = this.y + 2 + temp - n;
    sum = x + y[0] + this.sum;
    System.out.println(y[0]+ " "+ temp + " " + sum);
    return y[0];
  }
}
```

## Tester9 Class

```java
public class Tester9 {
   public static void main(String args[]){
    int[] x = {35};
    A a1 = new A();
    A a2 = new A(-5,-7);
    a1.methodA(1, x);       
    a2.methodA(1, x);
  }
}
```

---

## **Main Method Execution**

```java
int[] x = {35};
```
- Creates array `x` with one element: `x[0] = 35`

## First Constructor Call: A()
```java
A a1 = new A();
```

**Initially creates A object a1 with:**
- `temp = 3`
- `sum = 9`
- `y = 4`
- `x = 0`

**Inside A() constructor:**

**Constructor Code:**
```java
int sum = 7;
y = temp - 5;
sum = temp + 2;    
temp-=2;
this.x = sum + temp + y;
```

**Constructor execution line by line:**

```
Step 1: int sum = 7
        sum = 7 (local variable, shadows instance sum)

Step 2: y = temp - 5
        y = 3 - 5 = -2 (instance variable)

Step 3: sum = temp + 2
        sum = 3 + 2 = 5 (local variable)

Step 4: temp -= 2
        temp = 3 - 2 = 1 (instance variable)

Step 5: this.x = sum + temp + y
        this.x = 5 + 1 + (-2) = 4 (instance variable)
```

**State after A() constructor:**
- `a1.temp = 1`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 4`

## Second Constructor Call: A(int y, int temp)
```java
A a2 = new A(-5,-7);
```

**Initially creates A object a2 with:**
- `temp = 3`
- `sum = 9`
- `y = 4`
- `x = 0`

**Inside A(int y, int temp) constructor:**
- Parameters: `y = -5`, `temp = -7`

**Constructor Code:**
```java
y = temp - 1 + x;
sum = temp + 2 -x;
temp-=2;
```

**Constructor execution line by line:**

```
Step 1: y = temp - 1 + x
        y = -7 - 1 + 0 = -8 (parameter y, NOT instance y)

Step 2: sum = temp + 2 - x
        sum = -7 + 2 - 0 = -5 (instance variable)

Step 3: temp -= 2
        temp = -7 - 2 = -9 (parameter temp, NOT instance temp)
```

**State after A(int y, int temp) constructor:**
- `a2.temp = 3` (unchanged - parameter shadowed instance)
- `a2.sum = -5`
- `a2.y = 4` (unchanged - parameter shadowed instance)
- `a2.x = 0`

## First methodA Call: a1.methodA(1, x)
```java
a1.methodA(1, x);
```

**Inside a1.methodA(int m, int[] n):**
- Parameters: `m = 1`, `n` references array `x` (n[0] = 35)

**Current State:**
- `a1.temp = 1`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 4`
- `x[0] = 35`

**methodA Code:**
```java
int x = 0;
y = y + m + methodB(x,m);
x = this.x + 2 + (++n[0]);
sum = sum + x + y;
n[0] = sum + 2;
System.out.println(n[0] + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 0
        x = 0 (local variable, shadows instance x)

Step 2: y = y + m + methodB(x,m)
        Need to call methodB(0, 1) first
```

## Nested methodB Call: a1.methodB(0, 1)
**Inside a1.methodB(int m, int n):**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a1.temp = 1`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 4`

**methodB Code:**
```java
int [] y = {0};
this.y = y[0] + this.y + m;
x = this.y + 2 + temp - n;
sum = x + y[0] + this.sum;
System.out.println(y[0]+ " "+ temp + " " + sum);
return y[0];
```

**methodB execution line by line:**

```
Step 1: int [] y = {0}
        Creates local array y with y[0] = 0

Step 2: this.y = y[0] + this.y + m
        this.y = 0 + (-2) + 0 = -2 (instance variable)

Step 3: x = this.y + 2 + temp - n
        x = -2 + 2 + 1 - 1 = 0 (instance variable a1.x)

Step 4: sum = x + y[0] + this.sum
        sum = 0 + 0 + 9 = 9 (instance variable)

Step 5: Print "0 1 9" (y[0], temp, sum)

Step 6: Return y[0] = 0
```

**Back to a1.methodA:**
```
Step 2 (continued): y = y + m + methodB(0, 1)
                    y = -2 + 1 + 0 = -1 (instance variable)

Step 3: x = this.x + 2 + (++n[0])
        ++n[0] increments x[0] from 35 to 36 (pre-increment)
        x = 0 + 2 + 36 = 38 (local variable)

Step 4: sum = sum + x + y
        sum = 9 + 38 + (-1) = 46 (instance variable)

Step 5: n[0] = sum + 2
        x[0] = 46 + 2 = 48

Step 6: Print "48 -1 46" (n[0], y, sum)
```

**State after first methodA call:**
- `a1.temp = 1`
- `a1.sum = 46`
- `a1.y = -1`
- `a1.x = 0`
- `x[0] = 48`

## Second methodA Call: a2.methodA(1, x)
```java
a2.methodA(1, x);
```

**Inside a2.methodA(int m, int[] n):**
- Parameters: `m = 1`, `n` references array `x` (n[0] = 48)

**Current State:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`
- `x[0] = 48`

**methodA execution line by line:**

```
Step 1: int x = 0
        x = 0 (local variable, shadows instance x)

Step 2: y = y + m + methodB(x,m)
        Need to call methodB(0, 1) first
```

## Nested methodB Call: a2.methodB(0, 1)
**Inside a2.methodB(int m, int n):**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodB execution line by line:**

```
Step 1: int [] y = {0}
        Creates local array y with y[0] = 0

Step 2: this.y = y[0] + this.y + m
        this.y = 0 + 4 + 0 = 4 (instance variable)

Step 3: x = this.y + 2 + temp - n
        x = 4 + 2 + 3 - 1 = 8 (instance variable a2.x)

Step 4: sum = x + y[0] + this.sum
        sum = 8 + 0 + (-5) = 3 (instance variable)

Step 5: Print "0 3 3" (y[0], temp, sum)

Step 6: Return y[0] = 0
```

**Back to a2.methodA:**
```
Step 2 (continued): y = y + m + methodB(0, 1)
                    y = 4 + 1 + 0 = 5 (instance variable)

Step 3: x = this.x + 2 + (++n[0])
        ++n[0] increments x[0] from 48 to 49 (pre-increment)
        x = 8 + 2 + 49 = 59 (local variable)

Step 4: sum = sum + x + y
        sum = 3 + 59 + 5 = 67 (instance variable)

Step 5: n[0] = sum + 2
        x[0] = 67 + 2 = 69

Step 6: Print "69 5 67" (n[0], y, sum)
```

## Final Output
The program produces the following output:
```
0 1 9
48 -1 46
0 3 3
69 5 67
```

## Final State Summary
- `a1.temp = 1`
- `a1.sum = 46`
- `a1.y = -1`
- `a1.x = 0`
- `a2.temp = 3`
- `a2.sum = 67`
- `a2.y = 5`
- `a2.x = 8`
- `x[0] = 69`