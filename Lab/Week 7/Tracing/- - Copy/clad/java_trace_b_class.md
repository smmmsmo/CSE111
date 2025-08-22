# Code Trace - Class B

## B Class

```java
class B{
  public static int x;
  public int y = 4;
  public int temp = -5;
  public int sum = 2;
  public B(){
    y = temp + 3 ;
    sum = 3 + temp + 3;
    temp-=2;
  }  ****
  public B(B b){
    sum = b.sum;
    x = b.x;
    b.methodB(1,3);
  }
  public void methodA(int m, int n){
    int x = 2;
    y = y + m + (temp++);
    x = x + 7 +  n;
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

## Code Execution

```java
B b1 = new B();
B b2 = new B(b1);
b1.methodA(3, 2);
b2.methodB(1, 2);
```

---
## **First Constructor Call**

```java
B b1 = new B();
```

**Initial state when creating b1:**
- `B.x = 0` (static variable, default value)
- `b1.y = 4` (instance variable initialized)
- `b1.temp = -5` (instance variable initialized)
- `b1.sum = 2` (instance variable initialized)

**Inside B() constructor:**

**Constructor Code:**
```java
y = temp + 3 ;
sum = 3 + temp + 3;
temp-=2;
```

**Constructor execution line by line:**

```
Step 1: y = temp + 3
        y = -5 + 3 = -2

Step 2: sum = 3 + temp + 3
        sum = 3 + (-5) + 3 = 1

Step 3: temp -= 2
        temp = -5 - 2 = -7
```

**State after b1 constructor:**
- `B.x = 0`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`

## **Second Constructor Call**
```java
B b2 = new B(b1);
```

**Initial state when creating b2:**
- `b2.y = 4` (instance variable initialized)
- `b2.temp = -5` (instance variable initialized)
- `b2.sum = 2` (instance variable initialized)
- Parameter: `b` references the same object as `b1`

**Inside B(B b) constructor:**

**Constructor Code:**
```java
sum = b.sum;
x = b.x;
b.methodB(1,3);
```

**Constructor execution line by line:**

```
Step 1: sum = b.sum
        sum = 1 (b2.sum = 1)

Step 2: x = b.x
        x = 0 (B.x = 0, static variable)

Step 3: b.methodB(1,3)
        Call methodB on b1 with parameters (1,3)
```

## **Nested methodB Call on b1**
**Inside b1.methodB(int m, int n):**
- Parameters: `m = 1`, `n = 3`

**Current State:**
- `B.x = 0`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`

**methodB Code:**
```java
int  y = 0;
y = y + this.y; 
x = this.y + 3 + temp;
methodA(x, y);
sum = x + y + sum;
System.out.println(x + " " + y+ " " + sum);
```

**methodB execution line by line:**

```
Step 1: int y = 0 (local variable)

Step 2: y = y + this.y
        y = 0 + (-2) = -2 (local variable)

Step 3: x = this.y + 3 + temp
        x = -2 + 3 + (-7) = -6 (static variable B.x = -6)

Step 4: methodA(x, y)
        Call methodA(-6, -2) on b1
```

## **Nested methodA Call on b1**
**Inside b1.methodA(int m, int n):**
- Parameters: `m = -6`, `n = -2`

**Current State:**
- `B.x = -6`
- `b1.y = -2`
- `b1.temp = -7`
- `b1.sum = 1`

**methodA Code:**
```java
int x = 2;
y = y + m + (temp++);
x = x + 7 +  n;
sum = sum + x + y;
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 2 (local variable, shadows static x)

Step 2: y = y + m + (temp++)
        y = -2 + (-6) + (-7) = -15 (temp becomes -6 after post-increment)

Step 3: x = x + 7 + n
        x = 2 + 7 + (-2) = 7 (local variable)

Step 4: sum = sum + x + y
        sum = 1 + 7 + (-15) = -7

Step 5: Print "7 -15 -7" (local x, instance y, instance sum)
```

**Back to b1.methodB:**
```
Step 5: sum = x + y + sum
        sum = -6 + (-2) + (-7) = -15

Step 6: Print "-6 -2 -15" (static x, local y, instance sum)
```

**State after b1.methodB completes:**
- `B.x = -6`
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -15`

**State after b2 constructor completes:**
- `B.x = -6`
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`

## **First methodA Call**
```java
b1.methodA(3, 2);
```

**Inside b1.methodA(int m, int n):**
- Parameters: `m = 3`, `n = 2`

**Current State:**
- `B.x = -6`
- `b1.y = -15`
- `b1.temp = -6`
- `b1.sum = -15`

**methodA execution line by line:**

```
Step 1: int x = 2 (local variable, shadows static x)

Step 2: y = y + m + (temp++)
        y = -15 + 3 + (-6) = -18 (temp becomes -5 after post-increment)

Step 3: x = x + 7 + n
        x = 2 + 7 + 2 = 11 (local variable)

Step 4: sum = sum + x + y
        sum = -15 + 11 + (-18) = -22

Step 5: Print "11 -18 -22" (local x, instance y, instance sum)
```

**State after b1.methodA:**
- `B.x = -6`
- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`

## **Final methodB Call**
```java
b2.methodB(1, 2);
```

**Inside b2.methodB(int m, int n):**
- Parameters: `m = 1`, `n = 2`

**Current State:**
- `B.x = -6`
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`

**methodB execution line by line:**

```
Step 1: int y = 0 (local variable)

Step 2: y = y + this.y
        y = 0 + 4 = 4 (local variable)

Step 3: x = this.y + 3 + temp
        x = 4 + 3 + (-5) = 2 (static variable B.x = 2)

Step 4: methodA(x, y)
        Call methodA(2, 4) on b2
```

## **Final methodA Call on b2**
**Inside b2.methodA(int m, int n):**
- Parameters: `m = 2`, `n = 4`

**Current State:**
- `B.x = 2`
- `b2.y = 4`
- `b2.temp = -5`
- `b2.sum = 1`

**methodA execution line by line:**

```
Step 1: int x = 2 (local variable, shadows static x)

Step 2: y = y + m + (temp++)
        y = 4 + 2 + (-5) = 1 (temp becomes -4 after post-increment)

Step 3: x = x + 7 + n
        x = 2 + 7 + 4 = 13 (local variable)

Step 4: sum = sum + x + y
        sum = 1 + 13 + 1 = 15

Step 5: Print "13 1 15" (local x, instance y, instance sum)
```

**Back to b2.methodB:**
```
Step 5: sum = x + y + sum
        sum = 2 + 4 + 15 = 21

Step 6: Print "2 4 21" (static x, local y, instance sum)
```

## Final Output
The program produces the following output:
```
7 -15 -7
-6 -2 -15
11 -18 -22
13 1 15
2 4 21
```

## Final State Summary
- `B.x = 2` (static variable)
- `b1.y = -18`
- `b1.temp = -5`
- `b1.sum = -22`
- `b2.y = 1`
- `b2.temp = -4`
- `b2.sum = 21`