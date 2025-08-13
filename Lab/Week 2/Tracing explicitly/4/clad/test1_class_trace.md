# Java Code Trace - Test1 Class

## Test1 Class

```java
class Test1{
  public int sum;
  public int y;
  public void methodA(){
    int x=2, y =3;
    int [] msg ={3, 7};
    y = this.y + msg[0];
    methodB(msg[1]++, msg[0]);
    x = x + this.y + msg[1];
    sum = x + y + msg[0];
    System.out.println(x + " " + y+ " " + sum);
  }
  public void methodB(int mg2, int mg1){
    int x = 0;
    y = this.y + mg2;
    x = x + 19 + mg1;
    sum = this.sum + x + y;
    mg2 = y + mg1;
    mg1 = mg2 + x + 2;
    System.out.println(x + " " + y+ " " + sum);
  }
}
```

## Tester5 Class

```java
public class Tester5{
  public static void main (String args[]){
    Test1 t1 = new Test1();
    t1.methodB(5,-8);
    Test1 t2 = new Test1();
    t2.methodA();
  }
}
```

---

## **Main Method Execution**

```java
Test1 t1 = new Test1();
```
- Creates `Test1` object `t1` with default instance variables:
  - `t1.sum = 0` (default int value)
  - `t1.y = 0` (default int value)

## First methodB Call
```java
t1.methodB(5,-8);
```

**Inside methodB(int mg2, int mg1) on t1:**
- Parameters: `mg2 = 5`, `mg1 = -8`

**Current State:**
- `t1.sum = 0`
- `t1.y = 0`

**methodB Code:**
```java
int x = 0;
y = this.y + mg2;
x = x + 19 + mg1;
sum = this.sum + x + y;
mg2 = y + mg1;
mg1 = mg2 + x + 2;
System.out.println(x + " " + y+ " " + sum);
```

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = this.y + mg2
        t1.y = 0 + 5 = 5 (instance variable)

Step 3: x = x + 19 + mg1
        x = 0 + 19 + (-8) = 11

Step 4: sum = this.sum + x + y
        t1.sum = 0 + 11 + 5 = 16

Step 5: mg2 = y + mg1
        mg2 = 5 + (-8) = -3 (parameter modification, no effect outside method)

Step 6: mg1 = mg2 + x + 2
        mg1 = -3 + 11 + 2 = 10 (parameter modification, no effect outside method)

Step 7: Print "11 5 16" (local x, instance y, sum)
```

**State after first methodB:**
- `t1.sum = 16`
- `t1.y = 5`

## Second Object Creation
```java
Test1 t2 = new Test1();
```
- Creates `Test1` object `t2` with default instance variables:
  - `t2.sum = 0` (default int value)
  - `t2.y = 0` (default int value)

## methodA Call
```java
t2.methodA();
```

**Inside methodA() on t2:**

**Current State:**
- `t2.sum = 0`
- `t2.y = 0`

**methodA Code:**
```java
int x=2, y =3;
int [] msg ={3, 7};
y = this.y + msg[0];
methodB(msg[1]++, msg[0]);
x = x + this.y + msg[1];
sum = x + y + msg[0];
System.out.println(x + " " + y+ " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x=2, y =3
        Creates local variables x = 2, y = 3 (y shadows instance y)

Step 2: int [] msg ={3, 7}
        Creates local array msg with values [3, 7]

Step 3: y = this.y + msg[0]
        y = 0 + 3 = 3 (local y = instance y + msg[0])

Step 4: methodB(msg[1]++, msg[0])
        Call methodB(7, 3) - msg[1] post-increments to 8 after passing 7
        Array becomes [3, 8] after post-increment
```

## Nested methodB Call
**Inside methodB(int mg2, int mg1) on t2:**
- Parameters: `mg2 = 7`, `mg1 = 3`

**Current State:**
- `t2.sum = 0`
- `t2.y = 0`

**methodB execution line by line:**

```
Step 1: int x = 0
        Creates local variable x = 0

Step 2: y = this.y + mg2
        t2.y = 0 + 7 = 7 (instance variable)

Step 3: x = x + 19 + mg1
        x = 0 + 19 + 3 = 22

Step 4: sum = this.sum + x + y
        t2.sum = 0 + 22 + 7 = 29

Step 5: mg2 = y + mg1
        mg2 = 7 + 3 = 10 (parameter modification, no effect outside method)

Step 6: mg1 = mg2 + x + 2
        mg1 = 10 + 22 + 2 = 34 (parameter modification, no effect outside method)

Step 7: Print "22 7 29" (local x, instance y, sum)
```

**State after nested methodB:**
- `t2.sum = 29`
- `t2.y = 7`

**Back to methodA:**
```
Step 5: x = x + this.y + msg[1]
        x = 2 + 7 + 8 = 17 (local x + instance y + msg[1])

Step 6: sum = x + y + msg[0]
        t2.sum = 17 + 3 + 3 = 23

Step 7: Print "17 3 23" (local x, local y, sum)
```

## Final Output
The program produces the following output:
```
11 5 16
22 7 29
17 3 23
```

## Final State Summary
**t1 object:**
- `t1.sum = 16`
- `t1.y = 5`

**t2 object:**
- `t2.sum = 23`
- `t2.y = 7`