# Code Trace - FinalT6A Class

## FinalT6A Class

```java
public class FinalT6A{
  public static int temp = 3;
  public int sum;
  public int y = 2;
  public FinalT6A(int x, int p){
    temp+=3;
    y = temp - p;
    sum = FinalT6A.temp + x;
    System.out.println(x + " " + y+ " " + sum);
  }
  public void methodA(){ 
    int x=0, y =0;
    y = y + this.y;
    x = this.y + 2 + temp;
    sum = x + y + methodB(temp, y);
    System.out.println(x + " " + y+ " " + sum);
  }
  public int methodB(int temp, int n){
    int x = 0;
    y = y + (++temp);
    x = x + 2 +  n;
    sum = sum + x + y;
    System.out.println(x + " " + y+ " " + sum);
    return sum;
  }
}
```

## Test10 Class

```java
public class Test10{
    public static void main(String [] args){
        FinalT6A q1 = new FinalT6A(2,1);
        q1.methodA();
        FinalT6A q2 = new FinalT6A(3,1);
        q2.methodB(7,8);
    }
}
```

---
## **Main Method Execution**

```java
FinalT6A q1 = new FinalT6A(2,1);
```

**Initial static state:**
- `FinalT6A.temp = 3`

## First Constructor Call
**Inside FinalT6A(int x, int p):**
- Parameters: `x = 2`, `p = 1`

**Initial instance state for q1:**
- `q1.sum = 0` (default value)
- `q1.y = 2` (instance variable initialized)

**Constructor Code:**
```java
temp+=3;
y = temp - p;
sum = FinalT6A.temp + x;
System.out.println(x + " " + y+ " " + sum);
```

**Constructor execution line by line:**

```
Step 1: temp += 3
        temp = 3 + 3 = 6 (static variable FinalT6A.temp = 6)

Step 2: y = temp - p
        y = 6 - 1 = 5

Step 3: sum = FinalT6A.temp + x
        sum = 6 + 2 = 8

Step 4: Print "2 5 8" (parameter x, instance y, instance sum)
```

**State after q1 constructor:**
- `FinalT6A.temp = 6`
- `q1.sum = 8`
- `q1.y = 5`

Output: `2 5 8`

## **First methodA Call**
```java
q1.methodA();
```

**Inside q1.methodA():**

**Current State:**
- `FinalT6A.temp = 6`
- `q1.sum = 8`
- `q1.y = 5`

**methodA Code:**
```java
int x=0, y =0;
y = y + this.y;
x = this.y + 2 + temp;
sum = x + y + methodB(temp, y);
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 0, y = 0 (local variables)

Step 2: y = y + this.y
        y = 0 + 5 = 5 (local variable)

Step 3: x = this.y + 2 + temp
        x = 5 + 2 + 6 = 13 (local variable)

Step 4: sum = x + y + methodB(temp, y)
        Need to call methodB(6, 5) first
```

## Nested methodB Call on q1
**Inside q1.methodB(int temp, int n):**
- Parameters: `temp = 6`, `n = 5`

**Current State:**
- `FinalT6A.temp = 6`
- `q1.sum = 8`
- `q1.y = 5`

**methodB Code:**
```java
int x = 0;
y = y + (++temp);
x = x + 2 +  n;
sum = sum + x + y;
System.out.println(x + " " + y+ " " + sum);
return sum;
```

**methodB execution line by line:**

```
Step 1: int x = 0 (local variable)

Step 2: y = y + (++temp)
        temp = 6 + 1 = 7 (local parameter, pre-increment)
        y = 5 + 7 = 12 (instance variable)

Step 3: x = x + 2 + n
        x = 0 + 2 + 5 = 7 (local variable)

Step 4: sum = sum + x + y
        sum = 8 + 7 + 12 = 27

Step 5: Print "7 12 27" (local x, instance y, instance sum)

Step 6: Return sum = 27
```

**Back to q1.methodA:**
```
Step 4 (continued): sum = x + y + methodB(6, 5)
                    sum = 13 + 5 + 27 = 45

Step 5: Print "13 5 45" (local x, local y, instance sum)
```

**State after q1.methodA:**
- `FinalT6A.temp = 6`
- `q1.sum = 45`
- `q1.y = 12`

## **Second Constructor Call**
```java
FinalT6A q2 = new FinalT6A(3,1);
```

**Inside FinalT6A(int x, int p):**
- Parameters: `x = 3`, `p = 1`

**Initial instance state for q2:**
- `q2.sum = 0` (default value)
- `q2.y = 2` (instance variable initialized)

**Constructor execution line by line:**

```
Step 1: temp += 3
        temp = 6 + 3 = 9 (static variable FinalT6A.temp = 9)

Step 2: y = temp - p
        y = 9 - 1 = 8

Step 3: sum = FinalT6A.temp + x
        sum = 9 + 3 = 12

Step 4: Print "3 8 12" (parameter x, instance y, instance sum)
```

**State after q2 constructor:**
- `FinalT6A.temp = 9`
- `q2.sum = 12`
- `q2.y = 8`

Output: `3 8 12`

## **Final methodB Call**
```java
q2.methodB(7,8);
```

**Inside q2.methodB(int temp, int n):**
- Parameters: `temp = 7`, `n = 8`

**Current State:**
- `FinalT6A.temp = 9`
- `q2.sum = 12`
- `q2.y = 8`

**methodB execution line by line:**

```
Step 1: int x = 0 (local variable)

Step 2: y = y + (++temp)
        temp = 7 + 1 = 8 (local parameter, pre-increment)
        y = 8 + 8 = 16 (instance variable)

Step 3: x = x + 2 + n
        x = 0 + 2 + 8 = 10 (local variable)

Step 4: sum = sum + x + y
        sum = 12 + 10 + 16 = 38

Step 5: Print "10 16 38" (local x, instance y, instance sum)

Step 6: Return sum = 38
```

## Final Output
The program produces the following output:
```
2 5 8
7 12 27
13 5 45
3 8 12
10 16 38
```

## Final State Summary
- `FinalT6A.temp = 9` (static variable)
- `q1.sum = 45`
- `q1.y = 12`
- `q2.sum = 38`
- `q2.y = 16`