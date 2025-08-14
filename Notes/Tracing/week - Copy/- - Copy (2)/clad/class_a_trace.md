# Java Code Trace - Class A

## Class A

```java
class A{
 public int temp = 3, sum = 9, y = 4, x = 0;
 public A(){
   int sum = 7;
   y = temp - 5;
   sum = temp + 2;
   this.x = sum + --temp + y;
 }
 public A(int y, int temp){
   y = temp - 1 + x;
   sum = temp + 2 - x;
   temp -= 2;
 }
 public void methodA(int m, int n){
   int x = 0;
   y = y + methodB(x,m) + m;
   x = this.x + 2 + ++n;
   sum = sum + y + methodB(n);
   System.out.println(x + " " + y+ " " + sum);
 }
 public int methodB(int m, int n){  
   int y = 0;
   this.y = y + this.y + m;
   x = this.y + 2 + temp - n;
   sum = x + y + this.sum;
   System.out.println(y+ " "+ temp + " " + sum);
   return y;
 }
 public int methodB(int x){  
   this.x = x + this.y;
   x -= y + 2 + temp;
   sum = x + y + this.sum;
   return sum;
 }
}
```

## Tester11 Class

```java
public class Tester11 {
   public static void main(String args[]){
    A a1 = new A();
    A a2 = new A(-5,-7);
    a1.methodA(1, 2);       
    a2.methodA(1, 4);
  }
}
```

---

## **Main Method Execution**

```java
A a1 = new A();
```
- Creates `A` object `a1` using default constructor

## First Object Creation - Default Constructor
**Inside A() constructor on a1:**

**Initial field values:**
- `a1.temp = 3`
- `a1.sum = 9`
- `a1.y = 4`
- `a1.x = 0`

**Constructor Code:**
```java
int sum = 7;
y = temp - 5;
sum = temp + 2;
this.x = sum + --temp + y;
```

**Constructor execution line by line:**

```
Step 1: int sum = 7
        Creates local variable sum = 7 (shadows instance sum)

Step 2: y = temp - 5
        a1.y = 3 - 5 = -2 (instance y = instance temp - 5)

Step 3: sum = temp + 2
        sum = 3 + 2 = 5 (local sum = instance temp + 2)

Step 4: this.x = sum + --temp + y
        a1.temp = 3 - 1 = 2 (pre-decrement of instance temp)
        a1.x = 5 + 2 + (-2) = 5 (instance x = local sum + decremented temp + instance y)
```

**State after a1 constructor:**
- `a1.temp = 2`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 5`

## Second Object Creation - Parameterized Constructor
```java
A a2 = new A(-5,-7);
```
- Creates `A` object `a2` using parameterized constructor

**Inside A(int y, int temp) constructor on a2:**
- Parameters: `y = -5`, `temp = -7`

**Initial field values:**
- `a2.temp = 3`
- `a2.sum = 9`
- `a2.y = 4`
- `a2.x = 0`

**Constructor Code:**
```java
y = temp - 1 + x;
sum = temp + 2 - x;
temp -= 2;
```

**Constructor execution line by line:**

```
Step 1: y = temp - 1 + x
        y = -7 - 1 + 0 = -8 (parameter y = parameter temp - 1 + instance x)
        Note: This only affects the parameter y, not instance y

Step 2: sum = temp + 2 - x
        a2.sum = -7 + 2 - 0 = -5 (instance sum = parameter temp + 2 - instance x)

Step 3: temp -= 2
        temp = -7 - 2 = -9 (parameter temp -= 2)
        Note: This only affects the parameter temp, not instance temp
```

**State after a2 constructor:**
- `a2.temp = 3` (unchanged - only parameter was modified)
- `a2.sum = -5`
- `a2.y = 4` (unchanged - only parameter was modified)
- `a2.x = 0`

## First methodA Call
```java
a1.methodA(1, 2);
```

**Inside methodA(int m, int n) on a1:**
- Parameters: `m = 1`, `n = 2`

**Current State:**
- `a1.temp = 2`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 5`

**methodA Code:**
```java
int x = 0;
y = y + methodB(x,m) + m;
x = this.x + 2 + ++n;
sum = sum + y + methodB(n);
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = y + methodB(x,m) + m
        Need to evaluate: -2 + methodB(0,1) + 1
        Call methodB(0,1) first
```

## Nested methodB(int m, int n) Call (First Call)
**Inside methodB(int m, int n) on a1:**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a1.temp = 2`
- `a1.sum = 9`
- `a1.y = -2`
- `a1.x = 5`

**methodB Code:**
```java
int y = 0;
this.y = y + this.y + m;
x = this.y + 2 + temp - n;
sum = x + y + this.sum;
System.out.println(y+ " "+ temp + " " + sum);
return y;
```

**methodB execution line by line:**

```
Step 1: int y = 0
        Creates local variable y = 0 (shadows instance y)

Step 2: this.y = y + this.y + m
        a1.y = 0 + (-2) + 0 = -2 (instance y = local y + instance y + m)

Step 3: x = this.y + 2 + temp - n
        a1.x = -2 + 2 + 2 - 1 = 1 (instance x = instance y + 2 + instance temp - n)

Step 4: sum = x + y + this.sum
        a1.sum = 1 + 0 + 9 = 10 (instance sum = instance x + local y + instance sum)

Step 5: Print "0 2 10" (local y, instance temp, instance sum)

Step 6: return y
        Returns 0 (local y)
```

**Back to methodA:**
```
Step 2 (continued): y = y + methodB(0,1) + m
                    a1.y = -2 + 0 + 1 = -1

Step 3: x = this.x + 2 + ++n
        n = 2 + 1 = 3 (pre-increment of parameter n)
        x = 1 + 2 + 3 = 6 (local x = instance x + 2 + incremented n)

Step 4: sum = sum + y + methodB(n)
        Need to evaluate: 10 + (-1) + methodB(3)
        Call methodB(3) first
```

## Nested methodB(int x) Call (Overloaded Method)
**Inside methodB(int x) on a1:**
- Parameter: `x = 3`

**Current State:**
- `a1.temp = 2`
- `a1.sum = 10`
- `a1.y = -1`
- `a1.x = 1`

**methodB Code:**
```java
this.x = x + this.y;
x -= y + 2 + temp;
sum = x + y + this.sum;
return sum;
```

**methodB execution line by line:**

```
Step 1: this.x = x + this.y
        a1.x = 3 + (-1) = 2 (instance x = parameter x + instance y)

Step 2: x -= y + 2 + temp
        x = 3 - ((-1) + 2 + 2) = 3 - 3 = 0 (parameter x -= instance y + 2 + instance temp)

Step 3: sum = x + y + this.sum
        a1.sum = 0 + (-1) + 10 = 9 (instance sum = parameter x + instance y + instance sum)

Step 4: return sum
        Returns 9 (instance sum)
```

**Back to methodA:**
```
Step 4 (continued): sum = sum + y + methodB(3)
                    a1.sum = 10 + (-1) + 9 = 18

Step 5: Print "6 -1 18" (local x, instance y, instance sum)
```

**State after first methodA:**
- `a1.temp = 2`
- `a1.sum = 18`
- `a1.y = -1`
- `a1.x = 2`

## Second methodA Call
```java
a2.methodA(1, 4);
```

**Inside methodA(int m, int n) on a2:**
- Parameters: `m = 1`, `n = 4`

**Current State:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodA execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = y + methodB(x,m) + m
        Need to evaluate: 4 + methodB(0,1) + 1
        Call methodB(0,1) first
```

## Nested methodB(int m, int n) Call (Second Call)
**Inside methodB(int m, int n) on a2:**
- Parameters: `m = 0`, `n = 1`

**Current State:**
- `a2.temp = 3`
- `a2.sum = -5`
- `a2.y = 4`
- `a2.x = 0`

**methodB execution line by line:**

```
Step 1: int y = 0
        Creates local variable y = 0 (shadows instance y)

Step 2: this.y = y + this.y + m
        a2.y = 0 + 4 + 0 = 4 (instance y = local y + instance y + m)

Step 3: x = this.y + 2 + temp - n
        a2.x = 4 + 2 + 3 - 1 = 8 (instance x = instance y + 2 + instance temp - n)

Step 4: sum = x + y + this.sum
        a2.sum = 8 + 0 + (-5) = 3 (instance sum = instance x + local y + instance sum)

Step 5: Print "0 3 3" (local y, instance temp, instance sum)

Step 6: return y
        Returns 0 (local y)
```

**Back to methodA:**
```
Step 2 (continued): y = y + methodB(0,1) + m
                    a2.y = 4 + 0 + 1 = 5

Step 3: x = this.x + 2 + ++n
        n = 4 + 1 = 5 (pre-increment of parameter n)
        x = 8 + 2 + 5 = 15 (local x = instance x + 2 + incremented n)

Step 4: sum = sum + y + methodB(n)
        Need to evaluate: 3 + 5 + methodB(5)
        Call methodB(5) first
```

## Nested methodB(int x) Call (Second Overloaded Call)
**Inside methodB(int x) on a2:**
- Parameter: `x = 5`

**Current State:**
- `a2.temp = 3`
- `a2.sum = 3`
- `a2.y = 5`
- `a2.x = 8`

**methodB execution line by line:**

```
Step 1: this.x = x + this.y
        a2.x = 5 + 5 = 10 (instance x = parameter x + instance y)

Step 2: x -= y + 2 + temp
        x = 5 - (5 + 2 + 3) = 5 - 10 = -5 (parameter x -= instance y + 2 + instance temp)

Step 3: sum = x + y + this.sum
        a2.sum = -5 + 5 + 3 = 3 (instance sum = parameter x + instance y + instance sum)

Step 4: return sum
        Returns 3 (instance sum)
```

**Back to methodA:**
```
Step 4 (continued): sum = sum + y + methodB(5)
                    a2.sum = 3 + 5 + 3 = 11

Step 5: Print "15 5 11" (local x, instance y, instance sum)
```

**State after second methodA:**
- `a2.temp = 3`
- `a2.sum = 11`
- `a2.y = 5`
- `a2.x = 10`

## Final Output
The program produces the following output:
```
0 2 10
6 -1 18
0 3 3
15 5 11
```

## Final State Summary
**a1 object:**
- `a1.temp = 2`
- `a1.sum = 18`
- `a1.y = -1`
- `a1.x = 2`

**a2 object:**
- `a2.temp = 3`
- `a2.sum = 11`
- `a2.y = 5`
- `a2.x = 10`